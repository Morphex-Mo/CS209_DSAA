package lab10;

import java.util.*;

public class ass57 {
    static class Edge {
        int u, v;
        long weight;

        Edge(int u, int v, long weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static int[] parent, rank;

    static int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    static void quickSort(Edge[] edges, int low, int high) {
        if (low < high) {
            int pi = partition(edges, low, high);
            quickSort(edges, low, pi - 1);
            quickSort(edges, pi + 1, high);
        }
    }

    static int partition(Edge[] edges, int low, int high) {
        Edge pivot = edges[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (edges[j].weight > pivot.weight) { // 这里使用大于号实现最大生成树
                i++;
                Edge temp = edges[i];
                edges[i] = edges[j];
                edges[j] = temp;
            }
        }
        Edge temp = edges[i + 1];
        edges[i + 1] = edges[high];
        edges[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 行数
        int m = scanner.nextInt(); // 列数

        int[][] grid = new int[n][m];
        List<Edge> edges = new ArrayList<>();
        long totalWeight = 0;

        // 读取网格并生成边
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
                totalWeight += grid[i][j]; // 计算总权重
                // 连接相邻的单元格
                if (i > 0) { // 上方
                    edges.add(new Edge(i * m + j, (i - 1) * m + j, (long) grid[i][j] * grid[i - 1][j]));
                }
                if (j > 0) { // 左方
                    edges.add(new Edge(i * m + j, i * m + (j - 1), (long) grid[i][j] * grid[i][j - 1]));
                }
            }
        }

        int totalVertices = n * m;
        parent = new int[totalVertices];
        rank = new int[totalVertices];
        for (int i = 0; i < totalVertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // 使用快速排序对边进行排序
        quickSort(edges.toArray(new Edge[0]), 0, edges.size() - 1);

        long mstWeight = 0;

        // 计算最大生成树的权重
        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                mstWeight += edge.weight;
            }
        }

        // 最大收益 = 总权重 - MST权重
        long maxGain = mstWeight;
        System.out.println(maxGain);
    }
}