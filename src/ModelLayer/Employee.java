/**
 * 
 */
package ModelLayer;

import java.util.List;

/**
 * @author Bo Handskemager S�rensen, Kim Dam Gr�nh�j
 *
 */
public class Employee extends Person {
	private int employeeNo;
	private String position;
	private List<PartStep> partSteps;
	private Restaurant restaurant;
	
	/**
	 * @param id
	 * @param name
	 * @param zip
	 * @param street
	 * @param phone
	 */
	public Employee(int id, String name, Town town, String street, String phone, int employeeNo, String position, List<PartStep> partSteps, Restaurant restaurant) {
		super(id, name, town, street, phone);
		// TODO Auto-generated constructor stub
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
