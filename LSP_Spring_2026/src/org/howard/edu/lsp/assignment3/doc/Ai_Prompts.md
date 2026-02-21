Prompt 1:
I shared my Assignment 2 ETL Java code and asked the AI to redesign it to be more object-oriented while keeping the exact same input/output behavior, transformations, and error handling.

AI Suggestions Summary:
The AI suggested splitting responsibilities into multiple classes:
- A main/orchestrator class
- A reader class for extracting CSV rows
- A transformer class for applying business rules
- A writer class for loading output CSV
- A Product domain object to represent a row

How I Used/Adapted the Suggestions:
I implemented the suggested decomposition, but kept all Assignment 2 behavior identical:
- Same relative input/output paths
- Same skip rules and counters
- Same transformation rules and rounding
- Same summary output formatting

I reviewed and edited the generated Javadocs for accuracy and made sure each public class was in its own file.

Prompt 2
After implementing the object-oriented structure, I asked the AI to verify that my redesigned classes preserved the exact behavior of Assignment 2, including:
- Same input/output paths
- Same transformation logic
- Same error handling
- Same row counting rules

AI Response Summary
The AI reviewed the logic and confirmed that the reader preserved the skip rules, the transformer preserved the discount and rounding logic, and the writer preserved the output format. It also suggested verifying correctness by comparing the Assignment 2 and Assignment 3 output files directly.

How I Used the Suggestion
I followed the recommendation and tested the program by:
1. Running Assignment 2 and saving the output file.
2. Running Assignment 3 using the same input file.
3. Comparing both output files to ensure identical content and summary output.

This confirmed the redesign changed the internal structure but not the program behavior.

