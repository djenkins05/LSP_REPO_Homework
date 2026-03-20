package org.howard.edu.lsp.midterm.strategy;

/**
 * Demonstrates the Strategy Pattern implementation for price calculation.
 */
public class Driver {

    /**
     * Runs the driver program for the pricing strategies.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        double price = 100.0;

        PriceCalculator calculator = new PriceCalculator(new RegularStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        calculator.setPricingStrategy(new MemberStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        calculator.setPricingStrategy(new VIPStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        calculator.setPricingStrategy(new HolidayStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}
