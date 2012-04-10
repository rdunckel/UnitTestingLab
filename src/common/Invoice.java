package common;

import java.util.*;

/**
 * Holds information about the purchase made by the customer.
 * 
 * @author Ryan Dunckel rdunckel@my.wctc.edu
 * @version 1.0
 */
public class Invoice {

	private int invoiceNo;
	private Date invoiceDate;
	private String dueDateMessage = "Due 30 days from date of invoice";
	private Customer customer;
	private List<LineItem> lineItems = new ArrayList<LineItem>();
	private double discountPercentage;
	private double taxRate;
	private double minQtyForDiscount;

	public Invoice(Customer customer) {
		invoiceNo = Math.abs(new Random((new Date()).getTime()).nextInt());
		this.customer = customer;
		invoiceDate = new Date();
		discountPercentage = .10;
		taxRate = .05;
		minQtyForDiscount = 10;
	}

	/**
	 * Obtains the total quantity of all line items on the invoice.
	 * 
	 * @return The total quantity of all line items on the invoice.
	 */
	public double getTotalQty() {
		double qty = 0;

		for (LineItem item : lineItems) {
			qty += item.getQuantity();
		}

		return qty;
	}

	/**
	 * Obtains the net total cost of all line items on the invoice.
	 * 
	 * @return The net total cost of all line items on the invoice.
	 */
	public double getNetTotal() {
		double netTotal = 0.00;

		for (LineItem item : lineItems) {
			netTotal += item.getNetCost();
		}

		return netTotal;
	}

	/**
	 * Obtains the discounted total for the invoice.
	 * 
	 * @return The discounted total for the invoice.
	 */
	public double getDiscountedTotal() {
		if (getTotalQty() >= this.minQtyForDiscount) {
			return getNetTotal() * (1 - discountPercentage);
		} else {
			return getNetTotal();
		}
	}

	/**
	 * Obtains the grand discounted total for the invoice (including any
	 * applicable discounts and tax).
	 * 
	 * @return The grand discounted total for the invoice
	 */
	public double getGrandTotal() {
		double discountedTotal = getDiscountedTotal();
		return discountedTotal * (1 + taxRate);
	}

	public Customer getCustomer() {
		return customer;
	}

	public Date getDate() {
		return invoiceDate;
	}

	public double getDiscount() {
		return discountPercentage;
	}

	public String getDueDateMessage() {
		return dueDateMessage;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * Adds a line item to the invoice.
	 * 
	 * @param p
	 *            The product to add for the line item.
	 * @param qty
	 *            The quantity of the product to add.
	 */
	public void addLineItem(Product p, int qty) {
		LineItem lineItem = new LineItem(p.getProdId(), p.getProdName(),
				p.getUnitCost(), qty);
		lineItems.add(lineItem);
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public double getTaxRate() {
		return taxRate;
	}
}
