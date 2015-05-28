package GuiLayer;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import CtrLayer.PartStepCtr;
import ModelLayer.Customer;
import ModelLayer.Order;
import ModelLayer.OrderInfoViewModel;
import ModelLayer.PartOrder;
import ModelLayer.Product;
import ModelLayer.Town;

public class DetailView extends JPanel {

	PartStepCtr partstepCtr = new PartStepCtr();
	private JList list_1 = new JList(); 
	private JLabel DetailOrdernre = new JLabel("Ordre nr:");
	private JLabel DetailCustomername = new JLabel("");
	private JLabel detailsStreet = new JLabel("");
	private JLabel detailstown = new JLabel("");
	private JLabel detailsorderId = new JLabel("");
	
	
	public DetailView(JPanel panel){
			
					
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(10, 11, 465, 653);
			panel.add(panel_3);
			panel_3.setLayout(null);
							
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(260, 10, 195, 270);
			panel_3.add(panel_4);
			panel_4.setLayout(null);				
						
			
			list_1.setBounds(0, 0, 195, 270);
			panel_4.add(list_1);
			
			
			
			DetailOrdernre.setFont(new Font("Tahoma", Font.BOLD, 11));
			DetailOrdernre.setBounds(10, 11, 61, 14);
			panel_3.add(DetailOrdernre);
			
			
			
			DetailCustomername.setBounds(10, 36, 240, 14);
			panel_3.add(DetailCustomername);
			
			
			
			detailsStreet.setBounds(10, 61, 240, 14);
			panel_3.add(detailsStreet);
			
			
					
			detailstown.setBounds(10, 86, 240, 14);
			panel_3.add(detailstown);
			
			
				
			
			detailsorderId.setBounds(64, 10, 61, 14);
			panel_3.add(detailsorderId);					
			
		}
	
	
	
	public void setDetailsText(int orderid )
	{
		OrderInfoViewModel info = null;
		
		try {
			
			info = partstepCtr.findOrderInfo(orderid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(info != null){
		Order order = info.getOrder();
		Customer customer = order.getCustomer();
		Town town = customer.getTown();
		
		
		
		String orderId = Integer.toString(order.getId());	
		
		
		List<PartOrder> partOrders = order.getPartOrderList();
		
		list_1.setModel(new AbstractListModel() {
			List<String> productNames = null;
			
			public List<String> getProductNames()
			{
				if (productNames == null) {
					productNames = new ArrayList<String>();
					
					int l = 1;
					for (PartOrder partOrder : partOrders) {
						Product product = partOrder.getProduct();
						productNames.add(l + ". " + product.getName());
						
						l++;
					}
				}
				
				return productNames;
			}
			
			public int getSize() {
				return getProductNames().size();
			}
			public Object getElementAt(int index) {
				return getProductNames().get(index);
			}
		});
		
		
		DetailCustomername.setText(customer.getName()); 
		detailsStreet.setText(customer.getStreet()); 
		detailstown.setText(town.getZip() + " " + town.getName()); 
		String orderIdd = Integer.toString(order.getId());
		detailsorderId.setText(orderIdd);
		
		
		
		
		
		}	
		
	}
	
	
	
	
}
