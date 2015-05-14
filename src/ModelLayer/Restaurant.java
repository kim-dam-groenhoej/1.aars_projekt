/**
 * 
 */
package ModelLayer;

/**
 * @author Bo Handskemager S¿rensen
 *
 */
public class Restaurant {
	public int id;
	public String name;
	public String street;
	public int zip;
	public String phone;
	public String email;
	public String website;
	
	/**
	 * @param id
	 * @param name
	 * @param street
	 * @param zip
	 * @param phone
	 * @param email
	 * @param website
	 */
	public Restaurant(int id, String name, String street, int zip,
			String phone, String email, String website) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.zip = zip;
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
	public int getZip() {
		return zip;
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
