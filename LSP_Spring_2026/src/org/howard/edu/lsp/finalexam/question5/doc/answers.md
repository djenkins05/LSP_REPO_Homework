Heuristic 1:
Name:
Prefer private as opposed to public

Explanation:
This heuristic improves maintainability by hiding implementation details inside a class and preventing other classes from directly accessing internal data. In lecture, this was explained as part of encapsulation and information hiding, where programmers should not need to know the internal workings of a class. By keeping variables and methods private, changes can be made without affecting other parts of the system.

Heuristic 2:
Name:
Avoid duplication of code

Explanation:
This heuristic improves readability and maintainability by reducing repeated code that can lead to multiple bugs. In lecture, it was explained that cloning code creates two copies that may both contain errors, and fixing one does not guarantee the other is fixed. Instead, common functionality should be placed in a single method and reused.

Heuristic 3:
Name:
Choose simple and clear code over complex code

Explanation:
This heuristic improves readability by making code easier to understand for others. In lecture, it was emphasized that programs are written for people to read, not just for machines to execute. Developers should avoid overly clever or complicated solutions and instead choose clear, straightforward implementations.