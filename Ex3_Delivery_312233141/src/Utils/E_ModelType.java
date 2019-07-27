package Utils;

public enum E_ModelType {
	RENO("Reno"),
	BMW("Bmw"),
	TOYOTA("Toyota"),
	MITSUBISHI("Mitsubishi"),
	KIA("Kia");
	/** Text of the vehicle type */
	public String text;
	/**
	 * Constructor
	 * @param text The text to set
	 */
	E_ModelType(String text) {
		this.text = text;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return text;
	}
}
