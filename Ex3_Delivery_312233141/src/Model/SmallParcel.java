package Model;



import Utils.Constants;
import Utils.E_ParcelType;

public class SmallParcel extends Parcel{
	private static final long serialVersionUID = 1L;
	/** Small parcel type */
	private E_ParcelType parcelType;
	
	
	
	
	public SmallParcel (Receiver receiver){
		//TODO
		super(receiver);
		setParcelType();
	}

	 
	 
	 public SmallParcel(Receiver receiver, Item item) {
		 super(receiver);
		 addItem(item);
	 }
	 
	 
	 
	 
	/**
	 * Insert new item to the list for the package
	 * @param newItem
	 * @return
	 */
	 @Override
	public boolean addItem (Item newItem){
		//TODO
		if(listOfItem.contains(newItem))
			return false;
		if(!CheckWeight(getWeight()+newItem.getItemWeight())) {
			return false;
		}
		return listOfItem.add(newItem);
	}
	
	/**
	 * Check valid of weight
	 * @param weight
	 * @return
	 */
	@Override
	public boolean CheckWeight(double weight) {
		//TODO
		if (weight<=Constants.SMALL_PARCEL_MAX_WEIGHT)
		{
			super.setWeight(weight);
			return true;
		}
		return false;
		
	}
	/**
	 * @author Adam
	 * remove an item from list.
	 * @param itemToRemove
	 * @return
	 */
	public boolean removeItem(Item itemToRemove) {
		if(!listOfItem.contains(itemToRemove))
			return false;
		boolean itemRemoved = listOfItem.remove(itemToRemove);
		setWeight(getWeight() - itemToRemove.getItemWeight());
		return itemRemoved;
		
	}
	
	

	public E_ParcelType getParcelType() {
		return parcelType;
	}
	
	/**
	 * Decide small parcel type by the weight
	 * if total weight is less than 1.5kg - items will send by envelope 
	 * else will send by box
	 */
	public void setParcelType() {
		//TODO
		
		if (getWeight()<Constants.SMALL_LIMMITE_DOWN)
			this.parcelType=E_ParcelType.ENVELOPE;
		else 
			this.parcelType=E_ParcelType.BOX;
	}
	
	
	
}
