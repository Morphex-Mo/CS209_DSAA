package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class ass16 {
    //    樣例：1 3 4 2 5 6 7
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int arr[] = new int[T];
        int result[] = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < T; i++) {
            result[i] = -1;
        }
        int count = 0;
        int count1 = 0;
        mergeSort(arr, 0, T - 1);
        for (int i = 0; i < T; i++) {
            if (arr[i] <= arr[T / 3]) {
                count++;
            }
            if (arr[i] > arr[T / 3]) {
                break;
            }
        }
        for (int i = 0; i < T; i++) {
            if (arr[i] == arr[T / 3]) {
                count1++;
            }
            if (arr[i] > arr[T / 3]) {
                break;
            }
        }
        if (count > T / 3) {
            for (int i = 0; i < count-count1; i++) {
                result[3 * i] = arr[i];
            }
            int k = 0;
            for (int i = 0; i < T; i++) {
                if (result[i] == -1) {
                    result[i] = arr[count-count1 + k];
                    k++;
                }
            }
        } else {
            for (int i = 0; i < T / 3; i++) {
                result[3 * i] = arr[i];
            }
            int k = 0;
            for (int i = 0; i < T; i++) {
                if (result[i] == -1) {
                    result[i] = arr[T / 3 + k];
                    k++;
                }
            }
        }
        System.out.println(arr[T / 3]);
        for (int i = 0; i < T; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
//答案为arr【n/3】
//思路，找一个数组，赋值为-1；
//在0,3,6，……上填0；
//把圈放在0上后，把×放在-1上得到最小字典序

