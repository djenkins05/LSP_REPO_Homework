package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for VIP customers.
 */
public class VIPStrategy implements PricingStrategy {

    /**
     * Applies a 20% discount to the original price.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}
