package UnitTests;

import static org.junit.Assert.*;

<<<<<<< HEAD
import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;

=======
>>>>>>> branch 'master' of https://github.com/Eskelund/1.aars_projekt.git
import org.junit.Test;

import CtrLayer.StepCtr;
import DBLayer.IStepDB;
import DBLayer.StepDB;
import ModelLayer.Step;
/**
 * 
 * @author Kim Dam Grønhøj
 *
 */
public class JStep {

	@Test
	public void testStepDB() throws SQLException {
		StepCtr sctr = new StepCtr();
		ArrayList<Step> steps = (ArrayList<Step>)sctr.findNextSteps(1);

		for (Step s : steps) {
			System.out.println(s.getName());
		}

		assertTrue("Should contain one or more Step", steps.size() > 0);
	}

}
