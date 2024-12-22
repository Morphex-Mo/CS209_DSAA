package lab6;

import java.util.Scanner;

public class ass31 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a= sc.nextInt();
        for (int i = 0; i < a; i++) {
            String str= sc.next();
            System.out.println((str.length()+1)*str.length()/2);
        }
    }
}
