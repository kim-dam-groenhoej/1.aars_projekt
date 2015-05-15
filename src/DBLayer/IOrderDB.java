package DBLayer;

import java.util.List;

/**
 * 
 * @author Kim Dam Grønhøj
 *
 */
public interface IOrderDB {
	List<Order> findOrder(int orderId);
}
