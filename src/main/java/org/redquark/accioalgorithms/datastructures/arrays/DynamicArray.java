package org.redquark.accioalgorithms.datastructures.arrays;

/**
 * This class illustrates the common operations related to the Dynamic Array data structure.
 * Dynamic Arrays can adjust their size if more elements than the predefined capacity are
 * added to the data structure.
 * <p>
 * We are, however, using the in-built array data structure (implemented at low level)
 * by the JVM.
 * <p>
 * Even then this is a good resource to understand what happens under the hood when
 * we interact with the arrays.
 * <p>
 * Blog post - <a href="https://rdquark.org/dsa/arrays">Arrays</a>
 */
public class DynamicArray {

    // Internal JVM provided array to store elements in the array
    private int[] elements;
    // Size of the array - it represents the current number of elements in the array
    private int size;

    public DynamicArray(int capacity) {
        // Initialize the array with the specified capacity
        this.elements = new int[capacity];
        this.size = 0;
    }

    /**
     * Time complexity: O(1)
     *
     * @return size of the array
     */
    public int size() {
        return size;
    }

    /**
     * Time complexity: O(1)
     *
     * @param index at which we need to find the element
     * @return element at the given index
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    /**
     * Time complexity: O(1)
     *
     * @param index at which the element is to be added
     * @param value element to be added
     */
    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = value;
    }

    /**
     * Time complexity: O(n)
     *
     * @param index at which the element is to be inserted
     * @param value value to be inserted
     */
    public void insert(int index, int value) {
        // If we have reached the capacity. we will double the size
        // of the dynamic array
        if (size == elements.length) {
            int[] newArray = new int[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = value;
        size++;
    }

    /**
     * Time complexity: O(1)
     *
     * @param value to be added at the end
     */
    public void append(int value) {
        insert(size, value);
    }

    /**
     * Time complexity: O(n)
     *
     * @param index at which the element to be removed
     * @return removed element
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int removedValue = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return removedValue;
    }
}

