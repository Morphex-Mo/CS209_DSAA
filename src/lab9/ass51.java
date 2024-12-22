package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ass51 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());  // 测试用例数量
        StringBuilder result = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String[] firstLine = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(firstLine[0]);  // 城市数量
            int m = Integer.parseInt(firstLine[1]);  // 道路数量

            // 创建图的邻接表
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            // 读取边
            for (int i = 0; i < m; i++) {
                String[] edge = reader.readLine().trim().split(" ");
                int x = Integer.parseInt(edge[0]);
                int y = Integer.parseInt(edge[1]);
                graph[x].add(y);  // 添加边 x - y
                graph[y].add(x);  // 添加边 y - x（无向）
            }

            // 保护城市的布尔数组
            boolean[] protectedCities = new boolean[n + 1];
            ArrayList<Integer> towers = new ArrayList<>();

            // 贪心选择城市建立防御塔
            for (int u = 1; u <= n; u++) {
                if (!protectedCities[u]) {  // 如果城市 u 未被保护
                    towers.add(u);  // 在城市 u 建立塔
                    protectedCities[u] = true;  // 保护 u
                    // 保护所有相邻城市
                    for (int neighbor : graph[u]) {
                        protectedCities[neighbor] = true;  // 保护邻居
                    }
                }
            }

            // 限制塔的数量至多为 floor(n / 2)
            int maxTowers = n / 2;
            int k = Math.min(towers.size(), maxTowers);

            // 输出结果

            result.append(k).append("\n");
            for (int i = 0; i < k; i++) {
                result.append(towers.get(i)).append(" ");
                if (t!=T-1){
                    result.append("\n");
                }
            }
        }
        System.out.println(result.toString().trim());
    }
}