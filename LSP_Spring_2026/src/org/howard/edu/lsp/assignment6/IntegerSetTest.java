package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    @Test
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        assertTrue(set.isEmpty());

        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testLength() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());

        set.add(1);
        set.add(2);
        assertEquals(2, set.length());
    }

    @Test
    public void testEquals() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(1);
        set2.add(2);

        IntegerSet set3 = new IntegerSet();
        set3.add(1);
        set3.add(2);
        set3.add(4);

        assertTrue(set1.equals(set2));
        assertFalse(set1.equals(set3));
    }

    @Test
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);

        assertTrue(set.contains(10));
        assertFalse(set.contains(99));
    }

    @Test
    public void testLargest() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);
        set.add(2);

        assertEquals(10, set.largest());

        IntegerSet single = new IntegerSet();
        single.add(7);
        assertEquals(7, single.largest());

        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::largest);
    }

    @Test
    public void testSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);
        set.add(2);

        assertEquals(2, set.smallest());

        IntegerSet single = new IntegerSet();
        single.add(7);
        assertEquals(7, single.smallest());

        IntegerSet empty = new IntegerSet();
        assertThrows(RuntimeException.class, empty::smallest);
    }

    @Test
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(2);

        assertEquals("[1, 2]", set.toString());
        assertEquals(2, set.length());
    }

    @Test
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);

        set.remove(2);
        assertEquals("[1, 3]", set.toString());

        set.remove(99);
        assertEquals("[1, 3]", set.toString());
    }

    @Test
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.union(set2);
        assertEquals("[1, 2, 3, 4]", result.toString());

        IntegerSet empty = new IntegerSet();
        IntegerSet result2 = set1.union(empty);
        assertEquals("[1, 2]", result2.toString());
    }

    @Test
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.intersect(set2);
        assertEquals("[2, 3]", result.toString());

        IntegerSet set3 = new IntegerSet();
        set3.add(8);
        set3.add(9);

        IntegerSet result2 = set1.intersect(set3);
        assertEquals("[]", result2.toString());
    }

    @Test
    public void testDiff() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);

        IntegerSet result = set1.diff(set2);
        assertEquals("[1, 3]", result.toString());

        IntegerSet same = new IntegerSet();
        same.add(1);
        same.add(2);
        same.add(3);

        IntegerSet result2 = set1.diff(same);
        assertEquals("[]", result2.toString());
    }

    @Test
    public void testComplement() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.complement(set2);
        assertEquals("[3, 4]", result.toString());

        IntegerSet set3 = new IntegerSet();
        set3.add(5);
        set3.add(6);

        IntegerSet result2 = set1.complement(set3);
        assertEquals("[5, 6]", result2.toString());
    }

    @Test
    public void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());

        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    public void testToString() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());

        set.add(3);
        set.add(1);
        set.add(2);
        assertEquals("[1, 2, 3]", set.toString());
    }
}