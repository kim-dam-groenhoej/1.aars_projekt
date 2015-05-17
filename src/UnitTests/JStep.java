package UnitTests;

import static org.junit.Assert.*;

import java.awt.List;

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
			java.util.List<Step> steps = stepdb.findNextSteps(1, 1);
			
			for (Step s : steps) {
				System.out.println(s.getName());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
