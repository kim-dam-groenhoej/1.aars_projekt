package UnitTests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import CtrLayer.EmployeeCtr;
import CtrLayer.OrderCtr;
import CtrLayer.StepCtr;
import ModelLayer.Order;
import ModelLayer.PartOrder;
import ModelLayer.PartStep;
import ModelLayer.Step;

/**
 * This class represent all Unit Tests for Orders and PartSteps
 * @author Kim Dam Gr�nh�j, Tobias, Frank
 *
 */
public class JOrder {

	/**
	 * This is a positive 
	 * @throws SQLException
	 */
	@Test
	public void positiveTest_CanFindOrder() throws SQLException {
		OrderCtr ctr = new OrderCtr();
		Order o = ctr.findOrder(2);
		assertEquals(2, o.getId());
		assertEquals(2, o.getPartStepList().get(1).getEmployees().size());
		assertEquals(5, o.getPartStepList().get(1).getId());
		assertNotNull(o);
	}
	
	@Test
	public void negativeTest_NoOrder() throws SQLException
	{
		OrderCtr ctr = new OrderCtr();
		Order o = ctr.findOrder(2020);
		assertNull(o);
	}

	@Test
	public void CanAddPartStep() throws SQLException
	{
		// Set this to true to execute inserts
		Boolean doExecuteQuery = false;
		
		OrderCtr oCtr = new OrderCtr();
		StepCtr sCtr = new StepCtr();
		EmployeeCtr eCtr = new EmployeeCtr();
		Step s = sCtr.findNextSteps(2).get(0);
		Order o = oCtr.findOrder(1);
		PartStep ps = new PartStep(s, o);
		ps.setEmployees(eCtr.getAllEmployees(1));
		
		if (doExecuteQuery) {
			oCtr.finishStep(ps);
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void negativeTest_NoOrder_WithNegativeNumber() throws SQLException
	{
		OrderCtr ctr = new OrderCtr();
		Order o = ctr.findOrder(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void negativeTest_NoOrder_WithZero() throws SQLException
	{
		OrderCtr ctr = new OrderCtr();
		Order o = ctr.findOrder(0);
	}
	
	@Test
	public void positiveTest_CanFindAllActiveOrders() throws SQLException
	{
		OrderCtr ctr = new OrderCtr();
		ArrayList<Order> orders = (ArrayList<Order>) ctr.findAllActiveOrders(1);
		assertNotNull(orders);
		assertEquals(2, orders.size());
		assertEquals(2, orders.get(0).getPartOrderList().size());
	}
	
	@Test
	public void positiveTest_FindAllPartOrders() throws SQLException {
		OrderCtr oc = new OrderCtr();
		List<PartOrder> partOrders = oc.findAllPartOrders(1);
		
		for (PartOrder po : partOrders)
		{
			System.out.println("Amount: " + po.getAmount());
	
			System.out.println("Product name: " + po.getProduct().getName());
		}
		
		assertTrue("partorders found", partOrders.size() > 0);
	}
	

}
