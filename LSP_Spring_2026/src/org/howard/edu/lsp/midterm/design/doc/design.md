# Improved Design Using CRC Cards

Class: Order  
Responsibilities:
- Store order information
- Provide customer, item, and price data
- Provide access to computed totals if needed

Collaborators:
- Customer
- PricingService

---

Class: Customer  
Responsibilities:
- Store customer information such as name and email
- Provide customer details to other classes

Collaborators:
- Order
- NotificationService

---

Class: PricingService  
Responsibilities:
- Calculate tax for an order
- Apply discount rules
- Compute final total

Collaborators:
- Order
- DiscountPolicy

---

Class: DiscountPolicy  
Responsibilities:
- Define discount rules
- Determine whether a discount applies
- Return the discounted amount or adjusted total

Collaborators:
- PricingService
- Order

---

Class: ReceiptPrinter  
Responsibilities:
- Format and display receipt information
- Print customer, item, and total details

Collaborators:
- Order
- PricingService

---

Class: OrderRepository  
Responsibilities:
- Save order information to persistent storage
- Isolate file-writing behavior from business logic

Collaborators:
- Order

---

Class: NotificationService  
Responsibilities:
- Send confirmation messages to customers
- Handle notification-related behavior

Collaborators:
- Customer
- Order

---

Class: ActivityLogger  
Responsibilities:
- Record order-processing activity
- Log timestamps and processing events

Collaborators:
- Order

