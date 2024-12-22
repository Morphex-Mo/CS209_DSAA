package lab8;

import java.util.*;

public class ass44 {
    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        while (T-- > 0) {
            int n = scanner.nextInt(); // Number of nodes
            Node[] heap = new Node[n + 1]; // Max Heap (1-indexed)

            for (int i = 1; i <= n; i++) {
                int value = scanner.nextInt();
                heap[i] = new Node(value, i);
                insert(heap, i); // Insert into the max heap
            }

            int queryIndex = scanner.nextInt(); // Query for index p
            int level = getLevel(queryIndex);
            int indexInLevel = getIndexInLevel(queryIndex);

            System.out.println(level + " " + indexInLevel);
        }
        scanner.close();
    }

    // Insert the node into the max heap and maintain the heap property
    private static void insert(Node[] heap, int i) {
        int currentIndex = i;
        while (currentIndex > 1) {
            int parentIndex = currentIndex / 2;
            if (heap[currentIndex].value > heap[parentIndex].value) {
                swap(heap, currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    // Helper method to swap two nodes in the heap
    private static void swap(Node[] heap, int i, int j) {
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Get the level of the node based on its position
    private static int getLevel(int index) {
        int level = 0;
        while (index > 0) {
            index /= 2;
            level++;
        }
        return level;
    }

    // Get the index of the node at its level
    private static int getIndexInLevel(int index) {
        int level = getLevel(index);
        int firstIndexAtLevel = (1 << (level - 1)); // 2^(level-1)
        return index - firstIndexAtLevel + 1; // 1-indexed
    }
}