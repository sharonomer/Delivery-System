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


public class AllReceivedItemsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static JButton btnRefresh;
	SysData sys=SysData.getInstance();
	/**
	 * Panel for displaying all of the current user's received items.
	 */
	@SuppressWarnings("unchecked")
	public AllReceivedItemsPanel() {
		setBackground(new Color(25, 25, 112));		
		setLayout(null);
		this.setBounds(0, 0, 464, 411);
		
		JLabel lblAllReceivedItems = new JLabel("All received items:");
		lblAllReceivedItems.setForeground(new Color(255, 255, 255));
		lblAllReceivedItems.setBounds(10, 0, 285, 32);
		add(lblAllReceivedItems);
		lblAllReceivedItems.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		Receiver r=null;
		if(Session.id==null)
			for(Receiver temp:sys.getAllReciversMap().values())
				r=temp;
		else if(Session.id!=null) {
			r=sys.getAllReciversMap().get(Long.parseLong(Session.id));
		}
		
		DefaultListModel<Item> listModel = new DefaultListModel<Item>();
		if(r!=null) {
			for(Item i:r.getReceivedItems()) {
				listModel.addElement(i);
			}
		}
		JList<Item> list = new JList<Item>(listModel);
		list.setBackground(new Color(25, 25, 112));
		list.setVisibleRowCount(5);
		list.setCellRenderer(new ItemCellRenderer());
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane pane = new JScrollPane(list);
		pane.setBounds(10, 43, 444, 323);
		add(pane);
		JLabel lblCatalogId = new JLabel("(Catalog ID) Item name");
		lblCatalogId.setBackground(new Color(25, 25, 112));
		lblCatalogId.setForeground(new Color(255, 255, 255));
		lblCatalogId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCatalogId.setOpaque(true);
		pane.setColumnHeaderView(lblCatalogId);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Session.receiverPanel);
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
				remove(pane);
				list.removeAll();
				listModel.removeAllElements();
				for(Item i:sys.getAllReciversMap().get(Long.parseLong(Session.id)).getReceivedItems()) {
					listModel.addElement(i);
				}
				list.setModel(listModel);
				pane.setBounds(10, 43, 404, 187);
				add(pane);
				JLabel lblCatalogId = new JLabel("(Catalog ID) Item name");
				lblCatalogId.setBackground(new Color(25, 25, 112));
				lblCatalogId.setForeground(new Color(255, 255, 255));
				lblCatalogId.setHorizontalAlignment(SwingConstants.CENTER);
				lblCatalogId.setOpaque(true);
				pane.setColumnHeaderView(lblCatalogId);
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
		private static final Color HIGHLIGHT_COLOR = new Color(255, 255, 255);

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
