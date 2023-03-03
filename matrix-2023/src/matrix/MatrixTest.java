package matrix;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatrixTest {

	Matrix m;
	
	@BeforeEach
	void setup() {
		double[] elements = new double[] { 1,2,3,4,5,6 };
		m = new Matrix(2,3,elements);
	}
	
	@Test
	void testGetRowCount() {
		assertEquals(2,m.getRowCount());
	}

	@Test
	void testGetColumnCount() {
		assertEquals(3,m.getColumnCount());
	}

	@Test
	void testGetRows() {
		assertTrue(Arrays.deepEquals(new double[][] {
					{ 1,2,3 },
					{ 4,5,6 }
				},m.getRows()));
	}

	@Test
	void testGetElementsRowMajor() {
		assertArrayEquals(new double[] {1,2,3,4,5,6 }, m.getElementsRowMajor());
	}

	@Test
	void testGetElementsColumnMajor() {
		assertArrayEquals(new double[] {1,4,2,5,3,6 }, m.getElementsColumnMajor());
	}

	@Test
	void testGetElementAt() {
		assertEquals(6, m.getElementAt(1, 2));
	}

	@Test
	void testScaled() {
		assertArrayEquals(new double[] { 10,20,30,40,50,60 },
				m.scaled(10).getElementsRowMajor());
		
	}

	@Test
	void testPlus() {
		assertArrayEquals(new double[] { 2,4,6,8,10,12 },
				m.plus(m).getElementsRowMajor());
	}

}
