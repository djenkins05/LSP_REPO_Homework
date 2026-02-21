package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Applies Assignment 2 transformations to product records.
 */
public class ProductTransformer {

  /**
   * Transforms a list of products using the same logic as Assignment 2:
   * - uppercase name
   * - 10% discount if category == "Electronics"
   * - round HALF_UP to 2 decimals
   * - if discounted price > 500 and original category Electronics => category becomes "Premium Electronics"
   * - compute PriceRange using thresholds: 10, 100, 500
   *
   * Note: PriceRange is computed at write time (or can be returned via helper).
   *
   * @param products input products
   * @return transformed products (new list)
   */
  public List<Product> transform(List<Product> products) {
    List<Product> out = new ArrayList<>();

    for (Product p : products) {
      String originalCategory = p.getCategory();
      String category = originalCategory;

      BigDecimal price = p.getPrice();

      // Step 2.2: Apply discount if Electronics
      if ("Electronics".equals(originalCategory)) {
        price = price.multiply(new BigDecimal("0.90"));
      }

      // Round price (half-up to 2 decimals)
      price = price.setScale(2, RoundingMode.HALF_UP);

      // Step 2.3: Change to Premium Electronics if needed
      if (price.compareTo(new BigDecimal("500.00")) > 0 && "Electronics".equals(originalCategory)) {
        category = "Premium Electronics";
      }

      String name = p.getName().toUpperCase();

      out.add(new Product(p.getProductId(), name, price, category));
    }

    return out;
  }

  /**
   * Determines price range using Assignment 2 thresholds.
   *
   * @param price transformed price
   * @return price range label
   */
  public String determinePriceRange(BigDecimal price) {
    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
      return "Low";
    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
      return "Medium";
    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
      return "High";
    } else {
      return "Premium";
    }
  }
}
