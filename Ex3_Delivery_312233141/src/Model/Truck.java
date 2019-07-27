package Model;
import java.util.ArrayList;
//ADAMs
import Utils.Constants;
import Utils.E_Color;
import Utils.E_ModelType;
import Utils.E_ParcelType;
import Utils.E_TypeTruck;

public class Truck extends Vehicle{
	private static final long serialVersionUID = 1L;
	/** Type of trunk -depend on the load*/
	private E_TypeTruck typeTrunk;
	public WareHouse nextWh;

	/**
	 * Full constructor
	 * @param vin
	 * @param weight
	 * @param color
	 * @param type
	 * @param inuse
	 * @param driver
	 * @param typeTrunk
	 */
	public Truck(String vin, String color, E_ModelType type,  E_TypeTruck typeTrunk,Driver driver) {
		super(vin, color, type,driver);
		this.typeTrunk=typeTrunk;
		this.nextWh=null;
		driver.setDriverInUse(true);
	}

	/**
	 * Partial constructor
	 * @param vin
	 */
	public Truck(String vin) {
		super(vin);
	}


	/**
	 * After filling the truck, we can send it to the warehouse destination.
	 * move all parcels to warehouse
	 * @param wh
	 */
	public boolean dismantleAllParcelsToDestinationWareHouse(WareHouse wh) {
		int wareHouseParcelsCountBefore = wh.getAllParcels().size();
		int countOfParcels = 0;
		for(Parcel p:getAllDeliveries()) {
			p.addToLocations(wh);
			wh.addParcel(p);
			p.getLocations().get(p.getLocations().size()-1).addParcel(p);
			countOfParcels++;
			if(p instanceof SmallParcel)
				if(((SmallParcel) p).getParcelType().equals(E_ParcelType.BOX)) {
					wh.transactions_number++;
				}
			if(p instanceof LargeParcel)
				if(((LargeParcel) p).getColor().equals(E_Color.GREEN)) {
					wh.transactions_number++;
				}
		}
		if(wareHouseParcelsCountBefore+countOfParcels != wh.getAllParcels().size()) {
			return false;
		}
		getAllDeliveries().clear();
		setWeight(0);		
		if(getAllDeliveries().size()==0) {
			wh.getTruckTransactions().add(this);
			return true;
		}
		
		return false;
	}


	/**
	 * adds parcel p to truck
	 * @param p
	 * @return true if added
	 */
	public boolean addParcelToTruck(Parcel p) {
		if((getWeight()+p.getWeight()<=Constants.TRUCK_CAPACTITY)) {
			setWeight(getWeight()+p.getWeight());
			ArrayList<Parcel> temp=getAllDeliveries();
			temp.add(p);
			setAllDeliveries(temp);
		}
		return true;
	}
	
	
	
	/**
	 * Remove parcel from truck
	 * @param parcel
	 * @return
	 */
	public boolean removeParcelFromTruck(Parcel parcel) {
		if(!getAllDeliveries().contains(parcel))
			return false;
		setWeight(getWeight() - parcel.getWeight());
		ArrayList<Parcel> temp = getAllDeliveries();
		temp.remove(parcel);
		setAllDeliveries(temp);
		return true;
		
	}
	

	public E_TypeTruck getTypeTrunk() {
		return typeTrunk;
	}

	public void setTypeTrunk(E_TypeTruck typeTrunk) {
		this.typeTrunk = typeTrunk;
	}
	public WareHouse getNextWh() {
		return nextWh;
	}

	public void setNextWh(WareHouse nextWh) {
		this.nextWh = nextWh;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Truck [typeTrunk=" + typeTrunk + "]";
	}


}
