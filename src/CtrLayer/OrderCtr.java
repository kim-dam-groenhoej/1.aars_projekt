/**
 * 
 */
package Controllers;

/**
 * @author Frank Eskelund
 * @version 
 */
public class OrderCtr {

	private IOrderDB orderDB;
	
	public OrderCtr()
	{
		orderDB = new OrderDB();
	}
	
	/*This function finds order by orderId */
	public Order findOrder(int orderId)
	{
		return null;
	}
}
