package categories;

public class Products {
	private String productName;
	private double productPrice;
	private String productSize;
	
	public Products(String productName,double productPrice,String productSize) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productSize = productSize;
	}
	
	public Products() {
		super();
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductprice() {
		return productPrice;
	}
	public void setProductprice(double productprice) {
		this.productPrice = productprice;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
}
