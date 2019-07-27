package Model;
import java.io.Serializable;
import java.util.ArrayList;
import Utils.Constants;





public class Parcel implements Comparable<Parcel>,Serializable
{
	private static final long serialVersionUID = 1L;

	/**Key: Parcel ID, increase automatic*/
	private static int ID = 1;
	
	/** Tracking parcel location, keep all warehouse on the road.*/
	protected ArrayList<WareHouse> locations;
	
	
	
	/** List of item in the package */
	protected ArrayList<Item> listOfItem;
	 
	 
	 /**The weight of the of the package*/
	 private double weight;
	 

	 /**Is parcel reach to receiver*/
	 private boolean sentToReceiver;
	 
	 /**Detail about the client ordered the parcel*/
	 private Receiver receiver;

	 /**Item ID, should generated automaticlly**/
	 private String parcelId;
	 
	 public String currentIndexInWareHouse;
	 
	 private boolean isOnTruck;
//	 /**
//	  * C'tor
//	  * 
//	  * */
//	 public Parcel(double weight,String currentVehicle,boolean sentToReceiver,Receiver receiver) {
//		 this.receiver=receiver;
//		 this.weight=weight;
//		 this.currentVehicle=currentVehicle;
//		 this.sentToReceiver=false;
//		 locations = new ArrayList<WareHouse>();
//	 }
	 
	 public Parcel(Receiver receiver, Item item) {
		 this.receiver=receiver;
		 this.weight=0;
		 this.parcelId = getNextId();
		 this.sentToReceiver = false;
		 locations = new ArrayList<WareHouse>();
		 locations.add(Constants.BASE_WAREHOUSE);
		 this.currentIndexInWareHouse=null;
		 listOfItem = new ArrayList<Item>();
		 listOfItem.add(item);
		 this.isOnTruck=false;
	 }
	 

	public Parcel(Receiver receiver, ArrayList<Item> items) {
		 this.receiver=receiver;
		 this.weight=0;
		 this.parcelId = getNextId();
		 this.sentToReceiver = false;
		 locations = new ArrayList<WareHouse>();
		 locations.add(Constants.BASE_WAREHOUSE);
		 this.currentIndexInWareHouse=null;
		 listOfItem = new ArrayList<Item>();
		 listOfItem.addAll(items);
	 }
	 
	 
	 public Parcel(Receiver receiver) {
		 this.receiver=receiver;
		 this.weight=0;
		 this.parcelId = getNextId();
		 this.sentToReceiver = false;
		 listOfItem = new ArrayList<Item>();
		 locations = new ArrayList<WareHouse>();
		 locations.add(Constants.BASE_WAREHOUSE);
		 this.currentIndexInWareHouse=null;
	 }
	 
//	 /**
//	  * In case and the destination warehouse is new (not found in the list), 
//	  * so release the previous truck and reserve the new truck (Set in use as true)
//	  * @param wh
//	  * @param truck
//	  * @return
//	  */
//	public boolean sendToWareHouse(WareHouse wh,Truck truck) 
//	{
//		//TODO : Verify that this warehouse is not exist on the arrayList. (There is no warehouse loop).
//		if(locations.size()==0) {
//			currentTruck = truck;
//			currentTruck.setInUse(true);
//		}
//		else if(!locations.get(locations.size()-1).equals(wh)) {
//			currentTruck.setInUse(false);
//			currentTruck = truck;
//			currentTruck.setInUse(true);
//		}
//		return locations.add(wh);
//	}
	
	/**
	 * Add new location for the parcel
	 * @param wh
	 * @return
	 */
	public boolean addToLocations(WareHouse wh) {

		return this.locations.add(wh);
	}

	public String getNextId() {
		//TODO
		
		
		String id = ID+"";
		String updatedID="";
		for(int i=0;i<(10-id.length());i++) {
			updatedID = updatedID+"0";
		}
		ID++;
		return updatedID+id;
	}
	
	
	public void setParcelId(String parcelId) {
		this.parcelId = parcelId;
	}

	public boolean addItem (Item newItem){
		//TODO
		if(listOfItem.contains(newItem))
			return false;
		if(!CheckWeight(getWeight()+newItem.getItemWeight())) {
			return false;
		}
		return listOfItem.add(newItem);
	}
	
	public boolean removeItem(Item item) {
		if(!listOfItem.contains(item))
			return false;
		listOfItem.remove(item);
		return true;
	}
	
	public boolean CheckWeight(double weight) {
		if(this instanceof SmallParcel)
			if (weight<=Constants.SMALL_PARCEL_MAX_WEIGHT)
			{
				setWeight(weight);
				return true;
			}
		if(this instanceof LargeParcel)
			if (weight<=Constants.LARGE_PARCEL_MAX_WEIGHT)
			{
				setWeight(weight);
				return true;
			}
		return false;
	}


	public ArrayList<WareHouse> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<WareHouse> locations) {
		this.locations = locations;
	}

	public ArrayList<Item> getListOfItem() {
		return listOfItem;
	}

	public void setListOfItem(ArrayList<Item> listOfItem) {
		this.listOfItem = listOfItem;
	}

	public boolean isSentToReceiver() {
		return sentToReceiver;
	}

	public void setSentToReceiver(boolean sentToReceiver) {
		this.sentToReceiver = sentToReceiver;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}


	public double getWeight() {
		return weight;
	}
	
	public String getParcelId() {
		return this.parcelId;
	}
	

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getCurrentIndexInWareHouse() {
		if(!this.getLocations().get(this.getLocations().size()-1).allParcels.contains(this))
			return currentIndexInWareHouse;
		for(Parcel p:this.getLocations().get(this.getLocations().size()-1).allParcels) {
			if(p.equals(this)) {
				return Integer.toString(this.getLocations().get(this.getLocations().size()-1).allParcels.indexOf(p)+1);
			}
		}
		return null;
	}


	public void setCurrentIndexInWareHouse(String currentIndexInWareHouse) {
		this.currentIndexInWareHouse = currentIndexInWareHouse;
	}

	

	public boolean isOnTruck() {
		return isOnTruck;
	}


	public void setOnTruck(boolean isOnTruck) {
		this.isOnTruck = isOnTruck;
	}


	@Override
	public String toString() {
		return "Parcel [parcelId="+parcelId+", locations=" + locations + ", listOfItem=" + listOfItem + ", weight=" + weight
				+ ", sentToReceiver=" + sentToReceiver + ", receiver=" + receiver
				+ "]";
	}


	public double getCurrentCost() {
		double cost=0;
		for(Item i:listOfItem)
			cost+=i.getPrice();
		return cost;
	}

	@Override
	public int compareTo(Parcel p) {
		int compareId=Integer.parseInt(p.getParcelId());
		return Integer.parseInt(this.getParcelId())-compareId;
	}

//	@Override
//	public boolean equals(Object obj)
//	{
//		if(null == obj) {
//			return false;
//		}
//		if(obj instanceof SmallParcel) {
//			String firstVal = this.getParcelId();
//			System.out.println("First val:"+firstVal+", "+((SmallParcel)obj).getParcelId());
//			return this.getParcelId().equals(((SmallParcel)obj).getParcelId());
//		}
//		else {
//			
//			System.out.println("First val:"+this.getParcelId()+", "+((LargeParcel)obj).getParcelId());
//
//			
//			return this.getParcelId().equals(((LargeParcel)obj).getParcelId());
//		}
//	}

	
	
	
}
