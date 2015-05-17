package DBLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ModelLayer.Step;
import ModelLayer.Restaurant;

/**
 * 
 * @author Kim Dam Grønhøj
 * 
 *
 */
public class StepDB implements IStepDB {
	private Connection con;
	
	/**
	 * initializes database connection
	 */
	public StepDB()
	{
		con = DBConnection.getInstance().getDBcon();
	}
	
	/**
	 * Find the next steps for an order by orderId
	 * @orderId current orderId
	 * @return List of Step's the an user can choose
	 * @exception its possiblle SQL can throw exceptions
	 */
	@Override
	public List<Step> findNextSteps(int orderId) throws SQLException
	{
		ResultSet results;
		List<Step> steps = new ArrayList<Step>();
		
		// t-SQL query
		String query = "SELECT "
				+ "s.id, s.name, s.description, sr.nextstep_id, s.is_last_step, s.rest_id, r.name AS resName, r.street, r.zip, r.phone, r.email, r.website "
				+ "FROM (SELECT TOP(1) * FROM [PartStep] ps WHERE ps.order_id = ? ORDER BY ps.startDate DESC) ps "
				+ "INNER JOIN [StepRelation] sr ON ps.step_id = sr.step_id "
				+ "INNER JOIN [Step] s ON sr.nextstep_id = s.id "
				+ "INNER JOIN [Restaurant] r ON s.rest_id = r.id ";
		
		// prepare SQL-statement
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setQueryTimeout(5);
		
		// input parameters
		stmt.setInt(1, orderId);
		
		// send SQL-query and open a connection and return output
		results = stmt.executeQuery();
		
		// loop all data from database and create instances of Step objects
		while (results.next()){
			steps.add(findBuildStep(results));
		}
		
		// close connection
		stmt.close();
		
		return steps;
	}
	
	/**
	 * Fill Step object with data from ResultSet
	 * @param results current ResultSet data
	 * @return Filled Step
	 * @throws Exception
	 */
	private Step findBuildStep(ResultSet results) throws Exception {
		Step step;
		Restaurant res;
		
		int restId = results.getInt("rest_id");
		String resName = results.getString("resName");
		String street = results.getString("street");
		int zip = results.getInt("zip");
		String phone = results.getString("phone");
		String email = results.getString("email");
		String website = results.getString("website");
		
		res = new Restaurant(restId, resName, street, zip, phone, email, website);
		
		int id = results.getInt("id");
		String name = results.getString("name");
		String description = results.getString("description");
		int rest_id = results.getInt("rest_id");
		Boolean is_last_step = results.getBoolean("is_last_step");
		
		step = new Step(id, name, description, res, is_last_step);
		return step;
	}
}
