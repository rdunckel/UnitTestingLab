package common;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the Invoice class.
 * 
 * @author Ryan Dunckel rdunckel@my.wctc.edu
 * @version 1.0
 */
public class InvoiceTest {

	private Invoice invoice;
	private Customer customer;
	private Product product1;
	private Product product2;
	private Product product3;

	public InvoiceTest() {
	}

	@Before
	public void setUp() {
		product1 = new Product("SH-1", "Shoes", 52.50);
		product2 = new Product("GL-1", "Gloves", 22.00);
		product3 = new Product("SR-1", "Shirt", 42.99);
		customer = new Customer();
		invoice = new Invoice(customer);
	}

	@After
	public void tearDown() {
	}

	/**
	 * Invoice net total should equal the sum of all line items unit cost *
	 * quantity.
	 */
	@Test
	public void invoiceNetTotalShouldBeSumOfLineItemsUnitCostTimesQuantity() {

		invoice.addLineItem(product1, 2); // 52.50 * 2 = 105.00
		invoice.addLineItem(product2, 1); // 22.00 * 1 = 22.00
		invoice.addLineItem(product3, 3); // 42.99 * 3 = 128.97

		double expResult = 255.97; // 253.0
		double result = invoice.getNetTotal();

		assertEquals(expResult, result, 0);
	}

	/**
	 * A discount should be applied to the invoice if there are at least 10
	 * items purchased.
	 */
	@Test
	public void discountShouldBeAppliedWhenAtLeast10ProductsArePurchased() {
		invoice.addLineItem(product1, 4); // 52.50 * 4 = 210.00
		invoice.addLineItem(product2, 3); // 22.00 * 3 = 66.00
		invoice.addLineItem(product3, 5); // 42.99 * 5 = 214.95

		double total = invoice.getNetTotal();
		double discount = 0.10 * total;

		double expResult = total - discount;
		double result = invoice.getDiscountedTotal();

		assertEquals(expResult, result, 0.001);
	}
}
