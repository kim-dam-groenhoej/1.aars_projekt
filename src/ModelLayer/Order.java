/**
 * 
 */
package ModelLayer;

import java.util.Date;

/**
 * @author Reclzz
 *
 */
public class Order extends Person{
	public int id;
	public Date date;
	public int restId;
	public int customerId;
	
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
