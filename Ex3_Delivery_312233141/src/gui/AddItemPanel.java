package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.SysData;
import Model.Item;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class AddItemPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private long id;
	@SuppressWarnings("unused")
	private String password;
	private JTextField catalogID;
	private JTextField itemName;
	private JTextField price;
	private JTextField weight;
	SysData sys=SysData.getInstance();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Panel for creating a new item.
	 */
	public AddItemPanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblNewUserInfo = new JLabel("New Item:");
		lblNewUserInfo.setForeground(new Color(255, 255, 255));
		lblNewUserInfo.setBounds(0, 0, 285, 32);
		add(lblNewUserInfo);
		lblNewUserInfo.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblId = new JLabel("Catalog ID:");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(10, 36, 94, 20);
		add(lblId);
		
		catalogID = new JTextField();
		catalogID.setBounds(109, 36, 109, 20);
		add(catalogID);
		catalogID.setColumns(10);
		
		JLabel lblFname = new JLabel("Item name:");
		lblFname.setForeground(new Color(255, 255, 255));
		lblFname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFname.setBounds(10, 66, 86, 14);
		add(lblFname);
		
		itemName = new JTextField();
		itemName.setBounds(109, 67, 109, 20);
		add(itemName);
		itemName.setColumns(10);
		
		JLabel lblLname = new JLabel("Price:");
		lblLname.setForeground(new Color(255, 255, 255));
		lblLname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLname.setBounds(10, 99, 81, 14);
		add(lblLname);
		
		price = new JTextField();
		price.setBounds(109, 98, 109, 20);
		add(price);
		price.setColumns(10);
		
		JLabel lblHouse = new JLabel("Weight:");
		lblHouse.setForeground(new Color(255, 255, 255));
		lblHouse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHouse.setBounds(10, 141, 67, 20);
		add(lblHouse);
		
		weight = new JTextField();
		weight.setBounds(109, 140, 39, 20);
		add(weight);
		weight.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(25, 25, 112));
		btnAdd.setBounds(365, 377, 89, 23);
		add(btnAdd);
		
		JLabel lblHasLicense = new JLabel("Free shipping:");
		lblHasLicense.setForeground(new Color(255, 255, 255));
		lblHasLicense.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHasLicense.setBounds(10, 175, 128, 20);
		add(lblHasLicense);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBackground(new Color(25, 25, 112));
		rdbtnYes.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnYes);
		rdbtnYes.setBounds(144, 173, 46, 23);
		rdbtnYes.setSelected(true);
		add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(new Color(25, 25, 112));
		rdbtnNo.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setBounds(192, 173, 54, 23);
		add(rdbtnNo);
		
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
		
		JLabel weightEmpty = new JLabel("Can't be empty!");
		weightEmpty.setForeground(Color.RED);
		weightEmpty.setBounds(108, 158, 110, 14);
		weightEmpty.setVisible(false);
		add(weightEmpty);
		
		JLabel itemNameEmpty = new JLabel("Can't be empty!");
		itemNameEmpty.setForeground(Color.RED);
		itemNameEmpty.setBounds(108, 85, 110, 14);
		itemNameEmpty.setVisible(false);
		add(itemNameEmpty);
		
		JLabel priceEmpty = new JLabel("Can't be empty!");
		priceEmpty.setForeground(Color.RED);
		priceEmpty.setBounds(108, 116, 110, 14);
		priceEmpty.setVisible(false);
		add(priceEmpty);
		
		JLabel lblNotANumber = new JLabel("Not a number!");
		lblNotANumber.setForeground(Color.RED);
		lblNotANumber.setBounds(109, 115, 109, 14);
		lblNotANumber.setVisible(false);
		add(lblNotANumber);
		
		JLabel lblNotANumber2 = new JLabel("Not a number!");
		lblNotANumber2.setForeground(Color.RED);
		lblNotANumber2.setBounds(109, 158, 109, 14);
		lblNotANumber2.setVisible(false);
		add(lblNotANumber2);

		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sys = SysData.getInstance();
				idEmptySU.setVisible(false);
				onlyNumsSU.setVisible(false);
				idExistsSU.setVisible(false);
				weightEmpty.setVisible(false);
				itemNameEmpty.setVisible(false);
				priceEmpty.setVisible(false);
				lblNotANumber.setVisible(false);
				lblNotANumber2.setVisible(false);
				repaint();
				String id=catalogID.getText();
				if(isOnlyDigit(id)&&id.length()!=0)
					AddItemPanel.this.id=Long.parseLong(id);
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
				if(!isNumber(price.getText())) {
					lblNotANumber.setVisible(true);
					priceEmpty.setVisible(false);
				}
				if(!isNumber(weight.getText())) {
					lblNotANumber2.setVisible(true);
					weightEmpty.setVisible(false);
				}
				if(weight.getText().length()==0)
				{
					weightEmpty.setVisible(true);
					lblNotANumber2.setVisible(false);
				}
				if(itemName.getText().length()==0)
					itemNameEmpty.setVisible(true);
				if(price.getText().length()==0)
				{
					priceEmpty.setVisible(true);
					lblNotANumber.setVisible(false);
				}
				if(!idEmptySU.isVisible()&&!weightEmpty.isVisible()&&!lblNotANumber.isVisible()&&!lblNotANumber2.isVisible()&&!itemNameEmpty.isVisible()&&!priceEmpty.isVisible())
					try{
						boolean doesIdExist=false;
						for(Item i:sys.getAllItems()) {
							if(i.getCatalogID()==Long.parseLong(id)) {
								doesIdExist=true;
							}
						}
						if(doesIdExist){
							idExistsSU.setVisible(true);
						}
						else {
							sys.addItem(Long.parseLong(catalogID.getText()),itemName.getText(),Double.parseDouble(price.getText()),
									(rdbtnYes.isSelected())?true:false,Double.parseDouble(weight.getText()));
							SysData.getInstance().setAllItems(sys.allItems());
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
					lblNotANumber.setVisible(false);
					lblNotANumber2.setVisible(false);
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
				catalogID.setText("");
				itemName.setText("");
				price.setText("");
				weight.setText("");
				idEmptySU.setVisible(false);
				onlyNumsSU.setVisible(false);
				idExistsSU.setVisible(false);
				weightEmpty.setVisible(false);
				itemNameEmpty.setVisible(false);
				priceEmpty.setVisible(false);
				lblNotANumber.setVisible(false);
				lblNotANumber2.setVisible(false);
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
		
		JLabel objectsIcon = new JLabel("");
		objectsIcon.setBounds(196, 175, 258, 191);
//		objectsIcon.setIcon(new ImageIcon("img/objects.png"));
		objectsIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("objects.png")));
		add(objectsIcon);
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
	
	public static boolean isNumber(String s) {
		return s.matches("[0-9]+([,.][0-9]{1,2})?");
	}
}
