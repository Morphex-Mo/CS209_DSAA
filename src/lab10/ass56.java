package lab10;

import java.util.*;

public class ass56 {
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

    // 快速排序算法
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
            if (edges[j].weight < pivot.weight) {
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
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Edge[] edges = new Edge[m];
        long totalWeight = 0;

        // 读取边的信息
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1; // 0-based index
            int v = scanner.nextInt() - 1; // 0-based index
            long weight = scanner.nextLong(); // 使用 long 类型读取权重
            edges[i] = new Edge(u, v, weight);
            totalWeight += weight;
        }

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // 使用快速排序对边进行排序
        quickSort(edges, 0, m - 1);

        long mstWeight = 0;
        long negativeWeight = 0;

        // 首先计算负权边的总权重，并将其保留
        for (Edge edge : edges) {
            if (edge.weight < 0) {
                negativeWeight += edge.weight; // 保留负权边的权重
                union(edge.u, edge.v); // 将负权边加入并查集
            }
        }

        // 计算MST的权重，只考虑非负权边
        for (Edge edge : edges) {
            if (edge.weight >= 0 && find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                mstWeight += edge.weight;
            }
        }

        // 最大收益 = 总权重 - MST权重 + 负权边权重
        long maxGain = totalWeight - mstWeight - negativeWeight;
        System.out.println(maxGain);
    }
}