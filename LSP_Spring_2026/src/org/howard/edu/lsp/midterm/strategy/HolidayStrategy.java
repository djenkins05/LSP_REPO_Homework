package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for holiday pricing.
 */
public class HolidayStrategy implements PricingStrategy {

    /**
     * Applies a 15% discount to the original price.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}
