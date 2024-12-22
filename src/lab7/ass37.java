package lab7;

import java.util.Scanner;

public class ass37 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        for (int i = 0; i < a; i++) {
            long n= sc.nextLong();
            int k= sc.nextInt();
            long count=1;
            while (n-count>0){
                n-=count;
                count*=k;
            }
            System.out.println(n+count/k-(n+k-1)/k);
        }
    }

}
