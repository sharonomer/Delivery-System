package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.SysData;
import Model.Driver;
import Utils.Constants;
import Utils.E_ModelType;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AddCarPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String vin;
	@SuppressWarnings("unused")
	private String password;
	private JTextField signUpId;
	private JTextField color;
	SysData sys=SysData.getInstance();
	public static JButton btnRefresh;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Panel for adding a new car.
	 */
	public AddCarPanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel carIcon = new JLabel(" ");
		carIcon.setBounds(128, 206, 326, 125);
//		carIcon.setIcon(new ImageIcon("img/car_side_icon.png"));
		carIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("car_side_icon.png")));
		add(carIcon);
		
		JLabel renaultIcon = new JLabel(" ");
		renaultIcon.setBounds(10, 206, 135, 125);
//		renaultIcon.setIcon(new ImageIcon("img/renault.png"));
		renaultIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("renault.png")));
		renaultIcon.setVisible(true);
		add(renaultIcon);
		JLabel bmwIcon = new JLabel(" ");
		bmwIcon.setBounds(10, 206, 135, 125);
//		bmwIcon.setIcon(new ImageIcon("img/bmw.png"));
		bmwIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("bmw.png")));
		bmwIcon.setVisible(false);
		add(bmwIcon);
		JLabel toyotaIcon = new JLabel(" ");
		toyotaIcon.setBounds(10, 206, 135, 125);
//		toyotaIcon.setIcon(new ImageIcon("img/toyota.png"));
		toyotaIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("toyota.png")));
		toyotaIcon.setVisible(false);
		add(toyotaIcon);
		JLabel mitsubishiIcon = new JLabel(" ");
		mitsubishiIcon.setBounds(10, 206, 135, 125);
//		mitsubishiIcon.setIcon(new ImageIcon("img/mitsubishi.png"));
		mitsubishiIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("mitsubishi.png")));
		mitsubishiIcon.setVisible(false);
		add(mitsubishiIcon);
		JLabel kiaIcon = new JLabel(" ");
		kiaIcon.setBounds(10, 206, 135, 125);
//		kiaIcon.setIcon(new ImageIcon("img/kia.png"));
		kiaIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("kia.png")));
		kiaIcon.setVisible(false);
		add(kiaIcon);
		
		JLabel lblNewUserInfo = new JLabel("New Car:");
		lblNewUserInfo.setForeground(new Color(255, 255, 255));
		lblNewUserInfo.setBounds(0, 0, 285, 32);
		add(lblNewUserInfo);
		lblNewUserInfo.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblId = new JLabel("VIN:");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(10, 36, 46, 14);
		add(lblId);
		
		signUpId = new JTextField();
		signUpId.setBounds(109, 36, 109, 20);
		add(signUpId);
		signUpId.setColumns(10);
		
		JLabel lblFname = new JLabel("Color:");
		lblFname.setForeground(new Color(255, 255, 255));
		lblFname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFname.setBounds(10, 96, 86, 14);
		add(lblFname);
		
		color = new JTextField();
		color.setBounds(109, 95, 109, 20);
		add(color);
		color.setColumns(10);
		
		JLabel lblModelType = new JLabel("Model:");
		lblModelType.setForeground(new Color(255, 255, 255));
		lblModelType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModelType.setBounds(228, 32, 57, 22);
		add(lblModelType);
		
		DefaultComboBoxModel<E_ModelType> comboModel = new DefaultComboBoxModel<E_ModelType>(E_ModelType.values());
		JComboBox<E_ModelType> comboBox = new JComboBox<E_ModelType>(comboModel);
		comboBox.setBounds(305, 35, 109, 20);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				E_ModelType model = (E_ModelType)comboBox.getSelectedItem();
				if(model.equals(Utils.E_ModelType.RENO)) {
					bmwIcon.setVisible(false);
					toyotaIcon.setVisible(false);
					mitsubishiIcon.setVisible(false);
					kiaIcon.setVisible(false);
					renaultIcon.setVisible(true);
				}
				else if(model.equals(Utils.E_ModelType.BMW)) {
					renaultIcon.setVisible(false);
					toyotaIcon.setVisible(false);
					mitsubishiIcon.setVisible(false);
					kiaIcon.setVisible(false);
					bmwIcon.setVisible(true);
				}
				else if(model.equals(Utils.E_ModelType.TOYOTA)) {
					renaultIcon.setVisible(false);
					bmwIcon.setVisible(false);
					mitsubishiIcon.setVisible(false);
					kiaIcon.setVisible(false);
					toyotaIcon.setVisible(true);
				}
				else if(model.equals(Utils.E_ModelType.MITSUBISHI)) {
					renaultIcon.setVisible(false);
					bmwIcon.setVisible(false);
					toyotaIcon.setVisible(false);
					kiaIcon.setVisible(false);
					mitsubishiIcon.setVisible(true);
				}
				else if(model.equals(Utils.E_ModelType.KIA)) {
					renaultIcon.setVisible(false);
					bmwIcon.setVisible(false);
					toyotaIcon.setVisible(false);
					mitsubishiIcon.setVisible(false);
					kiaIcon.setVisible(true);
				}
				else {
					renaultIcon.setVisible(false);
					bmwIcon.setVisible(false);
					toyotaIcon.setVisible(false);
					mitsubishiIcon.setVisible(false);
					kiaIcon.setVisible(false);
				}
			}
		});
		add(comboBox);
		
		
		JLabel lblDriverId = new JLabel("Driver ID:");
		lblDriverId.setForeground(new Color(255, 255, 255));
		lblDriverId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDriverId.setBounds(228, 96, 87, 14);
		add(lblDriverId);
		
		ArrayList<Long> idArr = new ArrayList<Long>();
		for(Driver d:sys.allDrivers())
			if(!d.isDriverInUse())
				idArr.add(d.getId());
		Long[] idArr2 = idArr.toArray(new Long[idArr.size()]);
		DefaultComboBoxModel<Long> comboDriverId = new DefaultComboBoxModel<Long>(idArr2);
		JComboBox<Long> comboBox2 = new JComboBox<Long>(comboDriverId);
		comboBox2.setBounds(305, 95, 109, 20);
		add(comboBox2);
		
		JButton btnSignUp_1 = new JButton("Add");
		btnSignUp_1.setBackground(new Color(25, 25, 112));
		btnSignUp_1.setForeground(new Color(255, 255, 255));
		btnSignUp_1.setBounds(365, 377, 89, 23);
		add(btnSignUp_1);
		
		JLabel lblHasLicense = new JLabel("Hybrid:");
		lblHasLicense.setForeground(new Color(255, 255, 255));
		lblHasLicense.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHasLicense.setBounds(10, 144, 94, 21);
		add(lblHasLicense);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBackground(new Color(25, 25, 112));
		rdbtnYes.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnYes);
		rdbtnYes.setBounds(110, 145, 46, 23);
		rdbtnYes.setSelected(true);
		add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(new Color(25, 25, 112));
		rdbtnNo.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setBounds(164, 145, 54, 23);
		add(rdbtnNo);
		
		JLabel not8Chars = new JLabel("Must be 8 characters!");
		not8Chars.setForeground(Color.RED);
		not8Chars.setBounds(109, 54, 156, 14);
		not8Chars.setVisible(false);
		add(not8Chars);
		
		JLabel vinExistsSU = new JLabel("VIN exists already!");
		vinExistsSU.setForeground(Color.RED);
		vinExistsSU.setBounds(109, 54, 186, 14);
		vinExistsSU.setVisible(false);
		add(vinExistsSU);
		
		JLabel noDrivers = new JLabel("There are no drivers!");
		noDrivers.setForeground(Color.RED);
		noDrivers.setBounds(305, 121, 135, 14);
		noDrivers.setVisible(false);
		add(noDrivers);
		
		JLabel noFname = new JLabel("Can't be empty!");
		noFname.setForeground(Color.RED);
		noFname.setBounds(109, 121, 110, 14);
		noFname.setVisible(false);
		add(noFname);
		
		JLabel lblForbiddenCharacters = new JLabel("Forbidden characters : 'I','O','Q'.");
		lblForbiddenCharacters.setForeground(Color.RED);
		lblForbiddenCharacters.setBounds(108, 54, 207, 14);
		lblForbiddenCharacters.setVisible(false);
		add(lblForbiddenCharacters);
		
		JLabel lblDriverInUse = new JLabel("Driver in use!");
		lblDriverInUse.setForeground(Color.RED);
		lblDriverInUse.setBounds(305, 121, 109, 14);
		lblDriverInUse.setVisible(false);
		add(lblDriverInUse);
		
		btnSignUp_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sys = SysData.getInstance();
				not8Chars.setVisible(false);
				vinExistsSU.setVisible(false);
				noDrivers.setVisible(false);
				noFname.setVisible(false);
				lblForbiddenCharacters.setVisible(false);
				lblDriverInUse.setVisible(false);
				repaint();
				String vin=signUpId.getText();
				if(vin.length()==Utils.Constants.NUM_OF_VIN_CHARACTERS)
					AddCarPanel.this.vin=vin;
				else {
					not8Chars.setVisible(true);
					repaint();
				}
				if(!not8Chars.isVisible())
				{
					char ch;
					char[] charArray = vin.toCharArray();
					for (int i=0; i<Constants.FORBIDDEN_VIN_CHARACTERS.length;i++)
					{
						ch=Constants.FORBIDDEN_VIN_CHARACTERS[i];
						for (int j=0;j<Constants.NUM_OF_VIN_CHARACTERS;j++)
							if (ch==charArray[j])
								lblForbiddenCharacters.setVisible(true);
					}
				}
				if((Long)comboBox2.getSelectedItem()==null) {
					noDrivers.setVisible(true);
				}
				if(color.getText().length()==0)
					noFname.setVisible(true);
				if(comboBox2.getSelectedItem()!=null) {
					for(Driver d:SysData.getInstance().getAllDrivers()) {
						if(d.isDriverInUse()&&d.getId()==(long)comboBox2.getSelectedItem())
							lblDriverInUse.setVisible(true);
					}
				}
				else
					noDrivers.setVisible(true);
				if(!not8Chars.isVisible()&&!noDrivers.isVisible()&&!lblDriverInUse.isVisible()&&
						!noFname.isVisible()&&!lblForbiddenCharacters.isVisible())
					try{
						if(sys.getAllVehiclesMap().containsKey(vin)){
							vinExistsSU.setVisible(true);
						}
						else {
							sys.addCar(vin, color.getText(),(E_ModelType) comboBox.getSelectedItem(),
									(long) comboBox2.getSelectedItem(), (rdbtnYes.isSelected())?true:false);
							String p="";
							for(Driver d:sys.allDrivers())
								if(d.getId()==(long)comboBox2.getSelectedItem())
									p=d.getPassword();
							sys.addLoginInfo(Long.toString((long)comboBox2.getSelectedItem()),p);
							SysData.getInstance().setAllLoginInfo(sys.getAllLoginInfo());
							SysData.getInstance().setAllUsers(sys.getAllUsers());
							SysData.getInstance().setAllVehiclesMap(sys.getAllVehiclesMap());
							try {
								MainWindow.save();
//								MainWindow.reloadDatabase();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							finally {
								Session.btnRefresh.doClick();
								switchPanels(Session.loginPanel);
							}
							
							not8Chars.setVisible(false);
							repaint();
							vinExistsSU.setVisible(false);
							repaint();
						}
					}
				catch (NumberFormatException e1) {
					not8Chars.setVisible(true);
					vinExistsSU.setVisible(false);
					if(vin.length()!=0&&!vin.getClass().equals(Integer.class)) {
						not8Chars.setVisible(false);
					}
				}
				repaint();
			}
		});
		
		
		JButton btnClearAll = new JButton("Clear all");
		btnClearAll.setBackground(new Color(25, 25, 112));
		btnClearAll.setForeground(new Color(255, 255, 255));
		btnClearAll.setBounds(208, 377, 89, 23);
		add(btnClearAll);
		btnClearAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUpId.setText("");
				color.setText("");
				not8Chars.setVisible(false);
				vinExistsSU.setVisible(false);
				noDrivers.setVisible(false);
				noFname.setVisible(false);
				lblForbiddenCharacters.setVisible(false);
				lblDriverInUse.setVisible(false);
				repaint();
			}
		});
		add(btnClearAll);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Session.adminPanel);
			}
		});
		btnBack.setBounds(10, 377, 89, 23);
		add(btnBack);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(new Color(25, 25, 112));
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setBounds(109, 377, 89, 23);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBox2.removeAllItems();
				ArrayList<Long> idArr = new ArrayList<Long>();
				for(Driver d:SysData.getInstance().allDrivers())
					if(!d.isDriverInUse())
						idArr.add(d.getId());
				Long[] idArr2 = idArr.toArray(new Long[idArr.size()]);
				DefaultComboBoxModel<Long> comboDriverId = new DefaultComboBoxModel<Long>(idArr2);
				comboBox2.setModel(comboDriverId);;
				comboBox2.setBounds(305, 95, 109, 20);
				add(comboBox2);
			}
		});
		add(btnRefresh);
		
		
		
		
		
	}
	
	public void switchPanels(JPanel p) {
		Session.layeredPane.removeAll();
		Session.layeredPane.add(p);
		Session.layeredPane.repaint();
		Session.layeredPane.revalidate();;
	}
	public static boolean isOnlyDigit(String s)
	{
		return s.matches("\\d+");
	}
}
