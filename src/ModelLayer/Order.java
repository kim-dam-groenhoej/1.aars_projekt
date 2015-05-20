/**
 * 
 */
package ModelLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bo Handskemager S�rensen, Kim Dam Gr�nh�j
 *
 */
public class Order{
	private int id;
	private Date date;
	private Restaurant restaurant;
	private List<PartStep> partStepList;
	private int customerId;
	
	public Order(int id, Date date, Restaurant restaurant, int customerId){
		this.id = id;
		this.date = date;
		this.restaurant = restaurant;
		this.customerId = customerId;
		this.partStepList = new ArrayList<PartStep>();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the restId
	 */
	public Restaurant getRestId() {
		return restaurant;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	public List<PartStep> getPartStepList() {
		return partStepList;
	}

	public void addPartStep(PartStep ps) {
		partStepList.add(ps);
	}
	
}
