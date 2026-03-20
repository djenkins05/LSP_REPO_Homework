# Development Log – Question 3

## External Resources Used

### 1. ChatGPT (OpenAI)
URL: https://chat.openai.com/

**How it was used:**
ChatGPT was used to help design and implement the Task and TaskManager classes, generate CRC cards, explain how to set up packages in Eclipse, and ensure that the output matched the assignment requirements.

---

## ChatGPT Transcript
User: Does my design_evaluation.md meet the requirements for Question 3 part 1 
ChatGPT: It does what the prompt asks:
Evaluates the design of PriceCalculator ✔️
Explains maintenance problems ✔️
Explains extensibility problems ✔️
Connects the issue to system evolution ✔️
Suggests a stronger OO alternative ✔️
Your explanation is solid because it specifically points out:
the hardcoded if statements
the need to modify the class whenever a new rule is added
the Open/Closed Principle
why a Strategy Pattern would improve the design
The only thing I’d suggest is making it just a little fuller, since some graders like slightly more detail. Here’s a polished version:(Version Used)
So yes, your current version is acceptable, and this version is just a slightly stronger submission-ready refinement.

User: Does my code meet the requirement of question 3 part 2
ChatGPT: Then yes, your refactored design should meet the requirements, assuming these two things are true:
All classes are in the correct package
Each class is in its own .java file with Javadocs
PricingStrategy.java
PriceCalculator.java
each concrete strategy in its own file
all public classes and public methods documented
Your PriceCalculator class itself is good because it:
clearly uses delegation to a strategy
supports changing discount behavior without changing the calculator logic
includes Javadoc comments
fits the Strategy Pattern