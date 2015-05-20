/**
 * 
 */
package ModelLayer;

/**
 * @author Bo Handskemager S�rensen, Kim Dam Gr�nh�j
 *
 */
public class Restaurant {
	private int id;
	private String name;
	private String street;
	private Town town;
	private String phone;
	private String email;
	private String website;
	
	/**
	 * @param id
	 * @param name
	 * @param street
	 * @param zip
	 * @param phone
	 * @param email
	 * @param website
	 */
	public Restaurant(int id, String name, String street, Town town,
			String phone, String email, String website) {

		this.id = id;
		this.name = name;
		this.street = street;
		this.town = town;
		this.phone = phone;
		this.email = email;
		this.website = website;
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
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return the zip
	 */
	public Town getTown() {
		return town;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
}
