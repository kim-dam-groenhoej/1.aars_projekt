package ModelLayer;

/**
 * This class represent Town. Is used to get information about zip code and town name
 * @author Kim Dam Gr�nh�j
 *
 */
public class Town {
	public int zip;
	private String name;
	
	/**
	 * Town constructor initialize this model
	 * @param zip current zipcode
	 * @param name current town name
	 */
	public Town(int zip, String name){
		this.zip = zip;
		this.name = name;
	}
	
	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}
