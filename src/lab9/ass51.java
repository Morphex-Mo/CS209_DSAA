package lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class ass51 {
    static ArrayList<Integer>[] graph;
    static int[] color; // 用于标记城市
    static int count1, count2; // 计数每种标记的数量

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // 测试用例数量

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // 城市数量
            int m = scanner.nextInt(); // 道路数量

            // 初始化图的邻接表
            graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            // 读取每条边
            for (int j = 0; j < m; j++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            // 初始化颜色数组
            color = new int[n + 1];
            count1 = count2 = 0;

            // 从节点 1 开始 DFS
            dfs(1, 1);

            // 根据标记数量选择较少的标记
            ArrayList<Integer> result = new ArrayList<>();
            if (count1 <= count2) {
                for (int j = 1; j <= n; j++) {
                    if (color[j] == 1) {
                        result.add(j);
                    }
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    if (color[j] == 2) {
                        result.add(j);
                    }
                }
            }

            // 输出结果
            System.out.println(result.size());
            for (int city : result) {
                System.out.print(city + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    static void dfs(int node, int col) {
        color[node] = col; // 标记节点
        if (col == 1) count1++;
        else count2++;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == 0) { // 如果未访问
                dfs(neighbor, 3 - col); // 交替标记
            }
        }
    }
}