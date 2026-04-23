package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {

    @Test
    public void testAverage() {
        GradeCalculator calc = new GradeCalculator();
        assertEquals(80.0, calc.average(90, 80, 70));
    }

    @Test
    public void testLetterGrade() {
        GradeCalculator calc = new GradeCalculator();
        assertEquals("B", calc.letterGrade(85.0));
    }

    @Test
    public void testIsPassing() {
        GradeCalculator calc = new GradeCalculator();
        assertTrue(calc.isPassing(70.0));
    }

    @Test
    public void testBoundaryLetterGradeAt90() {
        GradeCalculator calc = new GradeCalculator();
        assertEquals("A", calc.letterGrade(90.0));
    }

    @Test
    public void testBoundaryIsPassingAt60() {
        GradeCalculator calc = new GradeCalculator();
        assertTrue(calc.isPassing(60.0));
    }

    @Test
    public void testExceptionNegativeScore() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calc.average(-5, 80, 90);
        });
    }

    @Test
    public void testExceptionScoreAbove100() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calc.average(105, 80, 90);
        });
    }
}