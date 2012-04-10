package common;

import org.junit.*;

/**
 * Unit tests for the Product class.
 * 
 * @author Ryan Dunckel rdunckel@my.wctc.edu
 * @version 1.0
 */
public class ProductTest {

	private Product p1;

	public ProductTest() {
	}

	@Before
	public void setUp() {
		p1 = new Product();
	}

	@After
	public void tearDown() {
	}

	/**
	 * Product description cannot be null.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void productDescriptionCannotBeNull() {
		p1.setDescription(null);
	}

	/**
	 * The unit cost of a product must be greater than or equal to zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void unitCostMustBePositive() {
		p1.setUnitCost(-1.2);
	}
}
