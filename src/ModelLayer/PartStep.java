/**
 * 
 */
package ModelLayer;

import java.util.Date;
import java.util.List;

/**
 * @author Bo Handskemager S¿rensen
 *
 */
public class PartStep {
	public int id;
	public Date startDate;
	public Step step;
	public Order order;
	public List<Employee> employees;
	
	
	
	public PartStep(int id, Date startDate, Step step, Order order, List<Employee> employees){
		this.id = id;
		this.startDate = startDate;
		this.step = step;
		this.order = order;
		this.employees = employees;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}


	/**
	 * @return the step
	 */
	public Step getStep() {
		return step;
	}


	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}


	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}
}
