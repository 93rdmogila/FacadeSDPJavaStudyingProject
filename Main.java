import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Product> catalog = new HashMap<>();
        catalog.put("Laptop", new Product("Laptop", 1200.0, 10));
        catalog.put("Mouse", new Product("Mouse", 25.0, 25));
        InventoryService inventory = new InventoryService();
        PaymentProcessor payment = new PaymentProcessor();
        ShippingService shipping = new ShippingService();
        NotificationService notification = new NotificationService();
        OrderFacade orderFacade = new OrderFacade(inventory, payment, shipping, notification);
        Cart cart = new Cart();
        cart.addItem("Mouse", 2);
        CreditCard card = new CreditCard(123456, 100.0);
        orderFacade.placeOrder(cart, card, "Amanzhol", catalog);
    }
}