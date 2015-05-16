/**
 * 
 */
package ModelLayer;

import java.util.Date;

/**
 * @author Bo Handskemager S¿rensen, Kim Dam Grønhøj
 *
 */
public class Order{
	private int id;
	private Date date;
	private int restId;
	private int customerId;
	
	public Order(int id, Date date, int restId, int customerId){
		this.id = id;
		this.date = date;
		this.restId = restId;
		this.customerId = customerId;
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
	public int getRestId() {
		return restId;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	
}
