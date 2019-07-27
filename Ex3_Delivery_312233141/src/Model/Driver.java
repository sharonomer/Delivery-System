package Model;
import java.util.Date;



public class Driver extends Person{
	private static final long serialVersionUID = 1L;
	/**
	 * Is the driver has valid license
	 */	
	private boolean hasValidLicense;
	private boolean driverInUse;
	private String password;
    public Driver(long id, String firstName, String surname, Date birthDate, Address address,
    		boolean hasValidLicense,String password) {
    	// TODO 
		super(id, firstName, surname, birthDate, address);
		this.hasValidLicense = hasValidLicense;
		this.driverInUse = false;
		this.password=password;
	}


	public Driver(long id) {
		// TODO 
		super(id);
	
	}


	/********************** Getters/Setters of class*****************************/
	
	public boolean getHasValidLicense() {
		return hasValidLicense;
	}

	public void setDriverInUse(boolean isDriverInUse) {
		this.driverInUse = isDriverInUse;
	}
	
	public boolean isDriverInUse() {
		return this.driverInUse;
	}
	public void setHasValidLicense(boolean hasValidLicense) {
		this.hasValidLicense = hasValidLicense;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return this.getFirstName()+" "+this.getSurname();
	}
	
	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
}
