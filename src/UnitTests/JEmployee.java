package UnitTests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import CtrLayer.EmployeeCtr;
import ModelLayer.Employee;

public class JEmployee {

	@Test
	public void testFindgetAllEmployees() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		List<ModelLayer.Employee> list = ctr.getAllEmployees(1);
		assertEquals("List should contain one employee", 1, list.size());
	}

	@Test
	public void testFindEmployee() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		Employee e = ctr.findEmployee(1);
		
		assertTrue("Should return one Employee object", e != null);
	}
}
