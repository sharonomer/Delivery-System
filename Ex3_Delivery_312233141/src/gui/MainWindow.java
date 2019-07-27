package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.awt.EventQueue;
import javax.swing.JFrame;
import Controller.SysData;

public class MainWindow extends JFrame implements Serializable{
	private static final long serialVersionUID = 1L;
	public static SysData sys;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				reloadDatabase();
				new Session();
				save();
				System.out.println("Saved");
			}
		});
	}
	public static void reloadDatabase(){
		try {
			System.out.println("Searching for database..\n"+new File("Delivery.ser").getAbsolutePath());
			FileInputStream fileIn=new FileInputStream("Delivery.ser");
			ObjectInputStream in=new ObjectInputStream(fileIn);
			System.out.println("Database found.\nLoading data..");
			sys=(SysData) in.readObject();
			SysData.getInstance().setDatabase(sys.getAllParcels(),sys.getAllDrivers(),
					sys.getWareHouses(),sys.getAllItems(),sys.getAllLoginInfo(),
					sys.getAllParcelsMap(),sys.getAllVehiclesMap(),
					sys.getAllWareHouses(),sys.getAllReciversMap(),sys.getAllUsers(),sys.getTruckDeliveryRoute());
			System.out.println("Done.");
			in.close();
			fileIn.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Delivery.ser wasn't found.\nCreating new file..");
			save();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
	public static void save() {
		FileOutputStream fileOut;
		ObjectOutputStream out;
		try {
			sys=SysData.getInstance();
			fileOut = new FileOutputStream("Delivery.ser");
			out=new ObjectOutputStream(fileOut);
			out.writeObject(sys);
			out.close();
			fileOut.close();
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch(IOException e2) {
			e2.printStackTrace();
			return;
		}
	}	
}
