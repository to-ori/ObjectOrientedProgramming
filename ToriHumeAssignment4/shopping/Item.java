package shopping;

//this class contains the item information
public class Item {

	//class variables
	private String itemName;
	private long itemid;
	private int cost;

	//overloaded constructor
	public Item(long id, String name) {
		this.itemid= id;
		this.itemName= name;
	}

	//getters and setters
	public void setCost(int cost1) {
		this.cost= cost1;

	}

	public int getCost() {

		return cost;
	}

	public long getId() {

		return itemid;
	}


	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	//Overridden toString
	@Override
	public String toString() {
		return "Item Name: " + itemName + ", \tItem ID: " + itemid + ", \tCost: " + cost ;
	}



}
