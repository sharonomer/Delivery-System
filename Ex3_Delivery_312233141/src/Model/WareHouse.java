package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import Utils.Constants;
import Utils.E_Cities;
import Utils.E_Region;
// ADAM
public class WareHouse implements Comparable<WareHouse>, Serializable{
	private static final long serialVersionUID = 1L;
	/**Key: id of warehouse*/
	private int warehouseId;
	public int transactions_number=1;
	
	HashSet<Truck> truckTransactions;
	
	/**
	 * Warehouse address location
	 */
	Address address;

	
	/**
	 * list of all parcels in warehouse
	 */
	ArrayList<Parcel> allParcels;

	public WareHouse(int warehouseId,Address address) 
	{
		this.warehouseId=warehouseId;
		this.address = address;
		allParcels = new ArrayList<>();
		this.truckTransactions=new HashSet<>();
	}
	
	

	public WareHouse(int warehouseId)
	{
		this.warehouseId = warehouseId;
		allParcels = new ArrayList<>();
		this.truckTransactions=new HashSet<>();
	}
	
	/**
	 * 
	 * @param p parcel
	 * @param destWh destination warehouse
	 * @param weight of truck
	 * @return true if valid, false otherwise
	 */
	public boolean checkValidity(Parcel p,WareHouse destWh,double weight) {
		E_Region ReceiverRegion=p.getReceiver().getAddress().city.getRegion();
		E_Region WareHouseRegion=destWh.address.city.getRegion();
		E_Cities ReceiverCity=p.getReceiver().getAddress().city;
		E_Cities WareHouseCity=p.getLocations().get(p.getLocations().size()-1).getAddress().city;
		if(weight+p.getWeight()<=Constants.TRUCK_CAPACTITY) {
			if(!ReceiverCity.equals(WareHouseCity)) //not in same city
				if(!ReceiverRegion.equals(WareHouseRegion)) //not in same region
					return true;
			if(ReceiverRegion.equals(WareHouseRegion))
				if(!p.getReceiver().getAddress().city.equals(p.getLocations().get(p.getLocations().size()-1).getAddress().city))
					return true;
		}
		return false;
	}
	

	/**
	 * Removes parcel from warehouse, returns false if parcel doesn't exist.
	 * @param p
	 * @return
	 */
	public boolean removeParcel(Parcel p) {
		if (!allParcels.contains(p))
			return false;
		return allParcels.remove(p);
	}
	
	
	/**
	 * Adds parcel to warehouse, returns false if parcel exists already.
	 * @param p
	 * @return
	 */
	public boolean addParcel(Parcel p) {
		if(allParcels.contains(p))
			return false;
		if(allParcels.add(p)) {
			p.setCurrentIndexInWareHouse(p.getCurrentIndexInWareHouse());
			p.setCurrentIndexInWareHouse(p.currentIndexInWareHouse);
			return true;
		}
		return false;
	}
	
	
	

	public HashSet<Truck> getTruckTransactions() {
		return truckTransactions;
	}



	public void setTruckTransactions(HashSet<Truck> truckTransactions) {
		this.truckTransactions = truckTransactions;
	}



	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	public ArrayList<Parcel> getAllParcels() {
		return allParcels;
	}


	public void setAllParcels(ArrayList<Parcel> allParcels) {
		this.allParcels = allParcels;
	}


	@Override
	public String toString() {
		return "WareHouse [warehouseId=" + warehouseId + ", address=" + address + "]";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return this.getWarehouseId() == ((WareHouse)obj).getWarehouseId();
	}
	
	@Override
	public int compareTo(WareHouse w)
	{
		int compareId=w.getWarehouseId();
		return this.getWarehouseId()-compareId;
	}
	

}
