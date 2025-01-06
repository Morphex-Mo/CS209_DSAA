package lab10;

import java.util.*;

public class ass55 {
    static class Edge {
        long to, weight;

        Edge(long to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong(); // 城市数量
        long m = scanner.nextLong(); // 道路数量

        // 创建邻接表
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>((int) n + 1);
        for (long i = 0; i <= n; i++) {
            graph.add(new ArrayList<>()); // 初始化每个城市的边列表
        }

        // 读取道路信息
        for (long i = 0; i < m; i++) {
            long u = scanner.nextLong();
            long v = scanner.nextLong();
            long w = scanner.nextLong();
            graph.get((int) u).add(new Edge(v, w)); // 添加边
        }

        // 计算从城市 1 到城市 n 的最短路径
        long result = dijkstra(n, graph);
        System.out.println(result);
    }

    private static long dijkstra(long n, ArrayList<ArrayList<Edge>> graph) {
        // 初始化距离数组
        long[] dist = new long[(int) n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0; // 从城市 1 开始

        // 优先队列，存储 {距离, 城市}
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, 1}); // 初始状态加入起始城市

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long currentCost = current[0];
            long u = current[1];

            // 如果当前路径成本已经不是最小的，跳过
            if (currentCost > dist[(int) u]) {
                continue;
            }

            // 遍历所有邻居
            for (Edge edge : graph.get((int) u)) {
                long v = edge.to;
                long weight = edge.weight;

                // 放松操作
                if (dist[(int) u] + weight < dist[(int) v]) {
                    dist[(int) v] = dist[(int) u] + weight;
                    pq.add(new long[]{dist[(int) v], v});
                }
            }
        }

        // 检查城市 n 的距离
        if (dist[(int) n] == Long.MAX_VALUE) {
            return -1; // 无法到达城市 n
        } else {
            return dist[(int) n]; // 返回到城市 n 的最短路径
        }
    }
}