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
import Model.Item;
import Model.Parcel;
import javax.swing.SwingConstants;


public class AddItemToParcelPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String vin;
	public static JButton btnRefresh;
	SysData sys=SysData.getInstance();
	/**
	 * Panel for adding items to parcels.
	 */
	@SuppressWarnings("unchecked")
	public AddItemToParcelPanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblAddItemsToParcel = new JLabel("Add items to a parcel:");
		lblAddItemsToParcel.setForeground(new Color(255, 255, 255));
		lblAddItemsToParcel.setBounds(10, 0, 285, 32);
		add(lblAddItemsToParcel);
		lblAddItemsToParcel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblId = new JLabel("Parcel ID:");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(10, 36, 94, 14);
		add(lblId);
		
		ArrayList<Long> idArr = new ArrayList<Long>();
		for(Parcel p:sys.getAllParcelsMap().values())
			idArr.add(Long.parseLong(p.getParcelId()));
		Long[] idArr2 = idArr.toArray(new Long[idArr.size()]);
		DefaultComboBoxModel<Long> comboDriverId = new DefaultComboBoxModel<Long>(idArr2);
		JComboBox<Long> comboBox = new JComboBox<Long>(comboDriverId);
		comboBox.setBounds(109, 35, 109, 20);
		add(comboBox);
		
		JButton btnSignUp_1 = new JButton("Add");
		btnSignUp_1.setBackground(new Color(25, 25, 112));
		btnSignUp_1.setForeground(new Color(255, 255, 255));
		btnSignUp_1.setBounds(365, 377, 89, 23);
		add(btnSignUp_1);
		
		JLabel noParcels = new JLabel("There are no parcels!");
		noParcels.setForeground(Color.RED);
		noParcels.setBounds(109, 61, 135, 14);
		noParcels.setVisible(false);
		add(noParcels);
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setForeground(new Color(255, 255, 255));
		lblItems.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblItems.setBounds(10, 89, 70, 14);
		add(lblItems);
		
		JLabel noSelected = new JLabel("Select at least one item!");
		noSelected.setForeground(Color.RED);
		noSelected.setBounds(109, 352, 195, 14);
		noSelected.setVisible(false);
		add(noSelected);
		
		JLabel cantAdd = new JLabel("Items already in package / package is full!");
		cantAdd.setForeground(Color.RED);
		cantAdd.setBounds(109, 352, 285, 14);
		cantAdd.setVisible(false);
		add(cantAdd);
		
		DefaultListModel<Item> listModel = new DefaultListModel<Item>();
		for(Item i:sys.getAllItems()) {
			listModel.addElement(i);
		}
		JList<Item> list = new JList<Item>(listModel);
		list.setBackground(new Color(25, 25, 112));
		list.setVisibleRowCount(20);
		list.setCellRenderer(new ItemCellRenderer());
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(list);
		pane.setBounds(109, 86, 345, 255);
		add(pane);
		JLabel lblCatalogId = new JLabel("(Catalog ID) Item name");
		lblCatalogId.setHorizontalAlignment(SwingConstants.CENTER);
		pane.setColumnHeaderView(lblCatalogId);
		
		btnSignUp_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sys = SysData.getInstance();
				noParcels.setVisible(false);
				noSelected.setVisible(false);
//				cantAdd.setVisible(false);
				repaint();
				if(comboBox.getSelectedItem()==null)
					noParcels.setVisible(true);
				ArrayList<Item> iList = new ArrayList<Item>();
				for(Item i:list.getSelectedValuesList())
					iList.add(i);
				if(iList.size()==0)
					noSelected.setVisible(true);
				if(!noParcels.isVisible()&&!noSelected.isVisible()&&!cantAdd.isVisible())
					try{
						for(Parcel p:sys.getAllParcels()) {
							System.out.println("Parcel ID: "+p.getParcelId()+", num of items: "+p.getListOfItem().size()+", weight: "+p.getWeight());
						}
						for(Item i:iList)
							if(!sys.addItemToParcel(comboBox.getSelectedItem().toString(), i.getCatalogID(), i.getItemName()))
								cantAdd.setVisible(true);
						SysData.getInstance().setAllParcels(sys.getAllParcels());
						SysData.getInstance().setAllParcelsMap(sys.getAllParcelsMap());
						if(!cantAdd.isVisible()) {
							try {
								MainWindow.save();
//								MainWindow.reloadDatabase();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							finally {
								System.out.println("--------------------");
								for(Parcel p:sys.getAllParcels()) {
									System.out.println("Parcel ID: "+p.getParcelId()+", num of items: "+p.getListOfItem().size()+", weight: "+p.getWeight());
								}
								switchPanels(Session.loginPanel);
							}
						}
						
						repaint();
						repaint();
					}
				catch (NumberFormatException e1) {
//					vinExistsSU.setVisible(false);
					e1.printStackTrace();
				}
				repaint();
			}
		});
		
		
		JButton btnClearAll = new JButton("Clear all");
		btnClearAll.setBackground(new Color(25, 25, 112));
		btnClearAll.setForeground(new Color(255, 255, 255));
		btnClearAll.setBounds(206, 377, 89, 23);
		add(btnClearAll);
		btnClearAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				noParcels.setVisible(false);
				list.clearSelection();
				noSelected.setVisible(false);
				cantAdd.setVisible(false);
				repaint();
			}
		});
		add(btnClearAll);
		
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
		btnRefresh.setBounds(109, 377, 89, 23);
		add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				remove(pane);
				list.removeAll();
				listModel.removeAllElements();
				for(Item i:sys.getAllItems()) {
					listModel.addElement(i);
				}
				list.setModel(listModel);
				list.setBackground(new Color(25, 25, 112));
				pane.setBounds(109, 86, 285, 109);
				add(pane);
				JLabel lblCatalogId = new JLabel("(Catalog ID) Item name");
				pane.setColumnHeaderView(lblCatalogId);
				lblCatalogId.setHorizontalAlignment(SwingConstants.CENTER);

				comboBox.removeAllItems();
				ArrayList<Long> idArr = new ArrayList<Long>();
				for(Parcel p:sys.getAllParcelsMap().values())
					idArr.add(Long.parseLong(p.getParcelId()));
				Long[] idArr2 = idArr.toArray(new Long[idArr.size()]);
				DefaultComboBoxModel<Long> comboParcelId = new DefaultComboBoxModel<Long>(idArr2);
				comboBox.setModel(comboParcelId);
				comboBox.setBounds(109, 35, 109, 20);
				add(comboBox);
				
				repaint();
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
	static class ItemCellRenderer extends JLabel implements ListCellRenderer {
		private static final long serialVersionUID = 1L;
		private final Color HIGHLIGHT_COLOR = new Color(255, 255, 255);

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
		      setForeground(new Color(25, 25, 112));
		    } else {
		      setBackground(new Color(25, 25, 112));
		      setForeground(Color.white);
		    }
		    return this;
		  }
		}
}
