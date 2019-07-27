package Model;


import Utils.Constants;
import Utils.E_Color;

public class LargeParcel extends Parcel{
	private static final long serialVersionUID = 1L;
	/** Color of the sticker for customs*/
	public E_Color color;
	
	
	
	public LargeParcel(Receiver receiver) {
		//TODO
		super(receiver);
		setColor();
	}

	 
	 public LargeParcel(Receiver receiver, Item item) {
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
		listOfItem.add(newItem);
		setColor();
		return true;
	}
	
	

	/**
	 * Check valid of weight
	 * @param weight
	 * @return
	 */
	@Override
	public boolean CheckWeight(double weight) {
		//TODO
		if (weight<=Constants.LARGE_PARCEL_MAX_WEIGHT)
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
		setColor();
		return itemRemoved;
		
	}
	


	public E_Color getColor() {
		return color;
	}
	
	/**
	 * set color of large parcel
	 * if total price of parcel is bigger than the tax free - will be get red sticker
	 * else, green sticker.
	 */
	public void setColor() {
		//TODO
		double totalPrice=0;
		for (Item item : listOfItem){
			totalPrice+=item.getPrice();
		}
		if (totalPrice<=Constants.TAX_FREE)
			this.color = E_Color.GREEN;
		else
			this.color = E_Color.RED;
	}
	
	
}
