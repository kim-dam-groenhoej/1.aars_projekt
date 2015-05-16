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
 * """"""""""""KODE ER IKKE FÆRDIG"""""""""""""""
 *
 */
public class StepDB implements IStepDB {
	private Connection con;
	
	public StepDB()
	{
		con = DBConnection.getInstance().getDBcon();
	}
	
	public List<Step> findNextSteps(int orderId, int stepId) throws Exception
	{
		String wClause = " order_id = ? AND step_id = ? ORDER BY startDate";
		return findMultiplyWhere(wClause, orderId, stepId);
	}
	
	private List<Step> findMultiplyWhere(String wClause, int orderId, int stepId) throws Exception {

		ResultSet results;
		List<Step> steps = new ArrayList<Step>();
		String query = findBuildQuery(wClause);
		
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setQueryTimeout(5);
		
		stmt.setInt(1, orderId);
		stmt.setInt(2, stepId);
		
		results = stmt.executeQuery();
		
		while (results.next()){
			steps.add(findBuildStep(results));
		}
		
		stmt.close();
		
		return steps;
	}
	
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
	
	private String findBuildQuery(String wClause) {
		String query = "SELECT "
				+ "s.name, s.description, sr.nextstep_id, s.is_last_step, s.rest_id, r.name AS resName, r.street, r.zip, r.phone, r.email, r.website "
				+ "FROM [PartStep] ps "
				+ "INNER JOIN [Step] s ON ps.step_id = s.id "
				+ "INNER JOIN [Restaurant] r ON s.rest_id = r.id "
				+ "INNER JOIN [StepRelation] sr ON s.id = sr.step_id";
		
		if(wClause.length()>0)
		{
			query=query+" WHERE " + wClause;
		}	
		
		return query;
	}
}
