package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract class using Template Method pattern for report generation.
 */
public abstract class Report {

    protected abstract void loadData();
    protected abstract String formatHeader();
    protected abstract String formatBody();
    protected abstract String formatFooter();

    /**
     * Template Method defining the report workflow.
     */
    public final void generateReport() {
        loadData();

        System.out.println("=== HEADER ===");
        System.out.println(formatHeader());
        System.out.println();

        System.out.println("=== BODY ===");
        System.out.println(formatBody());
        System.out.println();

        System.out.println("=== FOOTER ===");
        System.out.println(formatFooter());
        System.out.println();
    }
}