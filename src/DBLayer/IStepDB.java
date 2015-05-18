package DBLayer;

import java.sql.SQLException;
import java.util.List;

import ModelLayer.Step;

/**
 * 
 * @author Kim Dam Gr�nh�j
 * @version 15-05-2015
 *
 */
public interface IStepDB {
	List<Step> findNextSteps(int orderId) throws SQLException;
}
