/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Date;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author rdunckel
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
     * Ensure net total is sum of all line items unit cost * quantity.
     */
    @Test
    public void invoiceNetTotalShouldBeSumOfLineItemsUnitCostTimesQuantity() {

        invoice.addLineItem(product1, 2); // 52.50 * 2 = 105.00
        invoice.addLineItem(product2, 1); // 22.00 * 1 = 22.00
        invoice.addLineItem(product3, 3); // 42.99 * 3 = 128.97

        System.out.println(invoice.getNetTotal());

        double expResult = 255.97; //253.0

        double result = invoice.getNetTotal();

        assertEquals(expResult, result, 0);

    }
}
