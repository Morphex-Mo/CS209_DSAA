package lab9;

import java.util.ArrayList;
import java.util.Scanner;

class Queue {
    private ArrayList<Integer> elements = new ArrayList<>();
    private int front = 0;

    public void enqueue(int value) {
        elements.add(value);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return elements.get(front++);
    }

    public boolean isEmpty() {
        return front >= elements.size();
    }

    public int size() {
        return elements.size() - front;
    }
}

public class ass54 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        while (T-- > 0) {
            int n = scanner.nextInt(); // Number of nodes
            int m = scanner.nextInt(); // Number of edges

            long[] a = new long[n + 1];
            long[] b = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextLong();
                b[i] = scanner.nextLong();
            }

            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            int[] inDegree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph[u].add(v);
                inDegree[v]++;
            }

            // Topological Sort using custom Queue
            Queue queue = new Queue();
            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue.enqueue(i);
                }
            }

            ArrayList<Integer> topoOrder = new ArrayList<>();
            while (!queue.isEmpty()) {
                int u = queue.dequeue();
                topoOrder.add(u);
                for (int v : graph[u]) {
                    inDegree[v]--;
                    if (inDegree[v] == 0) {
                        queue.enqueue(v);
                    }
                }
            }

            // Count paths
            long[][] pathCounts = new long[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                pathCounts[i][i] = 0; // count(i, i) = 0
            }

            for (int u : topoOrder) {
                for (int v : graph[u]) {
                    for (int j = 1; j <= n; j++) {
                        if (j != u) {
                            pathCounts[u][v] = (pathCounts[u][v] + pathCounts[u][j]) % MOD;
                        }
                    }
                }
            }

            // Calculate the result
            long result = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    result = (result + pathCounts[i][j] * a[i] % MOD * b[j] % MOD) % MOD;
                }
            }

            System.out.println(result);
        }

        scanner.close();
    }
}