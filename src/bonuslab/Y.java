package bonuslab;

import java.util.Scanner;

public class Y {
    private static final int MOD = 998244353;
    private static long[] dp;
    private static long[] factorial;
    private static long[] invFactorial;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        dp = new long[N + 1];
        factorial = new long[N + 1];
        invFactorial = new long[N + 1];

        // Initialize factorial and inverse factorial
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        invFactorial[N] = modInverse(factorial[N], MOD);
        for (int i = N - 1; i >= 0; i--) {
            invFactorial[i] = invFactorial[i + 1] * (i + 1) % MOD;
        }

        dp[0] = 1; // 0个节点
        dp[1] = 1; // 1个节点

        for (int n = 2; n <= N; n++) {
            int h = (int) (Math.log(n) / Math.log(2));
            int maxIndex = (1 << h) - 1; // 完全二叉树的节点数量
            int lastLevelCount = n - maxIndex; // 最后一层的节点数量
            int leftCount = (1 << (h - 1)); // 左子树的最大节点数

            // 左子树的实际节点数
            int leftNodes = Math.min(leftCount, lastLevelCount);
            int rightNodes = n - 1 - leftNodes;

            // 计算不同 Max-heap 的数量
            dp[n] = comb(n - 1, leftNodes) * dp[leftNodes + 1] % MOD * dp[rightNodes + 1] % MOD;
        }

        System.out.println(dp[5]);
    }

    // 计算组合数 C(n, k)
    private static long comb(int n, int k) {
        if (k > n || k < 0) return 0;
        return factorial[n] * invFactorial[k] % MOD * invFactorial[n - k] % MOD;
    }

    // 计算模逆
    private static long modInverse(long a, long mod) {
        return pow(a, mod - 2, mod);
    }

    // 快速幂
    private static long pow(long base, long exp, long mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = res * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return res;
    }
}