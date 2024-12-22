package lab6;

import java.util.Scanner;

public class ass34 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T= sc.nextInt();
        for (int i = 0; i < T; i++) {
            String str= sc.next();
            int arr[]=findNext(str);
            if (str.length()%(str.length()-arr[str.length()-1])==0&&arr[str.length()-1]!=0){
                System.out.println(0);
            } else if (str.length()%(str.length()-arr[str.length()-1])==0) {
                System.out.println(str.length());
            } else {
                int result=(str.length()-arr[str.length()-1])-str.length()%(str.length()-arr[str.length()-1]);
                System.out.println(result);
            }
        }
    }
    public static int[] findNext(String S){
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
        return next;
    }
}
