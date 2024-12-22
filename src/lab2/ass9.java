package lab2;

import java.util.Scanner;

public class ass9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int arr[] = new int[a];
        int arr1[][] = new int[b][2];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 2; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < b; i++) {
            if (BinaryDivided(arr, arr1[i][0], arr1[i][1]) != 0) {
                System.out.print("YES"+" "+BinaryDivided(arr, arr1[i][0], arr1[i][1]));
            }else System.out.println("NO");
        }
    }

    public static int BinaryDivided(int arr[], int x, int y) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int index1=0;
        int index2=0;
//        if (x >= y) {
//            return 0;
//        }
        if (left < x && y < right) {
            while (left < right) {
                mid = left + (right - left) / 2;
                if (arr[mid] > x) {
                    right = mid;
                } else if (arr[mid] == x||arr[mid]<x&&arr[mid+1]>x) {
                    right = mid;
                    index1 = right;
                    break;
                } else {
                    left = mid;
                }
            }
            while (left < right) {
                mid = left + (right - left) / 2;
                if (arr[mid] > y) {
                    right = mid;
                } else if (arr[mid] == y||arr[mid]<y&&arr[mid+1]>y) {
                    right = mid;
                    index2=right;
                    break;
                } else {
                    left = mid;
                }
            }
            return index2-index1;
        }
        return 0;
    }
}
