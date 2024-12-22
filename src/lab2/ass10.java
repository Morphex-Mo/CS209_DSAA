package lab2;

import java.util.Scanner;

public class ass10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        long b=sc.nextLong();
        long c=1;
        if (a==1||a==0){
            System.out.println(1%b);
        }
        if (a==2){
            System.out.println(2%b);
        }
        if (a==3){
            if (b<=720){
                System.out.println(0);
            }
            else {
                for (int i = 1; i <= 720; i++) {
                    c=((c%b)*i)%b;
                }
                System.out.println(c);
            }
        }
        if (a>=4){
            System.out.println(0);
        }
    }
}
