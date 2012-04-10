package common;

import java.util.Date;
import java.util.Random;

/**
 * A single line item on an invoice for a product purchased by a customer.
 * 
 * @author Ryan Dunckel rdunckel@my.wctc.edu
 * @version 1.0
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

	/**
	 * Standard mutator.
	 * 
	 * @param netCost
	 *            Validated to be greater than zero.
	 * @throws IllegalArgumentException
	 *             when invalid netCost parameter is used.
	 */
	public void setNetCost(double netCost) throws IllegalArgumentException {
		if (netCost < 0) {
			throw new IllegalArgumentException(
					"Net cost must be greater than zero.");
		}
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
