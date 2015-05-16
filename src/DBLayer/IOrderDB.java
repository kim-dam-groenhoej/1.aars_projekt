package DBLayer;

import java.util.List;

import ModelLayer.Order;

/**
 * 
 * @author Kim Dam Grønhøj
 *
 */
public interface IOrderDB {
	List<Order> findOrder(int orderId) throws Exception;
}
