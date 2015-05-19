package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

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
	public void testStepDB() {
		IStepDB stepdb = new StepDB();
		
		try {
			java.util.List<Step> steps = stepdb.findNextSteps(2);
			
			for (Step s : steps) {
				System.out.println(s.getName());
			}
			
			assertTrue("Should contain one or more Step", steps.size() > 0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
