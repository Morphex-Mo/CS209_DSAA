package lab9;

import java.util.Scanner;

public class ass49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 读入测试用例的数量
        StringBuilder output = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt(); // 节点数量
            int m = scanner.nextInt(); // 边数量

            // 初始化邻接矩阵
            int[][] matrix = new int[n][n];

            // 读入每条边并更新邻接矩阵
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt() - 1; // 读取边的起点，减去1以便使用0索引
                int y = scanner.nextInt() - 1; // 读取边的终点，减去1以便使用0索引
                matrix[x][y] = 1; // 设置邻接矩阵
            }

            // 构建输出
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    output.append(matrix[i][j]).append(" ");
                }
                output.append("\n"); // 换行
            }

        }

        // 打印最终结果
        System.out.print(output.toString().trim()); // 去掉最后的多余换行
    }
}