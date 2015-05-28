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

	private IStepDB stepDB;
	
	public StepCtr() {
		stepDB = new StepDB();
	}
	
	/**
	 * This function finds the next steps available based on the current stepId
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
