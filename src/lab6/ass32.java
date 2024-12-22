package lab6;

import java.util.Scanner;

public class ass32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        int n = S.length();
        int[] next = new int[n];
        next[0]=0;
        int j=0;
        for (int i = 1; i < n; i++) {
            while (j>0&&S.charAt(i)!=S.charAt(j)){
                j=next[j-1];
            }if (S.charAt(i)==S.charAt(j)){
                j++;
            }
            next[i]=j;
        }

        // Output the next array
        for (int i = 0; i < n; i++) {
            System.out.println(next[i]);
        }


    }


}