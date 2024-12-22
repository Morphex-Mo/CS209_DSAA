package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ass50 {

    private static int[] bfsShortestPath(int n, ArrayList<Integer>[] graph, int s) {
        int[] distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = -1;  // Initialize distances to -1
        }
        distance[s] = 0;  // Distance to itself is 0

        // 用于存储当前层的节点
        int[] currentLayer = new int[n];
        int currentLayerSize = 1;
        currentLayer[0] = s;

        while (currentLayerSize > 0) {
            int nextLayerSize = 0;
            int[] nextLayer = new int[n];  // 存储下一层的节点

            for (int i = 0; i < currentLayerSize; i++) {
                int node = currentLayer[i];
                for (int neighbor : graph[node]) {
                    if (distance[neighbor] == -1) {  // If not visited
                        distance[neighbor] = distance[node] + 1;
                        nextLayer[nextLayerSize++] = neighbor;  // 加入下一层
                    }
                }
            }

            currentLayer = nextLayer;  // 更新当前层为下一层
            currentLayerSize = nextLayerSize;  // 更新当前层大小
        }

        return distance;  // Return the distance array
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());  // Number of test cases

        for (int t = 0; t < T; t++) {
            String[] firstLine = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(firstLine[0]);  // Number of nodes
            int m = Integer.parseInt(firstLine[1]);  // Number of edges
            int s = Integer.parseInt(firstLine[2]);  // Starting node

            // Create graph as an ArrayList of ArrayLists
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            // Read edges
            for (int i = 0; i < m; i++) {
                String[] edge = reader.readLine().trim().split(" ");
                int x = Integer.parseInt(edge[0]);
                int y = Integer.parseInt(edge[1]);
                graph[x].add(y);  // Add edge x - y
                graph[y].add(x);  // Add edge y - x (undirected)
            }

            // Get distances from node s
            int[] distances = bfsShortestPath(n, graph, s);
            // Print distances
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                result.append(distances[i]).append(" ");
            }
            System.out.println(result.toString().trim());
        }
    }
}