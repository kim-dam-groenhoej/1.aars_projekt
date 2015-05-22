package DBLayer;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.sql.Statement;











import java.util.ArrayList;
import java.util.Date;

import ModelLayer.Customer;
import ModelLayer.Employee;
/**
 * 
 * @author Frank Eskelund
 * 
 *
 */
import ModelLayer.Order;
import ModelLayer.PartStep;
import ModelLayer.Restaurant;
import ModelLayer.Step;
import ModelLayer.Town;

public class OrderDB implements IOrderDB {
	
	private Connection con;
	
	public OrderDB() 
	{
		this.con = DBConnection.getInstance().getDBcon();
	}
	
	/* (non-Javadoc)
	 * @see DBLayer.OrderDB#findOrder(int)
	 */
	@Override
	public Order findOrder(int orderId) throws SQLException 
	{
		String wClause = " @orderid = " + orderId;
		return singleWhere(wClause);
		
	}
	
	//returns a single order based on a wClause
	private Order singleWhere(String wClause) throws SQLException
	{
		ResultSet results;
		Order order = null;
		String query = buildQuery(wClause);
		
		Statement statement = con.createStatement();
		statement.setQueryTimeout(2);
		results = statement.executeQuery(query);
		
		if(results.next())
		{
			int id = results.getInt("Order_Id");
			Date date = results.getDate("Order_Date");
			Customer customer = buildCustomer(results);
			Restaurant restaurant = buildRestaurant(results);
			order = new Order(id, date, restaurant, customer);
			order.setPartStepList(buildPartSteps(results, restaurant, order));
		}
		
		return order;
			
	}
	
	private ArrayList<PartStep> buildPartSteps(ResultSet results, Restaurant restaurant, Order order) throws SQLException {
		ArrayList<PartStep> steps = new ArrayList<PartStep>();
		while(results.next()){
			int stepId = results.getInt("Step_ID");
			String stepName = results.getString("Step_Name");
			String stepDesc = results.getString("Step_Description");
			boolean isLast = results.getBoolean("Step_Is_Last");
			
			int partStepId = results.getInt("Partstep_ID");
			Date partstepStartDate = results.getDate("Partstep_startdate");
			ArrayList<Employee> employeesOnPartStep = buildEmployees(results, restaurant);
			Step step = new Step(stepId, stepName, stepDesc, restaurant, isLast);
			PartStep partStep = new PartStep(step, partStepId, partstepStartDate, order, employeesOnPartStep);;
		}
		return steps;
	}

	private ArrayList<Employee> buildEmployees(ResultSet results, Restaurant restaurant) throws SQLException {
		ArrayList<Employee> list = new ArrayList<Employee>();
		int partStepId = results.getInt("Partstep_ID");
		int employeeID = results.getInt("Employee_Person_ID");
		
		boolean finished = employeeID == 0;
		while(!finished){
			String name = results.getString("Employee_Name");
			int zip = results.getInt("Employee_Zip");
			String townName = results.getString("Employee_Town_Name");
			String street = results.getString("Employee_Street");
			String phone = results.getString("Employee_Phone");
			int employeeNo = results.getInt("Employee_no");
			String position = results.getString("Employee_Position");
			
			Town town = new Town(zip, townName);
			Employee e = new Employee(employeeID, name, town, street, phone, employeeNo, position, null, restaurant);
			list.add(e);
			if(!results.next())
			{
				finished = true;
			}
			employeeID = results.getInt("Employee_Person_ID");
			finished = employeeID == 0;
		}
		return list;
		
	}

	private Restaurant buildRestaurant(ResultSet results) throws SQLException {
		Restaurant restaurant;
		int id = results.getInt("Restaurant_ID");
		String name = results.getString("Restaurant_Name");
		String email = results.getString("Restaurant_Email");
		String phone = results.getString("Restaurant_Phone");
		String website = results.getString("Restaurant_Website");
		String street = results.getString("Restaurant_Street");
		int zip = results.getInt("Restaurant_zip");
		String townName = results.getString("Restaurant_Town_Name");
		Town town = new Town(zip, townName);
		restaurant = new Restaurant(id, name, street, town, phone, email, website);
		return restaurant;
	}

	private Customer buildCustomer(ResultSet results) throws SQLException {
		Customer customer;
		int id = results.getInt("Customer_id");
		String name = results.getString("customer_name");
		int zip = results.getInt("customer_zip");
		String town = results.getString("Customer_Town_Name");
		String street = results.getString("Customer_Street");
		String phone = results.getString("Customer_Phone");
		String email = results.getString("Customer_email");
		
		Town customerTown = new Town(zip, town);
		customer = new Customer(id, name, customerTown, street, phone, email);
		return customer;
	}

	//Builds query with wClause
	private String buildQuery(String wClause)
	{
		String query = "EXEC FindOrder ";
		
		if(wClause.length() > 0) {
			query += wClause;
		}
		
		return query;		
				
	}
	

}
