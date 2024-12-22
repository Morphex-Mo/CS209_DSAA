import java.util.*;

public class FromNowOnMinDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements
        int n = scanner.nextInt();
        int[] a = new int[n];

        // Read the array elements
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Results array to store minimum differences
        long[] results = new long[n - 1];

        // Sort the array using a custom merge sort
        mergeSort(a, 0, n - 1);

        // Calculate minimum differences
        for (int i = 0; i < n - 1; i++) {
            long minDiff = Long.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                long diff = Math.abs(a[j] - a[i]);
                minDiff = Math.min(minDiff, diff);
            }
            results[i] = minDiff;
        }

        // Output results
        for (long result : results) {
            System.out.print(result + " ");
        }
        System.out.println();

        scanner.close();
    }

    // Merge Sort implementation
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        while (i < n1) {
            array[k++] = L[i++];
        }
        while (j < n2) {
            array[k++] = R[j++];
        }
    }
}