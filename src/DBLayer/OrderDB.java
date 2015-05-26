package DBLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ModelLayer.Customer;
import ModelLayer.Employee;
import ModelLayer.Order;
import ModelLayer.PartStep;
import ModelLayer.Restaurant;
import ModelLayer.Step;
import ModelLayer.Town;

/**
 * 
 * @author Frank Eskelund, KIm Dam Gr�nh�j, Tobias
 * 
 *
 */
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
		if(orderId <= 0)
		{
			throw new IllegalArgumentException("An identifier must be a positive value.");
		}
		String wClause = " @orderid = " + orderId;
		return singleWhere(wClause);
	}
	
	//returns a single order based on a wClause
	private Order singleWhere(String wClause) throws SQLException
	{
		ResultSet results;
		Order order = null;
		String query = buildQuery(wClause);
		
		//Parameterne til createStatement gør det muligt at gå frem og tilbage i ResultSettet.
		Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
		boolean finished = false;
		while(!finished){
			int stepId = results.getInt("Step_ID");
			String stepName = results.getString("Step_Name");
			String stepDesc = results.getString("Step_Description");
			boolean isLast = results.getBoolean("Step_Is_Last");
			
			int partStepId = results.getInt("Partstep_ID");
			Date partstepStartDate = results.getDate("Partstep_startdate");
			ArrayList<Employee> employeesOnPartStep = buildEmployees(results, restaurant);
			Step step = new Step(stepId, stepName, stepDesc, restaurant, isLast);
			PartStep partStep = new PartStep(step, partStepId, partstepStartDate, order, employeesOnPartStep);
			steps.add(partStep);
			finished = !results.next();
		}
		return steps;
	}

	private ArrayList<Employee> buildEmployees(ResultSet results, Restaurant restaurant) throws SQLException {
		ArrayList<Employee> list = new ArrayList<Employee>();
		int employeeID = results.getInt("Employee_Person_ID");
		int partStepID = results.getInt("PartStep_ID");
		
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
			
			//Gå frem til næste tupel, og check om den indeholder en yderligere a.
			if(results.next())
			{
				int currentPartStepID = results.getInt("PartStep_ID");
				finished = currentPartStepID != partStepID;
			}else{
				finished = true;
			}
			if(finished)
			{
				//Færdig med at håndtere ansatte, flyt cursoren én tupel tilbage.
				results.previous();
			}
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
	
	@Override
	public void savePartStep(PartStep partStep) throws SQLException
	{
		// Declare variables
		List<Employee> emps = partStep.getEmployees();
		String combinedQuery = "";
		
		DBConnection.startTransaction();
		
		// SQL-queries
		String insertPartStepQuery = "DECLARE @partStepID INT;"
				+ "INSERT INTO [PartStep] ([step_id] ,[order_id]) VALUES(?,?);"
				+ "SET @partStepID = SCOPE_IDENTITY();";
		String insertAssociatedEmployeesQuery = "INSERT INTO [EmployeesOnPartStep] ([partstep_id] ,[employee_no]) VALUES (@partStepID, ?);";
		
		// add insert partstep query into combined query
		combinedQuery += insertPartStepQuery;
		
		// add the same insert associated query based on how many employees are into combined query
		int l = 0;
		while (emps.size() > l) {
			combinedQuery += insertAssociatedEmployeesQuery;
			l++;
		}
		
		// prepare combined statement
		PreparedStatement partStepStatement = con.prepareStatement(combinedQuery, Statement.RETURN_GENERATED_KEYS);
		partStepStatement.setQueryTimeout(2);
		
		// Parameter index
		int i = 1;
		
		// Add partstep parameters to query by index. First ? in query is fx. index 1. and next ? is index 2...
		partStepStatement.setInt(i++, partStep.getStep().getId());
		partStepStatement.setInt(i++, partStep.getOrder().getId());

		// Add EmployeesOnPartStep parameters 
		for(Employee e : emps)
		{
			partStepStatement.setInt(i++, e.getEmployeeNo());
		}	
		
		// Add all parameters into query
		partStepStatement.addBatch();
		
		// Execute combined query
		partStepStatement.executeBatch();
		
		partStepStatement.close();
		DBConnection.commitTransaction();
	}
}
