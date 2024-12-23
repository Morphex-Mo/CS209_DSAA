package lab9;

import java.util.Scanner;

public class ass52 {

    static int maxA = 300000;

    static int[][] a = new int[maxA][];
    static int[] aa = new int[maxA];
    static int[] b = new int[maxA];
    static int[] c = new int[maxA];
    static int[] d = new int[maxA];
    static int e = 0;
    static int[] f = new int[maxA];
    static int[] g = new int[maxA];

    public static void main(String[] args) {
        Scanner h = new Scanner(System.in);

        int i = h.nextInt();
        for (int j = 0; j < i; j++) {
            int aA = h.nextInt();
            int aB = h.nextInt();

            e = 0;
            for (int k = 1; k <= aA; k++) {
                b[k] = 0;
                aa[k] = 0;
                g[k] = 0;
            }

            int[] aC = new int[aA];
            int[] aD = new int[aA];

            for (int k = 0; k < aA - 1; k++) {
                int aE = h.nextInt();
                int aF = h.nextInt();
                b[aF]++;
                g[aE] = aF;
                aC[k] = aE;
                aD[k] = aF;
            }

            for (int k = 1; k <= aA; k++) {
                a[k] = new int[b[k]];
                b[k] = 0;
            }

            for (int k = 0; k < aA - 1; k++) {
                int aE = aC[k];
                int aF = aD[k];
                a[aF][b[aF]++] = aE;
            }

            int root = 1;
            for (int k = 1; k <= aA; k++) {
                if (g[k] == 0) {
                    root = k;
                    break;
                }
            }

            dfs(root, aA);

            for (int k = 0; k < aB; k++) {
                int aE = h.nextInt();
                int aF = h.nextInt();

                if (c[aF] <= c[aE] && d[aE] <= d[aF]) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
        h.close();
    }

    static void dfs(int aA, int aB) {
        int top = 0;
        int[] aa = new int[aB + 1];
        boolean[] bb = new boolean[aB + 1];
        f[top++] = aA;

        while (top > 0) {
            int aC = f[top - 1];

            if (!bb[aC]) {
                bb[aC] = true;
                c[aC] = ++e;
            }

            if (aa[aC] < a[aC].length) {
                int aD = a[aC][aa[aC]++];
                if (!bb[aD]) {
                    f[top++] = aD;
                }
            } else {
                d[aC] = ++e;
                top--;
            }
        }
    }
}