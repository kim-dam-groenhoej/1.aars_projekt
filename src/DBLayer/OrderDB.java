package DBLayer;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.sql.Statement;




import ModelLayer.Customer;
/**
 * 
 * @author Frank Eskelund
 * 
 *
 */
import ModelLayer.Order;
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
		String wClause = " id = " + orderId;
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
			Customer customer = buildCustomer(results);
			
		}
		
		return order;
			
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
		String query = "SELECT O.id, O.date, R.id, R.name AS [Restaurant name], R.email, R.phone, R.street, R.zip, RT.name AS Restaurant_Town_Name, P.id AS Customer_id, P.name AS Customer_Name,C.email AS Customer_email, P.zip AS Customer_zip, CT.name AS Customer_Town_Name, P.street AS Customer_Street, p.phone AS Customer_Phone, PS.id as PartStep_ID, PS.startDate AS Partstep_startdate, S.name AS PartStep_Name, EOP.employee_no, E.position, EP.name"
				+"FROM [Order] AS O INNER JOIN Restaurant AS R ON O.rest_id = R.id"
				+ "INNER JOIN Town AS RT ON R.zip = RT.zip"
				+ "INNER JOIN Person AS P ON O.customer_id = P.id"
				+ "INNER JOIN Town AS CT ON P.zip = CT.zip "
				+ "INNER JOIN Customer AS C ON O.customer_id = C.person_id"
				+ "INNER JOIN PartStep AS PS ON PS.order_id = O.id"
				+ "INNER JOIN Step AS S ON PS.step_id = S.id"
				+ "LEFT JOIN EmployeesOnPartStep AS EOP ON PS.id = EOP.partstep_id"
				+ "FULL OUTER JOIN Employee AS E ON E.employee_no = EOP.employee_no"
				+ "FULL OUTER JOIN Person AS EP ON EP.id = E.person_id";
		
		if(wClause.length() > 0) {
			query += " WHERE " + wClause;
		}
		
		return query;		
				
	}
	

}
