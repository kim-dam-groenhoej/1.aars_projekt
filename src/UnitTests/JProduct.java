/**
 * 
 */
package UnitTests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import CtrLayer.ProductController;
import ModelLayer.PartOrder;
import ModelLayer.Product;

/**
 * @author Kim Dam Grønhøj
 *
 */
public class JProduct {

	@Test
	public void positiveTest_FindAllPartOrders() throws SQLException {
		ProductController pc = new ProductController();
		List<PartOrder> partOrders = pc.findAllPartOrders(1);
		
		for (PartOrder po : partOrders)
		{
			System.out.println("Amount: " + po.getAmount());
	
			System.out.println("Product name: " + po.getProduct().getName());
		}
		
		assertTrue("partorders found", partOrders.size() > 0);
	}

}
