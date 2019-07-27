package Utils;

public enum E_Region {
	JERUSALEM_DISTRICT("jerusalem"),
	NORTHEN_DISTRECT("north"),
	CENTERAL_DISTRICT("center"),
	SOUTHERN_DISTRICT("south"),
	HAIFA_DISTRICT("haifa");
	
	@SuppressWarnings("unused")
	private final String area;
	E_Region(String area) {
		this.area = area;
	}
	
	
}
