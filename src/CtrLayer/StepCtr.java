package CtrLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBLayer.IStepDB;
import DBLayer.StepDB;
import ModelLayer.Step;

/**
 * @author Frank Eskelund, Kim Dam Gr�nh�j, Bo Handskemager Sørensen
 * @version 
 */

public class StepCtr {

	/**
	 * Field variable
	 */
	private IStepDB stepDB;
	
	/**
	 * Constructor
	 * Invokes the StepDB constructor in order to get access to the DB
	 */
	public StepCtr() {
		stepDB = new StepDB();
	}
	
	/**
	 * This method finds the next steps available based on the current stepId
	 * 
	 * @param stepId
	 * @return
	 * @throws SQLException
	 */
	public List<Step> findNextSteps(int stepId) throws SQLException
	{
		return stepDB.findNextSteps(stepId);
	}
}
