package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for regular customers.
 */
public class RegularStrategy implements PricingStrategy {

    /**
     * Returns the original price with no discount.
     *
     * @param price the original purchase price
     * @return the unchanged price
     */
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}
