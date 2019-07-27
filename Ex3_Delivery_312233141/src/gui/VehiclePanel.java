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


public class VehiclePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String vin;
	public static JButton btnRefresh;
	JLabel lblVehicleID;
	SysData sys=SysData.getInstance();
	/**
	 * Panel for vehicle info.
	 */
	@SuppressWarnings("unchecked")
	public VehiclePanel() {
		setBackground(new Color(25, 25, 112));
		setForeground(new Color(0, 0, 0));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblParcels = new JLabel("Parcels:");
		lblParcels.setForeground(new Color(255, 255, 255));
		lblParcels.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblParcels.setBounds(10, 33, 70, 14);
		add(lblParcels);
		
		DefaultListModel<Parcel> listModel = new DefaultListModel<Parcel>();
		if(Session.vehicle!=null)
		{
			for(Parcel p:Session.vehicle.getAllDeliveries())
				listModel.addElement(p);
			lblVehicleID = new JLabel("Vehicle ID: "+Session.vehicle.getVin());
			lblVehicleID.setBounds(10, 0, 285, 32);
			lblVehicleID.setForeground(new Color(255, 255, 255));
			add(lblVehicleID);
			lblVehicleID.setFont(new Font("Tahoma", Font.BOLD, 24));
		}
		else {
			lblVehicleID = new JLabel("Vehicle ID: "+"NULL");
			lblVehicleID.setBounds(10, 0, 285, 32);
			lblVehicleID.setFont(new Font("Tahoma", Font.BOLD, 24));
		}
		JList<Parcel> list = new JList<Parcel>(listModel);
		list.setBackground(new Color(25, 25, 112));
		list.setVisibleRowCount(5);
		list.setCellRenderer(new ParcelCellRenderer());
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(list);
		pane.setBounds(10, 58, 181, 308);
		add(pane);
		JLabel lblParcelID = new JLabel("Parcel ID");
		lblParcelID.setHorizontalAlignment(SwingConstants.CENTER);
		lblParcelID.setBackground(new Color(25, 25, 112));
		lblParcelID.setForeground(new Color(255, 255, 255));
		lblParcelID.setOpaque(true);
		pane.setColumnHeaderView(lblParcelID);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(lblVehicleID);
				list.removeAll();
				listModel.removeAllElements();
				list.setModel(listModel);
				repaint();
				revalidate();
				switchPanels(Session.loginPanel);
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
				remove(lblVehicleID);
				list.removeAll();
				listModel.removeAllElements();
				if(Session.vehicle!=null)
				{
					for(Parcel p:Session.vehicle.getAllDeliveries())
						listModel.addElement(p);
					lblVehicleID = new JLabel("Vehicle ID: "+Session.vehicle.getVin());
					lblVehicleID.setBounds(10, 0, 285, 32);
					lblVehicleID.setForeground(new Color(255, 255, 255));
					add(lblVehicleID);
					lblVehicleID.setFont(new Font("Tahoma", Font.BOLD, 24));
				}
				else {
					lblVehicleID = new JLabel("Vehicle ID: "+"NULL");
					lblVehicleID.setBounds(10, 0, 285, 32);
					lblVehicleID.setFont(new Font("Tahoma", Font.BOLD, 24));
				}
				list.setModel(listModel);
				pane.setBounds(90, 55, 304, 175);
				add(pane);
				JLabel lblParcelID = new JLabel("Parcel ID, Weight");
				pane.setColumnHeaderView(lblParcelID);
				lblParcelID.setHorizontalAlignment(SwingConstants.CENTER);
				lblParcelID.setBackground(new Color(25, 25, 112));
				lblParcelID.setForeground(new Color(255, 255, 255));
				lblParcelID.setOpaque(true);
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
