/**
 * 
 */
package DBLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ModelLayer.Employee;
import ModelLayer.PartOrder;
import ModelLayer.Product;

/**
 * @author Kim Dam Grønhøj
 *
 */
public class ProductDB implements IProductDB {

	private Connection con;
	
	public ProductDB()
	{
		this.con = DBConnection.getInstance().getDBcon();
	}
	
	/* (non-Javadoc)
	 * @see DBLayer.IProductDB#findAllProducts(int)
	 */
	@Override
	public List<PartOrder> findAllPartOrders(int orderId) throws SQLException {
		List<PartOrder> list = new ArrayList<PartOrder>();
		
		if(orderId <= 0)
		{
			throw new IllegalArgumentException("An identifier must be a positive value.");
		}
		
		String query = "SELECT * FROM [PartOrder] AS po INNER JOIN [Product] AS p ON po.product_id = p.id WHERE po.order_id = ?";
		
		// prepare SQL-statement
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setQueryTimeout(5);
		
		// input parameters
		stmt.setInt(1, orderId);
		
		// send SQL-query and open connection and return output
		ResultSet results = stmt.executeQuery();
		
		while(results.next())
		{
			list.add(buildPartOrder(results));
		}
		
		stmt.close();
		
		return list;
	}
	
	private PartOrder buildPartOrder(ResultSet results) throws SQLException
	{
		Product p = new Product(results.getString("name"), results.getDouble("price"));	
		PartOrder model = new PartOrder(results.getInt("amount"), p);	
		
		return model;
	}
}
