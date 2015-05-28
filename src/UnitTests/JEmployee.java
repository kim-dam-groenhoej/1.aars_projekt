package UnitTests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import CtrLayer.EmployeeCtr;
import ModelLayer.Employee;

/**
 * This class represent all Unit Tests for Employees
 * @author Kim Dam Gr�nh�j, Tobias
 *
 */
public class JEmployee {

	/**
	 * This is a positve Test to get all employees
	 * @throws Exception unknown errors can occur
	 * @throws SQLException SQL-server can fail
	 */
	@Test
	public void positiveTest_getAllEmployees() throws Exception, SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		List<ModelLayer.Employee> list = ctr.getAllEmployees(1);
		
		Boolean foundItem = false;
		for (Employee emp : list) {
			if (emp.getName().equals("Jens Henrik")) {
				foundItem = true;
			}
		}
		
		assertTrue("Could not find employee", foundItem);
		assertTrue("List should contain one employee", list.size() > 0);
	}
	
	/**
	 * This is a negative test to check no employees returns if restaurant ID is 10000
	 * @throws SQLException SQL-server can fail
	 */
	@Test
	public void negativeTest_getAllEmployees() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		List<ModelLayer.Employee> list = ctr.getAllEmployees(10000);
		
		assertTrue("List should be empty", list.size() == 0);
	}
	
	/**
	 * This is a negative test to check no employees returns if restaurant ID is under 0
	 * @throws SQLException SQL-server can fail
	 */
	@Test(expected=IllegalArgumentException.class)
	public void negativeTest_getAllEmployees_withNegativeNumber() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		List<ModelLayer.Employee> list = ctr.getAllEmployees(-1);
	}
	
	/**
	 * This is a negative test to check no employees returns if restaurant ID is 0
	 * @throws SQLException SQL-server can fail
	 */
	@Test(expected=IllegalArgumentException.class)
	public void negativeTest_getAllEmployees_withZero() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		List<ModelLayer.Employee> list = ctr.getAllEmployees(0);
	}

	/**
	 * This is a positive test to check an employee returns with 1
	 * @throws SQLException SQL-server can fail
	 * @throws Exception unknown errors can occur
	 */
	@Test
	public void positiveTest_FindEmployee() throws SQLException, Exception {
		EmployeeCtr ctr = new EmployeeCtr();
		Employee e = ctr.findEmployee(1);
		
		assertEquals("Name not the same as excepted", "Jens Henrik", e.getName());
		assertNotNull("Should return one Employee object", e);
	}
	
	/**
	 * This is a negative test to check no Employees return if the employee id is 25555
	 * @throws SQLException SQK-server can fail
	 */
	@Test
	public void negativeTest_FindEmployee() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		Employee e = ctr.findEmployee(25555);
		
		assertTrue("Should return a null Employee object", e == null);
	}
	
	/**
	 * This is a negative test to check no Employees return if the employee id is under 0
	 * @throws SQLException SQL-server can fail
	 */
	@Test(expected=IllegalArgumentException.class)
	public void negativeTest_FindEmployee_withNegativeNumber() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		Employee e = ctr.findEmployee(-1);
	}
	
	/**
	 * This is a negative test to check no Employees return if the employee id is 0
	 * @throws SQLException SQL-server can fail
	 */
	@Test(expected=IllegalArgumentException.class)
	public void negativeTest_FindEmployee_withZero() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		Employee e = ctr.findEmployee(0);
	}
}
