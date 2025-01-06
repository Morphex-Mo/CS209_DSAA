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
/*
题目描述
Given two arrays A
 with length n
 and B
 with length T
. We want to know whether each element in array B
 is in array A
 or not.

输入
The 1st line is a positive integer n(1≤n≤1000)

The 2nd line contains n
 integers: a1,a2,...,an.For each ai,0≤ai≤109
.

The 3rd line contains a positive integer T(1≤T≤1000)

The 4th line contains T
 integers b1,b2,...,bT.For each bi,0≤bi≤109
.



输出

For each element in B
, print "yes" (in a single line, without quotes) if it is in A
, otherwise print "no"



样例输入
4
2 3 999999 1
2
3 99
样例输出
yes
no
 */