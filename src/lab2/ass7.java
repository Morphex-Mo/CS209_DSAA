package lab2;

import java.util.Scanner;

public class ass7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int arr[] = new int[T];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        int arr1[] = new int[a];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int j = 0; j < arr1.length; j++) {
            if (BinaryDivided(arr, arr1[j]) == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static int BinaryDivided(int arr[], int x) {
        int left = 0;
        int right = arr.length - 1;
        int mid = left + (right - left) / 2;
        if (arr[0] > x || arr[arr.length - 1] < x) {
            return 0;
        }
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                right = mid;
            } else if (arr[mid] == x) {
                return 1;
            } else if (left + 1 == right) {
                break;
            } else left = mid;

        }
        return 0;
    }
}
