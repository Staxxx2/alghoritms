
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Unsorted array:");
        printArray(arr);

        sort(arr);
        System.out.println("\nSorted array:");
        printArray(arr);
    }

    public static void sort(int arr[]) {
        int n = arr.length;

        // Build the max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
           heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move the current root to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Rebuild the max heap with the reduced array
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child is greater than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is greater than the largest value found so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest value is not the root, swap the values and recursively heapify the subtree
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}