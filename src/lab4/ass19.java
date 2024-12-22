package lab4;

import java.util.Scanner;

public class ass19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            nodeAss19 first = new nodeAss19(1);
            nodeAss19 cur = first;

            for (int i = 2; i <= n; i++) {
                cur.next = new nodeAss19(i);
                cur = cur.next;
            }
            cur.next = first;

            StringBuilder result = new StringBuilder();
            cur = first;
            nodeAss19 prev = cur;

            for (int remaining = n; remaining > 0; remaining--) {
                for (int i = 1; i < k; i++) {
                    prev = cur;
                    cur = cur.next;
                }

                result.append(cur.index).append(" ");
                prev.next = cur.next;
                cur = prev.next;
            }

            System.out.println(result.toString().trim());
        }

        sc.close();
    }
}

class nodeAss19 {
    int index;
    nodeAss19 next;

    public nodeAss19(int index) {
        this.index = index;
        this.next = null;
    }
}