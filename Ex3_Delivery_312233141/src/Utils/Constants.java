/**
 * Constants for the entire project
 */
package Utils;

import Model.Address;
import Model.WareHouse;

/**
 * @author Java Spring 2019
 *
 */
public class Constants {
	/** Number of characters in a vehicle identification number */
	public static final int NUM_OF_VIN_CHARACTERS = 8;
	/** Array of characters that cannot be in a VIN */
	public static final char[] FORBIDDEN_VIN_CHARACTERS = {'I', 'O', 'Q'};
	/** Array of String that can be in a email */
	public static final String[] ALLOWED_SERVER = {"gmail", "walla", "hotmail"};
	/** Array of String that can be in a email ending */
	public static final String[] ALLOWED_ENDING_EMAIL = {"com", "co.il"};
	/** Number of characters in a package identification number */
	public static final int NUM_OF_PACKAGE_CHARACTERS=11;
	/** Array of characters that must be in a catalog */
	public static final char[] NOT_ALLOWED_PACKAGE_CHARACTERS = {'X', 'Y', 'Z','W'};
	/** Weight limite of small package */
	public static final double SMALL_LIMMITE_DOWN = 1.5;
	/** Weight limite of small package */
	public static final double SMALL_LIMMITE_UP = 5.99;
	/** Weight limite of big package */
	public static final double BIG_LIMMITE_DOWN = 6.00;
	/** Weight limite of big package */
	public static final double BIG_LIMMITE_UP = 9.99;
	
	public static final double TRUCK_CAPACTITY = 40; // in KG(Weight)

	public static final double CAR_CAPACTITY = 20; // in KG(Weight)
	
	/*----------------------------------------------------*/
	public static final double LOW_TAX = 8.5;
	public static final double AVERAGE_TAX = 17.6;
	public static final double HIGH_TAX = 25.5;
	public static final double TAX_FREE = 999.99;
	
	public static final int SMALL_PARCEL_MAX_WEIGHT = 8;
	public static final int LARGE_PARCEL_MAX_WEIGHT = 20;

	public static final WareHouse BASE_WAREHOUSE = new WareHouse(1, new Address(E_Cities.Ashdod, "1", 1, "77041"));
}
