/**
 * 
 */
package ModelLayer;

/**
 * @author Kim Dam Grønhøj
 *
 */
public class PartOrder {
	/**
	 * @param amount
	 * @param product
	 */
	public PartOrder(double amount, Product product) {
		this.amount = amount;
		this.product = product;
	}

	private double amount;
	private Product product;

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
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
