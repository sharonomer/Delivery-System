package Model;

import java.io.Serializable;
import java.util.Objects;

import Utils.E_Cities;

public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	/** City name */
	public E_Cities city;
	
	/** Street name */
	public String street;
	
	/** House number to receive package */
	private int houseNumber;
	
	/** ZIP code */
	public String zipCode;
	/**
	 * Address constructor
	 * @param country Country name
	 * @param city City name
	 * @param street Street name
	 * @param houseNumber House number
	 * @param zipCode ZIP code
	 */
	public Address(E_Cities city, String street, int houseNumber,
			String zipCode) {
		this.city = city;
		this.street = street;
		setHouseNumber(houseNumber);
		this.zipCode = zipCode;
		
	}
	public E_Cities getCity() {
		return city;
	}
	public void setCity(E_Cities city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * Gets the house number
	 * @return The houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}
	/**
	 * Sets the house number, cannot be negative or 0 
	 * @param houseNumber The houseNumber to set
	 */
	public void setHouseNumber(int houseNumber) {
		if (houseNumber > 0)
			this.houseNumber = houseNumber;
	}
	
	
	
	
	
	@Override
	 public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [city=" + city + ", street="
				+ street + ", houseNumber=" + houseNumber + ", zipCode="
				+ zipCode + "]";
	}
}
