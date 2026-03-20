# Development Log – Task Management System

## External Resources Used

### 1. ChatGPT (OpenAI)
URL: https://chat.openai.com/

**How it was used:**
ChatGPT was used to help design and implement the Task and TaskManager classes, generate CRC cards, explain how to set up packages in Eclipse, and ensure that the output matched the assignment requirements.

---

## ChatGPT Transcript

User: Check my Code for if it meets the question one requirements
ChatGPT: Yes — your code meets the functional requirements.
What you got right:
Task has the required fields: taskId, description, status
The constructor sets default status to "OPEN"
getTaskId(), getDescription(), getStatus(), setStatus(), and toString() are all implemented correctly
setStatus() is case-sensitive and sets invalid values to "UNKNOWN"
toString() matches the required format: taskId description [status]
TaskManager uses an appropriate data structure: Map<String, Task>
addTask() prevents duplicate task IDs and throws IllegalArgumentException
findTask() returns the task or null if not found
getTasksByStatus() returns a List<Task>
All classes are in the correct package
Each class is in its own class definition and your code matches the provided Driver
Your output should match the expected output

User: How to create the package on eclipse  
ChatGPT: Explained that they should be placed in a separate package named org.howard.edu.lsp.midterm.crccards and org.howard.edu.lsp.midterm.crccards.doc on how to create the files and classes for the respective code

User: Does this crccards.md: TaskManager collaborates with Task because its responsibilities include storing, retrieving, and filtering Task objects, which requires direct interaction with Task instances. 
In contrast, Task does not collaborate with TaskManager because its responsibilities are limited to managing its own data (task ID, description, and status) and providing access to that data.
This separation ensures that Task remains a simple data model, while TaskManager handles all system-level operations. meet these requirements: In 2-3 sentences, explain why TaskManager collaborates with Task, but Task does not collaborate with TaskManager. Your explanation should reference the responsibilities listed in the CRC cards. 
ChatGPT: Yes — this meets the requirements well ✅
Here’s why it works:
2–3 sentences? ✔️ You have exactly 3 sentences.
Explains collaboration direction? ✔️ You clearly state why TaskManager → Task but not the reverse.
References responsibilities? ✔️ You mention:
TaskManager: storing, retrieving, filtering Task objects
Task: managing its own data (ID, description, status)
Conceptually correct? ✔️ You correctly highlight separation of concerns (manager vs data model).
Minor optional improvement (if you want it more “professor-polished”)
You could tighten wording slightly:
TaskManager collaborates with Task because its responsibilities include storing, retrieving, and filtering Task objects, which requires direct interaction with Task instances. Task, however, does not collaborate with TaskManager because its responsibilities are limited to managing its own data (task ID, description, and status). This separation ensures Task remains a simple data model, while TaskManager handles system-level operations.
But honestly — your original version is already submission-ready

User: does my development_log fit these requirements  
ChatGPT: Reviewed the requirements and explained that a full transcript was required, then suggested how to modify the file to meet grading criteria.
