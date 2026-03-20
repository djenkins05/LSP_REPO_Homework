# Design Evaluation of `OrderProcessor`
The `OrderProcessor` class has several object-oriented design issues that reduce its maintainability, extensibility, and overall clarity. The biggest issue is that it violates the **Single Responsibility Principle** because one class is doing too many unrelated jobs. It stores order data, calculates tax, applies discounts, prints receipts, saves orders to a file, sends confirmation messages, and logs activity. These responsibilities should not all belong to one class.

Another major problem is **poor encapsulation**. The fields `customerName`, `email`, `item`, and `price` are all public, which means any other class can directly change them without control. This makes the object harder to protect and can lead to invalid or inconsistent data.

The design is also **tightly coupled** to specific implementation details. For example, the class directly writes to a file using `FileWriter`, directly prints to the console, and directly handles email confirmation output. Because these behaviors are hardcoded inside the class, changing how receipts are stored or how confirmations are sent would require modifying the `OrderProcessor` class itself.

The discount logic is also poorly designed. The rule `if(price > 500)` is embedded directly in `processOrder()`. If new discount rules are added later, the method will continue growing and become harder to understand and modify. This reduces extensibility and makes the code more fragile.

The class also mixes **business logic** with **input/output concerns**. Calculating taxes and discounts is business logic, while printing receipts, writing files, and logging are infrastructure or output concerns. Combining all of these in one method creates low cohesion and makes testing more difficult.

From an object-oriented design perspective, this class does not distribute responsibilities well. A better design would separate order data, pricing logic, persistence, notification, and logging into different collaborating classes. That would improve readability, maintainability, and extensibility while producing a cleaner object-oriented structure.
