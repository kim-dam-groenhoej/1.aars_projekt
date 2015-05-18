/**
 * 
 */
package ModelLayer;

import java.util.Date;
import java.util.List;

/**
 * @author Bo Handskemager S¿rensen, Kim Dam Grønhøj
 *
 */
public class PartStep {
	private int id;
	private Date startDate;
	private Step step;
	private Order order;
	private List<Employee> employees;
	
	
	public PartStep(Step step, int id, Date startDate, Order order, List<Employee> employees)
	{
		this(step, order);
		this.id = id;
		if(startDate != null){
		this.startDate = startDate;	
		}
		this.employees = employees;
	}

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
