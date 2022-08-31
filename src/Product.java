import java.time.LocalDate;

public class Product {
	
	Integer productId;
	LocalDate currentDate;
	Integer inventory;	
	
	public Product(Integer productId,LocalDate currentDate,Integer inventory) {
		this.productId = productId;
		this.currentDate = currentDate;
		this.inventory = inventory;
	}
	
	public Product() {}
	public Integer getProductId() {
		return this.productId;
	}
	
	public LocalDate getCurrentDate() {
		return this.currentDate;
	}
	
	public Integer getInventory() {
		return this.inventory;
	}
	
}
