package lab4;

import java.util.Scanner;

public class ass20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            nodeAss20 fadeHead = new nodeAss20(-1, -1);
            nodeAss20 cur = fadeHead;
            for (int j = 0; j < n; j++) {
                nodeAss20 temp = new nodeAss20(sc.nextInt(), sc.nextInt());
                cur.next = temp;
                cur = cur.next;
            }
            nodeAss20 fadeTail = new nodeAss20(0, 1000000001);
            int m = sc.nextInt();
            cur.next = fadeTail;
            cur=fadeHead;
            for (int j = 0; j < m; j++) {
                int coe = sc.nextInt();
                int exp = sc.nextInt();
                while (cur.next.exp <= exp) {
                    cur = cur.next;
                }
                if (cur.exp == exp) {
                    cur.coe += coe;
                } else {
                    nodeAss20 temp = new nodeAss20(coe, exp);
                    temp.next = cur.next;
                    cur.next = temp;
                }
            }
            int Q = sc.nextInt();
            cur = fadeHead.next;
            for (int j = 0; j < Q; j++) {
                int qq = sc.nextInt();
                while (cur.next.exp <= qq) {
                    cur = cur.next;
                }
                if (cur.exp == qq) {
                    System.out.print(cur.coe + " ");
                } else System.out.print("0 ");
            }
        }
//        System.out.println();
    }
}

class nodeAss20 {
    int coe;
    int exp;
    nodeAss20 next;

    public nodeAss20(int coe, int exp) {
        this.coe = coe;
        this.exp = exp;
    }

}
