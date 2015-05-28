/**
 * 
 */
package ModelLayer;

import java.util.List;

/**
 * This class represnt Employee and extends from person
 * @author Bo Handskemager S�rensen, Kim Dam Gr�nh�j
 *
 */
public class Employee extends Person {
	private int employeeNo;
	private String position;
	private List<PartStep> partSteps;
	private Restaurant restaurant;
	
	/**
	 * Employee constructor initialize this model
	 * @param id currrent id
	 * @param name current full name of the employee
	 * @param zip current Town object with zip and town name
	 * @param street streetname with number
	 * @param phone current phonenumber
	 */
	public Employee(int id, String name, Town town, String street, String phone, int employeeNo, String position, List<PartStep> partSteps, Restaurant restaurant) {
		super(id, name, town, street, phone);

		this.employeeNo = employeeNo;
		this.position = position;
		this.partSteps = partSteps;
		this.restaurant = restaurant;
	}

	/**
	 * @return the employeeNo
	 */
	public int getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @return the partSteps
	 */
	public List<PartStep> getPartSteps() {
		return partSteps;
	}

	/**
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
}
