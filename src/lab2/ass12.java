package lab2;

import java.util.Scanner;

public class ass12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        int mediam1[] = new int[T];
        for (int i = 0; i < T; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            mediam1[i] = findMedian(arr1, arr2, l, r);
        }
        sc.close();
        for (int i = 0; i < mediam1.length; i++) {
            System.out.println(mediam1[i]);
        }
    }

    private static int findMedian(int[] arr1, int[] arr2, int l, int r) {
        int l1 = l, l2 = l, r1 = r, r2 = r, mid1 = (r1 + l1) / 2, mid2 = (r2 + l2) / 2;
        while (l1 != r1 || l2 != r2) {
            if (arr1[mid1 - 1] < arr2[mid2 - 1]) {
                l1 = mid1 + ((r1 - l1 + 1) % 2 == 0 ? 1 : 0);
                r2 = mid2;
            } else if (arr1[mid1 - 1] > arr2[mid2 - 1]) {
                l2 = mid2 + ((r1 - l1 + 1) % 2 == 0 ? 1 : 0);
                r1 = mid1;
            } else {
                return Math.min(arr1[mid1 - 1], arr2[mid2 - 1]);
            }
            mid1 = (r1 + l1) / 2;
            mid2 = (r2 + l2) / 2;
        }
        return Math.min(arr1[mid1 - 1], arr2[mid2 - 1]);
    }
}