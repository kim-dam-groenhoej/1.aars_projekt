package CtrLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBLayer.EmployeeDB;
import DBLayer.IEmployeeDB;
import ModelLayer.Employee;

/**
 * @author Frank Eskelund, Kim Dam Gr�nh�j, Tobias, Bo Handskemager Sørensen
 * @version 
 */
public class EmployeeCtr {
	
	private IEmployeeDB employeeDB;
	
	public EmployeeCtr() {
		this.employeeDB = new EmployeeDB();
	}

	/**
	 * This function gets all the employees from the restaurant by restaurantId
	 * 
	 * @param restaurantID
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> getAllEmployees(int restaurantID) throws SQLException
	{
		return employeeDB.getAllEmployees(restaurantID);
	}
	
	/**
	 * This function finds one employee based on the personId
	 * 
	 * @param personId
	 * @return
	 * @throws SQLException
	 */
	public Employee findEmployee(int personId) throws SQLException
	{
		return employeeDB.findEmployee(personId);
	}
}
