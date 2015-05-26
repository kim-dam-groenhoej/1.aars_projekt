/**
 * 
 */
package DBLayer;

import java.util.List;

import ModelLayer.Product;

/**
 * @author Kim Dam Grønhøj
 *
 */
public interface IProductDB {
	List<Product> findAllProducts(int orderId);
}
