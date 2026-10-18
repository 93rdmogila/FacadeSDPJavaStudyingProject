# Assignment #4 — Facade Pattern (Option B: Online Order Processing)

**Course:** ShP-2216 – Software Design Patterns  
**Student:** Yerzhanov Amanzhol (Group SE-2526)  
**Language:** Java (JDK 17)

---

## 📌 Overview
This project demonstrates the **Facade Structural Design Pattern** applied to an **Online Order Processing System**.

The `OrderFacade` class encapsulates a complex multi-step order workflow involving four subsystem services behind a single high-level API method: `placeOrder(...)`.

---

## 🏗️ Subsystem Components
1. **`InventoryService`**: Manages stock levels (`HashMap<String, Product>`), performs atomic two-pass stock checking (`checkAndReserve`), and handles stock restoration on order failures (`releaseReserve`).
2. **`PaymentProcessor`**: Calculates order totals and processes card charges via `CreditCard`, throwing exceptions if funds are insufficient.
3. **`ShippingService`**: Handles delivery arrangement upon successful payment.
4. **`NotificationService`**: Sends confirmation alerts to customers.

---

## 🔄 Transaction Rollback Workflow
If payment fails after inventory reservation, `OrderFacade` catches the exception and automatically triggers `releaseReserve(...)` on `InventoryService` to restore warehouse stock.

---

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone [https://github.com/amanzhol/Software-Design-Patterns-Assignment4-Facade.git](https://github.com/amanzhol/Software-Design-Patterns-Assignment4-Facade.git)
