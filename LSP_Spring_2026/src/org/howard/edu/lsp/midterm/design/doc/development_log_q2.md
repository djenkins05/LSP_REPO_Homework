# Development Log – Question 2 

## External Resources Used

### 1. ChatGPT (OpenAI)
URL: https://chat.openai.com/

**How it was used:**
ChatGPT was used to help design and implement the Task and TaskManager classes, generate CRC cards, explain how to set up packages in Eclipse, and ensure that the output matched the assignment requirements.

---

## ChatGPT Transcript
User: Does my evaluation.md meet the requirement of question 2 part 1
ChatGPT: Yes — the content meets the evaluation requirements very well.
It does all the main things the prompt asks for:
Evaluates the design of OrderProcessor ✔️
Identifies object-oriented design issues ✔️
Explains why those issues hurt maintainability/extensibility ✔️
Uses class design principles discussed in class ✔️
(Single Responsibility Principle, encapsulation, coupling, cohesion, separation of concerns)
Does not require exact Arthur Riel terminology ✔️
Your write-up is also strong because it gives specific examples from the class, like:
public fields
hardcoded if(price > 500) discount logic
direct use of FileWriter
printing and logging inside the same class
That makes it much better than a vague design critique.
The only thing to make sure of is the submission format requirement:
the file must be named evaluation.md
it must be placed in
org/howard/edu/lsp/midterm/design/doc
So the content is good. You just need to save it in the correct file and directory.
A slightly cleaner opening line, if you want it to sound a bit more polished, would be:
Design Evaluation of `OrderProcessor`
The `OrderProcessor` class has several object-oriented design issues that reduce its maintainability, extensibility, and overall clarity.
But your current version is already submission-ready.

User: Does my design.md meet the requirement of question 2 part 2
ChatGPT: Yes — your design.md does meet the requirements overall. It clearly redesigns the system using CRC cards, identifies the major components, and distributes responsibilities in a much more object-oriented way.
A few specific points:
Redesigns the system? ✔️
You split the original OrderProcessor responsibilities into separate classes like Order, PricingService, OrderRepository, NotificationService, and ActivityLogger.
Uses CRC cards? ✔️
Each section has:
Class
Responsibilities
Collaborators
Shows responsibility distribution? ✔️
You separate business logic, storage, printing, notifications, and logging into different classes.
The only thing I’d adjust is formatting so it matches the required template a little more literally. The prompt says:
Class:
Responsibilities:
Collaborators:
Your version uses markdown headers like ## Class: Order, which is probably fine, but a stricter grader might prefer each card written exactly in that format.
Here is a safer submission-ready version: (same thing without the markdown headers)
So: content-wise, yes. For maximum safety, I’d just change the formatting to match the professor’s required CRC format exactly and remove the extra spacing after Order in the last card.