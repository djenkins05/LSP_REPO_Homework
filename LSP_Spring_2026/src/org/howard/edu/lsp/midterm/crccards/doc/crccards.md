TaskManager collaborates with Task because its responsibilities include storing, retrieving, and filtering Task objects, which requires direct interaction with Task instances. 
In contrast, Task does not collaborate with TaskManager because its responsibilities are limited to managing its own data (task ID, description, and status) and providing access to that data.
This separation ensures that Task remains a simple data model, while TaskManager handles all system-level operations.

