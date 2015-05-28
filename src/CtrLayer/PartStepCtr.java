package CtrLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import DBLayer.IPartStepDB;
import ModelLayer.Employee;
import ModelLayer.Order;
import ModelLayer.OrderInfoViewModel;
import ModelLayer.PartStep;
import ModelLayer.Step;


/**
 * @author Frank Eskelund, Kim Dam Gr�nh�j, Bo Handskemager Sørensen
 * @version 
 */
public class PartStepCtr {

	private PartStep currentPartStep;
	private EmployeeCtr employeeCtr;
	private StepCtr stepCtr;
	private OrderCtr orderCtr;
	private IPartStepDB partStepDB;
	
	public PartStepCtr()
	{
		employeeCtr = new EmployeeCtr();
		stepCtr = new StepCtr();
		orderCtr = new OrderCtr();
	}
	
	/**
	 * 
	 * 
	 * @param orderID
	 * @return
	 * @throws SQLException
	 */
	public OrderInfoViewModel findOrderInfo(int orderID) throws SQLException
	{
		Order o = orderCtr.findOrder(orderID);
		o.setPartOrderList(orderCtr.findAllPartOrders(orderID));
		ArrayList<PartStep> ps = (ArrayList<PartStep>) o.getPartStepList();
		int psSize = ps.size();
		PartStep lastPartStep = ps.get(psSize - 1);
		ArrayList<Step> sl = (ArrayList<Step>) stepCtr.findNextSteps(lastPartStep.getStep().getId());
		
		ArrayList<Employee> el = (ArrayList<Employee>) employeeCtr.getAllEmployees(o.getRest().getId());
		OrderInfoViewModel vm = new OrderInfoViewModel(el, sl, o);
		
		return vm;
	}

	/**
	 * 
	 * 
	 * @param Step the PartStep to set
	 */
	public void setPartStep(Step step, Order order) 
	{
		 currentPartStep = new PartStep(step, order);
	}
	
	/**
	 * Assigns an employee with a unique employee id number
	 * 
	 * @param employeeNo
	 */
	public void associateEmployee(int employeeNo)
	{
		
	}

	/**
	 * Firing this method, sends all data to database
	 */
	public void finishStep()
	{
		
	}
}
