# Design Evaluation

The current `PriceCalculator` class works, but its design creates maintenance and extensibility problems. The class uses a sequence of hardcoded `if` statements to handle each customer type, which means every time a new pricing rule is added, the class itself must be modified. This violates the Open/Closed Principle because the class is not open to extension without changing existing code.

The design also places all pricing behaviors inside one class instead of separating them into smaller, reusable components. As the system grows, this approach makes the code harder to read, test, and maintain because more conditions will continue to accumulate in the same method. A better object-oriented design would use the Strategy Pattern, where each pricing rule is implemented in its own class and the calculator can apply different strategies without changing its core implementation.
