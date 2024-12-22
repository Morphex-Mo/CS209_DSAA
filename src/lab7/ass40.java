package lab7;

import java.util.Arrays;
import java.util.Scanner;

public class ass40 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        while (a-->0){
            int b= sc.nextInt();
            int arr[]=new int[b];
            for (int i = 0; i < b; i++) {
                arr[i]= sc.nextInt();
            }
            int count=0;
            int result=0;
            while (count!=b-1){
                result+=findTwoMinValues(arr);
                count++;
            }
            System.out.println(result);
        }
    }
    public static int findTwoMinValues(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        // 初始化最小值和第二小值
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min1Index = -1;
        int min2Index = -1;

        // 遍历数组找到最小的两个值及其索引
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min1) {
                // 更新第二小值
                min2 = min1;
                min2Index = min1Index;
                // 更新最小值
                min1 = arr[i];
                min1Index = i;
            } else if (arr[i] < min2) {
                // 更新第二小值
                min2 = arr[i];
                min2Index = i;
            }
        }

        // 将min1的位置替换为min1 + min2
        arr[min1Index] = min1 + min2;
        int sum=0;
        sum=min1+min2;
        // 将min2的位置设置为Integer.MAX_VALUE
        if (min2Index != -1) {
            arr[min2Index] = Integer.MAX_VALUE;
        }
        return sum;
    }
}
