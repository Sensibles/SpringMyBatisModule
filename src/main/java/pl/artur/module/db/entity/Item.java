package pl.artur.module.db.entity;

public class Item {
	
	long id;
	String itemName;
	int amount;
		
	public Item(long id, String itemName, int amount) {
		this.id = id;
		this.itemName = itemName;
		this.amount = amount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
