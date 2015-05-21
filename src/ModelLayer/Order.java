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

	private Customer customer;
	
	public Order(int id, Date date, Restaurant restaurant, Customer customer, ArrayList<PartStep> partSteps){
		this.id = id;
		this.date = date;
		this.restaurant = restaurant;
		this.customer = customer;
		this.partStepList = partSteps;
	}
	
	public Order(int id, Date date, Restaurant restaurant, Customer customer){
		this(id, date, restaurant, customer, new ArrayList<PartStep>());
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
	public Restaurant getRest() {
		return restaurant;
	}

	/**
	 * @return the customerId
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the list of partsteps
	 */
	public List<PartStep> getPartStepList() {
		return partStepList;
	}
	
	/**
	 * @param partStepList the partStepList to set
	 */
	public void setPartStepList(List<PartStep> partStepList) {
		this.partStepList = partStepList;
	}

	public void addPartStep(PartStep ps) {
		partStepList.add(ps);
	}
	
}
