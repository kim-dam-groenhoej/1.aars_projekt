/**
 * 
 */
package CtrLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBLayer.IStepDB;
import DBLayer.StepDB;
import ModelLayer.Step;

/**
 * @author Frank Eskelund, Kim Dam Grønhøj
 * @version 
 */
public class StepCtr {

	private IStepDB stepDB;
	
	public StepCtr() {
		stepDB = new StepDB();
	}
	
	public List<Step> findNextSteps(int stepId) throws SQLException
	{
		return stepDB.findNextSteps(stepId);
	}
}
