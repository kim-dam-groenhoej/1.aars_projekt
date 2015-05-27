/**
 * 
 */
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
	
	/*This function finds order by orderId */
	public Order findOrder(int orderId) throws SQLException
	{
		return orderDB.findOrder(orderId);
	}
	
	public List<Order> findAllActiveOrders(int restaurantId) throws SQLException
	{
		return orderDB.findAllActiveOrders(restaurantId);
	}
	
	public void finishStep(PartStep ps) throws SQLException
	{
		orderDB.savePartStep(ps);
	}
	
	public List<PartOrder> findAllPartOrders(int orderID) throws SQLException
	{
		return this.orderDB.findAllPartOrders(orderID);
	}
}
