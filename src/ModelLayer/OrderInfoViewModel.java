/**
 * 
 */
package ModelLayer;

import java.util.List;

/**
 * @author Bo Handskemager S¿rensen
 *
 */
public class OrderInfoViewModel {
	public List<Employee> employees;
	public List<Step> steps;
	public Order order;
	
	public OrderInfoViewModel(List<Employee> employees, List<Step> steps, Order order){
		this.employees = employees;
		this.steps = steps;
		this.order = order;
	}

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @return the steps
	 */
	public List<Step> getSteps() {
		return steps;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	
}
