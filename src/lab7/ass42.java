package lab7;

import java.util.ArrayList;
import java.util.Scanner;

public class ass42 {
    static int[] p; // Predefined values for each node
    static long[] e; // Values to be assigned to each node
    static boolean[] visited; // Track visited nodes
    static ArrayList<Integer>[] tree; // Adjacency list for the tree

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of nodes
        p = new int[n + 1]; // Predefined values
        e = new long[n + 1]; // Values to assign
        visited = new boolean[n + 1]; // Track visited nodes
        tree = new ArrayList[n + 1];

        // Initialize the adjacency list
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // Read values p and edges simultaneously to find the root
        int root = 1; // Start with the first node as the root
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt(); // Read predefined values
            if (p[i] > p[root]) {
                root = i; // Update the root if current node has a larger p value
            }
        }

        // Read edges
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u); // Since it's an undirected tree
        }

        // Start DFS from the node with the maximum p value
        dfs(root);

        // Calculate total sum of e values
        long total = 0;
        for (int i = 1; i <= n; i++) {
            total += e[i];
        }

        // Output the result
        System.out.println(total);
    }

    public static void dfs(int node) {
        visited[node] = true;
        ArrayList<Long> childValues = new ArrayList<>();

        // Process each child node
        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child);
                childValues.add(e[child]);
            }
        }

        // Determine the value for the current node
        if (childValues.isEmpty()) {
            e[node] = p[node]; // Leaf node, assign its value
        } else {
            // Sort child values in descending order
            childValues.sort((a, b) -> Long.compare(b, a));
            if (childValues.size() == 1) {
                e[node] = Math.max(p[node], childValues.get(0));
            } else {
                e[node] = Math.max(p[node], childValues.get(0) + childValues.get(1));
            }
        }
    }
}