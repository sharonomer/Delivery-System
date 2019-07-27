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
import Model.WareHouse;


public class LoadTruckPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String vin;
	public static JButton btnRefresh;
	SysData sys=SysData.getInstance();
	/**
	 * Panel for manually loading a Truck with parcels (Used by admin).
	 */
	public LoadTruckPanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblLoadTruck = new JLabel("Load the truck:");
		lblLoadTruck.setForeground(new Color(255, 255, 255));
		lblLoadTruck.setBounds(10, 0, 285, 32);
		add(lblLoadTruck);
		lblLoadTruck.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblTruck = new JLabel("Truck:");
		lblTruck.setForeground(new Color(255, 255, 255));
		lblTruck.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTruck.setBounds(10, 38, 89, 14);
		add(lblTruck);
		
		JLabel lblOrigin = new JLabel("Origin:");
		lblOrigin.setForeground(new Color(255, 255, 255));
		lblOrigin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrigin.setBounds(10, 63, 89, 32);
		add(lblOrigin);
		
		JLabel lblDest = new JLabel("Dest.:");
		lblDest.setForeground(new Color(255, 255, 255));
		lblDest.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDest.setBounds(237, 64, 46, 30);
		add(lblDest);
		
		JLabel lblYouMustSelect = new JLabel("You must select from all fields!");
		lblYouMustSelect.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYouMustSelect.setForeground(Color.RED);
		lblYouMustSelect.setBounds(227, 39, 187, 14);
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
		comboBoxTruck.setSelectedIndex(-1);
		comboBoxTruck.setBounds(109, 35, 109, 20);
		add(comboBoxTruck);
		
		
		ArrayList<Integer> widArr = new ArrayList<Integer>();
		for(WareHouse w:sys.getAllWareHouses().values())
		{
			if(w.getAllParcels().size()!=0)
				widArr.add(w.getWarehouseId());
		}
		Integer[] widArr2 = widArr.toArray(new Integer[widArr.size()]);
		DefaultComboBoxModel<Integer> comboWhId = new DefaultComboBoxModel<Integer>(widArr2);
		JComboBox<Integer> comboBoxWhId = new JComboBox<Integer>(comboWhId);
		comboBoxWhId.setBounds(109, 71, 109, 20);
		comboBoxWhId.setSelectedIndex(-1);
		add(comboBoxWhId);
		ArrayList<Integer> widArr3 = new ArrayList<Integer>();
		for(WareHouse w:sys.getAllWareHouses().values())
		{
			if(!widArr.contains(w.getWarehouseId()))
				widArr3.add(w.getWarehouseId());
		}
		Integer[] widArr4 = widArr3.toArray(new Integer[widArr3.size()]);
		DefaultComboBoxModel<Integer> comboWhId2 = new DefaultComboBoxModel<Integer>(widArr4);
		JComboBox<Integer> comboBoxWhId2 = new JComboBox<Integer>(comboWhId2);
		comboBoxWhId2.setBounds(293, 71, 109, 20);
		comboBoxWhId2.setSelectedIndex(-1);
		add(comboBoxWhId2);
		
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setForeground(new Color(255, 255, 255));
		btnLoad.setBackground(new Color(25, 25, 112));
		btnLoad.setBounds(365, 377, 89, 23);
		add(btnLoad);		
		btnLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sys = SysData.getInstance();
				lblYouMustSelect.setVisible(false);
				if(comboBoxTruck.getSelectedItem()==null||comboBoxWhId.getSelectedItem()==null||comboBoxWhId2.getSelectedItem()==null)
					lblYouMustSelect.setVisible(true);
				else {
					sys.addAllPossibleParcelsToTruck((String)comboBoxTruck.getSelectedItem(), (Integer)comboBoxWhId.getSelectedItem(), (Integer)comboBoxWhId2.getSelectedItem());
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
		btnRefresh.setBounds(109, 377, 89, 23);
		add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblYouMustSelect.setVisible(false);
				idArr.clear();
				//-------------------
				comboBoxTruck.removeAllItems();
				comboBoxWhId.removeAllItems();
				comboBoxWhId2.removeAllItems();
				remove(comboBoxWhId);
				remove(comboBoxWhId2);
				remove(comboBoxTruck);
				//-------------------
				for(Vehicle v:sys.getAllVehiclesMap().values()) {
					if(v instanceof Truck) {
						idArr.add(v.getVin());
					}
				}
				String[] idArr2 = idArr.toArray(new String[idArr.size()]);
				DefaultComboBoxModel<String> comboTruckId = new DefaultComboBoxModel<String>(idArr2);
				comboBoxTruck.setBounds(109, 35, 109, 20);
				comboBoxTruck.setModel(comboTruckId);
				comboBoxTruck.setSelectedIndex(-1);
				add(comboBoxTruck);
				//------------------------------------------------------
				ArrayList<Integer> widArr = new ArrayList<Integer>();
				for(WareHouse w:sys.getAllWareHouses().values())
				{
					if(w.getAllParcels().size()!=0)
						widArr.add(w.getWarehouseId());
				}
				Integer[] widArr2 = widArr.toArray(new Integer[widArr.size()]);
				DefaultComboBoxModel<Integer> comboWhId = new DefaultComboBoxModel<Integer>(widArr2);
				comboBoxWhId.setBounds(109, 71, 109, 20);
				comboBoxWhId.setModel(comboWhId);
				comboBoxWhId.setSelectedIndex(-1);
				add(comboBoxWhId);
				ArrayList<Integer> widArr3 = new ArrayList<Integer>();
				for(WareHouse w:sys.getAllWareHouses().values())
				{
					if(!widArr.contains(w.getWarehouseId()))
						widArr3.add(w.getWarehouseId());
				}
				Integer[] widArr4 = widArr3.toArray(new Integer[widArr3.size()]);
				DefaultComboBoxModel<Integer> comboWhId2 = new DefaultComboBoxModel<Integer>(widArr4);
				comboBoxWhId2.setBounds(293, 71, 109, 20);
				comboBoxWhId2.setModel(comboWhId2);
				comboBoxWhId2.setSelectedIndex(-1);
				add(comboBoxWhId2);
				//-------------------------------------------------------
				repaint();
				revalidate();
			}
		});
		add(btnRefresh);
		
		JLabel loadTruckIcon = new JLabel(" ");
		loadTruckIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("load_truck_icon.png")));
		loadTruckIcon.setBounds(37, 106, 381, 260);
		add(loadTruckIcon);
		
		
		
		
		
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
