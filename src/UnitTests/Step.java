package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import DBLayer.IStepDB;
import DBLayer.StepDB;
/**
 * 
 * @author Kim Dam Grønhøj
 *
 */
public class Step {

	@Test
	public void testStepDB() {
		
		IStepDB stepdb = new StepDB();
		try {
			stepdb.findNextSteps(1, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
