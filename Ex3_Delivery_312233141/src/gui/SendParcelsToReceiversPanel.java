package gui;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.ListCellRenderer;
import javax.swing.JList;
import Controller.SysData;
import Model.Car;
import Model.Item;
import Model.Vehicle;
import Model.WareHouse;


public class SendParcelsToReceiversPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String vin;
	public static JButton btnRefresh;
	SysData sys=SysData.getInstance();
	/**
	 * Panel for sending a car to it's destinations.
	 */
	public SendParcelsToReceiversPanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblLoadTruck = new JLabel("Load car and send parcels to receivers:");
		lblLoadTruck.setForeground(new Color(255, 255, 255));
		lblLoadTruck.setBounds(10, 0, 404, 32);
		add(lblLoadTruck);
		lblLoadTruck.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblCar = new JLabel("Car:");
		lblCar.setForeground(new Color(255, 255, 255));
		lblCar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCar.setBounds(10, 71, 89, 14);
		add(lblCar);
		
		JLabel lblWareHouse = new JLabel("WareHouse:");
		lblWareHouse.setForeground(new Color(255, 255, 255));
		lblWareHouse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWareHouse.setBounds(10, 28, 100, 32);
		add(lblWareHouse);
		
		JLabel lblYouMustSelect = new JLabel("You must select from all fields!");
		lblYouMustSelect.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYouMustSelect.setForeground(Color.RED);
		lblYouMustSelect.setBounds(267, 73, 187, 14);
		add(lblYouMustSelect);
		lblYouMustSelect.setVisible(false);
		
		ArrayList<String> idArr = new ArrayList<String>();
		for(Vehicle v:sys.getAllVehiclesMap().values()) {
			if(v instanceof Car) {
				idArr.add(v.getVin());
			}
		}
		String[] idArr2 = idArr.toArray(new String[idArr.size()]);
		DefaultComboBoxModel<String> comboCarId = new DefaultComboBoxModel<String>(idArr2);
		JComboBox<String> comboBoxCar = new JComboBox<String>(comboCarId);
		comboBoxCar.setBounds(123, 70, 109, 20);
		add(comboBoxCar);
		if(Session.id!=null&&!Session.id.equals("Admin")&&sys.getAllUsers().get(Long.parseLong(Session.id)).getUserType().equals(Utils.E_UserType.CAR_DRIVER)) {
			for(Vehicle v:sys.getAllVehiclesMap().values()) {
				if(v.getDriver().equals(sys.getAllUsers().get(Long.parseLong(Session.id)))) {
					for(int i=0;i<idArr2.length;i++) {
						if(idArr2[i].equals(v.getVin())) {
							comboBoxCar.setSelectedIndex(i);
							comboBoxCar.setEnabled(false);
						}
					}
				}
			}
		}
		else
			comboBoxCar.setEnabled(true);
		
		
		ArrayList<Integer> widArr = new ArrayList<Integer>();
		for(WareHouse w:sys.getAllWareHouses().values())
		{
			if(w.getAllParcels().size()!=0)
				widArr.add(w.getWarehouseId());
		}
		Integer[] widArr2 = widArr.toArray(new Integer[widArr.size()]);
		DefaultComboBoxModel<Integer> comboWhId = new DefaultComboBoxModel<Integer>(widArr2);
		JComboBox<Integer> comboBoxWhId = new JComboBox<Integer>(comboWhId);
		comboBoxWhId.setBounds(123, 36, 109, 20);
		add(comboBoxWhId);
		
		
		JButton btnSend = new JButton("Send");
		btnSend.setBackground(new Color(25, 25, 112));
		btnSend.setForeground(new Color(255, 255, 255));
		btnSend.setBounds(365, 377, 89, 23);
		add(btnSend);		
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sys = SysData.getInstance();
				lblYouMustSelect.setVisible(false);
				if(comboBoxCar.getSelectedItem()==null||comboBoxWhId.getSelectedItem()==null)
					lblYouMustSelect.setVisible(true);
				else {
					sys.sendParcelsToReceivers((Integer)comboBoxWhId.getSelectedItem(), (String)comboBoxCar.getSelectedItem());
					try {
						MainWindow.save();
//						MainWindow.reloadDatabase();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					finally {
						Session.btnRefresh.doClick();
						switchPanels(Session.loginPanel);
					}
				}
				
				revalidate();
				repaint();
				
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Session.loginPanel);
			}
		});
		btnBack.setBounds(10, 377, 89, 23);
		add(btnBack);
		
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(new Color(25, 25, 112));
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setBounds(113, 377, 89, 23);
		add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblYouMustSelect.setVisible(false);
				idArr.clear();
				comboBoxWhId.removeAllItems();
				comboBoxCar.removeAllItems();
				remove(comboBoxWhId);
				remove(comboBoxCar);
				//-------------------
				for(Vehicle v:sys.getAllVehiclesMap().values()) {
					if(v instanceof Car) {
						idArr.add(v.getVin());
					}
				}
				String[] idArr2 = idArr.toArray(new String[idArr.size()]);
				DefaultComboBoxModel<String> comboCarId = new DefaultComboBoxModel<String>(idArr2);
				comboBoxCar.setBounds(123, 70, 109, 20);
				comboBoxCar.setModel(comboCarId);
				comboBoxCar.setSelectedIndex(-1);
				add(comboBoxCar);
				if(Session.id!=null&&!Session.id.equals("Admin")&&sys.getAllUsers().get(Long.parseLong(Session.id)).getUserType().equals(Utils.E_UserType.CAR_DRIVER)) {
					for(Vehicle v:sys.getAllVehiclesMap().values()) {
						if(v.getDriver().equals(sys.getAllUsers().get(Long.parseLong(Session.id)))) {
							for(int i=0;i<idArr2.length;i++) {
								if(idArr2[i].equals(v.getVin())) {
									comboBoxCar.setSelectedIndex(i);
									comboBoxCar.setEnabled(false);
								}
							}
						}
					}
				}
				else
					comboBoxCar.setEnabled(true);
				
				//------------------------------------------------------				
				ArrayList<Integer> widArr = new ArrayList<Integer>();
				for(WareHouse w:sys.getAllWareHouses().values())
				{
					if(w.getAllParcels().size()!=0)
						widArr.add(w.getWarehouseId());
				}
				Integer[] widArr2 = widArr.toArray(new Integer[widArr.size()]);
				DefaultComboBoxModel<Integer> comboWhId = new DefaultComboBoxModel<Integer>(widArr2);
				comboBoxWhId.setBounds(123, 36, 109, 20);
				comboBoxWhId.setModel(comboWhId);
				comboBoxWhId.setSelectedIndex(-1);
				add(comboBoxWhId);
				//-------------------------------------------------------
				repaint();
				revalidate();
			}
		});
		add(btnRefresh);
		
		JLabel deliverPackageIcon = new JLabel(" ");
		deliverPackageIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("deliver_package_icon.png")));
		deliverPackageIcon.setBounds(76, 96, 283, 273);
		add(deliverPackageIcon);
		
		
		
	}
	
	public void switchPanels(JPanel p) {
		Session.layeredPane.removeAll();
		Session.layeredPane.add(p);
		Session.layeredPane.repaint();
		Session.layeredPane.revalidate();;
	}
	
	@SuppressWarnings("rawtypes")
	static class ItemCellRenderer extends JLabel implements ListCellRenderer {
		private static final long serialVersionUID = 1L;
		private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

		  public ItemCellRenderer() {
		    setOpaque(true);
		    setIconTextGap(12);
		  }
		  public Component getListCellRendererComponent(JList list, Object value,
		      int index, boolean isSelected, boolean cellHasFocus) {
		    Item i = (Item) value;
		    setText(String.format("(%s) %s", i.getCatalogID(),i.getItemName()));
		    if (isSelected) {
		      setBackground(HIGHLIGHT_COLOR);
		      setForeground(Color.white);
		    } else {
		      setBackground(Color.white);
		      setForeground(Color.black);
		    }
		    return this;
		  }
		}
}
