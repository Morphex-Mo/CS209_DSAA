package lab6;

import java.util.Scanner;

public class ass33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        int m = S.length();

        // 转移表
        int[][] transition = new int[m + 1][26];

        // 初始化状态 0
        for (int j = 0; j < 26; j++) {
            transition[0][j] = 0; // 初始状态的所有转移都指向状态 0
        }

        // 填充转移表
        for (int q = 0; q < m; q++) {
            for (int j = 0; j < 26; j++) {
                char currentChar = (char) ('a' + j);
                if (currentChar == S.charAt(q)) {
                    transition[q][j] = q + 1; // 如果匹配，转移到下一个状态
                } else {
                    transition[q][j] = transition[getPrefixLength(transition, q)][j]; // 使用前缀函数
                }
            }
        }

        // 输出转移表
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 26; j++) {
                System.out.print(transition[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    // 查找状态 q 的前缀长度
    private static int getPrefixLength(int[][] transition, int q) {
        while (q > 0 && transition[q][0] == 0) {
            q--;
        }
        return q;
    }
}