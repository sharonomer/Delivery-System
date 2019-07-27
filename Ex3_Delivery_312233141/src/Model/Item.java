package Model;

import java.io.Serializable;

public class Item implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	  * Key:item catalog number 
	  */
	 private long catalogID;
	 
	 /**
	  * The name of the item
	  */
	 private String itemName;
	 
	 /**
	  * price of the item 
	  */
	 private double price;
	 
	 /**
	  * does the item have free shipping
	  */
	 private boolean hasFreeShipping;
	 
	 /**
	  * item wegiht
	  */
	 private double itemWeight;
	 
	 /**
	  * Full Constractor
	  * @param catalogID
	  * @param itemName
	  * @param quantity
	  * @param price
	  * @param hasFreeShipping
	  *  * @param itemWeight
	  */
	 
	 public Item(long catalogID, String itemName,  double price, boolean hasFreeShipping,double itemWeight) {
		this.catalogID = catalogID;
		this.itemName = itemName;
		//setQuantity(quantity);
		setPrice(price);
		this.hasFreeShipping = hasFreeShipping;
		this.itemWeight=itemWeight;
	}
	 
	 //Discuss later.
	 /**
	  * Partial constructor using only CatalogId. 
	  * @param catalogID
	  */
	 public Item (long catalogID){
		 this.catalogID=catalogID;
	 }

	 /*
	  * GETTETS/SETTERS
	  * 
	  */

	public long getCatalogID() {
		return catalogID;
	}

	public void setCatalogID(long catalogID) {
		this.catalogID = catalogID;
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(double itemWeight) {
		this.itemWeight = itemWeight;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
//
//	public int getQuantity() {
//		return quantity;
//	}

//	public void setQuantity(int quantity) {
//		//TODO
//		if (quantity>0)
//			this.quantity = quantity;
//		else
//			this.quantity=0;
//	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price>0)
			this.price = price;
		else 
			this.price=0;
	}

	public boolean isHasFreeShipping() {
		return hasFreeShipping;
	}

	public void setHasFreeShipping(boolean hasFreeShipping) {
		this.hasFreeShipping = hasFreeShipping;
	}

	@Override
	public String toString() {
		return "Item [catalogID=" + catalogID + ", itemName=" + itemName +  ", price=" + price
				+ ", hasFreeShipping=" + hasFreeShipping + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (catalogID ^ (catalogID >>> 32));
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		//TODO
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (catalogID != other.catalogID)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}
	
	

}
