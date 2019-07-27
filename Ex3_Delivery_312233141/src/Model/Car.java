package Model;
import java.util.ArrayList;
//ADAM
import Utils.Constants;
import Utils.E_ModelType;

public class Car extends Vehicle{
	private static final long serialVersionUID = 1L;
	private boolean hybrid;
	/**
	 * Full constructor
	 * @param vin
	 * @param weight
	 * @param color
	 * @param type
	 * @param inuse
	 * @param driver
	 */
	public Car(String vin, String color, E_ModelType type,boolean hybrid,Driver driver) {
		//TODO
		super(vin, color, type,driver);
		this.hybrid=hybrid;
		driver.setDriverInUse(true);
	}

	/**
	 * partial constructor
	 * @param vin
	 */
	public Car (String vin){
		super(vin);
	}
	
	
	/**
	 * Add parcel to car
	 * @param parcel
	 * @return
	 */
	public boolean addParcelToCar(Parcel parcel) {
		//TODO
		
		if((getWeight() + parcel.getWeight()) <= Constants.CAR_CAPACTITY) {
			setWeight(getWeight() + parcel.getWeight());
			ArrayList<Parcel> temp = getAllDeliveries();
			temp.add(parcel);
			setAllDeliveries(temp);
			parcel.getLocations().get(parcel.getLocations().size()-1).removeParcel(parcel);
			return true;
		}
		return false;
	}
	
	
	/**
	 * Remove parcel from car
	 * @param parcel
	 * @return
	 */
	public boolean removeParcelFromCar (Parcel parcel){
		//TODO
		if (!getAllDeliveries().contains(parcel)) return false;
		setWeight(getWeight() - parcel.getWeight());
		ArrayList<Parcel> temp = getAllDeliveries();
		temp.remove(parcel);
		setAllDeliveries(temp);
//		parcel.getLocations().get(parcel.getLocations().size()-1).addParcel(parcel);
		return true;
	}
	
	/**
	 * Deliver all parcel of the client 
	 * and remove them from Car.
	 * @param client
	 */
	public boolean sendToDestination() {
		for(Parcel p:getAllDeliveries())
			p.setSentToReceiver(true);
		this.getAllDeliveries().clear();
		return(this.getAllDeliveries().size()==0);
	}

	
	public boolean isHybrid() {
		return hybrid;
	}

	public void setHybrid(boolean hybrid) {
		this.hybrid = hybrid;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
}
