package common;

/**
 *
 * @author jlombardo
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

    public void setDescription(String description) {
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

    public void setUnitCost(double unitCost) {
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
        if ((this.prodId == null) ? (other.prodId != null) : !this.prodId.equals(other.prodId)) {
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
