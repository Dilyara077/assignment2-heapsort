package algorithms;
// Unit tests for HeapSort

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        HeapSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        HeapSort.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testDuplicates() {
        int[] arr = {5, 3, 5, 2, 2};
        HeapSort.sort(arr);
        assertArrayEquals(new int[]{2, 2, 3, 5, 5}, arr);
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        HeapSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        HeapSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
}
