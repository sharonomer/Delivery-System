package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import Controller.SysData;
import Model.Address;
import Model.Driver;
import Utils.E_Cities;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AddDriverPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private long id;
	@SuppressWarnings("unused")
	private String password;
	private JTextField signUpId;
	private JTextField lblFirstName;
	private JTextField lblLastName;
	private JTextField street;
	private JTextField houseNum;
	private JTextField zipCode;
	private JPasswordField signUpPw;
	SysData sys=MainWindow.sys;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Panel for adding a new driver.
	 */
	public AddDriverPanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		UtilDateModel model = new UtilDateModel();
		Properties pr = new Properties();
		pr.put("text.today", "Today");
		pr.put("text.month", "Month");
		pr.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, pr);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(109, 129, 109, 29);
		add(datePicker);
		
		JLabel lblNewUserInfo = new JLabel("New Driver:");
		lblNewUserInfo.setForeground(new Color(255, 255, 255));
		lblNewUserInfo.setBounds(0, 0, 285, 32);
		add(lblNewUserInfo);
		lblNewUserInfo.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(10, 36, 46, 14);
		add(lblId);
		
		signUpId = new JTextField();
		signUpId.setBounds(109, 36, 109, 20);
		add(signUpId);
		signUpId.setColumns(10);
		
		JLabel lblFname = new JLabel("First name:");
		lblFname.setForeground(new Color(255, 255, 255));
		lblFname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFname.setBounds(10, 66, 86, 14);
		add(lblFname);
		
		lblFirstName = new JTextField();
		lblFirstName.setBounds(109, 67, 109, 20);
		add(lblFirstName);
		lblFirstName.setColumns(10);
		
		JLabel lblLname = new JLabel("Last name:");
		lblLname.setForeground(new Color(255, 255, 255));
		lblLname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLname.setBounds(10, 99, 81, 14);
		add(lblLname);
		
		lblLastName = new JTextField();
		lblLastName.setBounds(109, 98, 109, 20);
		add(lblLastName);
		lblLastName.setColumns(10);
		
		JLabel lblDate = new JLabel("Birth date:");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDate.setBounds(10, 134, 81, 14);
		add(lblDate);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setForeground(new Color(255, 255, 255));
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCity.setBounds(228, 32, 46, 22);
		add(lblCity);
		
		DefaultComboBoxModel<E_Cities> comboModel = new DefaultComboBoxModel<E_Cities>(E_Cities.values());
		JComboBox<E_Cities> comboBox = new JComboBox<E_Cities>(comboModel);
		comboBox.setBounds(295, 35, 109, 20);
		add(comboBox);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setForeground(new Color(255, 255, 255));
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStreet.setBounds(228, 68, 57, 14);
		add(lblStreet);
		
		street = new JTextField();
		street.setBounds(295, 65, 109, 20);
		add(street);
		street.setColumns(10);
		
		JLabel lblHouse = new JLabel("House #:");
		lblHouse.setForeground(new Color(255, 255, 255));
		lblHouse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHouse.setBounds(228, 101, 67, 14);
		add(lblHouse);
		
		houseNum = new JTextField();
		houseNum.setBounds(295, 98, 39, 20);
		add(houseNum);
		houseNum.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setForeground(new Color(255, 255, 255));
		lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblZipCode.setBounds(228, 121, 69, 37);
		add(lblZipCode);
		
		zipCode = new JTextField();
		zipCode.setBounds(295, 129, 86, 20);
		add(zipCode);
		zipCode.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 214, 81, 14);
		add(lblPassword);
		
		JButton btnSignUp_1 = new JButton("Sign up");
		btnSignUp_1.setForeground(new Color(255, 255, 255));
		btnSignUp_1.setBackground(new Color(25, 25, 112));
		btnSignUp_1.setBounds(365, 377, 89, 23);
		add(btnSignUp_1);
		
		signUpPw = new JPasswordField();
		signUpPw.setBounds(109, 213, 109, 20);
		add(signUpPw);
		
		JLabel lblHasLicense = new JLabel("Has License:");
		lblHasLicense.setForeground(new Color(255, 255, 255));
		lblHasLicense.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHasLicense.setBounds(10, 175, 94, 14);
		add(lblHasLicense);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBackground(new Color(25, 25, 112));
		rdbtnYes.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnYes);
		rdbtnYes.setBounds(109, 169, 46, 23);
		rdbtnYes.setSelected(true);
		add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(new Color(25, 25, 112));
		rdbtnNo.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setBounds(164, 169, 54, 23);
		add(rdbtnNo);
		
		JLabel idEmptySU = new JLabel("ID can't be empty!");
		idEmptySU.setForeground(Color.RED);
		idEmptySU.setBounds(109, 54, 109, 14);
		idEmptySU.setVisible(false);
		add(idEmptySU);
		
		JLabel pwEmptySU = new JLabel("Password can't be empty!");
		pwEmptySU.setForeground(Color.RED);
		pwEmptySU.setBounds(109, 199, 165, 14);
		pwEmptySU.setVisible(false);
		add(pwEmptySU);
		
		JLabel idExistsSU = new JLabel("ID exists already!");
		idExistsSU.setForeground(Color.RED);
		idExistsSU.setBounds(109, 54, 186, 14);
		idExistsSU.setVisible(false);
		add(idExistsSU);
		
		JLabel onlyNumsSU = new JLabel("Only digits!");
		onlyNumsSU.setForeground(Color.RED);
		onlyNumsSU.setBounds(109, 54, 128, 14);
		onlyNumsSU.setVisible(false);
		add(onlyNumsSU);
		
		JLabel streetEmpty = new JLabel("Can't be empty!");
		streetEmpty.setForeground(Color.RED);
		streetEmpty.setBounds(294, 85, 109, 14);
		streetEmpty.setVisible(false);
		add(streetEmpty);
		
		JLabel houseEmpty = new JLabel("Can't be empty!");
		houseEmpty.setForeground(Color.RED);
		houseEmpty.setBounds(294, 116, 110, 14);
		houseEmpty.setVisible(false);
		add(houseEmpty);
		
		JLabel zipEmpty = new JLabel("Can't be empty!");
		zipEmpty.setForeground(Color.RED);
		zipEmpty.setBounds(296, 148, 121, 14);
		zipEmpty.setVisible(false);
		add(zipEmpty);
		
		JLabel noBirthday = new JLabel("Choose a birth date!");
		noBirthday.setForeground(Color.RED);
		noBirthday.setBounds(109, 156, 128, 14);
		noBirthday.setVisible(false);
		add(noBirthday);
		
		JLabel noFname = new JLabel("Can't be empty!");
		noFname.setForeground(Color.RED);
		noFname.setBounds(108, 85, 110, 14);
		noFname.setVisible(false);
		add(noFname);
		
		JLabel noLname = new JLabel("Can't be empty!");
		noLname.setForeground(Color.RED);
		noLname.setBounds(108, 116, 110, 14);
		noLname.setVisible(false);
		add(noLname);

		btnSignUp_1.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				sys = SysData.getInstance();
				idEmptySU.setVisible(false);
				onlyNumsSU.setVisible(false);
				pwEmptySU.setVisible(false);
				idExistsSU.setVisible(false);
				streetEmpty.setVisible(false);
				houseEmpty.setVisible(false);
				zipEmpty.setVisible(false);
				noBirthday.setVisible(false);
				noFname.setVisible(false);
				noLname.setVisible(false);
				repaint();
				String id=signUpId.getText();
				String p=signUpPw.getText();
				if(isOnlyDigit(id)&&id.length()!=0&&!id.equals("Admin"))
					AddDriverPanel.this.id=Long.parseLong(id);
				else {
					if(id.length()==0) {
						onlyNumsSU.setVisible(false);
						idEmptySU.setVisible(true);
						repaint();
//						lblUserAddedSuccessfully.setVisible(false);
					}
						
					else {
						idEmptySU.setVisible(false);
						onlyNumsSU.setVisible(true);
						repaint();
					}
					if(id.length()!=0&&!id.getClass().equals(Integer.class)) {
						idEmptySU.setVisible(false);
						onlyNumsSU.setVisible(true);
//						lblUserAddedSuccessfully.setVisible(false);
						repaint();
					}
				}
				if(p.length()!=0)
					AddDriverPanel.this.password=p;
				else {
					pwEmptySU.setVisible(true);
//					lblUserAddedSuccessfully.setVisible(false);
					repaint();
				}
				if(id.equals("Admin")) {
					idExistsSU.setVisible(true);
					onlyNumsSU.setVisible(false);
					idEmptySU.setVisible(false);
				}
				if(street.getText().length()==0)
					streetEmpty.setVisible(true);
				if(houseNum.getText().length()==0)
					houseEmpty.setVisible(true);
				if(zipCode.getText().length()==0)
					zipEmpty.setVisible(true);
				if((Date)datePicker.getModel().getValue()==null)
					noBirthday.setVisible(true);
				if(lblFirstName.getText().length()==0)
					noFname.setVisible(true);
				if(lblLastName.getText().length()==0)
					noLname.setVisible(true);
				if(!idEmptySU.isVisible()&&!pwEmptySU.isVisible()&&
						!streetEmpty.isVisible()&&!houseEmpty.isVisible()&&!zipEmpty.isVisible()&&
						!noFname.isVisible()&&!noLname.isVisible())
					try{
						boolean doesIdExist=false;
						for(Driver d:sys.allDrivers()) {
							if(d.getId()==Long.parseLong(id)) {
								doesIdExist=true;
//								lblUserAddedSuccessfully.setVisible(false);
							}
						}
						if(doesIdExist){
							idExistsSU.setVisible(true);
//							lblUserAddedSuccessfully.setVisible(false);
						}
						else {
							Address address=new Address((E_Cities)comboBox.getSelectedItem(), street.getText(), Integer.parseInt(houseNum.getText()), zipCode.getText());
							boolean hasValidLicense = (rdbtnYes.isSelected())?true:false;
							sys.addDriver(Long.parseLong(id), lblFirstName.getText(), lblLastName.getText(),
									(Date)datePicker.getModel().getValue(), address,hasValidLicense,p);
							SysData.getInstance().setAllDrivers(sys.allDrivers());
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
							
//							lblUserAddedSuccessfully.setVisible(true);
							idEmptySU.setVisible(false);
							pwEmptySU.setVisible(false);
							onlyNumsSU.setVisible(false);
							repaint();
							idExistsSU.setVisible(false);
							repaint();
						}
					}
				catch (NumberFormatException e1) {
					idEmptySU.setVisible(true);
//					lblUserAddedSuccessfully.setVisible(false);
					onlyNumsSU.setVisible(false);
					idExistsSU.setVisible(false);
					if(id.length()!=0&&!id.getClass().equals(Integer.class)) {
						idEmptySU.setVisible(false);
						onlyNumsSU.setVisible(true);
//						lblUserAddedSuccessfully.setVisible(false);
					}
				}
				repaint();
			}
		});
		
		JButton btnClearAll = new JButton("Clear all");
		btnClearAll.setForeground(new Color(255, 255, 255));
		btnClearAll.setBackground(new Color(25, 25, 112));
		btnClearAll.setBounds(109, 377, 89, 23);
		add(btnClearAll);
		btnClearAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUpId.setText("");
				signUpPw.setText("");
				lblFirstName.setText("");
				lblLastName.setText("");
				street.setText("");
				houseNum.setText("");
				zipCode.setText("");
				datePicker.getModel().setDate(2000, 0, 1);
				idEmptySU.setVisible(false);
				onlyNumsSU.setVisible(false);
				pwEmptySU.setVisible(false);
				idExistsSU.setVisible(false);
//				badEmail.setVisible(false);
				streetEmpty.setVisible(false);
				houseEmpty.setVisible(false);
				zipEmpty.setVisible(false);
				noBirthday.setVisible(false);
				noFname.setVisible(false);
				noLname.setVisible(false);
//				lblUserAddedSuccessfully.setVisible(false);
				repaint();
			}
		});
		add(btnClearAll);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Session.adminPanel);
			}
		});
		btnBack.setBounds(10, 377, 89, 23);
		add(btnBack);
		
		JLabel lblReminder = new JLabel("Reminder: The driver can login only after adding a vehicle with his ID!");
		lblReminder.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblReminder.setForeground(new Color(255, 215, 0));
		lblReminder.setBounds(10, 292, 311, 14);
		add(lblReminder);
		
		JLabel driverIcon = new JLabel(" ");
		driverIcon.setBounds(268, 169, 186, 205);
//		driverIcon.setIcon(new ImageIcon("img/driver_icon.png"));
		driverIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("driver_icon.png")));
		add(driverIcon);
		
		
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
