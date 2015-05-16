/**
 * 
 */
package ModelLayer;

/**
 * @author Bo Handskemager Sï¿½rensen, Kim Dam Grønhøj
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
	public Customer(int id, String name, int zip, String street, String phone, String email) {
		super(id, name, zip, street, phone);
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
