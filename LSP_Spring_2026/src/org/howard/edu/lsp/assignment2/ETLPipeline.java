package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

	public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);

        // Handle missing input file
        if (!inputFile.exists()) {
            System.out.println("Error: Input file not found at " + inputPath);
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {
            String header = reader.readLine();

            // Always write header to output
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            // Handle empty input file (no header)
            if (header == null) {
                System.out.println("Input file is empty. Created output with header only.");
                printSummary(rowsRead, rowsTransformed, rowsSkipped, outputPath);
                return;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                rowsRead++;

                // Skip blank rows
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",");

                // Skip if not exactly 4 fields
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                // Trim all fields
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

                String name = parts[1].toUpperCase();
                String category = parts[3];
                String originalCategory = category;

                // Step 2.2: Apply discount if Electronics
                if (originalCategory.equals("Electronics")) {
                    price = price.multiply(new BigDecimal("0.90"));
                }

                // Round price (half-up to 2 decimals)
                price = price.setScale(2, RoundingMode.HALF_UP);

                // Step 2.3: Change to Premium Electronics if needed
                if (price.compareTo(new BigDecimal("500.00")) > 0 &&
                    originalCategory.equals("Electronics")) {
                    category = "Premium Electronics";
                }

                // Step 2.4: Determine price range
                String priceRange;
                if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                    priceRange = "Low";
                } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                    priceRange = "Medium";
                } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                // Write output row
                writer.write(productId + "," +
                             name + "," +
                             price.toPlainString() + "," +
                             category + "," +
                             priceRange);
                writer.newLine();

                rowsTransformed++;
            }

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            return;
        }

        // Print summary
        printSummary(rowsRead, rowsTransformed, rowsSkipped, outputPath);
    }

    private static void printSummary(int read, int transformed, int skipped, String outputPath) {
        System.out.println("Run Summary:");
        System.out.println("Rows read: " + read);
        System.out.println("Rows transformed: " + transformed);
        System.out.println("Rows skipped: " + skipped);
        System.out.println("Output written to: " + outputPath);

	}

}
