package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.SysData;
import Model.Address;
import Utils.E_Cities;

public class AddWarehousePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private long id;
	@SuppressWarnings("unused")
	private String password;
	private JTextField signUpId;
	private JTextField street;
	private JTextField houseNum;
	private JTextField zipCode;
	SysData sys=SysData.getInstance();
	/**
	 * Panel for adding a new Warehouse.
	 */
	public AddWarehousePanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblNewUserInfo = new JLabel("New WareHouse:");
		lblNewUserInfo.setForeground(new Color(255, 255, 255));
		lblNewUserInfo.setBounds(10, 0, 285, 32);
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
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setForeground(new Color(255, 255, 255));
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCity.setBounds(10, 79, 46, 22);
		add(lblCity);
		
		DefaultComboBoxModel<E_Cities> comboModel = new DefaultComboBoxModel<E_Cities>(E_Cities.values());
		JComboBox<E_Cities> comboBox = new JComboBox<E_Cities>(comboModel);
		comboBox.setBounds(109, 82, 109, 20);
		add(comboBox);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setForeground(new Color(255, 255, 255));
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStreet.setBounds(10, 112, 57, 14);
		add(lblStreet);
		
		street = new JTextField();
		street.setBounds(109, 111, 109, 20);
		add(street);
		street.setColumns(10);
		
		JLabel lblHouse = new JLabel("House #:");
		lblHouse.setForeground(new Color(255, 255, 255));
		lblHouse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHouse.setBounds(10, 148, 67, 14);
		add(lblHouse);
		
		houseNum = new JTextField();
		houseNum.setBounds(109, 147, 39, 20);
		add(houseNum);
		houseNum.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setForeground(new Color(255, 255, 255));
		lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblZipCode.setBounds(10, 185, 69, 37);
		add(lblZipCode);
		
		zipCode = new JTextField();
		zipCode.setBounds(109, 195, 86, 20);
		add(zipCode);
		zipCode.setColumns(10);
		
		JButton btnSignUp_1 = new JButton("Sign up");
		btnSignUp_1.setForeground(new Color(255, 255, 255));
		btnSignUp_1.setBackground(new Color(25, 25, 112));
		btnSignUp_1.setBounds(365, 377, 89, 23);
		add(btnSignUp_1);
		
		JLabel idEmptySU = new JLabel("ID can't be empty!");
		idEmptySU.setForeground(Color.RED);
		idEmptySU.setBounds(109, 54, 109, 14);
		idEmptySU.setVisible(false);
		add(idEmptySU);
		
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
		streetEmpty.setBounds(108, 133, 109, 14);
		streetEmpty.setVisible(false);
		add(streetEmpty);
		
		JLabel houseEmpty = new JLabel("Can't be empty!");
		houseEmpty.setForeground(Color.RED);
		houseEmpty.setBounds(109, 170, 110, 14);
		houseEmpty.setVisible(false);
		add(houseEmpty);
		
		JLabel zipEmpty = new JLabel("Can't be empty!");
		zipEmpty.setForeground(Color.RED);
		zipEmpty.setBounds(109, 216, 121, 14);
		zipEmpty.setVisible(false);
		add(zipEmpty);

		btnSignUp_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sys = SysData.getInstance();
				idEmptySU.setVisible(false);
				onlyNumsSU.setVisible(false);
				idExistsSU.setVisible(false);
//				badEmail.setVisible(false);
				streetEmpty.setVisible(false);
				houseEmpty.setVisible(false);
				zipEmpty.setVisible(false);
				repaint();
				String id=signUpId.getText();
				if(isOnlyDigit(id)&&id.length()!=0)
					AddWarehousePanel.this.id=Long.parseLong(id);
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
				if(street.getText().length()==0)
					streetEmpty.setVisible(true);
				if(houseNum.getText().length()==0)
					houseEmpty.setVisible(true);
				if(zipCode.getText().length()==0)
					zipEmpty.setVisible(true);
				if(!idEmptySU.isVisible()&&!streetEmpty.isVisible()&&!houseEmpty.isVisible()&&!zipEmpty.isVisible())
					try{
						if(sys.getAllWareHouses().containsKey(Integer.parseInt(id)))
							idExistsSU.setVisible(true);
						else {
							Address address=new Address((E_Cities)comboBox.getSelectedItem(), street.getText(), Integer.parseInt(houseNum.getText()), zipCode.getText());
							sys.addWarehouse(Integer.parseInt(signUpId.getText()), address);
							SysData.getInstance().setWareHouses(sys.getWareHouses());
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
							idEmptySU.setVisible(false);
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
		btnClearAll.setForeground(new Color(255, 255, 255));
		btnClearAll.setBackground(new Color(25, 25, 112));
		btnClearAll.setBounds(109, 377, 89, 23);
		add(btnClearAll);
		btnClearAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUpId.setText("");
				street.setText("");
				houseNum.setText("");
				zipCode.setText("");
				idEmptySU.setVisible(false);
				onlyNumsSU.setVisible(false);
				idExistsSU.setVisible(false);
				streetEmpty.setVisible(false);
				houseEmpty.setVisible(false);
				zipEmpty.setVisible(false);
				repaint();
			}
		});
		add(btnClearAll);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Session.loginPanel);
			}
		});
		btnBack.setBounds(10, 377, 89, 23);
		add(btnBack);
		
		JLabel warehouseIcon = new JLabel(" ");
		warehouseIcon.setBounds(191, 169, 263, 197);
//		warehouseIcon.setIcon(new ImageIcon("img/warehouse_icon.png"));
		warehouseIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("warehouse_icon.png")));
		add(warehouseIcon);
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
