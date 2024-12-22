package lab5;

import java.util.Scanner;

public class ass26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        System.out.println(calculateScore(str));
    }

    private static int calculateScore(String s) {
        int MOD = 514329;
        int[] stack = new int[s.length()]; // 模拟栈
        int top = -1; // 栈顶指针
        int currentScore=0;

        for (char str : s.toCharArray()) {
            if (str == '(') {
                stack[++top] = currentScore;
                currentScore = 0;
            } else if (str == ')') {
                if (currentScore == 0) {
                    currentScore = 1;
                } else {
                    currentScore = (currentScore * 2) % MOD;
                }
                if (top >= 0) {
                    currentScore = (currentScore + stack[top--]) % MOD;
                }
            }
        }

        return currentScore;
    }
}