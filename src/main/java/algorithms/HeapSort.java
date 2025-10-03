package algorithms;

public class HeapSort {
    public static long comparisons = 0;
    public static long swaps = 0;

    public static void sort(int[] arr) {
        comparisons = 0;
        swaps = 0;
        int n = arr.length;

        // Построение max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлечение элементов из кучи
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            comparisons++;
            if (arr[left] > arr[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            comparisons++;
            if (arr[right] > arr[largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return; // фикс: не считаем "пустые" свапы
        swaps++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
