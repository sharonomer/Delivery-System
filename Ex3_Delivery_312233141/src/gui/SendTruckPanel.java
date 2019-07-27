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
import Model.Item;
import Model.Truck;
import Model.Vehicle;

public class SendTruckPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String vin;
	public static JButton btnRefresh;
	public static JButton btnSend;
	SysData sys=SysData.getInstance();
	/**
	 * Panel for sending the truck to the next warehouse.
	 */
	public SendTruckPanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblSendTruck = new JLabel("Send Truck to WareHouse:");
		lblSendTruck.setForeground(new Color(255, 255, 255));
		lblSendTruck.setBounds(10, 0, 371, 32);
		add(lblSendTruck);
		lblSendTruck.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblTruck = new JLabel("Truck:");
		lblTruck.setForeground(new Color(255, 255, 255));
		lblTruck.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTruck.setBounds(10, 43, 89, 14);
		add(lblTruck);
		
		JLabel lblYouMustSelect = new JLabel("Please select a truck.");
		lblYouMustSelect.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYouMustSelect.setForeground(Color.RED);
		lblYouMustSelect.setBounds(228, 45, 187, 14);
		add(lblYouMustSelect);
		lblYouMustSelect.setVisible(false);
		
		ArrayList<String> idArr = new ArrayList<String>();
		for(Vehicle v:sys.getAllVehiclesMap().values()) {
			if(v instanceof Truck) {
				idArr.add(v.getVin());
			}
		}
		String[] idArr2 = idArr.toArray(new String[idArr.size()]);
		DefaultComboBoxModel<String> comboTruckId = new DefaultComboBoxModel<String>(idArr2);
		JComboBox<String> comboBoxTruck = new JComboBox<String>(comboTruckId);
		comboBoxTruck.setBounds(109, 43, 109, 20);
		comboBoxTruck.setSelectedIndex(-1);
		if(Session.id!=null&&!Session.id.equals("Admin")&&sys.getAllUsers().get(Long.parseLong(Session.id)).getUserType().equals(Utils.E_UserType.TRUCK_DRIVER)) {
			for(Vehicle v:sys.getAllVehiclesMap().values()) {
				if(v.getDriver().equals(sys.getAllUsers().get(Long.parseLong(Session.id)))) {
					for(int i=0;i<idArr2.length;i++) {
						if(idArr2[i].equals(v.getVin())) {
							comboBoxTruck.setSelectedIndex(i);
							comboBoxTruck.setEnabled(false);
						}
					}
				}
			}
		}
		if(Session.id!=null&&Session.id.equals("Admin"))
			comboBoxTruck.setEnabled(true);
		add(comboBoxTruck);
		
		
		btnSend = new JButton("Send");
		btnSend.setBackground(new Color(25, 25, 112));
		btnSend.setForeground(new Color(255, 255, 255));
		btnSend.setBounds(365, 377, 89, 23);
		add(btnSend);		
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sys = SysData.getInstance();
				lblYouMustSelect.setVisible(false);
				if(comboBoxTruck.getSelectedItem()==null)
					lblYouMustSelect.setVisible(true);
				else {
					if(sys.sendTruckToWareHouse((String)comboBoxTruck.getSelectedItem()))
						System.out.println("Sent truck to destination successfully.");
					try {
						MainWindow.save();
//						MainWindow.reloadDatabase();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					finally {
						Session.removeWhsFromTruckList();
						Session.btnRefresh.doClick();
						switchPanels(Session.truckDriverPanel);
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
				switchPanels(Session.truckDriverPanel);
			}
		});
		btnBack.setBounds(10, 377, 89, 23);
		add(btnBack);
		
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(new Color(25, 25, 112));
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setBounds(109, 377, 89, 23);
		add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblYouMustSelect.setVisible(false);
				comboBoxTruck.removeAllItems();
				remove(comboBoxTruck);
				idArr.clear();
				for(Vehicle v:sys.getAllVehiclesMap().values()) {
					if(v instanceof Truck) {
						idArr.add(v.getVin());
					}
				}
				String[] idArr2 = idArr.toArray(new String[idArr.size()]);
				DefaultComboBoxModel<String> comboTruckId = new DefaultComboBoxModel<String>(idArr2);
				comboBoxTruck.setBounds(109, 43, 109, 20);
				comboBoxTruck.setModel(comboTruckId);
				comboBoxTruck.setSelectedIndex(-1);
				if(Session.id!=null&&!Session.id.equals("Admin")&&sys.getAllUsers().get(Long.parseLong(Session.id)).getUserType().equals(Utils.E_UserType.TRUCK_DRIVER)) {
					for(Vehicle v:sys.getAllVehiclesMap().values()) {
						if(v.getDriver().equals(sys.getAllUsers().get(Long.parseLong(Session.id)))) {
							for(int i=0;i<idArr2.length;i++) {
								if(idArr2[i].equals(v.getVin())) {
									comboBoxTruck.setSelectedIndex(i);
									comboBoxTruck.setEnabled(false);
								}
							}
						}
					}
				}
				if(Session.id!=null&&Session.id.equals("Admin"))
					comboBoxTruck.setEnabled(true);
				add(comboBoxTruck);
				repaint();
				revalidate();
			}
		});
		add(btnRefresh);
		
		
		JLabel sendTruckIcon = new JLabel(" ");
		sendTruckIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("send_truck_icon.png")));
		sendTruckIcon.setBounds(10, 68, 444, 298);
		add(sendTruckIcon);
		
		
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
