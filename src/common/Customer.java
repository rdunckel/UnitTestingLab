package common;

/**
 * Represents a customer at a retail store.
 * 
 * @author Ryan Dunckel rdunckel@my.wctc.edu
 * @version 1.0
 */
public class Customer {

	private String phone;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;

	public Customer() {
	}

	public Customer(String name, String phone) {
		this.phone = phone;
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getState() {
		return state;
	}

	/**
	 * Standard mutator.
	 * 
	 * @param state
	 *            The state the customer lives in. Validated to ensure the state
	 *            is non-null and two characters.
	 * @throws IllegalArgumentException
	 *             when an invalid state is passed.
	 */
	public void setState(String state) {
		if (state == null) {
			throw new IllegalArgumentException("State cannot be null");
		} else if (state.length() > 2 || state.length() < 2) {
			throw new IllegalArgumentException("State must be two characters");
		}

		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Tests equality based on the customer's phone number.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Customer other = (Customer) obj;
		if ((this.phone == null) ? (other.phone != null) : !this.phone
				.equals(other.phone)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 97 * hash + (this.phone != null ? this.phone.hashCode() : 0);
		return hash;
	}

	public String toString() {
		return name + ", " + phone;
	}
}
