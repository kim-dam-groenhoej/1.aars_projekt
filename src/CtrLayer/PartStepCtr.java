/**
 * 
 */
package CtrLayer;

import DBLayer.IPartStepDB;
import ModelLayer.Order;
import ModelLayer.OrderInfoViewModel;
import ModelLayer.PartStep;
import ModelLayer.Step;


/**
 * @author Frank Eskelund, Kim Dam Grønhøj
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
	
	/*This function finds order information by orderID*/
	public OrderInfoViewModel findOrderInfo(int OrderID)
	{
		return null;
	}

	/**
	 * @param Step the PartStep to set
	 */
	public void setPartStep(Step step, Order order) 
	{
		 currentPartStep = new PartStep(step, order);
	}
	
	/*
	 * This function associate a employee by EmployeeNo
	 * */
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
