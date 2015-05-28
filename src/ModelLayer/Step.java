/**
 * 
 */
package ModelLayer;

/**
 * This class represent the real Step
 * @author Bo Handskemager S¿rensen, KIm Dam Grønhøj
 *
 */
public class Step {
	private int id;
	private String name;
	private String description;
	private Restaurant restaurant;
	private boolean isLastStep;
	
	/**
	 * Step constructor initialize this model
	 * @param id current id
	 * @param name current step name
	 * @param description current description of this step
	 * @param restaurant current restaurant using this step
	 * @param isLastStep is it the lastStep for this order-flow?
	 */
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
