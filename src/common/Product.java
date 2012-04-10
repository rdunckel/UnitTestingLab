package common;

/**
 * A product, for purchase, in a retail store.
 * 
 * @author Ryan Dunckel rdunckel@my.wctc.edu
 * @version 1.0
 */
public class Product {
	private String prodId;
	private String prodName;
	private double unitCost;
	private String description;

	public Product() {
	}

	public Product(String prodId, String prodName, double unitCost) {
		this.prodId = prodId;
		this.prodName = prodName;
		this.unitCost = unitCost;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * Standard mutator.
	 * 
	 * @param description
	 *            The product's description. Null not allowed.
	 * @throws IllegalArgumentException
	 *             when null description is passed.
	 */
	public void setDescription(String description)
			throws IllegalArgumentException {
		if (description == null) {
			throw new IllegalArgumentException(
					"Must provide product description");
		}
		this.description = description;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getUnitCost() {
		return unitCost;
	}

	/**
	 * Standard mutator.
	 * 
	 * @param unitCost
	 *            Validated to be greater than zero.
	 * @throws IllegalArgumentException
	 *             when invalid unitCost parameter is used.
	 */
	public void setUnitCost(double unitCost) throws IllegalArgumentException {
		if (unitCost < 0) {
			throw new IllegalArgumentException(
					"Unit cost must be greater than zero.");
		}
		this.unitCost = unitCost;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Product other = (Product) obj;
		if ((this.prodId == null) ? (other.prodId != null) : !this.prodId
				.equals(other.prodId)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 29 * hash + (this.prodId != null ? this.prodId.hashCode() : 0);
		return hash;
	}

	public String toString() {
		return prodId + ", " + prodName + ", " + unitCost;
	}
}
