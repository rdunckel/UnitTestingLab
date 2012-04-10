package common;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the LineItem class.
 * 
 * @author Ryan Dunckel rdunckel@my.wctc.edu
 * @version 1.0
 */
public class LineItemTest {

	private LineItem item1;
	private LineItem item2;

	public LineItemTest() {
	}

	@Before
	public void setUp() {
		item1 = new LineItem();
		item2 = new LineItem();
	}

	@After
	public void tearDown() {
	}

	/**
	 * Two LineItems are equal if they have the same id.
	 */
	@Test
	public void lineItemsAreEqualIfIdIsSame() {
		item1.setId(12);
		item2.setId(12);

		assertEquals(item1, item2);
	}

	/**
	 * Two LineItems are not equal if they have different ids.
	 */
	@Test
	public void lineItemsAreNotEqualIfIdIsDifferent() {
		item1.setId(12);
		item2.setId(13);

		assertFalse(item1.equals(item2));

	}

	/**
	 * The net cost of a line item must be greater than or equal to zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void netCostMustBePositive() {
		item1.setNetCost(-1.2);
	}

}
