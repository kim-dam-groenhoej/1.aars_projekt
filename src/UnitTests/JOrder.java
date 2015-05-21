package UnitTests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import CtrLayer.OrderCtr;
import ModelLayer.Order;

public class JOrder {

	@Test
	public void CanFindOrder() throws SQLException {
		OrderCtr ctr = new OrderCtr();
		Order o = ctr.findOrder(2);
		assertNotNull(0);
	}

}
