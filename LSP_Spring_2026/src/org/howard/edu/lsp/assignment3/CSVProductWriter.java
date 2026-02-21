package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes transformed products to the required output CSV using Assignment 2 compatible format.
 */
public class CSVProductWriter {

  private final String outputPath;
  private BufferedWriter writer;

  /**
   * Constructs a writer for the given output path.
   *
   * @param outputPath output CSV path
   */
  public CSVProductWriter(String outputPath) {
    this.outputPath = outputPath;
  }

  /**
   * Opens the output file for writing.
   *
   * @throws IOException if the file cannot be opened
   */
  public void open() throws IOException {
    writer = new BufferedWriter(new FileWriter(outputPath));
  }

  /**
   * Writes the fixed header required by Assignment 2.
   *
   * @throws IOException if writing fails
   */
  public void writeHeader() throws IOException {
    writer.write("ProductID,Name,Price,Category,PriceRange");
    writer.newLine();
  }

  /**
   * Writes transformed product rows in the same format as Assignment 2.
   *
   * @param products transformed products
   * @throws IOException if writing fails
   */
  public void writeProducts(List<Product> products) throws IOException {
    ProductTransformer helper = new ProductTransformer();

    for (Product p : products) {
      String priceRange = helper.determinePriceRange(p.getPrice());

      writer.write(
          p.getProductId() + "," +
          p.getName() + "," +
          p.getPrice().toPlainString() + "," +
          p.getCategory() + "," +
          priceRange
      );
      writer.newLine();
    }
  }

  /** @return output path */
  public String getOutputPath() {
    return outputPath;
  }

  /**
   * Closes the writer if open.
   *
   * @throws IOException if closing fails
   */
  public void close() throws IOException {
    if (writer != null) {
      writer.close();
    }
  }
}
