package lab6;

import java.util.Arrays;
import java.util.Scanner;

public class ass35 {
    private static final int BASE = 139;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int result = longestCommonSubstring(s1, s2);
        System.out.println(result);
    }

    private static int longestCommonSubstring(String s1, String s2) {
        int left = 1, right = Math.min(s1.length(), s2.length());
        int longest = 0;
//        System.out.println("left is "+left);
//        System.out.println("right is "+right);
        while (left <= right) {
            int mid = left + (right - left) / 2;
//            System.out.println("mid is "+mid);
            if (hasCommonSubstringOfLength(s1, s2, mid)) {
                longest = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return longest;
    }

    private static boolean hasCommonSubstringOfLength(String s1, String s2, int length) {
        long[] hashes = new long[s1.length() - length + 1];
        long hash1 = 0;
        for (int i = 0; i < length; i++) {
            hash1 = (hash1 * BASE + s1.charAt(i));
            //  hashes[i] = hash1;
        }
        hashes[0] = hash1;
        long pow = 1;
        for (int i = 0; i < length - 1; i++) {
            pow *= BASE;

        }
        for (int i = length; i < s1.length(); i++) {
            hashes[i - length + 1] = (hashes[i - length] - s1.charAt(i - length) * pow) * BASE + s1.charAt(i);
        }


        quickSort(hashes, 0, hashes.length - 1);
        long hash = 0;
        long[] hashes1 = new long[s2.length() - length + 1];
        for (int i = 0; i < length; i++) {
            hash = (hash * BASE + s2.charAt(i));
            //  hashes[i] = hash1;
        }
        hashes1[0] = hash;
        for (int i = length; i < s2.length(); i++) {
            hashes1[i - length + 1] = (hashes1[i - length] - s2.charAt(i - length) * pow) * BASE + s2.charAt(i);
        }

        for (int i = 0; i < hashes1.length; i++) {
            if (binarySearch(hashes, hashes1[i]) >= 0) {
                return true;
            }
        }

        return false;
    }

    private static void quickSort(long[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(long[] arr, int low, int high) {
        long pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int binarySearch(long[] arr, long key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}