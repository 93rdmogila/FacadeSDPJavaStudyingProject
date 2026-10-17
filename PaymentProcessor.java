import java.util.HashMap;
public class PaymentProcessor {
    public void processPayment(Cart cart, CreditCard card, HashMap<String, Product> catalog) {
        double totalCost = 0.0;
        
        for (String itemName : cart.getItems().keySet()) {
            int qty = cart.getItems().get(itemName);
            Product product = catalog.get(itemName);
            totalCost += product.getPrice() * qty;
        }

        card.withdrawMoney(totalCost);
        System.out.println("Payment of $" + totalCost + " processed successfully.");
    }
}