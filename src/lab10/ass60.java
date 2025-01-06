package lab10;

import java.util.ArrayList;
import java.util.Scanner;

public class ass60 {

    static class Edge {
        int to;
        long weight;  // 使用 long 处理可能的大距离

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State {
        int city;
        int portalsUsed;
        long distance;  // 使用 long 处理可能的大距离

        State(int city, int portalsUsed, long distance) {
            this.city = city;
            this.portalsUsed = portalsUsed;
            this.distance = distance;
        }
    }

    static class Graph {
        int n;
        ArrayList<ArrayList<Edge>> roads;
        ArrayList<ArrayList<Edge>> portals;

        Graph(int n) {
            this.n = n;
            roads = new ArrayList<>(n + 1);
            portals = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                roads.add(new ArrayList<>());
                portals.add(new ArrayList<>());
            }
        }

        void addRoad(int u, int v, long w) {
            roads.get(u).add(new Edge(v, w));
        }

        void addPortal(int u, int v) {
            portals.get(u).add(new Edge(v, 0)); // portal weight is 0
        }
    }

    static class MinHeap {
        State[] heap;
        int size;

        MinHeap(int capacity) {
            heap = new State[capacity];
            size = 0;
        }

        void insert(State state) {
            heap[size] = state;
            size++;
            bubbleUp(size - 1);
        }

        State extractMin() {
            if (size == 0) return null;
            State min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            bubbleDown(0);
            return min;
        }

        boolean isEmpty() {
            return size == 0;
        }

        void bubbleUp(int index) {
            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                if (heap[index].distance >= heap[parentIndex].distance) break;
                swap(index, parentIndex);
                index = parentIndex;
            }
        }

        void bubbleDown(int index) {
            while (true) {
                int leftChild = 2 * index + 1;
                int rightChild = 2 * index + 2;
                int smallest = index;

                if (leftChild < size && heap[leftChild].distance < heap[smallest].distance) {
                    smallest = leftChild;
                }
                if (rightChild < size && heap[rightChild].distance < heap[smallest].distance) {
                    smallest = rightChild;
                }
                if (smallest == index) break;
                swap(index, smallest);
                index = smallest;
            }
        }

        void swap(int i, int j) {
            State temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int k = scanner.nextInt();

        Graph graph = new Graph(n);

        // Adding roads
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            long w = scanner.nextLong();  // 使用 long 读取权重
            graph.addRoad(u, v, w);
        }

        // Adding portals
        for (int i = 0; i < p; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addPortal(u, v);
        }

        int S = scanner.nextInt();
        int T = scanner.nextInt();

        System.out.println(findMinimumDistance(graph, n, k, S, T));
    }

    static long findMinimumDistance(Graph graph, int n, int k, int S, int T) {
        long[][] minDistance = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                minDistance[i][j] = Long.MAX_VALUE;  // 使用 Long.MAX_VALUE 初始化
            }
        }

        MinHeap heap = new MinHeap(n * (k + 1));
        heap.insert(new State(S, 0, 0)); // Start at city S with 0 portals used and distance 0
        minDistance[S][0] = 0;

        while (!heap.isEmpty()) {
            State current = heap.extractMin();
            int city = current.city;
            int portalsUsed = current.portalsUsed;
            long distance = current.distance;

            // If we reach the target city, return the distance
            if (city == T) {
                return distance;
            }

            // If the current distance is greater than the recorded minimum, skip it
            if (distance > minDistance[city][portalsUsed]) {
                continue;
            }

            // Traverse regular roads
            for (Edge edge : graph.roads.get(city)) {
                int nextCity = edge.to;
                long newDistance = distance + edge.weight;
                if (newDistance < minDistance[nextCity][portalsUsed]) {
                    minDistance[nextCity][portalsUsed] = newDistance;
                    heap.insert(new State(nextCity, portalsUsed, newDistance));
                }
            }

            // Traverse portals if we haven't used all allowed portals
            if (portalsUsed < k) {
                for (Edge edge : graph.portals.get(city)) {
                    int nextCity = edge.to;
                    if (distance < minDistance[nextCity][portalsUsed + 1]) {
                        minDistance[nextCity][portalsUsed + 1] = distance;
                        heap.insert(new State(nextCity, portalsUsed + 1, distance));
                    }
                }
            }
        }

        return -1; // This line should never be reached since T is guaranteed to be reachable.
    }
}