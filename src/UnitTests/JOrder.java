package UnitTests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import CtrLayer.EmployeeCtr;
import CtrLayer.OrderCtr;
import CtrLayer.StepCtr;
import ModelLayer.Order;
import ModelLayer.PartStep;
import ModelLayer.Step;

public class JOrder {

	@Test
	public void positiveTest_CanFindOrder() throws SQLException {
		OrderCtr ctr = new OrderCtr();
		Order o = ctr.findOrder(2);
		assertEquals(2, o.getId());
		assertEquals(2, o.getPartStepList().get(1).getEmployees().size());
		assertEquals(5, o.getPartStepList().get(1).getId());
		assertEquals(4, o.getPartStepList().size());
		assertNotNull(o);
	}
	
	@Test
	public void negativeTest_NoOrder() throws SQLException
	{
		OrderCtr ctr = new OrderCtr();
		Order o = ctr.findOrder(2020);
		assertNull(o);
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
	
//	@Test
//	public void CanAddPartStep() throws SQLException
//	{
//		OrderCtr oCtr = new OrderCtr();
//		StepCtr sCtr = new StepCtr();
//		EmployeeCtr eCtr = new EmployeeCtr();
//		Step s = sCtr.findNextSteps(2).get(0);
//		Order o = oCtr.findOrder(1);
//		PartStep ps = new PartStep(s, o);
//		ps.setEmployees(eCtr.getAllEmployees(1));
//		oCtr.finishStep(ps);
//	}
}
