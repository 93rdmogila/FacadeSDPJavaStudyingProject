public class OrderFacade {
    private InventoryService inventoryService;
    private PaymentProcessor paymentProcessor;
    private ShippingService shippingService;
    private NotificationService notificationService;

    public OrderFacade(InventoryService inventoryService,
						PaymentProcessor paymentProcessor,
						ShippingService shippingService,
                    	NotificationService notificationService) {
        this.inventoryService = inventoryService;
        this.paymentProcessor = paymentProcessor;
        this.shippingService = shippingService;
        this.notificationService = notificationService;
    }

    public void placeOrder(Cart cart, CreditCard card, String customerName, java.util.HashMap<String, Product> catalog) {
        try {
            inventoryService.checkAndReserve(cart);
            paymentProcessor.processPayment(cart, card, catalog);
            shippingService.arrangeShipping(customerName);
            notificationService.sendNotification(customerName);
            System.out.println("Order completed successfully!\n");
        } catch (RuntimeException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Initiating rollback (releasing stock)...");
            inventoryService.releaseReserve(cart);
            System.out.println("Order cancelled due to an error.");
        }
    }
}