/**
 * 
 */
package ModelLayer;

/**
 * @author Kim Dam Gr�nh�j
 *
 */
public class PartOrder {
	/**
	 * @param amount
	 * @param product
	 */
	public PartOrder(int amount, Product product) {
		this.amount = amount;
		this.product = product;
	}

	private int amount;
	private Product product;

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
