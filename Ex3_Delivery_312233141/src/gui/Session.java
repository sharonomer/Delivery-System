package gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import Controller.SysData;
import Model.Car;
import Model.Driver;
import Model.Item;
import Model.LargeParcel;
import Model.Parcel;
import Model.Person;
import Model.Receiver;
import Model.SmallParcel;
import Model.Truck;
import Model.Vehicle;
import Model.WareHouse;
import Utils.E_UserType;
import gui.AddItemToParcelPanel.ItemCellRenderer;
import gui.VehiclePanel.ParcelCellRenderer;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Session extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String password;
	private JTextField numberField;
	private JPasswordField passwordField;
	public static JLayeredPane layeredPane;
	public static JPanel loginPanel;
	public static JPanel adminPanel;
	public static JPanel coordinatorPanel;
	public static JPanel carDriverPanel;
	public static JPanel truckDriverPanel;
	public static JPanel receiverPanel;
	public static JLabel lblUserAddedSuccessfully;
	public static JButton btnRefresh;
	public static JButton btnRefresh_1;
	public static String id;
	public static WareHouse warehouse;
	public static WareHouse originWarehouse;
	public static WareHouse destWarehouse;
	public static Parcel parcel;
	public static Vehicle vehicle;
	public static JList<LinkedHashMap<WareHouse,WareHouse>> list6_2;
	public static SysData sys=SysData.getInstance();
	JLabel lblFullName = new JLabel();
	JLabel lblAddress = new JLabel();
	JLabel lblEmail = new JLabel();
	JLabel lblId = new JLabel();

	/**
	 * Creates the frame, handles the initial creation of all panels using LayeredPane, as well as refreshes for real-time updates and a couple of methods.
	 */
	@SuppressWarnings("unchecked")
	public Session() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 464, 411);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		//-----------ALL PANES--------------
		
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(25, 25, 112));
		layeredPane.add(loginPanel, "name_358031842246500");
		loginPanel.setLayout(null);
		
		adminPanel = new JPanel();
		adminPanel.setBackground(new Color(25, 25, 112));
		layeredPane.add(adminPanel, "name_358057126175600");
		adminPanel.setLayout(null);
		
		coordinatorPanel = new JPanel();
		coordinatorPanel.setBackground(new Color(25, 25, 112));
		layeredPane.add(coordinatorPanel, "name_358061749487900");
		coordinatorPanel.setLayout(null);
		
		carDriverPanel = new JPanel();
		carDriverPanel.setBackground(new Color(25, 25, 112));
		layeredPane.add(carDriverPanel, "name_358063617412600");
		carDriverPanel.setLayout(null);
		
		truckDriverPanel = new JPanel();
		truckDriverPanel.setBackground(new Color(25, 25, 112));
		layeredPane.add(truckDriverPanel, "name_358065290113000");
		truckDriverPanel.setLayout(null);
		
		receiverPanel = new JPanel();
		receiverPanel.setBackground(new Color(25, 25, 112));
		layeredPane.add(receiverPanel, "name_358091801015700");
		receiverPanel.setLayout(null);
		
		AddReceiverPanel addRPanel = new AddReceiverPanel();
		layeredPane.add(addRPanel, "name_358430282265500");
		
		AddCoordinatorPanel addCoorPanel = new AddCoordinatorPanel();
		layeredPane.add(addCoorPanel, "name_358431242245500");
		
		AddDriverPanel addDrPanel = new AddDriverPanel();
		layeredPane.add(addDrPanel, "name_358231242245500");
		
		AddCarPanel addCPanel = new AddCarPanel();
		layeredPane.add(addCPanel, "name_358431247245500");
		
		AddTruckPanel addTPanel = new AddTruckPanel();
		layeredPane.add(addTPanel, "name_358431245242500");
		
		AddItemPanel addIPanel = new AddItemPanel();
		layeredPane.add(addIPanel, "name_358231255242500");
		
		AddWarehousePanel addWPanel = new AddWarehousePanel();
		layeredPane.add(addWPanel, "name_358231257246500");
		
		AddSmallParcelPanel addSPPanel = new AddSmallParcelPanel();
		layeredPane.add(addSPPanel, "name_358238277266500");
		
		AddLargeParcelPanel addLPPanel = new AddLargeParcelPanel();
		layeredPane.add(addLPPanel, "name_358638277666500");
		
		AddItemToParcelPanel addItoPPanel = new AddItemToParcelPanel();
		layeredPane.add(addItoPPanel, "name_358608978676500");
		
		ParcelLocationPanel pLocationPanel = new ParcelLocationPanel();
		layeredPane.add(pLocationPanel, "name_358608978666500");
		
		AllReceivedItemsPanel receivedItemsPanel = new AllReceivedItemsPanel();
		layeredPane.add(receivedItemsPanel, "name_358908878667500");
		
		LoadTruckPanel loadTPanel = new LoadTruckPanel();
		layeredPane.add(loadTPanel, "name_356902878667500");
		
		SendTruckPanel sendTPanel = new SendTruckPanel();
		layeredPane.add(sendTPanel, "name_356922572667500");
		
		WarehousePanel whPanel = new WarehousePanel();
		layeredPane.add(whPanel, "name_356202471667500");
		
		VehiclePanel vPanel = new VehiclePanel();
		layeredPane.add(vPanel, "name_355206471667500");
		
		ParcelPanel pPanel = new ParcelPanel();
		layeredPane.add(pPanel, "name_366272271667500");
		
		SendParcelsToReceiversPanel sendPtoRPanel = new SendParcelsToReceiversPanel();
		layeredPane.add(sendPtoRPanel,"name_356262261267500");
		
		PlanDeliveryPanel planDeliveryPanel = new PlanDeliveryPanel();
		layeredPane.add(planDeliveryPanel,"name_356466661567500");
		
		LoadTruckPanel2 loadTPanel2 = new LoadTruckPanel2();
		layeredPane.add(loadTPanel2, "name_356502678667500");
		
		//-----------------------------------------------LOGIN PANE----------------------------------------------
		
		setTitle("Delivery System v3.31");
//		ImageIcon img = new ImageIcon("img/box.png");
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("box.png"));
		setIconImage(img.getImage());
		setVisible(true);
		
		JLabel label = new JLabel("Log-in");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 23));
		label.setBounds(181, 11, 81, 28);
		loginPanel.add(label);
		
		JLabel noUser = new JLabel("Invalid information, user doesn't exist!");
		noUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		noUser.setForeground(Color.RED);
		noUser.setBounds(74, 50, 297, 14);
		noUser.setVisible(false);
		loginPanel.add(noUser);
		
		lblUserAddedSuccessfully = new JLabel("User added successfully!");
		lblUserAddedSuccessfully.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserAddedSuccessfully.setForeground(new Color(0, 128, 0));
		lblUserAddedSuccessfully.setBounds(101, 381, 138, 14);
		lblUserAddedSuccessfully.setVisible(false);
		loginPanel.add(lblUserAddedSuccessfully);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(116, 243, 24, 14);
		loginPanel.add(lblNewLabel);
		
		numberField = new JTextField();
		numberField.setText("Admin");
		numberField.setBounds(150, 242, 145, 20);
		loginPanel.add(numberField);
		numberField.setColumns(10);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setForeground(Color.WHITE);
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblpassword.setBounds(67, 286, 73, 14);
		loginPanel.add(lblpassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 285, 145, 20);
		loginPanel.add(passwordField);
		
		JLabel onlyNumbers = new JLabel("Only numbers are allowed!");
		onlyNumbers.setFont(new Font("Tahoma", Font.BOLD, 11));
		onlyNumbers.setForeground(Color.RED);
		onlyNumbers.setBounds(150, 262, 149, 14);
		onlyNumbers.setVisible(false);
		loginPanel.add(onlyNumbers);
		
		JLabel idEmpty = new JLabel("ID can't be empty!");
		idEmpty.setFont(new Font("Tahoma", Font.BOLD, 11));
		idEmpty.setForeground(Color.RED);
		idEmpty.setBounds(150, 262, 104, 14);
		idEmpty.setVisible(false);
		loginPanel.add(idEmpty);
		
		JLabel lblIDisTaken = new JLabel("ID is already taken!");
		lblIDisTaken.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIDisTaken.setForeground(Color.RED);
		lblIDisTaken.setBounds(101, 381, 110, 14);
		loginPanel.add(lblIDisTaken);
		lblIDisTaken.setVisible(false);
		
		JLabel passEmpty = new JLabel("Password can't be empty!");
		passEmpty.setForeground(Color.RED);
		passEmpty.setFont(new Font("Tahoma", Font.BOLD, 11));
		passEmpty.setBounds(150, 308, 149, 14);
		passEmpty.setVisible(false);
		loginPanel.add(passEmpty);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBackground(new Color(25, 25, 112));
		btnClear.setBounds(298, 377, 73, 23);
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numberField.setText("");
				passwordField.setText("");
				idEmpty.setVisible(false);
				onlyNumbers.setVisible(false);
				passEmpty.setVisible(false);
				noUser.setVisible(false);
				lblIDisTaken.setVisible(false);
				lblUserAddedSuccessfully.setVisible(false);
				contentPane.repaint();
			}
		});
		loginPanel.add(btnClear);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(25, 25, 112));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBounds(381, 377, 73, 23);
		loginPanel.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
//		lblNewLabel_1.setIcon(new ImageIcon("img/login_icon.png"));
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("login_icon.png")));
		lblNewLabel_1.setBounds(169, 61, 158, 170);
		loginPanel.add(lblNewLabel_1);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setBackground(new Color(25, 25, 112));
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setBounds(10, 377, 81, 23);
		loginPanel.add(btnSignUp);
	
		
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(addRPanel);
			}
		});
		
		ActionListener loginListener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblUserAddedSuccessfully.setVisible(false);
				lblIDisTaken.setVisible(false);
				idEmpty.setVisible(false);
				onlyNumbers.setVisible(false);
				passEmpty.setVisible(false);
				noUser.setVisible(false);
				contentPane.repaint();
				id=numberField.getText();
				@SuppressWarnings("deprecation")
				String p=passwordField.getText();
				if(isOnlyDigit(id)&&id.length()!=0&&!id.equals("Admin"));
				else {
					if(id.length()==0) {
						onlyNumbers.setVisible(false);
						idEmpty.setVisible(true);
						lblUserAddedSuccessfully.setVisible(false);
						loginPanel.repaint();
					}
					else {
						idEmpty.setVisible(false);
						lblUserAddedSuccessfully.setVisible(false);
						onlyNumbers.setVisible(true);
						loginPanel.repaint();
					}
					if(id.length()!=0&&!id.getClass().equals(Integer.class)) {
						idEmpty.setVisible(false);
						lblUserAddedSuccessfully.setVisible(false);
						onlyNumbers.setVisible(true);
						loginPanel.repaint();
					}
				}
				if(p.length()!=0)
				{
					Session.this.password=p;
					if(id.equals("Admin")&&Session.this.password.equals("Admin")) {
						System.out.println("Administrator permissions");
						btnRefresh.doClick();
						switchPanels(adminPanel);
					}
				}
				else {
					passEmpty.setVisible(true);
					loginPanel.repaint();
				}
				if(!idEmpty.isVisible()&&!passEmpty.isVisible()&&!idEmpty.isVisible())
					try{
						if(sys.getAllLoginInfo().containsKey(Long.parseLong(id))&&
								sys.getAllLoginInfo().get(Long.parseLong(id)).equals(Session.this.password)){
							E_UserType typeOfUser = sys.getAllUsers().get(Long.parseLong(id)).getUserType();
							if(typeOfUser.equals(Utils.E_UserType.RECEIVER)) {
								btnRefresh_1.doClick();
								switchPanels(receiverPanel);
							}
							else if(typeOfUser.equals(Utils.E_UserType.COORDINATOR)) {
								System.out.println("Co-ordinator permissions");
								btnRefresh.doClick();
								switchPanels(coordinatorPanel);
							}
							else if(typeOfUser.equals(Utils.E_UserType.CAR_DRIVER)) {
								System.out.println("Car-driver permissions");
								switchPanels(carDriverPanel);
							}
							else if(typeOfUser.equals(Utils.E_UserType.TRUCK_DRIVER)) {
								System.out.println("Truck-driver permissions");
								for(Vehicle v:sys.getAllVehiclesMap().values()) {
									if(Session.id.equals(String.valueOf(v.getDriver().getId()))) {
										Session.vehicle=v;
									}
								}
								switchPanels(truckDriverPanel);
							}
						}
						else {
							noUser.setVisible(true);
							idEmpty.setVisible(false);
							passEmpty.setVisible(false);
							onlyNumbers.setVisible(false);
							lblUserAddedSuccessfully.setVisible(false);
							loginPanel.repaint();
						}
					}
				catch (NumberFormatException e1) {
					idEmpty.setVisible(true);
					onlyNumbers.setVisible(false);
					if(id.length()!=0&&!id.getClass().equals(Integer.class)) {
						idEmpty.setVisible(false);
						onlyNumbers.setVisible(true);
					}
				}
				if(id.equals("Admin")&&p.equals("Admin")) {
					idEmpty.setVisible(false);
					onlyNumbers.setVisible(false);
					lblUserAddedSuccessfully.setVisible(false);
					loginPanel.repaint();
				}
				loginPanel.repaint();
			}
		};
		btnLogin.addActionListener(loginListener);
		//adding an ENTER listener to both id and password fields 
		numberField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnLogin.doClick();
				}
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnLogin.doClick();
				}
			}
		});
		
		//--------------------------------------------ADMIN PANEL-----------------------------------------------	
		JLabel lblAdminMenu = new JLabel("Admin menu");
		lblAdminMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdminMenu.setForeground(new Color(255, 255, 255));
		lblAdminMenu.setBackground(new Color(25, 25, 112));
		lblAdminMenu.setBounds(190, 379, 90, 14);
		lblAdminMenu.setOpaque(true);
		adminPanel.add(lblAdminMenu);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setForeground(new Color(255, 255, 255));
		btnBack_1.setBackground(new Color(25, 25, 112));
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(loginPanel);
			}
		});
		btnBack_1.setBounds(10, 377, 89, 23);
		adminPanel.add(btnBack_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 462, 21);
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(25, 25, 112));
		menuBar.setOpaque(true);
		adminPanel.add(menuBar);
		
		JMenu mnAdd = new JMenu("Add");
		menuChanger(mnAdd);
		menuBar.add(mnAdd);
		
//		Icon userIcon = new ImageIcon("img/login_icon_small.png");
		Icon userIcon = new ImageIcon(getClass().getClassLoader().getResource("login_icon_small.png"));
		JMenu mnUsers = new JMenu("Users");
		mnUsers.setIcon(userIcon);
		menuChanger(mnUsers);
		mnAdd.add(mnUsers);
		
//		Icon receiverIcon = new ImageIcon("img/userIcon.png");
		Icon receiverIcon = new ImageIcon(getClass().getClassLoader().getResource("userIcon.png"));
		JMenuItem mntmReceiver = new JMenuItem("Receiver");
		mntmReceiver.setIcon(receiverIcon);
		menuItemChanger(mntmReceiver);
		mnUsers.add(mntmReceiver);
		mntmReceiver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(addRPanel);
			}
		});
		
//		Icon coordinatorIcon = new ImageIcon("img/coordinator_icon_small.png");
		Icon coordinatorIcon = new ImageIcon(getClass().getClassLoader().getResource("coordinator_icon_small.png"));
		JMenuItem mntmAddCoordinator = new JMenuItem("Coordinator");
		mntmAddCoordinator.setIcon(coordinatorIcon);
		menuItemChanger(mntmAddCoordinator);
		mnUsers.add(mntmAddCoordinator);
		mntmAddCoordinator.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(addCoorPanel);
			}
		});
		
//		Icon driverIcon = new ImageIcon("img/wheel_icon_small.png");
		Icon driverIcon = new ImageIcon(getClass().getClassLoader().getResource("wheel_icon_small.png"));
		JMenuItem mntmAddDriver = new JMenuItem("Driver");
		mntmAddDriver.setIcon(driverIcon);
		menuItemChanger(mntmAddDriver);
		mnUsers.add(mntmAddDriver);
		mntmAddDriver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(addDrPanel);
			}
		});
		
//		Icon vehicleIcon = new ImageIcon("img/wheel_icon.png");
		Icon vehicleIcon = new ImageIcon(getClass().getClassLoader().getResource("wheel_icon.png"));
		JMenu mnVehicles = new JMenu("Vehicles");
		mnVehicles.setIcon(vehicleIcon);
		menuChanger(mnVehicles);
		mnAdd.add(mnVehicles);
		
//		Icon carIcon = new ImageIcon("img/car_icon.png");
		Icon carIcon = new ImageIcon(getClass().getClassLoader().getResource("car_icon.png"));
		JMenuItem mntmAddCar = new JMenuItem("Car");
		mntmAddCar.setIcon(carIcon);
		menuItemChanger(mntmAddCar);
		mnVehicles.add(mntmAddCar);
		mntmAddCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddCarPanel.btnRefresh.doClick();
				switchPanels(addCPanel);
			}
		});
		
//		Icon truckIcon = new ImageIcon("img/truck_icon.png");
		Icon truckIcon = new ImageIcon(getClass().getClassLoader().getResource("truck_icon.png")); 
		JMenuItem mntmAddTruck = new JMenuItem("Truck");
		mntmAddTruck.setIcon(truckIcon);
		menuItemChanger(mntmAddTruck);
		mnVehicles.add(mntmAddTruck);
		mntmAddTruck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddTruckPanel.btnRefresh.doClick();
				switchPanels(addTPanel);
			}
		});
		
//		Icon parcelIcon=new ImageIcon("img/boxBW.png");
		Icon parcelIcon = new ImageIcon(getClass().getClassLoader().getResource("boxBW.png"));
		JMenu mnParcel = new JMenu("Parcel");
		mnParcel.setIcon(parcelIcon);
		menuChanger(mnParcel);
		mnAdd.add(mnParcel);
		
		JMenuItem mntmAddSmallParcel = new JMenuItem("Small Parcel",parcelIcon);
		menuItemChanger(mntmAddSmallParcel);
		mnParcel.add(mntmAddSmallParcel);
		mntmAddSmallParcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddSmallParcelPanel.btnRefresh.doClick();
				switchPanels(addSPPanel);
			}
		});
		
		JMenuItem mntmAddLargeParcel = new JMenuItem("Large Parcel",parcelIcon);
		menuItemChanger(mntmAddLargeParcel);
		mnParcel.add(mntmAddLargeParcel);
		mntmAddLargeParcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddLargeParcelPanel.btnRefresh.doClick();
				switchPanels(addLPPanel);
			}
		});
		
//		Icon itemIcon = new ImageIcon("img/objects_icon.png");
		Icon itemIcon = new ImageIcon(getClass().getClassLoader().getResource("objects_icon.png"));
		JMenuItem mntmAddItem = new JMenuItem("Item");
		mntmAddItem.setIcon(itemIcon);
		menuItemChanger(mntmAddItem);
		mnAdd.add(mntmAddItem);
		mntmAddItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(addIPanel);
			}
		});
		
//		Icon itemToParcelIcon = new ImageIcon("img/itemToParcel_icon.png");
		Icon itemToParcelIcon = new ImageIcon(getClass().getClassLoader().getResource("itemToParcel_icon.png"));
		JMenuItem mntmItemToParcel = new JMenuItem("Item to Parcel");
		mntmItemToParcel.setIcon(itemToParcelIcon);
		menuItemChanger(mntmItemToParcel);
		mnAdd.add(mntmItemToParcel);
		mntmItemToParcel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddItemToParcelPanel.btnRefresh.doClick();
				switchPanels(addItoPPanel);
			}
		});
		
//		Icon warehouseIcon = new ImageIcon("img/warehouse_icon_small.png");
		Icon warehouseIcon = new ImageIcon(getClass().getClassLoader().getResource("warehouse_icon_small.png"));
		JMenuItem mntmAddWarehouse = new JMenuItem("Warehouse");
		mntmAddWarehouse.setIcon(warehouseIcon);
		menuItemChanger(mntmAddWarehouse);
		mnAdd.add(mntmAddWarehouse);
		mntmAddWarehouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(addWPanel);
			}
		});
		
		JMenu mnQueries = new JMenu("Actions/Queries");
		mnQueries.setForeground(new Color(255, 255, 255));
		menuBar.add(mnQueries);
		
		Icon packageLocationIcon = new ImageIcon(getClass().getClassLoader().getResource("package_location_icon.png"));
		JMenuItem mntmParcelLocation = new JMenuItem("Parcel Location");
		mntmParcelLocation.setIcon(packageLocationIcon);
		menuItemChanger(mntmParcelLocation);
		mnQueries.add(mntmParcelLocation);
		mntmParcelLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ParcelLocationPanel.btnRefresh.doClick();
				switchPanels(pLocationPanel);
			}
		});
		
		Icon loadTruckIcon = new ImageIcon(getClass().getClassLoader().getResource("load_truck_icon_small.png"));
		JMenuItem mntmLoadTruck = new JMenuItem("Load Truck");
		mntmLoadTruck.setIcon(loadTruckIcon);
		menuItemChanger(mntmLoadTruck);
		mnQueries.add(mntmLoadTruck);
		mntmLoadTruck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoadTruckPanel.btnRefresh.doClick();
				switchPanels(loadTPanel);
			}
		});
		
		Icon sendTruckIcon = new ImageIcon(getClass().getClassLoader().getResource("send_truck_icon_small.png"));
		JMenuItem mntmSendTruck = new JMenuItem("Send Truck");
		mntmSendTruck.setIcon(sendTruckIcon);
		menuItemChanger(mntmSendTruck);
		mnQueries.add(mntmSendTruck);
		mntmSendTruck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SendTruckPanel.btnRefresh.doClick();
				switchPanels(sendTPanel);
			}
		});
		
		Icon planRouteIcon = new ImageIcon(getClass().getClassLoader().getResource("planRoute_icon.png"));
		ActionListener planRoute = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlanDeliveryPanel.btnRefresh.doClick();
				switchPanels(planDeliveryPanel);
			}
		};
		JMenuItem mntmPlanRouteFor_1 = new JMenuItem("Plan Route for Trucks");
		mntmPlanRouteFor_1.setIcon(planRouteIcon);
		mntmPlanRouteFor_1.addActionListener(planRoute);
		menuItemChanger(mntmPlanRouteFor_1);
		mnQueries.add(mntmPlanRouteFor_1);
		
		Icon sendParcelsToReceiverIcon = new ImageIcon(getClass().getClassLoader().getResource("deliver_package_icon_small.png"));
		JMenuItem mntmSendParcelsTo = new JMenuItem("Send Parcels to Receiver");
		mntmSendParcelsTo.setIcon(sendParcelsToReceiverIcon);
		menuItemChanger(mntmSendParcelsTo);
		mnQueries.add(mntmSendParcelsTo);
		mntmSendParcelsTo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SendParcelsToReceiversPanel.btnRefresh.doClick();
				switchPanels(sendPtoRPanel);
			}
		});
		
		Icon num2Icon = new ImageIcon(getClass().getClassLoader().getResource("numberTwo_icon.png"));
		JMenuItem mntmTwiceAtWarehouse = new JMenuItem("Twice at Warehouse");
		mntmTwiceAtWarehouse.setIcon(num2Icon);
		menuItemChanger(mntmTwiceAtWarehouse);
		mnQueries.add(mntmTwiceAtWarehouse);
		mntmTwiceAtWarehouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = "";
				for(Parcel p:sys.TwiceAtWarehouse().keySet())
					s=String.format("%s\nParcel: %s, times: %s\n",s,p.getParcelId(),sys.TwiceAtWarehouse().get(p));
				JOptionPane.showMessageDialog(null, s);
			}
		});
		
		@SuppressWarnings("rawtypes")
		class ItemCellRenderer extends JLabel implements ListCellRenderer {
			private static final long serialVersionUID = 1L;
			private final Color HIGHLIGHT_COLOR = new Color(255, 255, 255);

			  public ItemCellRenderer() {
			    setOpaque(true);
			    setIconTextGap(12);
			  }
			  public Component getListCellRendererComponent(JList list, Object value,
			      int index, boolean isSelected, boolean cellHasFocus) {
			    Item i = (Item) value;
			    setFont(new Font("Tahoma", Font.PLAIN, 11));
			    setText(String.format("(%s) %s", i.getCatalogID(),i.getItemName()));
			    if (isSelected) {
				      setBackground(HIGHLIGHT_COLOR);
				      setForeground(new Color(25, 25, 112));
				    }
			    else {
				      setBackground(new Color(25, 25, 112));
				      setForeground(Color.white);
				}
			    return this;
			  }
			}
		DefaultListModel<Item> listModel = new DefaultListModel<Item>();
		for(Item i:sys.getAllItems()) {
			listModel.addElement(i);
		}
		JList<Item> list = new JList<Item>(listModel);
		list.setBackground(new Color(25, 25, 112));
		list.setVisibleRowCount(5);
		list.setCellRenderer(new ItemCellRenderer());
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setEnabled(false);
		JScrollPane allItems = new JScrollPane(list);
		allItems.setBounds(308, 32, 154, 164);
		adminPanel.add(allItems);
		JLabel lblallItems = new JLabel("All Items");
		lblallItems.setBackground(new Color(25, 25, 112));
		lblallItems.setForeground(new Color(224, 255, 255));
		lblallItems.setOpaque(true);
		lblallItems.setHorizontalAlignment(SwingConstants.CENTER);
		allItems.setColumnHeaderView(lblallItems);
		
		
		@SuppressWarnings({ "rawtypes" })
		class UsersCellRenderer extends JLabel implements ListCellRenderer {
			private static final long serialVersionUID = 1L;
			private final Color HIGHLIGHT_COLOR = new Color(255, 255, 255);

			  public UsersCellRenderer() {
			    setOpaque(true);
			    setIconTextGap(12);
			  }
			  public Component getListCellRendererComponent(JList list, Object value,
			      int index, boolean isSelected, boolean cellHasFocus) {
			    Person i = (Person) value;
			    setFont(new Font("Tahoma", Font.PLAIN, 11));
			    if(i instanceof Receiver)
			    	setText(String.format("(Receiver) %s %s", i.getFirstName(),i.getSurname()));
			    else if(i instanceof Driver)
			    {
			    	for(Vehicle v:sys.getAllVehiclesMap().values())
			    	{
			    		if(v.getDriver().equals(i) && v instanceof Car)
			    			setText(String.format("(Car driver) %s %s", i.getFirstName(), i.getSurname()));
			    		else if(v.getDriver().equals(i) && v instanceof Truck)
			    			setText(String.format("(Truck driver) %s %s", i.getFirstName(), i.getSurname()));
			    	}
			    }
			    else if(i.getUserType()==E_UserType.COORDINATOR)
			    	setText(String.format("(Coordinator) %s %s", i.getFirstName(), i.getSurname()));
			    if (isSelected) {
				      setBackground(HIGHLIGHT_COLOR);
				      setForeground(new Color(25, 25, 112));
				    }
			    else {
				      setBackground(new Color(25, 25, 112));
				      setForeground(Color.white);
				}
			    return this;
			  }
			}
		DefaultListModel<Person> listModel3 = new DefaultListModel<Person>();
		for(Person i:sys.getAllUsers().values()) {
			listModel3.addElement(i);
		}
		JList<Person> list3 = new JList<Person>(listModel3);
		list3.setBackground(new Color(25, 25, 112));
		list3.setVisibleRowCount(5);
		list3.setCellRenderer(new UsersCellRenderer());
		list3.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list3.setEnabled(true);
		list3.addMouseListener(new MouseAdapter() {// Double-click listener
			public void mouseClicked(MouseEvent mouseEvent) {
		        JList<String> theList = (JList<String>) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2) {
		          int index = theList.locationToIndex(mouseEvent.getPoint());
		          if (index >= 0) {
		            Object o = theList.getModel().getElementAt(index);
		            Person p=(Person)o;
		            id=String.valueOf(p.getId());
		            if(sys.getAllUsers().get(Long.parseLong(id)) instanceof Receiver)
		            {
		            	btnRefresh_1.doClick();
		            	switchPanels(receiverPanel);
		            }
		            else if(sys.getAllUsers().get(Long.parseLong(id)).getUserType().equals(Utils.E_UserType.COORDINATOR))
		            {
		            	System.out.println("Coordinator permissions");
		            	btnRefresh.doClick();
		            	switchPanels(coordinatorPanel);
		            }
		            else if(sys.getAllUsers().get(Long.parseLong(id)).getUserType().equals(Utils.E_UserType.CAR_DRIVER))
		            {
		            	System.out.println("Car driver permissions");
		            	switchPanels(carDriverPanel);
		            }
		            else if(sys.getAllUsers().get(Long.parseLong(id)).getUserType().equals(Utils.E_UserType.TRUCK_DRIVER))
		            {
		            	for(Vehicle v:sys.getAllVehiclesMap().values()) {
							if(Session.id.equals(String.valueOf(v.getDriver().getId()))) {
								Session.vehicle=v;
							}
						}
		            	VehiclePanel.btnRefresh.doClick();
		            	btnRefresh.doClick();
		            	System.out.println("Truck driver permissions");
		            	switchPanels(truckDriverPanel);
		            }
		          }
		        }
		      }
		});
		JScrollPane allUsers = new JScrollPane(list3);
		allUsers.setBounds(0, 32, 154, 164);
		adminPanel.add(allUsers);
		JLabel lblAllUsers = new JLabel("All Users");
		lblAllUsers.setBackground(new Color(25, 25, 112));
		lblAllUsers.setForeground(new Color(255, 255, 255));
		lblAllUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllUsers.setOpaque(true);
		allUsers.setColumnHeaderView(lblAllUsers);
		
		
		@SuppressWarnings({ "rawtypes" })
		class VehicleCellRenderer extends JLabel implements ListCellRenderer {
			private static final long serialVersionUID = 1L;
			private final Color HIGHLIGHT_COLOR = new Color(255, 255, 255);

			  public VehicleCellRenderer() {
			    setOpaque(true);
			    setIconTextGap(12);
			  }
			  public Component getListCellRendererComponent(JList list, Object value,
			      int index, boolean isSelected, boolean cellHasFocus) {
			    Vehicle i = (Vehicle) value;
			    setFont(new Font("Tahoma", Font.PLAIN, 11));
			    if(i instanceof Car && i.isInUse())
			    	setText(String.format("(Car) %s in use.", i.getVin()));
			    else if(i instanceof Car && !i.isInUse())
			    	setText(String.format("(Car) %s not in use.", i.getVin()));
			    else if(i instanceof Truck && i.isInUse())
			    	setText(String.format("(Truck) %s in use.", i.getVin()));
			    else if(i instanceof Truck && !i.isInUse())
			    	setText(String.format("(Truck) %s not in use.", i.getVin()));
			    if (isSelected) {
				      setBackground(HIGHLIGHT_COLOR);
				      setForeground(new Color(25, 25, 112));
				    }
			    else {
				      setBackground(new Color(25, 25, 112));
				      setForeground(Color.white);
				}
			    return this;
			  }
			}
		DefaultListModel<Vehicle> listModel4 = new DefaultListModel<Vehicle>();
		for(Vehicle i:sys.getAllVehiclesMap().values()) {
			listModel4.addElement(i);
		}
		JList<Vehicle> list4 = new JList<Vehicle>(listModel4);
		list4.setBackground(new Color(25, 25, 112));
		list4.setVisibleRowCount(5);
		list4.setCellRenderer(new VehicleCellRenderer());
		list4.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list4.setEnabled(true);
		JScrollPane allVehicles = new JScrollPane(list4);
		allVehicles.setBounds(154, 202, 154, 164);
		adminPanel.add(allVehicles);
		JLabel lblAllVehicles = new JLabel("All Vehicles");
		lblAllVehicles.setBackground(new Color(25, 25, 112));
		lblAllVehicles.setForeground(new Color(255, 255, 255));
		lblAllVehicles.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllVehicles.setOpaque(true);
		allVehicles.setColumnHeaderView(lblAllVehicles);
		
		
		@SuppressWarnings({ "rawtypes" })
		class ParcelCellRenderer extends JLabel implements ListCellRenderer {
			private static final long serialVersionUID = 1L;
			private final Color HIGHLIGHT_COLOR = new Color(255, 255, 255);

			  public ParcelCellRenderer() {
			    setOpaque(true);
			    setIconTextGap(12);
			  }
			  public Component getListCellRendererComponent(JList list, Object value,
			      int index, boolean isSelected, boolean cellHasFocus) {
			    Parcel i = (Parcel) value;
			    setFont(new Font("Tahoma", Font.PLAIN, 11));
			    if(i instanceof SmallParcel)
			    	setText(String.format("(Small) %s", i.getParcelId()));
			    else if(i instanceof LargeParcel)
			    	setText(String.format("(Large) %s", i.getParcelId()));
			    if (isSelected) {
				      setBackground(HIGHLIGHT_COLOR);
				      setForeground(new Color(25, 25, 112));
				    }
			    else {
				      setBackground(new Color(25, 25, 112));
				      setForeground(Color.white);
				}
			    return this;
			  }
			}
		DefaultListModel<Parcel> listModel5 = new DefaultListModel<Parcel>();
		for(Parcel i:sys.getAllParcelsMap().values()) {
			listModel5.addElement(i);
		}
		JList<Parcel> list5 = new JList<Parcel>(listModel5);
		list5.setBackground(new Color(25, 25, 112));
		list5.setVisibleRowCount(5);
		list5.setCellRenderer(new ParcelCellRenderer());
		list5.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list5.setEnabled(true);
		JScrollPane allParcels = new JScrollPane(list5);
		allParcels.setBounds(308, 202, 154, 164);
		adminPanel.add(allParcels);
		JLabel lblAllParcels = new JLabel("All Parcels");
		lblAllParcels.setBackground(new Color(25, 25, 112));
		lblAllParcels.setForeground(new Color(255, 255, 255));
		lblAllParcels.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllParcels.setOpaque(true);
		allParcels.setColumnHeaderView(lblAllParcels);
		
		@SuppressWarnings({ "rawtypes" })
		class DriverCellRenderer extends JLabel implements ListCellRenderer {
			private static final long serialVersionUID = 1L;
			private final Color HIGHLIGHT_COLOR = new Color(255, 255, 255);
			  public DriverCellRenderer() {
			    setOpaque(true);
			    setIconTextGap(12);
			  }
			  public Component getListCellRendererComponent(JList list, Object value,
			      int index, boolean isSelected, boolean cellHasFocus) {
			    Driver i = (Driver) value;
			    setFont(new Font("Tahoma", Font.PLAIN, 11));
			    if(i.isDriverInUse())
			    	setText(String.format("(Driving)     %s %s %s", i.getId(),i.getFirstName(),i.getSurname()));
			    else
			    	setText(String.format("(Available) %s %s %s", i.getId(),i.getFirstName(),i.getSurname()));
			    if (isSelected) {
				      setBackground(HIGHLIGHT_COLOR);
				      setForeground(new Color(25, 25, 112));
				    }
			    else {
				      setBackground(new Color(25, 25, 112));
				      setForeground(Color.white);
				}
			    return this;
			  }
			}
		DefaultListModel<Driver> listModel7 = new DefaultListModel<Driver>();
		for(Driver i:sys.getAllDrivers()) {
			listModel7.addElement(i);
		}
		JList<Driver> list7 = new JList<Driver>(listModel7);
		list7.setBackground(new Color(25, 25, 112));
		list7.setVisibleRowCount(5);
		list7.setCellRenderer(new DriverCellRenderer());
		list7.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list7.setEnabled(false);
		JScrollPane allDrivers = new JScrollPane(list7);
		allDrivers.setBounds(154, 32, 154, 164);
		adminPanel.add(allDrivers);
		JLabel lblAllDrivers= new JLabel("All Drivers");
		lblAllDrivers.setBackground(new Color(25, 25, 112));
		lblAllDrivers.setForeground(new Color(255, 255, 255));
		lblAllDrivers.setOpaque(true);
		lblAllDrivers.setHorizontalAlignment(SwingConstants.CENTER);
		allDrivers.setColumnHeaderView(lblAllDrivers);
		
		
		
		@SuppressWarnings({ "rawtypes" })
		class WarehouseCellRenderer extends JLabel implements ListCellRenderer {
			private static final long serialVersionUID = 1L;
			private final Color HIGHLIGHT_COLOR = new Color(255, 255, 255);

			  public WarehouseCellRenderer() {
			    setOpaque(true);
			    setIconTextGap(12);
			  }
			  public Component getListCellRendererComponent(JList list, Object value,
			      int index, boolean isSelected, boolean cellHasFocus) {
			    WareHouse i = (WareHouse) value;
			    setFont(new Font("Tahoma", Font.PLAIN, 11));
			    setText(String.format("(%s) %s", i.getWarehouseId(),i.getAddress().getCity()));
			    if (isSelected) {
				      setBackground(HIGHLIGHT_COLOR);
				      setForeground(new Color(25, 25, 112));
				    }
			    else {
				      setBackground(new Color(25, 25, 112));
				      setForeground(Color.white);
				}
			    return this;
			  }
			}
		DefaultListModel<WareHouse> listModel6 = new DefaultListModel<WareHouse>();
		for(WareHouse i:SysData.getInstance().getAllWareHouses().values()) {
			listModel6.addElement(i);
		}
		JList<WareHouse> list6 = new JList<WareHouse>(listModel6);
		list6.setBackground(new Color(25, 25, 112));
		list6.setVisibleRowCount(5);
		list6.setCellRenderer(new WarehouseCellRenderer());
		list6.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list6.setEnabled(true);
		list6.addMouseListener(new MouseAdapter() {// Double-click listener
			public void mouseClicked(MouseEvent mouseEvent) {
		        JList<String> theList = (JList<String>) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2) {
		          int index = theList.locationToIndex(mouseEvent.getPoint());
		          if (index >= 0) {
		            Object o = theList.getModel().getElementAt(index);
		            warehouse=(WareHouse)o;
		            WarehousePanel.btnRefresh.doClick();
		            switchPanels(whPanel);
		            revalidate();
		            repaint();
		          }
		        }
		      }
		});
		JScrollPane allWareHouses = new JScrollPane(list6);
		allWareHouses.setBounds(0, 202, 154, 164);
		adminPanel.add(allWareHouses);
		JLabel lblAllWareHouses = new JLabel("All WareHouses");
		lblAllWareHouses.setBackground(new Color(25, 25, 112));
		lblAllWareHouses.setForeground(new Color(255, 255, 255));
		lblAllWareHouses.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllWareHouses.setOpaque(true);
		allWareHouses.setColumnHeaderView(lblAllWareHouses);
		
		
		//------------------------RECEIVER PANEL-------------------
		JLabel lblReceiverPanel = new JLabel("Receiver Panel");
		lblReceiverPanel.setForeground(new Color(255, 255, 255));
		lblReceiverPanel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReceiverPanel.setBounds(169, 379, 128, 14);
		receiverPanel.add(lblReceiverPanel);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBackground(new Color(25, 25, 112));
		menuBar_1.setBounds(0, 0, 464, 21);
		menuBar.setBounds(0, 0, 462, 21);
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(25, 25, 112));
		menuBar.setOpaque(true);
		receiverPanel.add(menuBar_1);
		
		
		JMenu mnQueries_1 = new JMenu("Queries");
		menuChanger(mnQueries_1);
		menuBar_1.add(mnQueries_1);
		
		JMenuItem mntmParcelLocation_1 = new JMenuItem("Parcel location");
		mntmParcelLocation_1.setIcon(packageLocationIcon);
		menuItemChanger(mntmParcelLocation_1);
		mnQueries_1.add(mntmParcelLocation_1);
		mntmParcelLocation_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ParcelLocationPanel.btnRefresh.doClick();
				switchPanels(pLocationPanel);
			}
		});
		
		Icon receivedItemsIcon = new ImageIcon(getClass().getClassLoader().getResource("received_items_icon.png"));
		JMenuItem mntmReceivedItems = new JMenuItem("Received items");
		mntmReceivedItems.setIcon(receivedItemsIcon);
		menuItemChanger(mntmReceivedItems);
		mnQueries_1.add(mntmReceivedItems);
		mntmReceivedItems.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AllReceivedItemsPanel.btnRefresh.doClick();
				switchPanels(receivedItemsPanel);
			}
		});
		
		if(id!=null) {
			Receiver r=sys.getAllReciversMap().get(Long.parseLong(id));
			lblFullName = new JLabel("Full name: "+r.getFirstName() +" "+r.getSurname());
			lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblFullName.setForeground(new Color(255, 255, 255));
			lblFullName.setBounds(10, 32, 287, 21);
			receiverPanel.add(lblFullName);
			
			lblAddress = new JLabel("Address: "+r.getAddress().getStreet()+" "+r.getAddress().getHouseNumber()+", "+r.getAddress().getCity()+", "+r.getAddress().getZipCode()+".");
			lblAddress.setForeground(new Color(255, 255, 255));
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblAddress.setBounds(10, 64, 287, 21);
			receiverPanel.add(lblAddress);
			
			lblEmail = new JLabel("E-mail: "+r.getEmail());
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblEmail.setForeground(new Color(255, 255, 255));
			lblEmail.setBounds(10, 96, 287, 21);
			receiverPanel.add(lblEmail);
			
			lblId = new JLabel("ID: "+r.getId());
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblId.setForeground(new Color(255, 255, 255));
			lblId.setBounds(10, 128, 287, 21);
			receiverPanel.add(lblId);
			repaint();
		}
		
		
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.setBackground(new Color(25, 25, 112));
		btnBack_2.setForeground(new Color(255, 255, 255));
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(loginPanel);
			}
		});
		btnBack_2.setBounds(10, 377, 89, 23);
		receiverPanel.add(btnBack_2);
		
		btnRefresh_1 = new JButton("Refresh");
		btnRefresh_1.setBackground(new Color(25, 25, 112));
		btnRefresh_1.setForeground(new Color(255, 255, 255));
		btnRefresh_1.setBounds(365, 377, 89, 23);
		btnRefresh_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Receiver permissions");
				receiverPanel.remove(lblFullName);
				receiverPanel.remove(lblAddress);
				receiverPanel.remove(lblEmail);
				receiverPanel.remove(lblId);
				Receiver r=sys.getAllReciversMap().get(Long.parseLong(id));
				lblFullName = new JLabel("Full name: "+r.getFirstName() +" "+r.getSurname());
				lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblFullName.setForeground(new Color(255, 255, 255));
				lblFullName.setBounds(10, 32, 287, 21);
				receiverPanel.add(lblFullName);
				
				lblAddress = new JLabel("Address: "+r.getAddress().getStreet()+" "+r.getAddress().getHouseNumber()+", "+r.getAddress().getCity()+", "+r.getAddress().getZipCode()+".");
				lblAddress.setForeground(new Color(255, 255, 255));
				lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblAddress.setBounds(10, 64, 287, 21);
				receiverPanel.add(lblAddress);
				
				lblEmail = new JLabel("E-mail: "+r.getEmail());
				lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblEmail.setForeground(new Color(255, 255, 255));
				lblEmail.setBounds(10, 96, 287, 21);
				receiverPanel.add(lblEmail);
				
				lblId = new JLabel("ID: "+r.getId());
				lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblId.setForeground(new Color(255, 255, 255));
				lblId.setBounds(10, 128, 287, 21);
				receiverPanel.add(lblId);
				repaint();
			}
		});
		receiverPanel.add(btnRefresh_1);
		
		
		
		//--------------------COORDINATOR PANEL----------------------
		
		JLabel lblCoordinatorPanel = new JLabel("Coordinator panel");
		lblCoordinatorPanel.setBounds(185, 381, 101, 14);
		lblCoordinatorPanel.setForeground(new Color(255, 255, 255));
		coordinatorPanel.add(lblCoordinatorPanel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBounds(10, 377, 89, 23);
		coordinatorPanel.add(btnBack);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(0, 0, 464, 21);
		menuBar_2.setForeground(new Color(255, 255, 255));
		menuBar_2.setBackground(new Color(25, 25, 112));
		menuBar_2.setOpaque(true);
		coordinatorPanel.add(menuBar_2);
		
		JMenu mnQueries_2 = new JMenu("Actions/Queries");
		mnQueries_2.setForeground(new Color(255, 255, 255));
		menuBar_2.add(mnQueries_2);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(loginPanel);
			}
		});
		
		JMenu mnVehicles2 = new JMenu("Add Vehicles");
		mnVehicles2.setIcon(vehicleIcon);
		menuChanger(mnVehicles2);
		mnQueries_2.add(mnVehicles2);
		
		JMenuItem mntmAddCar2 = new JMenuItem("Add Car");
		mntmAddCar2.setIcon(carIcon);
		menuItemChanger(mntmAddCar2);
		mnVehicles2.add(mntmAddCar2);
		mntmAddCar2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddCarPanel.btnRefresh.doClick();
				switchPanels(addCPanel);
			}
		});
		 
		JMenuItem mntmAddTruck2 = new JMenuItem("Add Truck");
		mntmAddTruck2.setIcon(truckIcon);
		menuItemChanger(mntmAddTruck2);
		mnVehicles2.add(mntmAddTruck2);
		mntmAddTruck2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddTruckPanel.btnRefresh.doClick();
				switchPanels(addTPanel);
			}
		});
		
		
		JMenuItem mntmPlanRouteFor = new JMenuItem("Plan Route for Trucks");
		mntmPlanRouteFor.setBackground(new Color(25, 25, 112));
		mntmPlanRouteFor.setForeground(new Color(255, 255, 255));
		mntmPlanRouteFor.setIcon(planRouteIcon);
		mnQueries_2.add(mntmPlanRouteFor);
		mntmPlanRouteFor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlanDeliveryPanel.btnRefresh.doClick();
				switchPanels(planDeliveryPanel);
			}
		});

		
		JMenuItem mntmLoadTruck2 = new JMenuItem("Load Truck (manually)");
		mntmLoadTruck2.setIcon(loadTruckIcon);
		menuItemChanger(mntmLoadTruck2);
		mnQueries_2.add(mntmLoadTruck2);
		mntmLoadTruck2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoadTruckPanel.btnRefresh.doClick();
				switchPanels(loadTPanel);
			}
		});
		
		
		DefaultListModel<Driver> listModel7_2 = new DefaultListModel<Driver>();
		for(Driver i:sys.getAllDrivers()) {
			listModel7_2.addElement(i);
		}
		JList<Driver> list7_2 = new JList<Driver>(listModel7_2);
		list7_2.setBackground(new Color(25, 25, 112));
		list7_2.setVisibleRowCount(5);
		list7_2.setCellRenderer(new DriverCellRenderer());
		list7_2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list7_2.setEnabled(false);
		JScrollPane allDrivers_2 = new JScrollPane(list7_2);
		allDrivers_2.setBounds(10, 32, 218, 334);
		coordinatorPanel.add(allDrivers_2);
		JLabel lblAllDrivers_2= new JLabel("All Drivers");
		lblAllDrivers_2.setBackground(new Color(25, 25, 112));
		lblAllDrivers_2.setForeground(new Color(255, 255, 255));
		lblAllDrivers_2.setOpaque(true);
		lblAllDrivers_2.setHorizontalAlignment(SwingConstants.CENTER);
		allDrivers_2.setColumnHeaderView(lblAllDrivers_2);
		
		DefaultListModel<Vehicle> listModel4_2 = new DefaultListModel<Vehicle>();
		for(Vehicle i:sys.getAllVehiclesMap().values()) {
			listModel4_2.addElement(i);
		}
		JList<Vehicle> list4_2 = new JList<Vehicle>(listModel4_2);
		list4_2.setBackground(new Color(25, 25, 112));
		list4_2.setVisibleRowCount(5);
		list4_2.setCellRenderer(new VehicleCellRenderer());
		list4_2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list4_2.setEnabled(true);
		JScrollPane allVehicles_2 = new JScrollPane(list4_2);
		allVehicles_2.setBounds(236, 32, 218, 334);
		coordinatorPanel.add(allVehicles_2);
		JLabel lblAllVehicles_2 = new JLabel("All Vehicles");
		lblAllVehicles_2.setBackground(new Color(25, 25, 112));
		lblAllVehicles_2.setForeground(new Color(255, 255, 255));
		lblAllVehicles_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllVehicles_2.setOpaque(true);
		allVehicles_2.setColumnHeaderView(lblAllVehicles_2);
		
		
		
		@SuppressWarnings({ "rawtypes" })
		class WhOriginDestCellRenderer extends JLabel implements ListCellRenderer {
			private static final long serialVersionUID = 1L;
			private final Color HIGHLIGHT_COLOR = new Color(255, 255, 255);

			  public WhOriginDestCellRenderer() {
			    setOpaque(true);
			    setIconTextGap(12);
			  }
			  public Component getListCellRendererComponent(JList list, Object value,
			    int index, boolean isSelected, boolean cellHasFocus) {
				LinkedHashMap<WareHouse,WareHouse> p = (LinkedHashMap<WareHouse,WareHouse>) value;
				WareHouse tempW=(WareHouse) p.keySet().toArray()[0];
			    setFont(new Font("Tahoma", Font.PLAIN, 11));
			    setText(String.format("%s -> %s", tempW.getWarehouseId(),p.get(tempW).getWarehouseId()));
			    setHorizontalAlignment(SwingConstants.CENTER);
			    if (isSelected) {
				      setBackground(HIGHLIGHT_COLOR);
				      setForeground(new Color(25, 25, 112));
				    }
			    else {
				      setBackground(new Color(25, 25, 112));
				      setForeground(Color.white);
				}
			    return this;
			  }
			}
		DefaultListModel<LinkedHashMap<WareHouse, WareHouse>> listModel6_2 = new DefaultListModel<LinkedHashMap<WareHouse, WareHouse>>();
		if(sys.getTruckDeliveryRoute()==null) {
			sys.setTruckDeliveryRoute(new HashMap<String, ArrayList<LinkedHashMap<WareHouse,WareHouse>>>());
		}
		else if(vehicle!=null && sys.getTruckDeliveryRoute().size()!=0) {
			for(LinkedHashMap<WareHouse,WareHouse> pair:sys.getTruckDeliveryRoute().get(vehicle.getVin())) {
				listModel6_2.addElement(pair);
			}
		}
		list6_2 = new JList<LinkedHashMap<WareHouse,WareHouse>>(listModel6_2);
		list6_2.setBackground(new Color(25, 25, 112));
		list6_2.setVisibleRowCount(5);
		list6_2.setCellRenderer(new WhOriginDestCellRenderer());
		list6_2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list6_2.setEnabled(true);
		list6_2.addMouseListener(new MouseAdapter() {// Double-click listener
			public void mouseClicked(MouseEvent mouseEvent) {
		        JList<String> theList = (JList<String>) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2) {
		          int index = theList.locationToIndex(mouseEvent.getPoint());
		          if (index >= 0) {
		            Object o = theList.getModel().getElementAt(index);
		            LinkedHashMap<WareHouse, WareHouse> temp=(LinkedHashMap<WareHouse, WareHouse>)o;
		            originWarehouse=(WareHouse)temp.keySet().toArray()[0];
		            destWarehouse=(WareHouse)temp.values().toArray()[0];
		            Session.warehouse=originWarehouse;
		            PlanDeliveryPanel.btnRefresh.doClick();
		            LoadTruckPanel2.btnRefresh.doClick();
		            String s="";
		            for(Parcel p:originWarehouse.getAllParcels()) {
		            	s=String.format("%s\nParcel ID: %s, Weight = %sKg, Receiver = %s %s\n",s, p.getParcelId(),p.getWeight(),p.getReceiver().getFirstName(),p.getReceiver().getSurname());
		            }
		            JOptionPane.showMessageDialog(null, s);
//		            switchPanels(loadTPanel2);
		          }
		        }
		      }
		});
		JScrollPane allWareHouses2 = new JScrollPane(list6_2);
		truckDriverPanel.add(allWareHouses2);
		allWareHouses2.setBounds(365, 32, 89, 334);
		JLabel lblAllWareHouses2 = new JLabel("WH_1 -> WH_2");
		lblAllWareHouses2.setBackground(new Color(25, 25, 112));
		lblAllWareHouses2.setForeground(new Color(255, 255, 255));
		lblAllWareHouses2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllWareHouses2.setOpaque(true);
		allWareHouses2.setColumnHeaderView(lblAllWareHouses2);
		
		
		
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setBackground(new Color(25, 25, 112));
		btnRefresh.setBounds(373, 377, 89, 23);
		
		JLabel lblWaitForMore = new JLabel("Wait for more instructions from the Coordinator!");
		lblWaitForMore.setForeground(new Color(255, 215, 0));
		lblWaitForMore.setBounds(10, 284, 312, 14);
		lblWaitForMore.setVisible(false);
		truckDriverPanel.add(lblWaitForMore);
		
		
		ActionListener refreshListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblWaitForMore.setVisible(false);
				
				
				adminPanel.remove(allWareHouses);
				DefaultListModel<WareHouse> listModel6 = new DefaultListModel<WareHouse>();
				for(WareHouse i:SysData.getInstance().getAllWareHouses().values()) {
					listModel6.addElement(i);
				}
				list6.removeAll();
				list6.setModel(listModel6);
				allWareHouses.setBounds(0, 202, 154, 164);
				JLabel lblAllWareHouses = new JLabel("All WareHouses");
				allWareHouses.setColumnHeaderView(lblAllWareHouses);
				lblAllWareHouses.setBackground(new Color(25, 25, 112));
				lblAllWareHouses.setForeground(new Color(255, 255, 255));
				lblAllWareHouses.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllWareHouses.setOpaque(true);
				adminPanel.add(allWareHouses);
				
				truckDriverPanel.remove(allWareHouses);
				DefaultListModel<LinkedHashMap<WareHouse, WareHouse>> listModel6_2 = new DefaultListModel<LinkedHashMap<WareHouse, WareHouse>>();
				if(sys.getTruckDeliveryRoute()==null) {
					sys.setTruckDeliveryRoute(new HashMap<String, ArrayList<LinkedHashMap<WareHouse,WareHouse>>>());
				}
				else if(vehicle!=null && sys.getTruckDeliveryRoute().size()!=0) {
					for(LinkedHashMap<WareHouse,WareHouse> pair:sys.getTruckDeliveryRoute().get(vehicle.getVin())) {
						listModel6_2.addElement(pair);
					}
				}
				list6_2.removeAll();
				list6_2.setModel(listModel6_2);
				allWareHouses2.setBounds(365, 32, 89, 334);
				JLabel lblAllWareHouses2 = new JLabel("WH_1 -> WH_2");
				allWareHouses2.setColumnHeaderView(lblAllWareHouses2);
				lblAllWareHouses2.setBackground(new Color(25, 25, 112));
				lblAllWareHouses2.setForeground(new Color(255, 255, 255));
				lblAllWareHouses2.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllWareHouses2.setOpaque(true);
				truckDriverPanel.add(allWareHouses2);
				
				adminPanel.remove(allUsers);
				DefaultListModel<Person> listModel3 = new DefaultListModel<Person>();
				for(Person i:SysData.getInstance().getAllUsers().values()) {
					listModel3.addElement(i);
				}
				list3.removeAll();
				list3.setModel(listModel3);
				allUsers.setBounds(0, 32, 154, 164);
				JLabel lblAllUsers = new JLabel("All Users");
				allUsers.setColumnHeaderView(lblAllUsers);
				lblAllUsers.setBackground(new Color(25, 25, 112));
				lblAllUsers.setForeground(new Color(255, 255, 255));
				lblAllUsers.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllUsers.setOpaque(true);
				adminPanel.add(allUsers);
				
				adminPanel.remove(allItems);
				DefaultListModel<Item> listModel = new DefaultListModel<Item>();
				for(Item i:SysData.getInstance().getAllItems()) {
					listModel.addElement(i);
				}
				list.removeAll();
				list.setModel(listModel);
				allItems.setBounds(308, 32, 154, 164);
				JLabel lblallItems = new JLabel("All Items");
				allItems.setColumnHeaderView(lblallItems);
				lblallItems.setBackground(new Color(25, 25, 112));
				lblallItems.setForeground(new Color(255, 255, 255));
				lblallItems.setHorizontalAlignment(SwingConstants.CENTER);
				lblallItems.setOpaque(true);
				adminPanel.add(allItems);
				
				adminPanel.remove(allVehicles);
				coordinatorPanel.remove(allVehicles_2);
				DefaultListModel<Vehicle> listModel4 = new DefaultListModel<Vehicle>();
				for(Vehicle i:SysData.getInstance().getAllVehiclesMap().values()) {
					listModel4.addElement(i);
				}
				DefaultListModel<Vehicle> listModel4_2 = new DefaultListModel<Vehicle>();
				for(Vehicle i:sys.getAllVehiclesMap().values()) {
					listModel4_2.addElement(i);
				}
				list4.removeAll();
				list4_2.removeAll();
				list4.setModel(listModel4);
				list4_2.setModel(listModel4);
				list4.addMouseListener(new MouseAdapter() {// Double-click listener
					public void mouseClicked(MouseEvent mouseEvent) {
				        JList<String> theList = (JList<String>) mouseEvent.getSource();
				        if (mouseEvent.getClickCount() == 2) {
				          int index = theList.locationToIndex(mouseEvent.getPoint());
				          if (index >= 0) {
				            Object o = theList.getModel().getElementAt(index);
				            vehicle=(Vehicle)o;
				            VehiclePanel.btnRefresh.doClick();
				            switchPanels(vPanel);
				          }
				        }
				      }
				});
				list4_2.addMouseListener(new MouseAdapter() {// Double-click listener
					public void mouseClicked(MouseEvent mouseEvent) {
				        JList<String> theList = (JList<String>) mouseEvent.getSource();
				        if (mouseEvent.getClickCount() == 2) {
				          int index = theList.locationToIndex(mouseEvent.getPoint());
				          if (index >= 0) {
				            Object o = theList.getModel().getElementAt(index);
				            vehicle=(Vehicle)o;
				            VehiclePanel.btnRefresh.doClick();
				            switchPanels(vPanel);
				          }
				        }
				      }
				});
				allVehicles.setBounds(154, 202, 154, 164);
				allVehicles_2.setBounds(236, 32, 218, 334);
				JLabel lblAllVehicles = new JLabel("All Vehicles");
				allVehicles.setColumnHeaderView(lblAllVehicles);
				lblAllVehicles.setBackground(new Color(25, 25, 112));
				lblAllVehicles.setForeground(new Color(255, 255, 255));
				lblAllVehicles.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllVehicles.setOpaque(true);
				JLabel lblAllVehicles_2 = new JLabel("All Vehicles");
				allVehicles_2.setColumnHeaderView(lblAllVehicles_2);
				lblAllVehicles_2.setBackground(new Color(25, 25, 112));
				lblAllVehicles_2.setForeground(new Color(255, 255, 255));
				lblAllVehicles_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllVehicles_2.setOpaque(true);
				adminPanel.add(allVehicles);
				coordinatorPanel.add(allVehicles_2);
				
				adminPanel.remove(allParcels);
				DefaultListModel<Parcel> listModel5 = new DefaultListModel<Parcel>();
				for(Parcel i:SysData.getInstance().getAllParcelsMap().values()) {
					listModel5.addElement(i);
				}
				list5.removeAll();
				list5.setModel(listModel5);
				list5.addMouseListener(new MouseAdapter() {// Double-click listener
					public void mouseClicked(MouseEvent mouseEvent) {
				        JList<String> theList = (JList<String>) mouseEvent.getSource();
				        if (mouseEvent.getClickCount() == 2) {
				          int index = theList.locationToIndex(mouseEvent.getPoint());
				          if (index >= 0) {
				            Object o = theList.getModel().getElementAt(index);
				            parcel=(Parcel)o;
				            ParcelPanel.btnRefresh.doClick();
				            switchPanels(pPanel);
				          }
				        }
				      }
				});
				allParcels.setBounds(308, 202, 154, 164);
				JLabel lblAllParcels = new JLabel("All Parcels");
				allParcels.setColumnHeaderView(lblAllParcels);
				lblAllParcels.setBackground(new Color(25, 25, 112));
				lblAllParcels.setForeground(new Color(255, 255, 255));
				lblAllParcels.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllParcels.setOpaque(true);
				adminPanel.add(allParcels);
				
				adminPanel.remove(allDrivers);
				coordinatorPanel.remove(allDrivers_2);
				DefaultListModel<Driver> listModel7 = new DefaultListModel<Driver>();
				for(Driver i:sys.getAllDrivers()) {
					listModel7.addElement(i);
				}
				DefaultListModel<Driver> listModel7_2 = new DefaultListModel<Driver>();
				for(Driver i:sys.getAllDrivers()) {
					listModel7_2.addElement(i);
				}
				list7.removeAll();
				list7_2.removeAll();
				list7.setModel(listModel7);
				list7_2.setModel(listModel7_2);
				allDrivers.setBounds(154, 32, 154, 164);
				allDrivers_2.setBounds(10, 32, 218, 334);
				JLabel lblAllDrivers= new JLabel("All Drivers");
				allDrivers.setColumnHeaderView(lblAllDrivers);
				lblAllDrivers.setBackground(new Color(25, 25, 112));
				lblAllDrivers.setForeground(new Color(255, 255, 255));
				lblAllDrivers.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllDrivers.setOpaque(true);
				JLabel lblAllDrivers_2= new JLabel("All Drivers");
				allDrivers.setColumnHeaderView(lblAllDrivers_2);
				lblAllDrivers_2.setBackground(new Color(25, 25, 112));
				lblAllDrivers_2.setForeground(new Color(255, 255, 255));
				lblAllDrivers_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblAllDrivers_2.setOpaque(true);
				adminPanel.add(allDrivers);
				coordinatorPanel.add(allDrivers_2);
				
				
				
				
				
				
				
				
				adminPanel.revalidate();
				adminPanel.repaint();
				coordinatorPanel.revalidate();
				coordinatorPanel.repaint();
				truckDriverPanel.revalidate();
				truckDriverPanel.repaint();
				
				revalidate();
				repaint();
			}
		};
		btnRefresh.addActionListener(refreshListener);
		adminPanel.add(btnRefresh);
		
		
		JButton btnRefresh_3 = new JButton("Refresh");
		btnRefresh_3.setForeground(new Color(255, 255, 255));
		btnRefresh_3.setBackground(new Color(25, 25, 112));
		btnRefresh_3.setBounds(365, 377, 89, 23);
		truckDriverPanel.add(btnRefresh_3);
		btnRefresh_3.addActionListener(refreshListener);
		
		ActionListener parcelInW2T2W=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblWaitForMore.setVisible(false);
				ListModel<LinkedHashMap<WareHouse, WareHouse>> model = list6_2.getModel();
				if(model.getSize()>0) {
					LinkedHashMap<WareHouse, WareHouse> pair = model.getElementAt(0);
					originWarehouse=(WareHouse) pair.keySet().toArray()[0];
					destWarehouse=(WareHouse) pair.values().toArray()[0];
					Truck t=null;
			    	if(sys.getAllVehiclesMap().get(vehicle.getVin()).getClass().equals(Truck.class))
						t=(Truck)sys.getAllVehiclesMap().get(vehicle.getVin());
			    	t.setNextWh(destWarehouse);
					btnRefresh_3.doClick();
					LoadTruckPanel2.btnRefresh.doClick();
					switchPanels(loadTPanel2);
				}
				else {
					lblWaitForMore.setVisible(true);
				}
				
				
			}
		};
		
		
		JButton btnRefresh_2 = new JButton("Refresh");
		btnRefresh_2.setBackground(new Color(25, 25, 112));
		btnRefresh_2.setForeground(new Color(255, 255, 255));
		btnRefresh_2.setBounds(365, 377, 89, 23);
		coordinatorPanel.add(btnRefresh_2);
		btnRefresh_2.addActionListener(refreshListener);
		
		
		//-----------------------TRUCK DRIVER PANEL-------------------------
		JLabel lblTruckDriverPanel = new JLabel("Truck driver panel");
		lblTruckDriverPanel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTruckDriverPanel.setForeground(new Color(255, 255, 255));
		lblTruckDriverPanel.setBounds(164, 381, 113, 14);
		truckDriverPanel.add(lblTruckDriverPanel);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.setForeground(new Color(255, 255, 255));
		btnBack_3.setBackground(new Color(25, 25, 112));
		btnBack_3.setBounds(10, 377, 89, 23);
		truckDriverPanel.add(btnBack_3);
		btnBack_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(loginPanel);
			}
		});
		
		
		JMenuBar menuBar_4 = new JMenuBar();
		menuBar_4.setBackground(new Color(25, 25, 112));
		menuBar_4.setBounds(0, 0, 464, 21);
		menuBar_4.setOpaque(true);
		truckDriverPanel.add(menuBar_4);
		
		JMenu mnActions = new JMenu("Actions");
		mnActions.setBackground(new Color(25, 25, 112));
		mnActions.setForeground(new Color(255, 255, 255));
		mnActions.setOpaque(true);
		menuBar_4.add(mnActions);
		
		JMenuItem mntmAllLoadedParcels = new JMenuItem("All loaded parcels");
		mntmAllLoadedParcels.setBackground(new Color(25, 25, 112));
		mntmAllLoadedParcels.setForeground(new Color(255, 255, 255));
		mntmAllLoadedParcels.setOpaque(true);
		mntmAllLoadedParcels.setIcon(parcelIcon);
		mnActions.add(mntmAllLoadedParcels);
		mntmAllLoadedParcels.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VehiclePanel.btnRefresh.doClick();
				switchPanels(vPanel);
			}
		});
		
		JMenuItem mntmTransferParcelsTo = new JMenuItem("Transfer parcels to next warehouse");
		mntmTransferParcelsTo.setBackground(new Color(25, 25, 112));
		mntmTransferParcelsTo.setForeground(new Color(255, 255, 255));
		mntmTransferParcelsTo.setOpaque(true);
		mntmTransferParcelsTo.setIcon(sendTruckIcon);
		mnActions.add(mntmTransferParcelsTo);
		mntmTransferParcelsTo.addActionListener(parcelInW2T2W);

		
		//-----------------------------------CAR DRIVER PANEL------------------------------------
		JLabel lblCarDriverPanel = new JLabel("Car driver panel");
		lblCarDriverPanel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCarDriverPanel.setForeground(new Color(255, 255, 255));
		lblCarDriverPanel.setBackground(new Color(25, 25, 112));
		lblCarDriverPanel.setBounds(172, 386, 105, 14);
		carDriverPanel.add(lblCarDriverPanel);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setForeground(new Color(255, 255, 255));
		menuBar_3.setBackground(new Color(25, 25, 112));
		menuBar_3.setOpaque(true);
		menuBar_3.setBounds(0, 0, 464, 21);
		carDriverPanel.add(menuBar_3);
		
		JMenu mnActions_1 = new JMenu("Actions");
		mnActions_1.setForeground(new Color(255, 255, 255));
		menuBar_3.add(mnActions_1);
		
		JMenuItem mntmSendParcels = new JMenuItem("Send Parcels to Receiver");
		mntmSendParcels.setIcon(sendParcelsToReceiverIcon);
		menuItemChanger(mntmSendParcels);
		mnActions_1.add(mntmSendParcels);
		mntmSendParcels.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SendParcelsToReceiversPanel.btnRefresh.doClick();
				switchPanels(sendPtoRPanel);
			}
		});
		
		JButton btnBack_4 = new JButton("Back");
		btnBack_4.setForeground(new Color(255, 255, 255));
		btnBack_4.setBackground(new Color(25, 25, 112));
		btnBack_4.setBounds(10, 377, 89, 23);
		carDriverPanel.add(btnBack_4);
		btnBack_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(loginPanel);
			}
		});
		
		
		
		
		revalidate();
		repaint();
	}
	
	/**
	 * Method to help with updating the warehouse ToDo list of a Truck.
	 */
	public static void removeWhsFromTruckList() {
		HashMap<String,ArrayList<LinkedHashMap<WareHouse,WareHouse>>> temp=sys.getTruckDeliveryRoute();
		temp.get(vehicle.getVin()).remove(0);
		sys.setTruckDeliveryRoute(temp);
		MainWindow.save();
	}
	
	/**
	 * Method used in LayeredPane to switch the displayed pane.
	 * @param p panel
	 */
	public void switchPanels(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	/**
	 * Method used to return true if the String s is made of digits only. False otherwise
	 * @param s string
	 * @return true if digits, false otherwise.
	 */
	public static boolean isOnlyDigit(String s)
	{
		return s.matches("\\d+");
	}
	
	/**
	 * Method used to easily change the theme of menus
	 * @param m menu
	 */
	public static void menuChanger(JMenu m) {
		m.setForeground(new Color(255, 255, 255));
		m.setBackground(new Color(25, 25, 112));
		m.setOpaque(true);
	}
	
	/**
	 * Method used to easily change the theme of menuItems
	 * @param m menu item
	 */
	public static void menuItemChanger(JMenuItem m) {
		m.setForeground(new Color(255, 255, 255));
		m.setBackground(new Color(25, 25, 112));
		m.setOpaque(true);
	}
}
