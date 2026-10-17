import java.util.HashMap;

public class InventoryService{
	private HashMap<String, Product> stock = new HashMap<>();
	public InventoryService(){
		stock.put("Laptop", new Product("Laptop", 1200.0, 10));
		stock.put("Mouse", new Product("Mouse", 25.0, 25));
		stock.put("Keyboard", new Product("Keyboard", 50.0, 20));
	}

	public void checkAndReserve(Cart cart){
		for(String itemName : cart.getItems().keySet()){
			if(!stock.containsKey(itemName)){
				throw new RuntimeException("There is no item " + itemName + " in the stock now");
			}

			Product product = stock.get(itemName);
			if(product.getQuantity() == 0){
				throw new RuntimeException("Item " + itemName + " ran out");
			}
		}

		for(String itemName : cart.getItems().keySet()){
			Product product = stock.get(itemName);
			product.setQuantity(product.getQuantity() - 1);
		}
		System.out.println("Items have been reserved!");
	}

	public void releaseReserve(Cart cart){
		Product product;
		for(String itemName : cart.getItems().keySet()){
			if(stock.containsKey(itemName)){
				product = stock.get(itemName);
				product.setQuantity(product.getQuantity() + 1);
			}
		}
		System.out.println("Reserve was released and returned to the stock");
	}
}