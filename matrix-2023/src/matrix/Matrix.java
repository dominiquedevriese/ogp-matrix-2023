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
	 * @post | 0 <= result
	 */
	public int getRowCount() {
		throw new RuntimeException("Not implemented yet");
	}
	/**
	 * @post | 0 <= result
	 */
	public int getColumnCount() {
		throw new RuntimeException("Not implemented yet");
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
		throw new RuntimeException("Not implemented yet");
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
		throw new RuntimeException("Not implemented yet");
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
		throw new RuntimeException("Not implemented yet");
	}
	public double getElementAt(int i, int j)  {
		throw new RuntimeException("Not implemented yet");
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
		throw new RuntimeException("Not implemented yet");
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
		throw new RuntimeException("Not implemented yet");
	}
	/**
	 * @pre | elementsRowMajor.length == rowCount * columnCount
	 * @post | getRowCount() == rowCount
	 * @post | getColumnCount() == columnCount
	 * @post | Arrays.equals(elementsRowMajor, getElementsRowMajor())
	 */
	public Matrix(int rowCount, int columnCount, double[] elementsRowMajor) {
		throw new RuntimeException("Not implemented yet");
	}
}
