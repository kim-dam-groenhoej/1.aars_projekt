package ModelLayer;

/**
 * 
 * @author Kim Dam Gr�nh�j
 *
 */
public class Town {
	public int zip;
	private String name;
	
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
