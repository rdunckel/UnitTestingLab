package common;

import java.util.*;

/**
 *
 * @author jlombardo
 */
public class Invoice {

    private int invoiceNo;
    private Date invoiceDate;
    private String dueDateMessage = "Due 30 days from date of invoice";
    private Customer customer;
    private List<LineItem> lineItems = new ArrayList<LineItem>();
    private double discountPercentage;
    private double tax;
    private double minQtyForDiscount;

    public Invoice(Customer customer) {
        invoiceNo = Math.abs(new Random((new Date()).getTime()).nextInt());
        this.customer = customer;
        invoiceDate = new Date();
        discountPercentage = .10;
        tax = .05;
        minQtyForDiscount = 10;
    }

    public double getTotalQty() {
        double qty = 0;

        for (LineItem item : lineItems) {
            qty += item.getQuantity();
        }

        return qty;
    }

    public double getNetTotal() {
        double netTotal = 0.00;

        for (LineItem item : lineItems) {
            netTotal += item.getNetCost();
        }

        return netTotal;
    }

    public double getDiscountedTotal() {
        if (getTotalQty() >= this.minQtyForDiscount) {
            return getNetTotal() * (1 - discountPercentage);
        } else {
            return getNetTotal();
        }
    }

    public double getGrandTotal() {
        double discountedTotal = getDiscountedTotal();
        return discountedTotal - tax;
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

    public void addLineItem(Product p, int qty) {
        LineItem lineItem =
                new LineItem(p.getProdId(), p.getProdName(), p.getUnitCost(), qty);
        lineItems.add(lineItem);
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTax() {
        return tax;
    }
}
