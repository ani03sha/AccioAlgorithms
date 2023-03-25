package org.redquark.accioalgorithms.datastructures.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DynamicArrayTest {

    private DynamicArray dynamicArray;

    @BeforeEach
    void setUp() {
        dynamicArray = new DynamicArray(3);
    }

    @Test
    void testSize() {
        assertEquals(0, dynamicArray.size());
        dynamicArray.append(1);
        assertEquals(1, dynamicArray.size());
        dynamicArray.append(2);
        assertEquals(2, dynamicArray.size());
    }

    @Test
    void testGet() {
        dynamicArray.append(1);
        dynamicArray.append(2);
        dynamicArray.append(3);
        assertEquals(1, dynamicArray.get(0));
        assertEquals(2, dynamicArray.get(1));
        assertEquals(3, dynamicArray.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.get(3));
    }

    @Test
    void testSet() {
        dynamicArray.append(1);
        dynamicArray.append(2);
        dynamicArray.append(3);
        dynamicArray.set(1, 4);
        assertEquals(4, dynamicArray.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.set(-1, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.set(3, 5));
    }

    @Test
    void testInsert() {
        dynamicArray.append(1);
        dynamicArray.append(3);
        dynamicArray.insert(1, 2);
        assertEquals(3, dynamicArray.size());
        assertEquals(1, dynamicArray.get(0));
        assertEquals(2, dynamicArray.get(1));
        assertEquals(3, dynamicArray.get(2));
        dynamicArray.insert(0, 0);
        assertEquals(4, dynamicArray.size());
        assertEquals(0, dynamicArray.get(0));
        assertEquals(1, dynamicArray.get(1));
        assertEquals(2, dynamicArray.get(2));
        assertEquals(3, dynamicArray.get(3));
        dynamicArray.insert(4, 4);
        assertEquals(5, dynamicArray.size());
        assertEquals(0, dynamicArray.get(0));
        assertEquals(1, dynamicArray.get(1));
        assertEquals(2, dynamicArray.get(2));
        assertEquals(3, dynamicArray.get(3));
        assertEquals(4, dynamicArray.get(4));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.insert(-1, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.insert(6, 5));
    }

    @Test
    void testAppend() {
        dynamicArray.append(1);
        dynamicArray.append(2);
        dynamicArray.append(3);
        dynamicArray.append(4);
        assertEquals(4, dynamicArray.size());
        assertEquals(1, dynamicArray.get(0));
        assertEquals(2, dynamicArray.get(1));
        assertEquals(3, dynamicArray.get(2));
        assertEquals(4, dynamicArray.get(3));
    }

    @Test
    void testRemove() {
        dynamicArray.append(1);
        dynamicArray.append(2);
        dynamicArray.append(3);
        assertEquals(2, dynamicArray.remove(1));
        assertEquals(2, dynamicArray.size());
        assertEquals(1, dynamicArray.get(0));
        assertEquals(3, dynamicArray.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.remove(2));
    }
}
