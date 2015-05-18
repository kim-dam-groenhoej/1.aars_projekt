package DBLayer;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author Frank Eskelund
 * 
 *
 */
import ModelLayer.Order;

public class OrderDB implements IOrderDB {
	
	private Connection con;

	@Override
	public Order findOrder(int orderId) throws SQLException 
	{
	return null;
		
	}

	

}
