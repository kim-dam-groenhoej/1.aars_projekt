/**
 * 
 */
package CtrLayer;

import java.sql.SQLException;
import java.util.List;

import DBLayer.IProductDB;
import DBLayer.ProductDB;
import ModelLayer.PartOrder;

/**
 * @author Kim Dam Grønhøj
 *
 */
public class ProductController {
	
	private IProductDB productDB;
	
	public ProductController()
	{
		this.productDB = new ProductDB();
	}
	
	public List<PartOrder> findAllPartOrders(int orderID) throws SQLException
	{
		return this.productDB.findAllPartOrders(orderID);
	}
}
