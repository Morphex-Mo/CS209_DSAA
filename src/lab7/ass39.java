package lab7;

import java.util.ArrayList;
import java.util.Scanner;

public class ass39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int j = 0; j < n - 1; j++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            nodes[u].children.add(new Edge(nodes[v], w));
            nodes[v].children.add(new Edge(nodes[u], w));
        }

        boolean[] visited = new boolean[n + 1];
        int count = dfs(nodes[1], 0, target, visited);

        System.out.println(count);
    }

    private static int dfs(Node node, int currentPathSum, int target, boolean[] visited) {
        visited[node.id] = true;
        int count = 0;

        // Check the path sum at the current node
        for (Edge edge : node.children) {
            if (!visited[edge.to.id]) {
                // Calculate new path sum
                int newPathSum = currentPathSum + edge.weight;

                // Check if the child is a leaf node (only connected back to the parent)
                if (edge.to.children.size() == 1) {
                    if (newPathSum == target) {
                        count++; // Found a valid path
                    }
                } else {
                    // Continue DFS
                    count += dfs(edge.to, newPathSum, target, visited);
                }
            }
        }

        visited[node.id] = false; // Backtrack
        return count;
    }
}

class Node {
    int id;
    ArrayList<Edge> children = new ArrayList<>();

    public Node(int id) {
        this.id = id;
    }
}

class Edge {
    Node to;
    int weight;

    public Edge(Node to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}