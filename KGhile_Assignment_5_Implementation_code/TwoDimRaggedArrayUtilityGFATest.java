
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a TwoDimRaggedArrayUtility object.
 * 
 * @author Kebron Ghile
 * @version 04/09/2024
 * 
 */
public class TwoDimRaggedArrayUtilityGFATest {
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
	
	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
		dataSet1 = null;
	}

	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of row 1.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
	}
	@Test
	public void testGetColTotal() {
		assertEquals(14.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,1),.001);
	}
	@Test
	public void testGetTotal() {
		assertEquals(45,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
	}
	
	
}
