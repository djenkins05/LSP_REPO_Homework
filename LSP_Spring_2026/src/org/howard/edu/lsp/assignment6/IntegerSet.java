package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet {
    private ArrayList<Integer> set;

    public IntegerSet() {
        set = new ArrayList<>();
    }

    public void clear() {
        set.clear();
    }

    public int length() {
        return set.size();
    }

    public boolean equals(IntegerSet b) {
        ArrayList<Integer> thisCopy = new ArrayList<>(this.set);
        ArrayList<Integer> otherCopy = new ArrayList<>(b.set);

        Collections.sort(thisCopy);
        Collections.sort(otherCopy);

        return thisCopy.equals(otherCopy);
    }

    public boolean contains(int value) {
        return set.contains(value);
    }

    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int num : this.set) {
            result.add(num);
        }

        for (int num : intSetb.set) {
            result.add(num);
        }

        return result;
    }

    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int num : this.set) {
            if (intSetb.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int num : this.set) {
            if (!intSetb.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int num : intSetb.set) {
            if (!this.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public String toString() {
        ArrayList<Integer> sortedSet = new ArrayList<>(set);
        Collections.sort(sortedSet);
        return sortedSet.toString();
    }
}
