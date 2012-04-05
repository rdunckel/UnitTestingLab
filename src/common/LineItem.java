package common;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author jlombardo
 */
public class LineItem {

    private long id;
    private String productId;
    private String productName;
    private double unitCost;
    private double quantity;
    private double netCost;

    public LineItem() {
    }

    public LineItem(String prodId, String prodName, double unitCost, double qty) {
        id = new Random((new Date()).getTime()).nextLong();
        this.productId = prodId;
        this.productName = prodName;
        this.unitCost = unitCost;
        this.quantity = qty;
        netCost = unitCost * qty;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LineItem other = (LineItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    public double getNetCost() {
        return netCost;
    }

    public void setNetCost(double netCost) {
        this.netCost = netCost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String prodId) {
        this.productId = prodId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public String toString() {
        return productName + ", " + quantity + ", " + netCost;
    }
}
