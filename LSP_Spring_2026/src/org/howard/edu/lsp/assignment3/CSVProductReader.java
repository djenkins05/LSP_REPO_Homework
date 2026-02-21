package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads product records from a CSV file using Assignment 2 compatible parsing and skip rules.
 */
public class CSVProductReader {

  private final File inputFile;
  private BufferedReader reader;

  private int rowsRead = 0;     // counts only data lines attempted (same as A2 loop)
  private int rowsSkipped = 0;

  /**
   * Constructs a reader for the given CSV file.
   *
   * @param inputFile input CSV file
   */
  public CSVProductReader(File inputFile) {
    this.inputFile = inputFile;
  }

  /**
   * Opens the file and reads the first line (header).
   * If the file is empty (header == null), returns false.
   *
   * @return true if a header line exists, false if file is empty
   * @throws IOException if file cannot be opened/read
   */
  public boolean openAndReadHeader() throws IOException {
    reader = new BufferedReader(new FileReader(inputFile));
    String header = reader.readLine();
    return header != null;
  }

  /**
   * Reads and parses product rows from the file after the header.
   * Preserves Assignment 2 rules:
   * - increments rowsRead for each line read
   * - skips blank lines
   * - skips if not exactly 4 fields
   * - trims all fields
   * - skips if ProductID not int or Price not BigDecimal
   *
   * @return list of valid Product objects
   * @throws IOException if reading fails
   */
  public List<Product> readProducts() throws IOException {
    List<Product> products = new ArrayList<>();
    String line;

    while ((line = reader.readLine()) != null) {
      rowsRead++;

      if (line.trim().isEmpty()) {
        rowsSkipped++;
        continue;
      }

      String[] parts = line.split(",");

      if (parts.length != 4) {
        rowsSkipped++;
        continue;
      }

      for (int i = 0; i < parts.length; i++) {
        parts[i] = parts[i].trim();
      }

      int productId;
      BigDecimal price;

      try {
        productId = Integer.parseInt(parts[0]);
        price = new BigDecimal(parts[2]);
      } catch (Exception e) {
        rowsSkipped++;
        continue;
      }

      String name = parts[1];
      String category = parts[3];

      products.add(new Product(productId, name, price, category));
    }

    return products;
  }

  /** @return number of data lines read */
  public int getRowsRead() {
    return rowsRead;
  }

  /** @return number of data lines skipped */
  public int getRowsSkipped() {
    return rowsSkipped;
  }

  /**
   * Closes the underlying reader if open.
   *
   * @throws IOException if close fails
   */
  public void close() throws IOException {
    if (reader != null) {
      reader.close();
    }
  }
}
