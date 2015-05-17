/**
 * 
 */
package CtrLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBLayer.EmployeeDB;
import DBLayer.IEmployeeDB;
import ModelLayer.Employee;

/**
 * @author Frank Eskelund, Kim Dam Gr�nh�j, Tobias
 * @version 
 */
public class EmployeeCtr {
	
	private IEmployeeDB employeeDB;
	
	
	
	public EmployeeCtr() {
		this.employeeDB = new EmployeeDB();
	}

	/*This function get all the employees from the restaurant by RestaurantID*/
	public List<Employee> getAllEmployees(int restaurantID) throws SQLException
	{
		return employeeDB.getAllEmployees(restaurantID);
	}
	
	/*This function find one employee from a EmployeeNO*/
	public Employee findEmployee(int employeeNo)
	{
		return null;
	}
}
