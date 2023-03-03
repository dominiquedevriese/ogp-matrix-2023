package matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a matrix of double-precision floating point values.
 * 
 * @immutable
 */
public class Matrix {
	/**
	 * @invar | 0 <= rowCount
	 * @invar | 0 <= columnCount
	 * @invar | elementsRowMajor != null
	 * @invar | elementsRowMajor.length == rowCount * columnCount
	 */
	private int rowCount;
	private int columnCount;
	private double[] elementsRowMajor; 
	
	/**
	 * @post | 0 <= result
	 */
	public int getRowCount() {
		return rowCount;
	}
	/**
	 * @post | 0 <= result
	 */
	public int getColumnCount() {
		return columnCount;
	}
	/**
	 * @creates | result
	 * @creates | ...result
	 * @post | result.length == getRowCount()
	 * @post | Arrays.stream(result).allMatch(row -> row != null && row.length == getColumnCount())
	 * @post | IntStream.range(0,getRowCount()).allMatch(i->
	 * 		 |    IntStream.range(0,getColumnCount()).allMatch(j ->
	 *       |        result[i][j] == getElementAt(i,j)
	 *       |    ) 
	 *       | )
	 */
	public double[][] getRows() {
		double[][] r = new double[rowCount][columnCount];
		for( int i = 0; i < getRowCount(); ++i ) {
			for( int j = 0; j < getColumnCount(); ++j ) {
				r[i][j] = getElementAt(i,j);
			}
		}
		return r;
	}
	/**
	 * @creates | result
	 * @post | result.length == getRowCount() * getColumnCount()
	 * @post | IntStream.range(0,getRowCount()).allMatch(i->
	 * 		 |    IntStream.range(0,getColumnCount()).allMatch(j ->
	 *       |        result[i * getColumnCount() + j] == getElementAt(i,j)
	 *       |    ) 
	 *       | )
	 */
	public double[] getElementsRowMajor()  {
		double[] r = new double[rowCount*columnCount];
		for( int i = 0; i < getRowCount(); ++i ) {
			for( int j = 0; j < getColumnCount(); ++j ) {
				r[i*getRowCount() + j] = getElementAt(i,j);
			}
		}
		return r;
	}
	/**
	 * @creates | result
	 * @post | result.length == getRowCount() * getColumnCount()
	 * @post | IntStream.range(0,getRowCount()).allMatch(i->
	 * 		 |    IntStream.range(0,getColumnCount()).allMatch(j ->
	 *       |        result[j * getRowCount() + i] == getElementAt(i,j)
	 *       |    ) 
	 *       | )
	 */
	public double[] getElementsColumnMajor()  {
		double[] r = new double[rowCount*columnCount];
		for( int i = 0; i < getRowCount(); ++i ) {
			for( int j = 0; j < getColumnCount(); ++j ) {
				r[j*getRowCount() + i] = getElementAt(i,j);
			}
		}
		return r;
	}
	public double getElementAt(int i, int j)  {
		return elementsRowMajor[i*rowCount+j];
	}
	/**
	 * @creates | result
	 * @post | result.getColumnCount() == this.getColumnCount()
	 * @post | result.getRowCount() == this.getRowCount()
	 * @post | IntStream.range(0,getRowCount()).allMatch(i->
	 * 		 |    IntStream.range(0,getColumnCount()).allMatch(j ->
	 *       |        result.getElementAt(i,j) == getElementAt(i,j) * factor
	 *       |    ) 
	 *       | )
	 */
	public Matrix scaled(double factor)  {
		double[] r = new double[rowCount*columnCount];
		for( int i = 0; i < getRowCount(); ++i ) {
			for( int j = 0; j < getColumnCount(); ++j ) {
				r[i*getRowCount() + j] = getElementAt(i,j)*factor;
			}
		}
		return new Matrix(getRowCount(),getColumnCount(),r);
	}
	/**
	 * @pre | other != null
	 * @pre | other.getColumnCount() == this.getColumnCount()
	 * @pre | other.getRowCount() == this.getRowCount()
	 * @post | result.getColumnCount() == this.getColumnCount()
	 * @post | result.getRowCount() == this.getRowCount()
	 * @post | IntStream.range(0,getRowCount()).allMatch(i->
	 * 		 |    IntStream.range(0,getColumnCount()).allMatch(j ->
	 *       |        result.getElementAt(i,j) == getElementAt(i,j) + other.getElementAt(i,j)
	 *       |    ) 
	 *       | )
	 * @creates | result
	 */
	public Matrix plus(Matrix other)  {
		double[] r = new double[rowCount*columnCount];
		for( int i = 0; i < getRowCount(); ++i ) {
			for( int j = 0; j < getColumnCount(); ++j ) {
				r[i*getRowCount() + j] = getElementAt(i,j) + other.getElementAt(i, j);
			}
		}
		return new Matrix(getRowCount(),getColumnCount(),r);
	}
	/**
	 * @pre | elementsRowMajor.length == rowCount * columnCount
	 * @post | getRowCount() == rowCount
	 * @post | getColumnCount() == columnCount
	 * @post | Arrays.equals(elementsRowMajor, getElementsRowMajor())
	 */
	public Matrix(int rowCount, int columnCount, double[] elementsRowMajor) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.elementsRowMajor = elementsRowMajor.clone(); 
	}
}
