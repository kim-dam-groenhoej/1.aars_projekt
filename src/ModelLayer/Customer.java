/**
 * 
 */
package ModelLayer;

/**
 * @author Bo Handskemager S�rensen, Kim Dam Gr�nh�j
 *
 */
public class Customer extends Person {
	private String email;
	
	/**
	 * @param id
	 * @param name
	 * @param zip
	 * @param street
	 * @param phone
	 */
	public Customer(int id, String name, Town town, String street, String phone, String email) {
		super(id, name, town, street, phone);
		// TODO Auto-generated constructor stub
		this.email = email;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
}
