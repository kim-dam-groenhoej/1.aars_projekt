package DBLayer;

import java.util.List;

import ModelLayer.Employee;

/**
 * 
 * @author Kim Dam Grønhøj
 * @version 15-05-2015
 *
 */
public interface IEmployeeDB {
	List<Employee> findEmployees(int restaurentId);
}
