package lab3;

import java.util.Scanner;

public class ass17 {

    private static long mergeAndCount(int[] arr, int[] tempArr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long cost = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                cost += (long) arr[j] * (mid - i + 1);
                tempArr[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }
        while (j <= right) {
            tempArr[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = tempArr[i];
        }

        return cost;
    }

    private static long MsortCounting(int[] arr, int[] tempArr, int left, int right) {
        long cost = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            cost += MsortCounting(arr, tempArr, left, mid);
            cost += MsortCounting(arr, tempArr, mid + 1, right);
            cost += mergeAndCount(arr, tempArr, left, mid, right);
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] tempArr = new int[n];
        long minCost = MsortCounting(arr, tempArr, 0, n - 1);
        System.out.println(minCost);
    }
}
//    逆序对
//    a[i]<a[j];
//    i>j;
//    mid-i+1
//    if(a[j]<a[i]){
//        b[k++]=a[j++];
//        count+=(mid-i+1)*a[j];
//    }


//补充:j-(mid+1)*a[i]
