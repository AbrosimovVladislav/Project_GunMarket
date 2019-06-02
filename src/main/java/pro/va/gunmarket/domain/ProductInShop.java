package pro.va.gunmarket.domain;

import pro.va.gunmarket.domain.product.Product;


public class ProductInShop {
	private Product product;
	private Shop shop;
	private double price;
	private int sale;
	private boolean inStock;
	private String additionalInfo;

	public ProductInShop(Product product, Shop shop, double price, boolean inStock) {
		this.product = product;
		this.shop = shop;
		this.price = price;
		this.inStock = inStock;
	}

	public ProductInShop(Product product, Shop shop, double price, int sale, boolean inStock, String additionalInfo) {
		this.product = product;
		this.shop = shop;
		this.price = price;
		this.sale = sale;
		this.inStock = inStock;
		this.additionalInfo = additionalInfo;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
