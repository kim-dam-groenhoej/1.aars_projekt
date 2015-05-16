/**
 * 
 */
package ModelLayer;

/**
 * @author Bo Handskemager S¿rensen, Kim Dam Grønhøj
 *
 */
public class Person {
	private int id;
	private String name;
	private int zip;
	private String street;
	private String phone;
	
	Person (int id, String name, int zip, String street, String phone){
		this.id = id;
		this.name = name;
		this.zip = zip;
		this.street = street;
		this.phone = phone;
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
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	

}
