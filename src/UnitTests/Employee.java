package UnitTests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import CtrLayer.EmployeeCtr;

public class Employee {

	@Test
	public void test() throws SQLException {
		EmployeeCtr ctr = new EmployeeCtr();
		List<ModelLayer.Employee> list = ctr.getAllEmployees(1);
		assertEquals("List should contain one employee", 1, list.size());
	}

}
