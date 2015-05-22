package UnitTests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import CtrLayer.EmployeeCtr;
import ModelLayer.Employee;

/**
 * 
 * @author Kim Dam Grønhøj
 *
 */
public class JEmployee {

	@Test
	public void positiveTest_FindgetAllEmployees() throws Exception, SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		List<ModelLayer.Employee> list = ctr.getAllEmployees(1);
		
		Boolean foundItem = false;
		for (Employee emp : list) {
			if (emp.getName().equals("Jens Henrik")) {
				foundItem = true;
			}
		}
		
		if (!foundItem) {
			throw new Exception("'Jens henrik' not found");
		}
		
		assertTrue("List should contain one employee", list.size() > 0);
	}
	
	@Test
	public void negativeTest_FindgetAllEmployees() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		List<ModelLayer.Employee> list = ctr.getAllEmployees(10000);
		
		assertTrue("List should contain one employee", list.size() == 0);
	}
	
	@Test
	public void negativeTest_FindgetAllEmployees_withNegativeNumber() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		List<ModelLayer.Employee> list = ctr.getAllEmployees(-1);
		
		assertTrue("List should contain one employee", list.size() == 0);
	}

	@Test
	public void positiveTest_FindEmployee() throws SQLException, Exception {
		EmployeeCtr ctr = new EmployeeCtr();
		Employee e = ctr.findEmployee(1);
		
		if (!e.getName().equals("Jens Henrik")) {
			throw new Exception("'Jens henrik' not found");
		}
		
		assertTrue("Should return one Employee object", e != null);
	}
	
	@Test
	public void negativeTest_FindEmployee() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		Employee e = ctr.findEmployee(25555);
		
		assertTrue("Should return one Employee object", e == null);
	}
	
	@Test
	public void negativeTest_FindEmployee_withNegativeNumber() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		Employee e = ctr.findEmployee(-1);
		
		assertTrue("Should return one Employee object", e == null);
	}
}
