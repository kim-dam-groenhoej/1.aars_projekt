/**
 * 
 */
package CtrLayer;

import DBLayer.IPartStepDB;
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
	
	/*This function finds order information by orderID*/
	public OrderInfoViewModel findOrderInfo(int OrderID)
	{
		return null;
	}

	/**
	 * @param Step the Step to set
	 */
	public void setStep(Step step) 
	{
		/* currentPartStep = new PartStep(step); <-- Kim 16-05-2015: Kan ikke compile! */
	}
	/*This function associate a employee by EmployeeNo*/
	public void associateEmployee(int employeeNo)
	{
		
	}
	/*This function finish the steps*/
	public void finishStep()
	{
		
	}
}
