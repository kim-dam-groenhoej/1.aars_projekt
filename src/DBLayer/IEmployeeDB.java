package DBLayer;

import java.sql.SQLException;
import java.util.List;

import ModelLayer.Employee;

/**
 * 
 * @author Kim Dam Gr�nh�j
 * @version 15-05-2015
 *
 */
public interface IEmployeeDB {
	List<Employee> getAllEmployees(int restaurentId) throws SQLException;
	Employee findEmployee(int employeeNumber);
}
