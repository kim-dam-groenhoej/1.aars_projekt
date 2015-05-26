/**
 * 
 */
package DBLayer;

import java.sql.SQLException;
import java.util.List;

import ModelLayer.PartOrder;
import ModelLayer.Product;

/**
 * @author Kim Dam Grønhøj
 *
 */
public interface IProductDB {
	/**
	 * @param orderId
	 * @return
	 * @throws SQLException
	 */
	List<PartOrder> findAllPartOrders(int orderId) throws SQLException;
}
