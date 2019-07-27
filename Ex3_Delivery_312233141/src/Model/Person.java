package Model;
import java.io.Serializable;
import java.util.Date;

import Utils.E_UserType;

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
     * The ID of the person.
     */
    final protected long id;

    /**
     * First name of the person.
     */
    private String firstName;

    /**
     * Last name of the person.
     */
    private String surname;

    /**
     * The birth date of the person.
     */
    private Date birthDate;


    /**
     * The person's address.
     */
    private Address address;
    
    
    /**
     * The type of user for the information system.
     */
    private E_UserType userType; 



  
    /**
     * Full constructor.
     *
     * @param id The ID of the person.
     * @param firstName First name of the person.
     * @param surname Last name of the person.
     * @param birthDate The birth date of the person.
     * @param email The person's email.
     * @param address The person's address.
     */
    public Person(long id, String firstName, String surname, Date birthDate, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }
    
    /**
     * Partial constructor using only id.
     * @param id The id of the person.
     */
    public Person(long id) {
        this.id = id;
    }


    /*
        Getters and Setters
     */

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public E_UserType getUserType() {
		return userType;
	}

	public void setUserType(E_UserType userType) {
		this.userType = userType;
	}

	@Override
    public String toString() {
    	return "Person [id="+this.id+", Name=" + this.firstName + " "+this.surname+", House number:"+address.getHouseNumber()+"]";

    }
    
    @Override
    public boolean equals(Object o) {
    	if(null==o) {
			return false;
		}
    	
        if(o instanceof Receiver) {
        	return this.getId() == ((Receiver)o).getId();
        }
        else {
        	return this.getId() == ((Driver)o).getId();

        }
    }
}
