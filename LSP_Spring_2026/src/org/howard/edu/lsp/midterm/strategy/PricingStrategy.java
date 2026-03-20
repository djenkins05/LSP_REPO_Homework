package org.howard.edu.lsp.midterm.strategy;

/**
 * Defines the pricing strategy interface for calculating final prices.
 */
public interface PricingStrategy {
    
    /**
     * Calculates the final price based on the given original price.
     *
     * @param price the original purchase price
     * @return the final price after applying the pricing rule
     */
    double calculatePrice(double price);
}
