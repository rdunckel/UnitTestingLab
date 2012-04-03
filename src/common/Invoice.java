package common;

import java.util.*;

/**
 *
 * @author jlombardo
 */
public class Invoice {
    private int invoiceNo;
    private Date date;
    private String dueDate = "Due 30 days from date of invoice";
    private Customer customer;
    private List<LineItem> lineItems = new ArrayList<LineItem>();
    private double discount;
    private double tax;
    private double minQtyForDiscount;

    public Invoice(Customer customer) {
        invoiceNo = Math.abs(new Random((new Date()).getTime()).nextInt());
        this.customer = customer;
        date = new Date();
        discount = .10;
        tax = .05;
        minQtyForDiscount = 10;
    }

    public double getTotalQty() {
        double qty = 0;

        for(LineItem item : lineItems) {
            qty += item.getQty();
        }

        return qty;
    }

    public double getNetTotal() {
        double netTotal = 0.00;

        for(LineItem item : lineItems) {
            netTotal += item.getExtPrice();
        }

        return netTotal;
    }

    public double getDiscountedTotal() {
        if(getTotalQty() >= this.minQtyForDiscount) {
            return getNetTotal() - discount;
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
        return date;
    }

    public double getDiscount() {
        return discount;
    }

    public String getDueDate() {
        return dueDate;
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
