package DBLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ModelLayer.Step;
import ModelLayer.Restaurant;
import ModelLayer.Town;

/**
 * 
 * @author Kim Dam Gr�nh�j
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
	 * @throws Exception 
	 * @exception its possiblle SQL can throw exceptions
	 */
	@Override
	public List<Step> findNextSteps(int stepID) throws SQLException
	{
		ResultSet results;
		List<Step> steps = new ArrayList<Step>();
		
		// t-SQL query
		String query = "SELECT S.rest_id, S.name AS resName, R.street, R.zip, T.name AS Town_Name, R.phone, R.email, R.website, S.id, S.name, S.description, S.is_last_step "
				+ "FROM [Step] AS S "
				+ "INNER JOIN [StepRelation] AS SR ON S.id = SR.nextstep_id "
				+ "INNER JOIN [Restaurant] AS R ON R.id = S.rest_id "
				+ "INNER JOIN [Town] AS T ON R.zip = t.zip "
				+ "WHERE SR.step_id = ? ";
		
		// prepare SQL-statement
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setQueryTimeout(5);
		
		// input parameters
		stmt.setInt(1, stepID);
		
		// send SQL-query and open connection and return output
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
	 * @throws SQLException
	 */
	private Step findBuildStep(ResultSet results) throws SQLException {
		Step step;
		Restaurant res;
		
		int restId = results.getInt("rest_id");
		String resName = results.getString("resName");
		String street = results.getString("street");
		int zip = results.getInt("zip");
		String townName = results.getString("Town_Name");
		String phone = results.getString("phone");
		String email = results.getString("email");
		String website = results.getString("website");
		Town town = new Town(zip, townName);
		res = new Restaurant(restId, resName, street, town, phone, email, website);
		
		int id = results.getInt("id");
		String name = results.getString("name");
		String description = results.getString("description");
		int rest_id = results.getInt("rest_id");
		Boolean is_last_step = results.getBoolean("is_last_step");
		
		step = new Step(id, name, description, res, is_last_step);
		return step;
	}
}
