package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a product record from the CSV input and the transformed output fields.
 */
public class Product {
  private final int productId;
  private final String name;
  private final BigDecimal price;
  private final String category;

  /**
   * Creates a product.
   *
   * @param productId product ID (int)
   * @param name product name (string)
   * @param price product price (BigDecimal)
   * @param category product category (string)
   */
  public Product(int productId, String name, BigDecimal price, String category) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.category = category;
  }

  /** @return product ID */
  public int getProductId() {
    return productId;
  }

  /** @return product name */
  public String getName() {
    return name;
  }

  /** @return product price */
  public BigDecimal getPrice() {
    return price;
  }

  /** @return product category */
  public String getCategory() {
    return category;
  }
}
