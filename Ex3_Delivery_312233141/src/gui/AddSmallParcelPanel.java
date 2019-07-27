package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.SysData;
import Model.Receiver;

public class AddSmallParcelPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String vin;
	private JTextField signUpId;
	public static JButton btnRefresh;
	SysData sys=SysData.getInstance();
	/**
	 * Panel for creating a new Small parcel.
	 */
	public AddSmallParcelPanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblNewUserInfo = new JLabel("New Small Parcel:");
		lblNewUserInfo.setForeground(new Color(255, 255, 255));
		lblNewUserInfo.setBounds(10, 49, 285, 32);
		add(lblNewUserInfo);
		lblNewUserInfo.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblId = new JLabel("Parcel ID:");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(10, 156, 94, 14);
		add(lblId);
		
		signUpId = new JTextField();
		signUpId.setBounds(109, 155, 109, 20);
		add(signUpId);
		signUpId.setColumns(10);		
		
		JLabel lblDriverId = new JLabel("Receiver ID:");
		lblDriverId.setForeground(new Color(255, 255, 255));
		lblDriverId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDriverId.setBounds(10, 208, 102, 14);
		add(lblDriverId);
		
		ArrayList<Long> idArr = new ArrayList<Long>();
		for(Receiver r:sys.getAllReciversMap().values())
			idArr.add(r.getId());
		Long[] idArr2 = idArr.toArray(new Long[idArr.size()]);
		DefaultComboBoxModel<Long> comboDriverId = new DefaultComboBoxModel<Long>(idArr2);
		JComboBox<Long> comboBox2 = new JComboBox<Long>(comboDriverId);
		comboBox2.setBounds(109, 207, 109, 20);
		add(comboBox2);
		
		JButton btnSignUp_1 = new JButton("Add");
		btnSignUp_1.setForeground(new Color(255, 255, 255));
		btnSignUp_1.setBackground(new Color(25, 25, 112));
		btnSignUp_1.setBounds(365, 377, 89, 23);
		add(btnSignUp_1);
		
		JLabel vinExistsSU = new JLabel("Parcel ID exists already!");
		vinExistsSU.setForeground(Color.RED);
		vinExistsSU.setBounds(109, 183, 186, 14);
		vinExistsSU.setVisible(false);
		add(vinExistsSU);
		
		JLabel noReceivers = new JLabel("There are no receivers!");
		noReceivers.setForeground(Color.RED);
		noReceivers.setBounds(109, 238, 135, 14);
		noReceivers.setVisible(false);
		add(noReceivers);
		
		JLabel lblCantBeEmpty = new JLabel("Can't be empty!");
		lblCantBeEmpty.setForeground(Color.RED);
		lblCantBeEmpty.setBounds(109, 182, 135, 14);
		lblCantBeEmpty.setVisible(false);
		add(lblCantBeEmpty);
		
		btnSignUp_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sys = SysData.getInstance();
				vinExistsSU.setVisible(false);
				noReceivers.setVisible(false);
				lblCantBeEmpty.setVisible(false);
				repaint();
				String vin=signUpId.getText();
				if(vin.length()!=0)
					AddSmallParcelPanel.this.vin=vin;
				else {
					lblCantBeEmpty.setVisible(true);
					repaint();
				}
				if((Long)comboBox2.getSelectedItem()==null) {
					noReceivers.setVisible(true);
				}
				if(!noReceivers.isVisible()&&!lblCantBeEmpty.isVisible())
					try{
						if(sys.getAllParcelsMap().containsKey(vin)){
							vinExistsSU.setVisible(true);
						}
						else {
							sys.addSmallParcel(signUpId.getText(), (long) comboBox2.getSelectedItem());
							SysData.getInstance().setAllParcels(sys.getAllParcels());
							SysData.getInstance().setAllParcelsMap(sys.getAllParcelsMap());
							SysData.getInstance().setAllWareHouses(sys.getAllWareHouses());
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
							
							repaint();
							vinExistsSU.setVisible(false);
							repaint();
						}
					}
				catch (NumberFormatException e1) {
					vinExistsSU.setVisible(false);
				}
				repaint();
			}
		});
		
		
		JButton btnClearAll = new JButton("Clear all");
		btnClearAll.setForeground(new Color(255, 255, 255));
		btnClearAll.setBackground(new Color(25, 25, 112));
		btnClearAll.setBounds(206, 377, 89, 23);
		add(btnClearAll);
		btnClearAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUpId.setText("");
				vinExistsSU.setVisible(false);
				noReceivers.setVisible(false);
				lblCantBeEmpty.setVisible(false);
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
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setBackground(new Color(25, 25, 112));
		add(btnRefresh);
		btnRefresh.setBounds(109, 377, 89, 23);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBox2.removeAllItems();
				ArrayList<Long> idArr = new ArrayList<Long>();
				for(Receiver r:SysData.getInstance().getAllReciversMap().values())
					idArr.add(r.getId());
				Long[] idArr2 = idArr.toArray(new Long[idArr.size()]);
				DefaultComboBoxModel<Long> comboReceiverId = new DefaultComboBoxModel<Long>(idArr2);
				comboBox2.setModel(comboReceiverId);;
				comboBox2.setBounds(109, 207, 109, 20);
				add(comboBox2);
			}
		});
		add(btnRefresh);
		
		JLabel boxIcon = new JLabel(" ");
		boxIcon.setBounds(229, 127, 225, 194);
//		boxIcon.setIcon(new ImageIcon("img/boxIcon.png"));
		boxIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("boxIcon.png")));
		add(boxIcon);
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
