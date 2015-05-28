/**
 * 
 */
package ModelLayer;

/**
 * This represent a "temp" class PartOrder. This class is used to get number of a product ordred
 * @author Kim Dam Gr�nh�j
 *
 */
public class PartOrder {
	private int amount;
	private Product product;
	
	/**
	 * @param amount
	 * @param product
	 */
	public PartOrder(int amount, Product product) {
		this.amount = amount;
		this.product = product;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}
