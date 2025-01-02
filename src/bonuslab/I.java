package bonuslab;

import java.util.Arrays;
import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int result[] = new int[t];
        for (int i = 0; i < t; i++) {
            int numberOfStringOfBeads = sc.nextInt();
            int arr[][] = new int[numberOfStringOfBeads][2];
            int sum=0;
            for (int j = 0; j < numberOfStringOfBeads; j++) {
                arr[j][0] = sc.nextInt();
                arr[j][1] = sc.nextInt();
                sum+=arr[j][0];
                sum+=arr[j][1];
            }
            mergeSort(arr, 0, arr.length - 1);
            int arr1[] = convertArr(arr);
//            System.out.println(Arrays.deepToString(arr));
//            System.out.println(Arrays.toString(arr1));

            for (int j = 1; j < numberOfStringOfBeads * 2 - 1; j += 2) {
                if (arr1[j] < arr1[j + 1]) {
                    result[i] += arr1[j];
                } else {
                    result[i] += arr1[j + 1];
                    arr1[j + 2] += arr1[j] - arr1[j + 1];
                }
            }
            result[i]=sum-2*result[i];
        }
        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }


    }

    public static int[] convertArr(int[][] arr) {
        int length = arr.length * 2;
        int[] YiWeiArr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            YiWeiArr[2 * i] = arr[i][0];
            YiWeiArr[2 * i + 1] = arr[i][1];
        }

        return YiWeiArr;
    }

    public static void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;


            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);


            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[][] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[][] L = new int[n1][2];
        int[][] R = new int[n2][2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (compare(L[i], R[j]) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    private static int compare(int[] arr1, int[] arr2) {
        if (arr1[0] < arr1[1] && arr2[0] < arr2[1]) {
            return Integer.compare(arr1[0], arr2[0]);
        } else if (arr1[0] < arr1[1]) {
            return -1000;
        } else if (arr2[0] < arr2[1]) {
            return 1000;
        } else {
            return Integer.compare(arr2[1], arr1[1]);
        }
    }

}
//    a<b的放左半边，a>b的放右半边；
//    如果ai<ai+1
//    ai放在ai+1左边；