/**
 * 
 */
package Controllers;


/**
 * @author Frank Eskelund
 * @version 
 */
public class PartStepCtr {

	private Partstep currentPartStep;
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
		currantPartStep = new PartStep(step);
	}
	/*This function associate a employee by EmployeeNo*/
	public void associateEmployee(EmployeeNo)
	{
		return null;
	}
	/*This function finish the steps*/
	public void finishStep()
	{
		return null;
	}
}
