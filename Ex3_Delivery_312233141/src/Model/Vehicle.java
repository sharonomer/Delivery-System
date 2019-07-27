package Model;
import java.io.Serializable;
import java.util.ArrayList;
import Utils.Constants;
import Utils.E_ModelType;

public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	private String vin;
	
	/** Weight of the loaded vehicle*/
	private double weight; 
	
	/** Vehicle color */
	private String color;
	
	/** Vehicle model */
	private E_ModelType type;
	
	/** Verify if vehicle can be used*/
	private boolean inUse;
	
	/**each vehicle register for one driver-*/
	private Driver driver;
	
	
	private ArrayList <Parcel> allDeliveries;
	

	/**
	 * Full constructor
	 * @param vin
	 * @param color
	 * @param type
	 */
	public Vehicle(String vin, String color, E_ModelType type,Driver driver) {
		setVin(vin);
		setDriver(driver);
		this.color = color;
		this.type = type;
		this.inUse=false;
		this.weight = 0;
		allDeliveries=new ArrayList<>();
	}
	

	/**
	 * Partial constructor
	 * @param vin Vehicle identification number
	 */
	public Vehicle(String vin) {
		/*TODO*/
		setVin(vin);
	}
	
	/**
	 * Set VIN
	 * VIN has a fixed number of characters
	 * There is a list of illegal characters that cannot be in a VIN 
	 * @param vin The VIN to set
	 */
	protected void setVin(String vin) {
		//TODO
		char ch;
		char[] charArray = vin.toCharArray();/*Converting String to “Character” array*/
		if (vin.length()!=Constants.NUM_OF_VIN_CHARACTERS)/*the lenght of the VIN MUST be a 8 characters only!!*/
			{this.vin=null;
			return;
			}
		for (int i=0; i<Constants.FORBIDDEN_VIN_CHARACTERS.length;i++)
		{
			ch=Constants.FORBIDDEN_VIN_CHARACTERS[i];
			for (int j=0;j<Constants.NUM_OF_VIN_CHARACTERS;j++)/*check each char from the string if it contain one of the frobbiden letters*/
				if (ch==charArray[j])
				{
					this.vin=null;
					return;
				}
		}
		this.vin=vin;	
	}

	
	// -------------------------------Getters And Setters------------------------------
	
	
	public String getColor() {
		return color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public E_ModelType getType() {
		return type;
	}

	public void setType(E_ModelType type) {
		this.type = type;
	}

	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	public Driver getDriver() {
		return driver;
	}

	
	public boolean setDriver(Driver driver) {
		if(isInUse())
			return false;
		this.driver = driver;
		return true;
	}

	public String getVin() {
		return vin;
	}
	
	public void releaseVehicle() {
		this.inUse = false;
	}
	
	public void useVehcile() {
		this.inUse = true;
	}
	
	
	public ArrayList<Parcel> getAllDeliveries() {
		return allDeliveries;
	}


	public void setAllDeliveries(ArrayList<Parcel> allDeliveries) {
		this.allDeliveries = allDeliveries;
	}

/**
 * Adds parcel to vehicle
 * @param p
 * @param v
 * @return
 */
	public boolean addParcelToVehicle(Parcel p, Vehicle v) {
		if(isInUse())
			return false;
		if(v instanceof Truck) {
			if((getWeight() + p.getWeight()) <= Constants.TRUCK_CAPACTITY) {
				setWeight(getWeight() + p.getWeight());
				ArrayList<Parcel> temp=getAllDeliveries();
				temp.add(p);
				setAllDeliveries(temp);
				return true;
			}
		}
		if(v instanceof Car) {
			if((getWeight() + p.getWeight()) <= Constants.CAR_CAPACTITY) {
				setWeight(getWeight() + p.getWeight());
				ArrayList<Parcel> temp=getAllDeliveries();
				temp.add(p);
				setAllDeliveries(temp);
				return true;
			}
		}
		return false;
	}


	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", weight=" + weight + ", color=" + color + ", type=" + type + ", inUse=" + inUse
				+ ", driver=" + driver+"]";
	}


	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		
		if(obj instanceof Car) {
			Car c = (Car) obj;
			return this.getVin().equals(c.getVin());

		}
		else {
			Truck v = (Truck) obj;
			return this.getVin().equals(v.getVin());

		}
		
	}
	
	

}
