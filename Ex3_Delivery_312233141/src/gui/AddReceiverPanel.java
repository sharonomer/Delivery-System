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
import javax.swing.JOptionPane;
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

public class AddReceiverPanel extends JPanel {
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
	private JTextField email;
	private JPasswordField signUpPw;
	SysData sys=SysData.getInstance();
	/**
	 * Panel for adding a new receiver (sign-up).
	 */
	public AddReceiverPanel() {
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
		datePicker.setBackground(new Color(25, 25, 112));
		datePicker.setForeground(new Color(255, 255, 255));
		datePicker.setBounds(109, 129, 109, 29);
		add(datePicker);
		
		JLabel lblNewUserInfo = new JLabel("New user info:");
		lblNewUserInfo.setForeground(new Color(255, 255, 255));
		lblNewUserInfo.setBounds(0, 0, 174, 32);
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
		comboBox.setBounds(295, 35, 159, 20);
		add(comboBox);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setForeground(new Color(255, 255, 255));
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStreet.setBounds(228, 68, 57, 14);
		add(lblStreet);
		
		street = new JTextField();
		street.setBounds(295, 65, 159, 20);
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
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(10, 173, 57, 14);
		add(lblEmail);
		
		email = new JTextField();
		email.setBounds(109, 172, 345, 20);
		add(email);
		email.setColumns(10);
		
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
		
		JLabel badEmail = new JLabel("Invalid!");
		badEmail.setForeground(Color.RED);
		badEmail.setBounds(64, 175, 128, 14);
		badEmail.setVisible(false);
		add(badEmail);
		
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
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sys = SysData.getInstance();
				idEmptySU.setVisible(false);
				onlyNumsSU.setVisible(false);
				pwEmptySU.setVisible(false);
				idExistsSU.setVisible(false);
				badEmail.setVisible(false);
				streetEmpty.setVisible(false);
				houseEmpty.setVisible(false);
				zipEmpty.setVisible(false);
				noBirthday.setVisible(false);
				noFname.setVisible(false);
				noLname.setVisible(false);
				repaint();
				String id=signUpId.getText();
				@SuppressWarnings("deprecation")
				String p=signUpPw.getText();
				if(isOnlyDigit(id)&&id.length()!=0&&!id.equals("Admin"));
				else {
					if(id.length()==0) {
						onlyNumsSU.setVisible(false);
						idEmptySU.setVisible(true);
						repaint();
					}
					else {
						idEmptySU.setVisible(false);
						onlyNumsSU.setVisible(true);
						repaint();
					}
					if(id.length()!=0&&!id.getClass().equals(Integer.class)) {
						idEmptySU.setVisible(false);
						onlyNumsSU.setVisible(true);
						repaint();
					}
				}
				if(p.length()!=0)
					AddReceiverPanel.this.password=p;
				else {
					pwEmptySU.setVisible(true);
					repaint();
				}
				if(id.equals("Admin")) {
					idExistsSU.setVisible(true);
					onlyNumsSU.setVisible(false);
					idEmptySU.setVisible(false);
				}
				if(!Model.Receiver.checkEmailIsValid(email.getText()))
					badEmail.setVisible(true);
				else
					badEmail.setVisible(false);
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
				if(!idEmptySU.isVisible()&&!pwEmptySU.isVisible()&&!badEmail.isVisible()&&
						!streetEmpty.isVisible()&&!houseEmpty.isVisible()&&!zipEmpty.isVisible()&&
						!noFname.isVisible()&&!noLname.isVisible())
					try{
						boolean doesIdExist=false;
						for(Driver d:SysData.getInstance().allDrivers()) {
							if(d.getId()==Long.parseLong(id)) {
								doesIdExist=true;
							}
						}
						if(sys.getAllLoginInfo().containsKey(Long.parseLong(id))||doesIdExist){
							idExistsSU.setVisible(true);
						}
						else {
							if(houseNum.getText().equals("")) houseNum.setText("1");
							Address address=new Address((E_Cities)comboBox.getSelectedItem(), street.getText(), Integer.parseInt(houseNum.getText()), zipCode.getText());
							sys.addReceiver(Long.parseLong(id), lblFirstName.getText(), lblLastName.getText(),
									(Date)datePicker.getModel().getValue(), address, email.getText());
							if(!sys.addLoginInfo(id, p))
								JOptionPane.showMessageDialog(null, "Couldn't add log-in information.","Error",JOptionPane.ERROR_MESSAGE);
							SysData.getInstance().setAllLoginInfo(sys.getAllLoginInfo());
							SysData.getInstance().setAllReciversMap(sys.getAllReciversMap());
							SysData.getInstance().setAllUsers(sys.getAllUsers());
							try {
								MainWindow.save();
//								MainWindow.reloadDatabase();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							finally {
								Session.btnRefresh.doClick();
								Session.lblUserAddedSuccessfully.setVisible(true);
								switchPanels(Session.loginPanel);
							}
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
					onlyNumsSU.setVisible(false);
					idExistsSU.setVisible(false);
					if(id.length()!=0&&!id.getClass().equals(Integer.class)) {
						idEmptySU.setVisible(false);
						onlyNumsSU.setVisible(true);
					}
				}
				repaint();
			}
		});
		
		JButton btnClearAll = new JButton("Clear all");
		btnClearAll.setBackground(new Color(25, 25, 112));
		btnClearAll.setForeground(new Color(255, 255, 255));
		btnClearAll.setBounds(109, 377, 89, 23);
		add(btnClearAll);
		btnClearAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUpId.setText("");
				signUpPw.setText("");
				lblFirstName.setText("");
				lblLastName.setText("");
				email.setText("");
				street.setText("");
				houseNum.setText("");
				zipCode.setText("");
				datePicker.getModel().setDate(2000, 0, 1);
				idEmptySU.setVisible(false);
				onlyNumsSU.setVisible(false);
				pwEmptySU.setVisible(false);
				idExistsSU.setVisible(false);
				badEmail.setVisible(false);
				streetEmpty.setVisible(false);
				houseEmpty.setVisible(false);
				zipEmpty.setVisible(false);
				noBirthday.setVisible(false);
				noFname.setVisible(false);
				noLname.setVisible(false);
				repaint();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBounds(10, 377, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(Session.loginPanel);
			}
		});
		add(btnBack);
		
		JLabel lblPersonIcon = new JLabel("");
		lblPersonIcon.setBounds(221, 218, 128, 182);
//		lblPersonIcon.setIcon(new ImageIcon("img/person_icon.png"));
		lblPersonIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("person_icon.png")));
		add(lblPersonIcon);
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
