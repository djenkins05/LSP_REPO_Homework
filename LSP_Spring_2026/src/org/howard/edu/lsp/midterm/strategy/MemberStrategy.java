package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for member customers.
 */
public class MemberStrategy implements PricingStrategy {

    /**
     * Applies a 10% discount to the original price.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}
