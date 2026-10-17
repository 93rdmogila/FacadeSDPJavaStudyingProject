import java.util.HashMap;

public class Cart {
	private HashMap<String, Integer> items = new HashMap<>();
	public Cart(){
		this.items = new HashMap<>();
	}
	public Cart(HashMap<String, Integer> items){
		this.items = items;
	}

	public HashMap<String, Integer> getItems(){
		return items;
	}

	public void addItem(String nameOfItem, Integer costOfItem){
		items.put(nameOfItem, costOfItem);
		System.out.println("Item " + nameOfItem + " was added");
	}

	public void deleteItem(String nameOfItem){
		if(items.containsKey(nameOfItem)){
			items.remove(nameOfItem);
			System.out.println("Item " + nameOfItem + "was deleted");
		}else{
			System.out.println("There is no item " + nameOfItem);
		}
	}
}
