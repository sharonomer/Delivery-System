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
import Model.Item;
import Model.Receiver;
import javax.swing.SwingConstants;


public class ParcelPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String vin;
	public static JButton btnRefresh;
	JLabel lblParcelID;
	JLabel lblActualReceiver;
	JLabel lblTotalWeight;
	JLabel isReceived;
	SysData sys=SysData.getInstance();
	/**
	 * Parcel info panel.
	 */
	@SuppressWarnings("unchecked")
	public ParcelPanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblReceiver = new JLabel("Receiver: ");
		lblReceiver.setForeground(new Color(255, 255, 255));
		lblReceiver.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReceiver.setBounds(10, 36, 94, 14);
		add(lblReceiver);
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setForeground(new Color(255, 255, 255));
		lblItems.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblItems.setBounds(10, 89, 70, 14);
		add(lblItems);
		
		JLabel lblReceived = new JLabel("Received?:");
		lblReceived.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReceived.setBackground(new Color(25, 25, 112));
		lblReceived.setForeground(new Color(255, 255, 255));
		lblReceived.setBounds(10, 247, 94, 14);
		add(lblReceived);
		
		
		DefaultListModel<Item> listModel = new DefaultListModel<Item>();
		if(Session.parcel!=null)
		{
			for(Item i:Session.parcel.getListOfItem())
				listModel.addElement(i);
			Receiver r=Session.parcel.getReceiver();
			lblActualReceiver = new JLabel("("+r.getId()+") "+r.getFirstName()+" "+r.getSurname());
			lblActualReceiver.setForeground(new Color(255, 255, 255));
			lblActualReceiver.setBounds(109, 38, 285, 14);
			
			lblParcelID = new JLabel("Parcel ID: "+Session.parcel.getParcelId());
			lblParcelID.setBounds(10, 0, 285, 32);
			add(lblParcelID);
			lblParcelID.setFont(new Font("Tahoma", Font.BOLD, 24));
			
			lblTotalWeight = new JLabel("Total weight: "+Session.parcel.getWeight()+" (Kg)");
			lblTotalWeight.setForeground(new Color(255, 255, 255));
			lblTotalWeight.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTotalWeight.setBounds(10, 61, 384, 23);
			add(lblTotalWeight);
			
			isReceived = new JLabel(" "+Session.parcel.isSentToReceiver());
			isReceived.setBounds(109, 249, 46, 14);
			lblTotalWeight.setForeground(new Color(255, 255, 255));
			lblTotalWeight.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(isReceived);
		}
		else {
			lblActualReceiver = new JLabel("Parcel is null, no receiver can be given.");
			lblActualReceiver.setBounds(109, 38, 285, 14);
			
			lblParcelID = new JLabel("Parcel ID: "+"NULL");
			lblParcelID.setBounds(10, 0, 285, 32);
			lblParcelID.setFont(new Font("Tahoma", Font.BOLD, 24));
			
			lblTotalWeight = new JLabel("Total weight: Null.");
			lblTotalWeight.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTotalWeight.setBounds(10, 61, 384, 23);
			add(lblTotalWeight);
			
			isReceived = new JLabel(" ");
			isReceived.setBounds(109, 249, 46, 14);
			isReceived.setForeground(new Color(255, 255, 255));
			isReceived.setFont(new Font("Tahoma", Font.BOLD, 15));
			add(isReceived);
		}
		add(lblActualReceiver);
		
		JList<Item> list = new JList<Item>(listModel);
		list.setBackground(new Color(25, 25, 112));
		list.setVisibleRowCount(5);
		list.setCellRenderer(new ItemCellRenderer());
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(list);
		pane.setBounds(109, 86, 285, 144);
		add(pane);
		JLabel lblCatalogID = new JLabel("(Catalog ID), Name, Weight (kg)");
		lblCatalogID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCatalogID.setHorizontalAlignment(SwingConstants.CENTER);
		lblCatalogID.setForeground(new Color(255, 255, 255));
		lblCatalogID.setBackground(new Color(25, 25, 112));
		lblCatalogID.setOpaque(true);
		pane.setColumnHeaderView(lblCatalogID);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(lblActualReceiver);
				remove(lblParcelID);
				remove(lblTotalWeight);
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
				remove(lblActualReceiver);
				remove(lblParcelID);
				remove(lblTotalWeight);
				remove(isReceived);
				list.removeAll();
				listModel.removeAllElements();
				if(Session.parcel!=null)
				{
					for(Item i:Session.parcel.getListOfItem())
						listModel.addElement(i);
					Receiver r=Session.parcel.getReceiver();
					lblActualReceiver = new JLabel("("+r.getId()+") "+r.getFirstName()+" "+r.getSurname());
					lblActualReceiver.setForeground(new Color(255, 255, 255));
					lblActualReceiver.setBounds(109, 38, 285, 14);
					
					lblParcelID = new JLabel("Parcel ID: "+Session.parcel.getParcelId());
					lblParcelID.setForeground(new Color(255, 255, 255));
					lblParcelID.setBounds(10, 0, 285, 32);
					add(lblParcelID);
					lblParcelID.setFont(new Font("Tahoma", Font.BOLD, 24));
					
					lblTotalWeight = new JLabel("Total weight: "+Session.parcel.getWeight()+" (Kg)");
					lblTotalWeight.setForeground(new Color(255, 255, 255));
					lblTotalWeight.setFont(new Font("Tahoma", Font.BOLD, 15));
					lblTotalWeight.setBounds(10, 61, 384, 23);
					add(lblTotalWeight);
					
					isReceived = new JLabel(" "+Session.parcel.isSentToReceiver());
					isReceived.setBounds(109, 249, 46, 14);
					isReceived.setForeground(new Color(255, 255, 255));
					isReceived.setFont(new Font("Tahoma", Font.BOLD, 15));
					add(isReceived);
				}
				else {
					lblActualReceiver = new JLabel("Parcel is null, no receiver can be given.");
					lblActualReceiver.setBounds(109, 38, 285, 14);
					
					lblParcelID = new JLabel("Parcel ID: "+"NULL");
					lblParcelID.setBounds(10, 0, 285, 32);
					lblParcelID.setFont(new Font("Tahoma", Font.BOLD, 24));
					
					lblTotalWeight = new JLabel("Total weight: Null.");
					lblTotalWeight.setFont(new Font("Tahoma", Font.BOLD, 15));
					lblTotalWeight.setForeground(new Color(255, 255, 255));
					lblTotalWeight.setBounds(10, 61, 384, 23);
					add(lblTotalWeight);
					
					isReceived = new JLabel(" "+Session.parcel.isSentToReceiver());
					isReceived.setBounds(109, 249, 46, 14);
					isReceived.setForeground(new Color(255, 255, 255));
					isReceived.setFont(new Font("Tahoma", Font.BOLD, 15));
					add(isReceived);
				}
				add(lblActualReceiver);
				list.setModel(listModel);
				pane.setBounds(109, 86, 285, 144);
				add(pane);
				JLabel lblItemID = new JLabel("(Catalog ID), Name, Weight (kg)");
				lblItemID.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblItemID.setHorizontalAlignment(SwingConstants.CENTER);
				lblItemID.setForeground(new Color(255, 255, 255));
				lblItemID.setBackground(new Color(25, 25, 112));
				lblItemID.setOpaque(true);
				pane.setColumnHeaderView(lblItemID);
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
		    setText(String.format("%s, %s, %.2f kg", i.getCatalogID(),i.getItemName(),i.getItemWeight()));
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
