What is different about the design?:
In Assignment 2, the entire ETL pipeline was implemented in a single class with one large `main` method that performed extraction, transformation, loading, and summary printing. The design was primarily procedural: file reading, validation, transformation logic, and file writing were all mixed together in one place.

In Assignment 3, I redesigned the solution using object-oriented decomposition. I separated responsibilities into multiple classes: `CSVProductReader` (extract), `ProductTransformer` (transform), `CSVProductWriter` (load), `Product` (data model), and `ETLPipeline`/`ProductETLApp` (orchestration). This makes the code easier to understand, maintain, and test because each class has a single purpose.

How is Assignment 3 more object-oriented?:
Assignment 3 is more object-oriented because it models the problem domain using objects and encapsulates related behavior:
- A `Product` object represents each row of input data.
- File input logic is encapsulated in `CSVProductReader`.
- Transformation rules are encapsulated in `ProductTransformer`.
- Output formatting and writing is encapsulated in `CSVProductWriter`.
- The pipeline flow is coordinated by `ETLPipeline`, and the program entry point is `ProductETLApp`.

The separation reduces duplication and makes it clearer where each responsibility belongs.

Which OO ideas did you use?:
- **Object/Class:** I created multiple classes that represent the components of the ETL pipeline (`Product`, reader, transformer, writer, pipeline).
- **Encapsulation:** Each class hides its internal details (ex: parsing and skip logic stays inside `CSVProductReader` ; rounding and discount rules stay inside `ProductTransformer`; output formatting stays inside `CSVProductWriter`).
- **Inheritance:** I did not use inheritance because the problem did not require a class hierarchy. Adding inheritance would not improve clarity for this assignment.
- **Polymorphism:** I did not implement polymorphism in this version. The solution could be extended by defining a `TransformationRule` interface with multiple rule implementations, but for this assignment I prioritized keeping the structure simple while still object-oriented.

How I tested Assignment 3 matches Assignment 2:
To confirm Assignment 3 produces the same results as Assignment 2, I:
1. Ran Assignment 2 and saved the produced `data/transformed_products.csv`.
2. Ran Assignment 3 but saved the produced `data/transformed_products2.csv` this time.
3. Compared the outputs to ensure:
   - The header matches exactly.
   - The number of rows written matches.
   - The transformed values match (uppercase names, electronics discount, rounding, premium category rule, price ranges).
   - Skipped rows matched the same conditions (blank lines, wrong number of fields, parse failures).
4. Verified the console summary output uses the same format and values (rows read, transformed, skipped, output path).

This ensured Assignment 3 met the exact same functional requirements as Assignment 2 while improving the internal design.

