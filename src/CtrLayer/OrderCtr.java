package CtrLayer;

import java.sql.SQLException;
import java.util.List;

import DBLayer.IOrderDB;
import DBLayer.OrderDB;
import ModelLayer.Order;
import ModelLayer.PartOrder;
import ModelLayer.PartStep;

/**
 * @author Frank Eskelund
 * @version 
 */
public class OrderCtr {

	private IOrderDB orderDB;
	
	public OrderCtr()
	{
		this.orderDB = new OrderDB();
	}
	
	/**
	 * This function finds order by orderId
	 * 
	 * @param orderId
	 * @return
	 * @throws SQLException
	 * 
	 * This function finds order by orderId
	 */
	public Order findOrder(int orderId) throws SQLException
	{
		Order order = orderDB.findOrder(orderId);
		if (order != null) {
			List<PartOrder> partOrders = findAllPartOrders(order.getId());
			order.setPartOrderList(partOrders);
		}
		
		return order;
	}
	
	/**
	 * This function finds all active orders and their respective part orders based on the restaurantId
	 * 
	 * @param restaurantId
	 * @return
	 * @throws SQLException
	 */
	public List<Order> findAllActiveOrders(int restaurantId) throws SQLException
	{
		List<Order> orders = orderDB.findAllActiveOrders(restaurantId);
		for(Order order : orders)
		{
			List<PartOrder> partOrders = findAllPartOrders(order.getId());
			order.setPartOrderList(partOrders);
		}
		return orders;
	}
	
	/**
	 * This function finishes the PartStep by saving it in the DB
	 * 
	 * @param ps
	 * @throws SQLException
	 */
	public void finishStep(PartStep ps) throws SQLException
	{
		orderDB.savePartStep(ps);
	}
	
	/**
	 * This function finds all PartOrders by orderId
	 * 
	 * @param orderID
	 * @return
	 * @throws SQLException
	 */
	public List<PartOrder> findAllPartOrders(int orderID) throws SQLException
	{
		return this.orderDB.findAllPartOrders(orderID);
	}
}
