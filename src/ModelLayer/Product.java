/**
 * 
 */
package ModelLayer;

/**
 * @author Kim Dam Grønhøj & peter
 *
 */
public class Product {
	private String name;
	private Double price;
	
	public Product(String name, double price)
	{
		this.name = name;
		this.price = price;
	}
	
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
