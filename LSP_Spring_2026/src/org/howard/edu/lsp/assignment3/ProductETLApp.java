package org.howard.edu.lsp.assignment3;

import java.io.File;

/**
 * Entry point for Assignment 3 ETL pipeline.
 * Preserves Assignment 2 behavior, paths, transformations, and error handling.
 */
public class ProductETLApp {

  /**
   * Runs the ETL pipeline using the required relative paths.
   *
   * @param args command-line args (unused)
   */
  public static void main(String[] args) {
    String inputPath = "data/products.csv";
    String outputPath = "data/transformed_products.csv";

    File inputFile = new File(inputPath);

    // Handle missing input file (same behavior as A2)
    if (!inputFile.exists()) {
      System.out.println("Error: Input file not found at " + inputPath);
      return;
    }

    ETLPipeline pipeline = new ETLPipeline(
        new CSVProductReader(inputFile),
        new ProductTransformer(),
        new CSVProductWriter(outputPath)
    );

    pipeline.run();
  }
}
