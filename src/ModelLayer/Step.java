/**
 * 
 */
package ModelLayer;

/**
 * @author Bo Handskemager S¿rensen
 *
 */
public class Step {
	public int id;
	public String name;
	public String description;
	public Restaurant restaurant;
	public boolean isLastStep;
	
	public Step(int id, String name, String description, Restaurant restaurant, boolean isLastStep){
		this.id = id;
		this.name = name;
		this.description = description;
		this.restaurant = restaurant;
		this.isLastStep = isLastStep;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * @return the isLastStep
	 */
	public boolean isLastStep() {
		return isLastStep;
	}
}
