package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import Controller.SysData;
import Model.Parcel;
import javax.swing.SwingConstants;


public class WarehousePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String vin;
	public static JButton btnRefresh;
	JLabel lblWareHouseID;
	JLabel lblActualAddress;
	SysData sys=SysData.getInstance();
	/**
	 * Panel for Warehouse info.
	 */
	@SuppressWarnings("unchecked")
	public WarehousePanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(10, 36, 94, 14);
		add(lblAddress);
		
		JLabel lblParcels = new JLabel("Parcels:");
		lblParcels.setForeground(new Color(255, 255, 255));
		lblParcels.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblParcels.setBounds(10, 89, 70, 14);
		add(lblParcels);
		
		DefaultListModel<Parcel> listModel = new DefaultListModel<Parcel>();
		if(Session.warehouse!=null)
		{
			for(Parcel p:Session.warehouse.getAllParcels())
				listModel.addElement(p);
			lblActualAddress = new JLabel(Session.warehouse.getAddress().street+" "+
				Session.warehouse.getAddress().getHouseNumber()+", "+
				Session.warehouse.getAddress().getCity()+", "+
				Session.warehouse.getAddress().getZipCode());
			lblActualAddress.setBounds(109, 38, 285, 14);
			
			lblWareHouseID = new JLabel("WareHouse ID: "+Integer.toString(Session.warehouse.getWarehouseId()));
			lblWareHouseID.setBounds(10, 0, 285, 32);
			lblWareHouseID.setForeground(new Color(255, 255, 255));
			lblWareHouseID.setBackground(new Color(25, 25, 112));
			add(lblWareHouseID);
			lblWareHouseID.setFont(new Font("Tahoma", Font.BOLD, 24));
		}
		else {
			lblActualAddress = new JLabel("WareHouse is null, no address can be given.");
			lblActualAddress.setBounds(109, 38, 285, 14);
			lblActualAddress.setForeground(new Color(255, 255, 255));
			lblActualAddress.setBackground(new Color(25, 25, 112));
			lblWareHouseID = new JLabel("WareHouse ID: "+"NULL");
			lblWareHouseID.setBounds(10, 0, 285, 32);
			lblWareHouseID.setForeground(new Color(255, 255, 255));
			lblWareHouseID.setBackground(new Color(25, 25, 112));
			lblWareHouseID.setFont(new Font("Tahoma", Font.BOLD, 24));
		}
		add(lblActualAddress);
		
		JList<Parcel> list = new JList<Parcel>(listModel);
		list.setBackground(new Color(25, 25, 112));
		list.setVisibleRowCount(5);
		list.setCellRenderer(new ParcelCellRenderer());
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(list);
		pane.setBounds(109, 86, 345, 280);
		add(pane);
		JLabel lblParcelID = new JLabel("Parcel ID");
		lblParcelID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblParcelID.setHorizontalAlignment(SwingConstants.CENTER);
		lblParcelID.setForeground(new Color(255, 255, 255));
		lblParcelID.setBackground(new Color(25, 25, 112));
		lblParcelID.setOpaque(true);
		pane.setColumnHeaderView(lblParcelID);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(lblActualAddress);
				remove(lblWareHouseID);
				list.removeAll();
				listModel.removeAllElements();
				list.setModel(listModel);
				repaint();
				revalidate();
				switchPanels(Session.adminPanel);
			}
		});
		btnBack.setBounds(10, 377, 89, 23);
		add(btnBack);
		
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(new Color(25, 25, 112));
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setBounds(365, 377, 89, 23);
		add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sys=SysData.getInstance();
				remove(pane);
				remove(lblActualAddress);
				remove(lblWareHouseID);
				list.removeAll();
				listModel.removeAllElements();
				if(Session.warehouse!=null)
				{
					for(Parcel p:Session.warehouse.getAllParcels())
						listModel.addElement(p);
					lblActualAddress = new JLabel(Session.warehouse.getAddress().street+" "+
						Session.warehouse.getAddress().getHouseNumber()+", "+
						Session.warehouse.getAddress().getCity()+", "+
						Session.warehouse.getAddress().getZipCode());
					lblActualAddress.setBounds(109, 38, 285, 14);
					lblActualAddress.setForeground(new Color(255, 255, 255));
					lblActualAddress.setBackground(new Color(25, 25, 112));
					lblWareHouseID = new JLabel("WareHouse ID: "+Integer.toString(Session.warehouse.getWarehouseId()));
					lblWareHouseID.setBounds(10, 0, 285, 32);
					lblWareHouseID.setForeground(new Color(255, 255, 255));
					lblWareHouseID.setBackground(new Color(25, 25, 112));
					add(lblWareHouseID);
					lblWareHouseID.setFont(new Font("Tahoma", Font.BOLD, 24));
				}
				else {
					lblActualAddress = new JLabel("WareHouse is null, no address can be given.");
					lblActualAddress.setBounds(109, 38, 285, 14);
					lblWareHouseID.setForeground(new Color(255, 255, 255));
					lblWareHouseID.setBackground(new Color(25, 25, 112));
					lblWareHouseID = new JLabel("WareHouse ID: "+"NULL");
					lblWareHouseID.setBounds(10, 0, 285, 32);
					
					lblWareHouseID.setFont(new Font("Tahoma", Font.BOLD, 24));
				}
				add(lblActualAddress);
				list.setModel(listModel);
				pane.setBounds(109, 86, 285, 144);
				add(pane);
				JLabel lblParcelID = new JLabel("Parcel ID, Weight");
				lblParcelID.setHorizontalAlignment(SwingConstants.CENTER);
				lblParcelID.setForeground(new Color(255, 255, 255));
				lblParcelID.setBackground(new Color(25, 25, 112));
				lblParcelID.setOpaque(true);
				lblParcelID.setFont(new Font("Tahoma", Font.BOLD, 11));
				pane.setColumnHeaderView(lblParcelID);
				repaint();
				revalidate();
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
	
	@SuppressWarnings("rawtypes")
	static class ParcelCellRenderer extends JLabel implements ListCellRenderer {
		private static final long serialVersionUID = 1L;
		private static final Color HIGHLIGHT_COLOR = new Color(255, 255, 255);

		  public ParcelCellRenderer() {
		    setOpaque(true);
		    setIconTextGap(12);
		  }
		  public Component getListCellRendererComponent(JList list, Object value,
		      int index, boolean isSelected, boolean cellHasFocus) {
		    Parcel i = (Parcel) value;
		    setText(String.format("%s, %s", i.getParcelId(),i.getWeight()));
		    if (isSelected) {
		      setBackground(HIGHLIGHT_COLOR);
		      setForeground(new Color(25, 25, 112));
		    } else {
		      setBackground(new Color(25, 25, 112));
		      setForeground(Color.white);
		    }
		    return this;
		  }
		}
}
