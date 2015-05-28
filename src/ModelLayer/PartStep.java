/**
 * 
 */
package ModelLayer;

import java.util.Date;
import java.util.List;

/**
 * This represent a PartStep. With is every step the user save in the use case flow "set step"
 * @author Bo Handskemager S�rensen, Kim Dam Gr�nh�j
 *
 */
public class PartStep {
	private int id;
	private Date startDate;
	private Step step;
	private Order order;
	private List<Employee> employees;
	
	/**
	 * PartStep constructor initialize this model
	 * @param step current Step used in the PartStep
	 * @param id current id
	 * @param startDate current time the PartStep was added
	 * @param order current order used to save the PartStep
	 * @param employees current employee
	 */
	public PartStep(Step step, int id, Date startDate, Order order, List<Employee> employees)
	{
		this(step, order);
		this.id = id;
		
		if(startDate != null){
			this.startDate = startDate;	
		}
		
		this.employees = employees;
	}

	/**
	 * PartStep constructor initialize this model
	 * @param step current Step used in the PartStep
	 * @param order current order used to save the PartStep
	 */
	public PartStep(Step step, Order order)
	{
		this.step = step;	
		this.order = order;
		this.startDate = new Date();
	}
	
	/**
	 * @return the id
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate()
	{
		return startDate;
	}

	/**
	 * @return the step
	 */
	public Step getStep() 
	{
		return step;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() 
	{
		return order;
	}

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() 
	{
		return employees;
	}
	
	/**
	 * sets the id
	 * @param id
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	/**
	 * sets the date
	 * @param date
	 */
	public void setStartDate(Date date)
	{
		this.startDate = date;
	}
	
	/**
	 * sets the step
	 * @param step
	 */
	public void setStep(Step step)
	{
		this.step = step;
	}
	
	/**
	 * sets the order
	 * @param order
	 */
	public void setOrder(Order order)
	{
		this.order = order;
	}
	
	/**
	 * set the employees
	 * @param emp
	 */
	public void setEmployees(List<Employee> emp)
	{
		this.employees = emp;
	}
}
