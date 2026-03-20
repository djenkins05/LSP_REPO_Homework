package org.howard.edu.lsp.midterm.strategy;

/**
 * Calculates final prices by delegating to a pricing strategy.
 */
public class PriceCalculator {
    private PricingStrategy pricingStrategy;

    /**
     * Constructs a PriceCalculator with the given pricing strategy.
     *
     * @param pricingStrategy the strategy used to calculate final price
     */
    public PriceCalculator(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    /**
     * Sets a new pricing strategy.
     *
     * @param pricingStrategy the new pricing strategy
     */
    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    /**
     * Calculates the final price using the current pricing strategy.
     *
     * @param price the original purchase price
     * @return the final price after applying the strategy
     */
    public double calculatePrice(double price) {
        return pricingStrategy.calculatePrice(price);
    }
}
