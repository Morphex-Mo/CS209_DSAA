package lab7;

import java.util.ArrayList;
import java.util.Scanner;

public class ass41 {
    private static nodeAss41[] nodes; // Use nodeAss41 array to store nodes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of cities
        int n = scanner.nextInt();
        nodes = new nodeAss41[n + 1]; // Create node array
        for (int i = 1; i <= n; i++) {
            nodes[i] = new nodeAss41(); // Initialize each node
        }

        // Input roads
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            nodes[u].children.add(nodes[v]); // Add edge
            nodes[v].children.add(nodes[u]); // Undirected graph
        }

        // Input number of giants
        int m = scanner.nextInt();
        int[] giants = new int[m];
        for (int i = 0; i < m; i++) {
            giants[i] = scanner.nextInt();
        }

        // Perform BFS to calculate the maximum days needed for all giants to reach city 1
        boolean[] visited = new boolean[n + 1];
        int maxDays = 0;

        for (int giantCity : giants) {
            maxDays = Math.max(maxDays, bfs(giantCity, visited));
        }

        // Print the minimum number of days needed for all giants to gather in city 1
        System.out.println(maxDays);
    }

    private static int bfs(int start, boolean[] visited) {
        ArrayList<nodeAss41> currentLevel = new ArrayList<>();
        ArrayList<nodeAss41> nextLevel = new ArrayList<>();
        currentLevel.add(nodes[start]);
        visited[start] = true;

        int days = 0;

        while (!currentLevel.isEmpty()) {
            // Process current level
            for (nodeAss41 node : currentLevel) {
                // Traverse neighbors
                for (nodeAss41 neighbor : node.children) {
                    if (!visited[neighbor.getId()]) {
                        visited[neighbor.getId()] = true;
                        nextLevel.add(neighbor);
                    }
                }
            }
            // Move to the next level
            currentLevel = nextLevel;
            nextLevel = new ArrayList<>(); // Prepare for the next level
            if (!currentLevel.isEmpty()) {
                days++; // Only increment days if there are nodes in the next level
            }
        }

        return days; // Return the number of days taken
    }
}

class nodeAss41 {
    ArrayList<nodeAss41> children = new ArrayList<>();
    private static int idCounter = 0;
    private int id;

    public nodeAss41() {
        this.id = ++idCounter; // Assign unique ID to each node
    }

    public int getId() {
        return id;
    }
}