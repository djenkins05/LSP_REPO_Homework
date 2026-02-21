package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

/**
 * Coordinates the Extract-Transform-Load process and prints the run summary.
 */
public class ETLPipeline {

  private final CSVProductReader reader;
  private final ProductTransformer transformer;
  private final CSVProductWriter writer;

  private int rowsRead = 0;
  private int rowsTransformed = 0;
  private int rowsSkipped = 0;

  /**
   * Constructs an ETL pipeline with specific reader/transformer/writer components.
   *
   * @param reader CSV reader for products
   * @param transformer transformation logic
   * @param writer CSV writer for transformed output
   */
  public ETLPipeline(CSVProductReader reader, ProductTransformer transformer, CSVProductWriter writer) {
    this.reader = reader;
    this.transformer = transformer;
    this.writer = writer;
  }

  /**
   * Runs the pipeline end-to-end with Assignment 2 compatible behavior.
   */
  public void run() {
    try {
      // Always write header first (same behavior as A2)
      writer.open();
      writer.writeHeader();

      // Read header line to detect empty file (same behavior as A2)
      boolean hasHeader = reader.openAndReadHeader();
      if (!hasHeader) {
        System.out.println("Input file is empty. Created output with header only.");
        printSummary();
        return;
      }

      // Read data rows
      List<Product> rawProducts = reader.readProducts();
      rowsRead = reader.getRowsRead();
      rowsSkipped = reader.getRowsSkipped();

      // Transform
      List<Product> transformed = transformer.transform(rawProducts);
      rowsTransformed = transformed.size();

      // Load
      writer.writeProducts(transformed);

    } catch (IOException e) {
      System.out.println("Error processing file: " + e.getMessage());
      return;
    } finally {
      try {
        reader.close();
      } catch (Exception ignored) { }
      try {
        writer.close();
      } catch (Exception ignored) { }
    }

    printSummary();
  }

  /**
   * Prints a run summary matching Assignment 2 output format.
   */
  private void printSummary() {
    System.out.println("Run Summary:");
    System.out.println("Rows read: " + rowsRead);
    System.out.println("Rows transformed: " + rowsTransformed);
    System.out.println("Rows skipped: " + rowsSkipped);
    System.out.println("Output written to: " + writer.getOutputPath());
  }
}
