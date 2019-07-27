package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import Controller.SysData;
import Model.Address;
import Model.Parcel;
import Model.Receiver;
import Model.WareHouse;
import javax.swing.SwingConstants;


public class ParcelLocationPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static JButton btnRefresh;
	SysData sys=SysData.getInstance();
	/**
	 * Panel for displaying a parcel's location history.
	 */
	@SuppressWarnings("unchecked")
	public ParcelLocationPanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblLocationOfParcel = new JLabel("Location history of the Parcel:");
		lblLocationOfParcel.setForeground(new Color(255, 255, 255));
		lblLocationOfParcel.setBounds(10, 0, 387, 32);
		add(lblLocationOfParcel);
		lblLocationOfParcel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblId = new JLabel("Parcel ID:");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(82, 36, 94, 14);
		add(lblId);
		
		ArrayList<Long> idArr = new ArrayList<Long>();
		if(Session.id==null||Session.id.equals("Admin"))
			for(Parcel p:sys.getAllParcelsMap().values())
				idArr.add(Long.parseLong(p.getParcelId()));
		else if(Session.id!=null&&sys.getAllUsers().containsKey(Long.parseLong(Session.id))) {
			Receiver r=(Receiver) sys.getAllUsers().get(Long.parseLong(Session.id));
			for(Parcel p:sys.getAllParcelsMap().values()) {
				if(r.equals(p.getReceiver())) {
					idArr.add((Long.parseLong(p.getParcelId())));
				}
			}
		}
		Long[] idArr2 = idArr.toArray(new Long[idArr.size()]);
		DefaultComboBoxModel<Long> comboDriverId = new DefaultComboBoxModel<Long>(idArr2);
		JComboBox<Long> comboBox = new JComboBox<Long>(comboDriverId);
		comboBox.setBounds(186, 35, 109, 20);
		add(comboBox);
		
		JButton btnSignUp_1 = new JButton("Get Locations");
		btnSignUp_1.setBackground(new Color(25, 25, 112));
		btnSignUp_1.setForeground(new Color(255, 255, 255));
		btnSignUp_1.setBounds(338, 377, 116, 23);
		add(btnSignUp_1);
		
		JLabel noParcels = new JLabel("There are no parcels!");
		noParcels.setForeground(Color.RED);
		noParcels.setBounds(180, 61, 135, 14);
		noParcels.setVisible(false);
		add(noParcels);
		
		DefaultListModel<Address> listModel = new DefaultListModel<Address>();
		JList<Address> list = new JList<Address>(listModel);
		list.setBackground(new Color(25, 25, 112));
		list.setVisibleRowCount(5);
		list.setCellRenderer(new AddressCellRenderer());
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(list);
		pane.setBounds(10, 86, 419, 280);
		add(pane);
		JLabel lblCatalogId = new JLabel("Locations:");
		lblCatalogId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCatalogId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCatalogId.setBackground(new Color(25, 25, 112));
		lblCatalogId.setForeground(new Color(255, 255, 255));
		lblCatalogId.setOpaque(true);
		pane.setColumnHeaderView(lblCatalogId);
		
		btnSignUp_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listModel.removeAllElements();
				list.setModel(listModel);
				Parcel p=sys.getAllParcelsMap().get(comboBox.getSelectedItem().toString());
				ArrayList<Address> aList = new ArrayList<Address>();
				noParcels.setVisible(false);
				if(comboBox.getSelectedItem()==null)
					noParcels.setVisible(true);
				if(!noParcels.isVisible()) {
					for(WareHouse w:p.getLocations())
						aList.add(w.getAddress());
					for(Address a:aList)
						listModel.addElement(a);
					if(p.isSentToReceiver())
						listModel.addElement(p.getReceiver().getAddress());
					list.setEnabled(false);
					list.setModel(listModel);
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
				noParcels.setVisible(false);
				list.clearSelection();
				listModel.removeAllElements();
				list.setModel(listModel);
				repaint();
			}
		});
		add(btnClearAll);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClearAll.doClick();
				switchPanels(Session.loginPanel);
			}
		});
		btnBack.setBounds(10, 377, 89, 23);
		add(btnBack);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(new Color(25, 25, 112));
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setBounds(340, 34, 89, 23);
		add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBox.removeAllItems();
				remove(comboBox);
				ArrayList<Long> idArr = new ArrayList<Long>();
				if(Session.id==null||Session.id.equals("Admin"))
					for(Parcel p:sys.getAllParcelsMap().values())
						idArr.add(Long.parseLong(p.getParcelId()));
				else if(Session.id!=null&&sys.getAllUsers().containsKey(Long.parseLong(Session.id))) {
					Receiver r=(Receiver) sys.getAllUsers().get(Long.parseLong(Session.id));
					for(Parcel p:sys.getAllParcelsMap().values()) {
						if(r.equals(p.getReceiver())) {
							idArr.add((Long.parseLong(p.getParcelId())));
						}
					}
				}
				Long[] idArr2 = idArr.toArray(new Long[idArr.size()]);
				DefaultComboBoxModel<Long> comboParcelId = new DefaultComboBoxModel<Long>(idArr2);
				comboBox.setModel(comboParcelId);;
				comboBox.setBounds(186, 35, 109, 20);
				add(comboBox);
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
	static class AddressCellRenderer extends JLabel implements ListCellRenderer {
		private static final long serialVersionUID = 1L;
		private static final Color HIGHLIGHT_COLOR = new Color(255, 255, 255);

		  public AddressCellRenderer() {
		    setOpaque(true);
		    setIconTextGap(12);
		  }
		  public Component getListCellRendererComponent(JList list, Object value,
		      int index, boolean isSelected, boolean cellHasFocus) {
		    Address i = (Address) value;
		    setText(String.format("%s %s, %s, %s", i.getStreet(),i.getHouseNumber(),i.getCity(),i.getZipCode()));
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
