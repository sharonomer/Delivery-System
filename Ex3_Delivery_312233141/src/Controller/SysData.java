package Controller;


import Model.*;

import Utils.Constants;
import Utils.E_Cities;
import Utils.E_Color;
import Utils.E_ModelType;
import Utils.E_TypeTruck;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;



public class SysData implements Serializable {
	private static final long serialVersionUID = 1L;
	// -------------------------------Class Members------------------------------
	private static SysData instance;
	private ArrayList <Parcel> allParcels;
    private ArrayList <Driver> allDrivers;
    private ArrayList <WareHouse> WareHouses;
    private ArrayList <Item> allItems;

    // -------------------------------DATA STRUCTURES---------------------------//
    HashMap<String, Parcel> allParcelsMap;
    HashMap<String,Vehicle> allVehiclesMap;
    HashMap<Integer, WareHouse> allWareHouses;
    HashMap<Long,Receiver> allReciversMap;
    HashMap<Long,String> allLoginInfo;
    HashMap<Long,Person> allUsers;
    HashMap<String,ArrayList<LinkedHashMap<WareHouse,WareHouse>>> truckDeliveryRoute;
    //--------------------------------------------------------------------------//
    // -------------------------------Constructors------------------------------
    private SysData() {
        allParcels = new ArrayList<Parcel>();
        allDrivers = new ArrayList<Driver>();
        WareHouses = new ArrayList<WareHouse>();
        if(!WareHouses.contains(Constants.BASE_WAREHOUSE))
        	WareHouses.add(Constants.BASE_WAREHOUSE);
        allItems = new ArrayList<Item>();
        allParcelsMap = new HashMap<String, Parcel>();
        allVehiclesMap = new HashMap<String, Vehicle>();
        allWareHouses = new HashMap<Integer, WareHouse>();
        if(!allWareHouses.containsKey(1))
        	allWareHouses.put(1, Constants.BASE_WAREHOUSE);
        allReciversMap = new HashMap<Long, Receiver>();
        allLoginInfo = new HashMap<Long,String>();
        allUsers = new HashMap<Long,Person>();
        truckDeliveryRoute = new HashMap<String, ArrayList<LinkedHashMap<WareHouse,WareHouse>>>();
     }
    // ------------------------------Getters && Setters-------------------------------

	public static SysData getInstance() {
		if (instance == null) 
			instance = new SysData();
		return instance;
	}
	
    public HashMap<String, ArrayList<LinkedHashMap<WareHouse, WareHouse>>> getTruckDeliveryRoute() {
		return truckDeliveryRoute;
	}

	public void setTruckDeliveryRoute(HashMap<String, ArrayList<LinkedHashMap<WareHouse, WareHouse>>> truckDeliveryRoute) {
		this.truckDeliveryRoute = truckDeliveryRoute;
	}

	public ArrayList<Parcel> allParcels() {
        return allParcels;
    }


    public ArrayList<Driver> allDrivers() { 
    	return allDrivers; 
    }


    public ArrayList<WareHouse> WareHouses() {
        return WareHouses;
    }

    public ArrayList<Item> allItems() {
        return allItems;
    }
	
    public HashMap<Long, String> getAllLoginInfo() {
		return allLoginInfo;
	}
    
    public ArrayList<Parcel> getAllParcels() {
		return allParcels;
	}

	public void setAllParcels(ArrayList<Parcel> allParcels) {
		this.allParcels = allParcels;
	}

	public ArrayList<Driver> getAllDrivers() {
		return allDrivers;
	}

	public void setAllDrivers(ArrayList<Driver> allDrivers) {
		this.allDrivers = allDrivers;
	}

	public ArrayList<WareHouse> getWareHouses() {
		return WareHouses;
	}

	public void setWareHouses(ArrayList<WareHouse> wareHouses) {
		WareHouses = wareHouses;
	}

	public ArrayList<Item> getAllItems() {
		return allItems;
	}

	public void setAllItems(ArrayList<Item> allItems) {
		this.allItems = allItems;
	}

	public HashMap<String, Parcel> getAllParcelsMap() {
		return allParcelsMap;
	}

	public void setAllParcelsMap(HashMap<String, Parcel> allParcelsMap) {
		this.allParcelsMap = allParcelsMap;
	}

	public HashMap<String, Vehicle> getAllVehiclesMap() {
		return allVehiclesMap;
	}

	public void setAllVehiclesMap(HashMap<String, Vehicle> allVehiclesMap) {
		this.allVehiclesMap = allVehiclesMap;
	}

	public HashMap<Integer, WareHouse> getAllWareHouses() {
		return allWareHouses;
	}

	public void setAllWareHouses(HashMap<Integer, WareHouse> allWareHouses) {
		this.allWareHouses = allWareHouses;
	}

	public HashMap<Long, Receiver> getAllReciversMap() {
		return allReciversMap;
	}

	public void setAllReciversMap(HashMap<Long, Receiver> allReciversMap) {
		this.allReciversMap = allReciversMap;
	}

	public void setAllLoginInfo(HashMap<Long, String> allLoginInfo) {
		this.allLoginInfo = allLoginInfo;
	}
	
	public HashMap<Long, Person> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(HashMap<Long, Person> allUsers) {
		this.allUsers = allUsers;
	}

	public void setDatabase(ArrayList<Parcel> allParcels,ArrayList<Driver> allDrivers,
			ArrayList<WareHouse> WareHouses,ArrayList<Item> allItems,
			HashMap<Long, String> getAllLoginInfo,HashMap<String, Parcel> getAllParcelsMap,HashMap<String, Vehicle> getAllVehiclesMap,
			HashMap<Integer, WareHouse> getAllWareHouses,HashMap<Long, Receiver> getAllReciversMap,HashMap<Long,Person> getAllUsers,
			HashMap<String,ArrayList<LinkedHashMap<WareHouse, WareHouse>>> truckDeliveryRoute) {
		this.allParcels=allParcels;
		this.allDrivers=allDrivers;
		this.WareHouses=WareHouses;
		this.allItems=allItems;
		this.allLoginInfo=getAllLoginInfo;
		this.allParcelsMap=getAllParcelsMap;
		this.allVehiclesMap=getAllVehiclesMap;
		this.allWareHouses=getAllWareHouses;
		this.allReciversMap=getAllReciversMap;
		this.allUsers=getAllUsers;
		this.truckDeliveryRoute=truckDeliveryRoute;
	}
    
// -------------------------------Add && Remove Methods------------------------------
    
	/**
	 * This method adds new login information to the database. (Two strings for ID and password)
	 * @return true if succeeded, false otherwise.
	 */
	public boolean addLoginInfo(String id,String pass) {
    	if(!allLoginInfo.containsKey(Long.parseLong(id))) {
    		allLoginInfo.put(Long.parseLong(id), pass);
    		return true;
    	}
    	return false;
    }
	
	/**
	 * 
	 * @param id
	 * @param firstName
	 * @param surname
	 * @param birthDate
	 * @param address
	 * This method adds a Coordinator to the database.
	 */
	public void addCoordinator(long id, String firstName, String surname, Date birthDate, Address address) {
		Person p = new Person(id, firstName, surname, birthDate, address);
		p.setUserType(Utils.E_UserType.COORDINATOR);
		allUsers.put(id, p);
	}
	
	public void addTruckRoute(String vin,WareHouse origin,WareHouse dest) {
		if(!getTruckDeliveryRoute().containsKey(vin)) {
			ArrayList<LinkedHashMap<WareHouse, WareHouse>> tempArr = new ArrayList<LinkedHashMap<WareHouse,WareHouse>>();
			LinkedHashMap<WareHouse, WareHouse> whToWh = new LinkedHashMap<WareHouse, WareHouse>();
			whToWh.put(origin, dest);
			tempArr.add(whToWh);
			truckDeliveryRoute.put(vin, tempArr);
//			for(LinkedHashMap<WareHouse, WareHouse> pair:tempArr)
//			{
//				WareHouse w1=(WareHouse) pair.keySet().toArray()[0];
//				WareHouse w2=(WareHouse) pair.values().toArray()[0];
//				System.out.println("Origin: "+w1.getWarehouseId());
//				System.out.println("Dest: "+w2.getWarehouseId());
//			}
		}
		else {
			LinkedHashMap<WareHouse, WareHouse> whToWh = new LinkedHashMap<WareHouse, WareHouse>();
			whToWh.put(origin, dest);
			getTruckDeliveryRoute().get(vin).add(whToWh);
//			ArrayList<LinkedHashMap<WareHouse, WareHouse>> tempArr = getTruckDeliveryRoute().get(vin);
//			for(LinkedHashMap<WareHouse, WareHouse> pair:tempArr)
//			{
//				WareHouse w1=(WareHouse) pair.keySet().toArray()[0];
//				WareHouse w2=(WareHouse) pair.values().toArray()[0];
//				System.out.println("Origin: "+w1.getWarehouseId());
//				System.out.println("Dest: "+w2.getWarehouseId());
//			}
		}
	}
    
	/**
     * This method adds a new Car to our company IF the Car doesn't
     * already exist and the details are valid.
     * @return true if the Car was added successfully, false otherwise
     */
    public boolean addCar(String vin, String color, E_ModelType type,long driverId,boolean hybryd) {
    	if (vin != null && color != null && type != null && driverId != 0) {
        	Driver driver = null;
        	if(allVehiclesMap.containsKey(vin))
        		return false;
        	for(Driver d:allDrivers) {
        		if(d.getId()==driverId) {
        			driver = d;
        			break;
        		}
        	}
        	if(driver==null) return false;
	    	if (allReciversMap.containsKey(driverId)) return false; //Driver should not be receiver.
            Car newCar = new Car(vin,color,type,hybryd,driver);
            if(newCar.getVin()==null)
            	return false;
            if (newCar != null && !allVehiclesMap.containsValue(newCar))
                if(allVehiclesMap.put(newCar.getVin(), newCar)==null){
                	driver.setUserType(Utils.E_UserType.CAR_DRIVER);
                	allUsers.put(driver.getId(), driver);
                	return true;
                }
            }
        return false;
    	
    }// ~ END OF addCar

  
    
    /**
     * This method adds a new Truck to our company IF the Truck doesn't
     * already exist and the details are valid.
     * @return true if the Truck was added successfully, false otherwise
     */
    public boolean addTruck(String vin, String color, E_ModelType type, long driverId, E_TypeTruck typeTrunk) {
    	if (vin != null && color != null && type != null && driverId != 0 && typeTrunk!=null) {
    		if(allVehiclesMap.containsKey(vin))
        		return false;
        	Driver driver = null;
        	//Get the proposed driver.
        	for(Driver d:allDrivers) {
        		if(d.getId()==driverId) {
        			driver = d;
        		}
        	}
        	if(driver==null) return false;//If cannot find driver.
        	
        	if(driver.isDriverInUse()) return false; //if driver already in use in another vehicle.
	    	if (allReciversMap.containsKey(driver.getId())) return false; //Driver should not be receiver.
	    	Truck newTruck = new Truck(vin, color, type, typeTrunk, driver);
	    	if(newTruck.getVin()==null) {
            	return false;
            }
            if (newTruck != null && !allVehiclesMap.containsValue(newTruck))
            	if(allVehiclesMap.put(newTruck.getVin(), newTruck)==null){
            		driver.setUserType(Utils.E_UserType.TRUCK_DRIVER);
                	allUsers.put(driver.getId(), driver);
            		return true;
            	}
        	}
        return false;
    } // ~ END OF addTruck

    
    /***
     * Given receiver ID, create new parcel which related to this receiver.
     * @param id
     * @return the parcel id if adding small parcel succeed.
     */
    @SuppressWarnings("unused")
	public String addSmallParcel(String parcelId,long id) {
		Receiver currentReceiver=null;
		if(allReciversMap.containsKey(id))
			currentReceiver=allReciversMap.get(id);
		if(currentReceiver==null) return null;
		SmallParcel sp=new SmallParcel(currentReceiver);
		sp.setParcelId(parcelId);
		if(sp!=null)
		{
			allParcelsMap.put(parcelId, sp);
			allParcels.add(sp);
//			Constants.BASE_WAREHOUSE.addParcel(sp);
			allWareHouses.get(1).addParcel(sp);
			for(WareHouse w:WareHouses)
				if(w.equals(Constants.BASE_WAREHOUSE))
					w.addParcel(sp);
			return parcelId;
		}
		return null;
    }
    
    
    
    /***
     * Given receiver ID, create new parcel which related to this receiver.
     * @param id
     * @return  parcel id  if adding small parcel succeed.
     */
    @SuppressWarnings("unused")
	public String addLargeParcel(String parcelId,long id) {
    	Receiver currentReceiver=null;
		if(allReciversMap.containsKey(id))
			currentReceiver=allReciversMap.get(id);
		if(currentReceiver==null) return null;
		LargeParcel lp=new LargeParcel(currentReceiver);
		lp.setParcelId(parcelId);
		if(lp!=null)
		{
			allParcelsMap.put(parcelId, lp);
			allParcels.add(lp);
//			Constants.BASE_WAREHOUSE.addParcel(lp);
			allWareHouses.get(1).addParcel(lp);
			for(WareHouse w:WareHouses)
				if(w.equals(Constants.BASE_WAREHOUSE))
					w.addParcel(lp);
			return parcelId;
		}
		return null;
    }
    
    
    
    /**
     * Creates and adds a new Driver into the relevant data-structure
     * @return true IF this Driver was added successfully, false otherwise
     */
    public boolean addDriver(long id, String firstName, String surname, Date birthDate, Address address,
                             boolean hasValidLicense,String password)   {
    	if (id > 0 && !firstName.equals("") && !surname.equals("") && birthDate != null && address != null) {
            Person newPerson = new Person(id, firstName, surname, birthDate, address);
            Driver newDriver = new Driver(id, firstName, surname, birthDate, address, hasValidLicense,password);
            if (newPerson != null && !allDrivers.contains(newDriver) && !allReciversMap.containsKey(newDriver.getId()))
            {
                return allDrivers.add(newDriver);
            }
        }
        return false;
    } // ~ END OF addDriver


    
    
    /**
     * Creates and adds a new Receiver into the relevant data-structure
     * @return true IF this Receiver was added successfully, false otherwise
     */
    @SuppressWarnings("unlikely-arg-type")
	public boolean addReceiver(long id, String firstName, String surname, Date birthDate, Address address, String email) {
    	if (id > 0 && !firstName.equals("") && !surname.equals("") && birthDate != null && address != null &&
    	           email != null) {
    	            Receiver newReceiver = new Receiver (id, firstName, surname, birthDate, address, email);
    	            if (newReceiver != null && !allReciversMap.containsValue(newReceiver) && !allDrivers.contains(newReceiver)) {
    	               if(allReciversMap.put(newReceiver.getId(),newReceiver)==null)
    	               {
    	            	   allUsers.put(id, newReceiver);
    	            	   return true;
    	               }
    	            }
    	        }
    	        return false;
    } // ~ END OF addReceiver

    /**
     * Creates and adds a new WareHouse into the relevant data-structure
     * @return true IF this WareHouse was added successfully, false otherwise
     */
    public boolean addWarehouse(int id, Address address) {
    	if (id > 0 && address.getCity()!=null && address.getHouseNumber()>0 && address.getStreet().length()>0&&address.getZipCode().length()>0) {
        	
            WareHouse newWareHouse = new WareHouse(id, address);
            if (newWareHouse != null && !allWareHouses.containsValue(newWareHouse)){
                if(allWareHouses.put(id,newWareHouse)==null) {
                	WareHouses.add(newWareHouse);
                	return true;
                }
            }
        }
        return false;
    } // ~ END OF addWareHouse

    /**
     * Creates and adds a new Item into the relevant data-structure
     * @return true IF this Item was added successfully, false otherwise
     */
    public boolean addItem (long catalogID, String itemName,  double price, boolean hasFreeShipping,double itemWeight)  {
    	if (catalogID > 0 && !itemName.equals("") && price > 0 &&  itemWeight > 0) {
            Item newItem = new Item(catalogID, itemName, price, hasFreeShipping, itemWeight);
            if (newItem != null && !allItems.contains(newItem)) {
                return allItems.add(newItem);
            }
        }
        return false;
    } // ~ END OF addItem




    /**
     * this method adds a parcel to a wareHouse IF the wareHouse already exist.
     * @return true if the parcel was added to the wareHouse, false otherwise.
     */
    public boolean addParcelToWarehouse (int id,String pacelId)  {
    	WareHouse currentWareHouse = null;
        // Check validity first
        if (id > 0 && !pacelId.equals("")&&pacelId.length()==10) {

            if(allWareHouses.containsKey(id))
            	currentWareHouse=allWareHouses.get(id);
            if(currentWareHouse==null) {
            	return false;
            }
            SmallParcel sp = (SmallParcel) allParcelsMap.get(pacelId);
            LargeParcel lp = (LargeParcel)allParcelsMap.get(pacelId);
            
            if(sp!=null) {
            	return currentWareHouse.addParcel(sp);
            }
            
            if(lp!=null) {
            	return currentWareHouse.addParcel(lp);
            }
        }
        return false;
    }// ~ END OF addSmallParcelToWareHouse


    
    /***
     * Send car to its destination.
     * Destination extracted according to the parcels receivers.
     * @param vin
     * @return
     */
    public boolean sendCarToDestination(String vin) {
    	if(vin!=null) {
    		Car car = (Car)allVehiclesMap.get(vin);
    		if(car == null)
    			return false;
    		if(car.getAllDeliveries().size()==0)
    			return false;
    		return car.sendToDestination();
    	}
    	return false;
    }
    /***
     * Get received all item for specific receiver.
     * @param receiverId
     * @return list of items
     */
    public ArrayList<Item> getReceiverItems(Long receiverId){
    	if(receiverId>0) {
    		Receiver receiver = allReciversMap.get(receiverId);
    		return receiver.getReceivedItems();
    	}
    	return null;
    }
    
    /***
     * Given parcel Id, add the relevant parcel to truck which has the given vin.
     * @param parcelId
     * @param vin
     * @return
     */
    public boolean addParcelToTruck(String parcelId, String vin) {
    	if(parcelId!=null && vin!=null) {
    		Truck currentTruck = (Truck)allVehiclesMap.get(vin);
    		if(currentTruck==null) return false;
    		Parcel p = allParcelsMap.get(parcelId);
    		for(String id:allVehiclesMap.keySet()/*O(n)*/) //O(n^2)
    		{
    			if(p!=null&&allVehiclesMap.get(id).getAllDeliveries().contains(p)) //O(n)
    				return false;
    		}
    		if(p!=null) {
    			if(p.getListOfItem().size()==0) {
    				return true;
    			}
    			if(p.isSentToReceiver()) {
    				return false;
    			}
    			if(currentTruck.getAllDeliveries().contains(p)) {
    				return false;
    			}
    			return currentTruck.addParcelToTruck(p);
    		}
    	}
    	return false;
    }
    
    
    
    /***
     * Given parcel Id, add the relevant parcel to truck which has the given vin.
     * @param parcelId
     * @param vin
     * @return
     */
    public boolean addParcelToCar(String parcelId, String vin) {
    	if(parcelId!=null && vin!=null) {
    		Car currentCar = (Car)allVehiclesMap.get(vin);
    		if(currentCar==null) return false;
    		Parcel p = allParcelsMap.get(parcelId);
    		for(String id:allVehiclesMap.keySet()/*O(n)*/) //O(n^2)
    		{
    			if(p!=null&&allVehiclesMap.get(id).getAllDeliveries().contains(p)) //O(n)
    				return false;
    		}
    		if(p!=null) {
    			if(p.getListOfItem().size()==0) {
    				return true;
    			}
    			if(p.isSentToReceiver()) {
    				return false;
    			}
    			if(currentCar.getAllDeliveries().contains(p)) {
    				return false;
    			}
    			return currentCar.addParcelToCar(p);
    		}
    	}
    	return false;
    }
    
    
    /***
     * Given parcel id, catalog id and item name, 
     * add the relevant item to the parcel with the given parcelId.
     * @param parcelId
     * @param catalogID
     * @param itemName
     * @return
     */
    public boolean addItemToParcel(String parcelId, Long catalogID, String itemName){
    	if(parcelId!=null && catalogID>0 && itemName!=null) {
    		Item currentItem = null;
    		//Search for item.
    		for(Item item:allItems) {
    			if(item.getCatalogID()==catalogID)
    			{
    				if(item.getItemName().equals(itemName)) {
    					currentItem = item;
    					break;
    				}
    			}
    		}
    		if(currentItem==null) return false; // If item is not found;
    		Parcel p=allParcelsMap.get(parcelId);
    		if(p!=null)
    		{
    			if(p.getListOfItem().contains(currentItem)) {
    				return false;
    			}
    			return p.addItem(currentItem);
    		}
    	}
    	return false;
    }
    //-------------------------Queries------------------------------------------------------


    /**
     * In order to analyze data about trucks, write a query 
     * To get the heaviest Truck which has the highest weight.
     * @return Truck
     */
    public Truck getTruckWithMaxWeight() {
    	Truck t = null;
    	double max=0;
    	double currentWeight = 0;
    	for(String id:allVehiclesMap.keySet())
    	{
    		currentWeight+=allVehiclesMap.get(id).getWeight();
    		if(max<currentWeight && allVehiclesMap.get(id) instanceof Truck) {
    			t=(Truck)allVehiclesMap.get(id);
    			max=currentWeight;
    		}
    		currentWeight=0;
    	}
    	return t;
    }
    
    /***
     * In order to assigned trucks to work write a query
     * That get a list of free trucks - truck that doesn't has any delivery.
     * @return 
     */
    public Collection <Truck> getFreeTrucks(){
    	ArrayList<Truck> freeTrucks = new ArrayList<Truck>();
    	for(String id:allVehiclesMap.keySet())
    	{
    		if(allVehiclesMap.get(id) instanceof Truck)
    		{
    			Truck t=(Truck)allVehiclesMap.get(id);
        		if(t.getAllDeliveries().size()==0)
        			freeTrucks.add(t);
    		}
    	}
    	return freeTrucks;
    }
    
    
    /***
     * Returns the receiver which received max number of items.
     * Pay attention : number of parcels doens't indicate max received items.
     * @return Receiver
     */
    public Receiver getPersonWithMaxReceivedItems()  {
    	Receiver currReceiver = null;
    	int maxItems =0;
    	for(Long id:allReciversMap.keySet())
    	{
    		Receiver r=allReciversMap.get(id);
    		if(r.getReceivedItems().size()>maxItems) {
    			maxItems=r.getReceivedItems().size();
    			currReceiver=r;
    		}
    	}
    	return currReceiver;
    }
    
    /***
     * Given a vin of vehicle and warehousId
     * Send truck to wareHouse if truck exists or truck is available.
     * Truck has capacity of loaded.
     * @param vin
     * @param wareHouseId
     * @return true if succeed.
     */
    public boolean sendTruckToWareHouse(String vin){
    	if(vin!=null)
    	{
    		Truck truck = (Truck)allVehiclesMap.get(vin);
    		WareHouse wh = truck.getNextWh();
    		if(truck==null || wh==null) {
    			return false;
    		}
    		if(truck.getAllDeliveries().size()==0) {
    			return false;
    		}
    		return truck.dismantleAllParcelsToDestinationWareHouse(wh);
    		
    	}
    	return false;
    }
    
    /***
     * given parcel id,
     * Returns the current address of the parcel 
     * parcel can be located at WareHouse or Receiver.
     * @param parcelId
     * @return
     */
    public Address getParcelLocation(String parcelId) {
    	Parcel p=allParcelsMap.get(parcelId);
    	if(p!=null) {
    		if(p.isSentToReceiver()) {
    			return p.getReceiver().getAddress();
    		}
    		else
    			return p.getLocations().get(p.getLocations().size()-1).getAddress();
    	}
    	return null;
    }
   
    
    
    /**
     * given a minimum barrier price
     * The system want to see the large parcel with total price higher the minPrice
     * and have Green sticker, the list must be order by the proportion of price/weight of the parcel (Max must be at the top)
     * You need to find for each parcel his proportion and than to sort the list
     * @param minPrice
     * @return 
     */
    public Collection <LargeParcel> smartBuy (double minPrice){
    	Comparator<LargeParcel> comp=new Comparator<LargeParcel>() {
			@Override
			public int compare(LargeParcel p1, LargeParcel p2) {
				if(p1.getCurrentCost()/p1.getWeight()>p2.getCurrentCost()/p2.getWeight())
					return 11;
				else if(p1.getCurrentCost()/p1.getWeight()==p2.getCurrentCost()/p2.getWeight())
					return 0;
				else
					return -1;
			}
		};
    	ArrayList<LargeParcel> listGreen = new ArrayList<>();
    	double total=0;
    	for (String id : allParcelsMap.keySet()){
    		for (Item it : allParcelsMap.get(id).getListOfItem()){
    			total +=it.getPrice();
    		}
    		if(allParcelsMap.get(id) instanceof LargeParcel)
    		{
    			LargeParcel lp=(LargeParcel)allParcelsMap.get(id);
        		if (lp.getColor().equals(E_Color.GREEN) && total>=minPrice)
        			listGreen.add(lp);
        		total = 0;
    		}
    	}
    	if (listGreen.isEmpty())
    		return null;
    	Collections.sort(listGreen, comp);
    	return listGreen;
    }
    
    
    /**
     * return all the parcels that have been (during the road to customer) 
     * At least twice at the same warehouse And to present the number of appearance at the warehouse
     * @return Data structure depend for your choice  Parcel
     */
	public HashMap<Parcel,Integer> TwiceAtWarehouse(){ 
		HashMap<Parcel,Integer> list=new HashMap<>();
		HashMap<WareHouse,Integer> temp=new HashMap<>();
		LinkedHashMap<Parcel,Integer> sorted_list=new LinkedHashMap<>();
		for(Parcel p:allParcels) {//o(n^2)
			for(WareHouse w:p.getLocations()) {//o(n)
				if(!temp.containsKey(w))
					temp.put(w,1);
				else
					temp.put(w, temp.get(w)+1);
			}
			for(WareHouse w:temp.keySet()) {//o(n)
				if(temp.get(w)>1)
					list.put(p, temp.get(w));
			}
			temp.clear();
		}
		
		/*The rest of the code is just to reverse the order of parcels shown*/
		ArrayList<Parcel> orderedKeySet=new ArrayList<>();
		for(Parcel p:list.keySet())
			orderedKeySet.add(p);
		Collections.reverse(orderedKeySet);
		for(Parcel p:orderedKeySet)
			sorted_list.put(p, list.get(p));
    	return sorted_list;
    }
	
	

    /*****
     * This method add as much as possible parcels from warehouse to car 
     * (If they stand on the requirement. city of warehouse = city of receiver)
     * and then, it divide the parcels to receivers by house number.
     * @see on WareHouse Class.
     * @param wareHouseId
     * @param vin
     * @return Collection<Receiver>: the order of the receivers which received the parcels.
     */
    public Collection<Parcel> sendParcelsToReceivers(int wareHouseId, String vin){
    	Car c=null;
    	if(allVehiclesMap.get(vin).getClass().equals(Car.class))
    		c=(Car)allVehiclesMap.get(vin);
    	WareHouse w=allWareHouses.get(wareHouseId);
    	ArrayList<Parcel> disposables=new ArrayList<>();
		for(Parcel p:w.getAllParcels())
		{
			E_Cities ReceiverCity=p.getReceiver().getAddress().city;
			E_Cities WareHouseCity=p.getLocations().get(p.getLocations().size()-1).getAddress().city;
			System.out.println("Receiver city: "+ReceiverCity+", WareHouse city: "+WareHouseCity);
			if(ReceiverCity.equals(WareHouseCity)) {
				System.out.println("Same city");
				if(c.addParcelToVehicle(p, c)) {
					System.out.println("Added to car");
					disposables.add(p);
				}
				else
					break;
			}
		}
		for(Parcel p:disposables) {
			w.removeParcel(p);
			p.getReceiver().updateReceivedItems(p);
			c.removeParcelFromCar(p);
			p.setSentToReceiver(true);
			System.out.println(p.getParcelId()+" received.");
		}
//		Comparator<Parcel> comp=new Comparator<Parcel>() {//compare by house number
//			@Override
//			public int compare(Parcel p1, Parcel p2) {
//				if(p1.getReceiver().getAddress().getHouseNumber()>p2.getReceiver().getAddress().getHouseNumber())
//					return 1;
//				else if(p1.getReceiver().getAddress().getHouseNumber()==p2.getReceiver().getAddress().getHouseNumber())
//					return 0;
//				else
//					return -1;
//			}
//		};
//		disposables.sort(comp);
    	return disposables;
    }
    
    /**
     * For analyst the system, we want to know with of the warehouses sorted by their id
     * busy warehouse is called if at least five parcels have been in this warehouse 
     * the parcel must be with red stamp or packed as a box.
     * @return collection of warehouse or null if no warehouse exist
     */
    public Collection <WareHouse> busyWarehouse (){
    	ArrayList<WareHouse> whList=new ArrayList<>();
    	for(WareHouse w:WareHouses) {
    		if(w.transactions_number>=4) {
    			whList.add(w);
    		}
    	}
		return whList;
    }
    
    /***
     * Get all unique category IDs of the received items.
     * @param receiverID
     * @return
     */
    public int getAllUniqCategories(Long receiverID) {
		int unique=0;
		HashMap<Item,Integer> hm = new HashMap<>();
		for(Item i:allReciversMap.get(receiverID).getReceivedItems()) {
			if(!hm.containsKey(i))
				hm.put(i,1);
			else
				hm.put(i,hm.get(i)+1);
		}
		for(Item i:hm.keySet()) {
			if(hm.get(i)==1)
				unique++;
		}
    	return unique;
    }
    
    /***
     * By Given a warehouseID,
     * return all the trucks which passed from this warehouse all the history of parcels (Print also duplicates).
     * @see  WareHouse Class.
     * @param wareHouseId
     * @return allTrucks
     */
    public Collection<Truck> getAllTrucksTransactions(int wareHouseId){
    	WareHouse w=allWareHouses.get(wareHouseId);
    	return w.getTruckTransactions();
    }
    
    /***
     * this method only add parcels to truck, add all the possible parcels to truck.
     * Given the truck and its destination, 
     * This method should add all the possible parcels from the source warehouse to the truck according to:
     * 1- add as much as possible.
     * 2- parcels which stands on the top of the data structure has an advantage.
     * 3- Parcels which exist on the same district as the receiver, are not allowed to be moved to another district.
     * 4- Parcels which exist on the same city as the receiver, are not allowed to be added to truck. only to car.
     * @param vin 	 		: Truck which will move the parcels.
     * @param fromWh 		: source warehouse. 
     * @param toWh   		: Destination warehouse.
     * @return collection 	: all the parcels which added to the truck.
     */
    public Collection<Parcel> addAllPossibleParcelsToTruck(String vin,int fromWh, int toWh){
    	Truck t=null;
    	if(allVehiclesMap.get(vin).getClass().equals(Truck.class))
			t=(Truck)allVehiclesMap.get(vin);
    	t.setNextWh(allWareHouses.get(toWh));
    	WareHouse w=allWareHouses.get(fromWh);
    	ArrayList<Parcel> disposables=new ArrayList<>();
		for(Parcel p:w.getAllParcels())
		{
//			if(w.checkValidity(p, allWareHouses.get(toWh), t.getWeight()))
//			{
				if(p.getWeight()!=0) {
					t.addParcelToVehicle(p, t);
					p.setOnTruck(true);
					disposables.add(p);
				}
//			}
		}
		
		ArrayList<Parcel> all_added=new ArrayList<Parcel>();
		if(!t.getAllDeliveries().isEmpty())
			for(Parcel p:t.getAllDeliveries())
				if(p!=null)
					all_added.add(p);
		for(Parcel p:disposables) {
			w.removeParcel(p);
		}
    	return all_added;
    }
    
    
    /****
     * Get all the parcels from given warehouse which have a price on the given range.
     * The query must run with the lowest time Complexity 
     * @param wareHouseId
     * @param lower
     * @param higher
     * @return
     */
    public Collection<Parcel> getParcelsFromWareHouseByPriceRange(int wareHouseId,double lower,double higher){
    	Comparator<Parcel> comp=new Comparator<Parcel>() {//compare by cost
			@Override
			public int compare(Parcel p1, Parcel p2) {
				if(p1.getCurrentCost()>p2.getCurrentCost())
					return 1;
				else if(p1.getCurrentCost()==p2.getCurrentCost())
					return 0;
				else
					return -1;
			}
		};
    	WareHouse w=allWareHouses.get(wareHouseId);//O(1)
		ArrayList<Parcel> list=new ArrayList<Parcel>();
		if(w.getAllParcels()!=null)
			for(Parcel p:w.getAllParcels())//O(n)
			{
				if(p.getCurrentCost()>=lower && p.getCurrentCost()<=higher) //last condition is to make output the same
					list.add(p);
			}
		Collections.sort(list, comp);
    	return list;
    }
}