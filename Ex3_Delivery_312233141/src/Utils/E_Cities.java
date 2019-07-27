package Utils;
import Utils.E_Region;

public enum E_Cities {
	
	
	//-------------------------------------------------------------Values---------------------------------------------------------------------
	Acre("Israel","haifa"),		
	Afula("Israel","north"),				
	Ariel("Israel","jerusalem"),		
	Ashdod("Israel","center"),
	Ashkelon("Israel","center"),
	Baqa_Jatt("Israel","center"),
	Beersheba("Israel","south"),
	Beit_Shemesh("Israel","jerusalem"),
	Tiberias("Israel","north"),	
	Bnei_Brak("Israel","jerusalem"),
	Dimona("Israel","south"),
	Eilat("Israel","south"),	
	Yavne("Israel","center"),
	Hadera("Israel","center"),
	Haifa("Israel","haifa"),	
	Herzliya("Israel","center"),	
	Hod_HaSharon("Israel","center"),		
	Holon("Israel","center"),	
	Jerusalem("Israel","jerusalem"),	
	Karmiel("Israel","north"),			
	Kafr_Qasim("Israel","center"),			
	Kfar_Saba("Israel","center"),			
	Kiryat_Ata("Israel","haifa"),
	Sderot("Israel","south"),			
	Tel_Aviv("Israel","center"),
	Umm_al_Fahm("Israel","north"),
	Kiryat_Shmona("Israel","north"),	
	Maale_Adumim("Israel","jerusalem"),		
	Migdal_HaEmek("Israel","haifa"),		
	Tirat_Carmel("Israel","haifa"),	
	Nahariya("Israel","north"),	
	Nazareth("Israel","north"),			
	Nazareth_Illit("Israel","north"),	
	Nesher("Israel","haifa"),	
	Yokneam("Israel","haifa"), 
	Petah_Tikva("Israel","center"),		
	Qalansawe("Israel","center"),		
	Raanana("Israel","center"),
	Rahat("Israel","south"),		
	Ramat_Gan("Israel","center"),		
	Ramat_HaSharon("Israel","center"),	
	Rehovot("Israel","center"),					
	Safed("Israel","north"),
	Tayibe("Israel","center"),
	Arad("Israel","south")
	;				
		
								
							
	
	
	
	//-------------------------------------------------------------Class Members----------------------------------------------------------------
	private final String country;
	private final E_Region region;
	//-------------------------------------------------------------Constructor------------------------------------------------------------------
	E_Cities(String country,String region){
		this.country = country;
		if(region.equals("jerusalem"))
		{
			this.region=E_Region.JERUSALEM_DISTRICT;
		}
		else if(region.equals("haifa")) {
			this.region=E_Region.HAIFA_DISTRICT;
		}
		else if(region.equals("north")) {
			this.region=E_Region.NORTHEN_DISTRECT;
		}
		else if(region.equals("south")) {
			this.region=E_Region.SOUTHERN_DISTRICT;
		}
		else {
			this.region=E_Region.CENTERAL_DISTRICT;
		}
		
	}
	
	//-------------------------------------------------------------Methods----------------------------------------------------------------------
	public String getCountry() { 
		return country; 
	}
	public E_Region getRegion() {
		return this.region;
	}
	
}// ~ END OF Enum Class Cities
