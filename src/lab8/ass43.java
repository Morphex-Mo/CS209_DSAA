package lab8;


import java.util.Scanner;

public class ass43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of nodes
        int N = sc.nextInt();
        int[] values = new int[N + 1]; // Using 1-based indexing
        for (int i = 1; i <= N; i++) {
            values[i] = sc.nextInt();
        }

        // Determine if the tree is a Max-heap, Min-heap, or neither
        String result = checkHeap(N, values);
        System.out.println(result);
    }

    private static String checkHeap(int N, int[] values) {
        boolean isMaxHeap = true;
        boolean isMinHeap = true;

        // Iterate through each node
        for (int i = 1; i <= N; i++) {
            int left = 2 * i; // Left child index
            int right = 2 * i + 1; // Right child index

            // Check left child
            if (left <= N) {
                if (values[i] < values[left]) {
                    isMaxHeap = false; // Violates Max-heap property
                }
                if (values[i] > values[left]) {
                    isMinHeap = false; // Violates Min-heap property
                }
            }

            // Check right child
            if (right <= N) {
                if (values[i] < values[right]) {
                    isMaxHeap = false; // Violates Max-heap property
                }
                if (values[i] > values[right]) {
                    isMinHeap = false; // Violates Min-heap property
                }
            }
        }

        // Determine the result based on the flags
        if (isMaxHeap && !isMinHeap) {
            return "Max";
        } else if (isMinHeap && !isMaxHeap) {
            return "Min";
        } else {
            return "Neither";
        }
    }
}