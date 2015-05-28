/**
 * 
 */
package ModelLayer;

/**
 * This class represent Customer
 * @author Bo Handskemager S�rensen, Kim Dam Gr�nh�j
 *
 */
public class Customer extends Person {
	private String email;
	
	/**
	 * Customer constructor initialize this model
	 * @param id current id
	 * @param name fullname of customer
	 * @param zip current Town object with zip and town name
	 * @param street streetname with number
	 * @param phone current phonenumber
	 */
	public Customer(int id, String name, Town town, String street, String phone, String email) {
		super(id, name, town, street, phone);
		
		this.email = email;
	}

	/**
	 * Get the email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
}
