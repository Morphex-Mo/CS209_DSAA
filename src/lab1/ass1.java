package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class ass1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int arrOfA[]=new int[n];
        for (int i = 0; i < n; i++) {
            arrOfA[i]=scanner.nextInt();
        }
        int T=scanner.nextInt();
        int arrOfB[]=new int[T];
        for (int i = 0; i < T; i++) {
            arrOfB[i]=scanner.nextInt();
        }
        int equal[]=new int[arrOfB.length];
        for (int i = 0; i < arrOfB.length; i++) {
            for (int j = 0; j < arrOfA.length; j++) {
                if (arrOfB[i]==arrOfA[j]){
                    equal[i]=1;
                    break;
                }else equal[i]=0;
            }
        }
        for (int i = 0; i < equal.length; i++) {
            if (equal[i]==1){
                System.out.println("yes");
            }else System.out.println("no");
        }
//        System.out.println(Arrays.toString(arrOfA));
//        System.out.println(Arrays.toString(arrOfB));
        //排序
    }
    public static int[] rank(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i]>=arr[j]){
                    int a=arr[j];
                    arr[j]=arr[i];
                    arr[i]=a;
                }
            }
        }
        return arr;
    }
}
