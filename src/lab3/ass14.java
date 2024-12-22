package lab3;

import java.io.*;
import java.util.StringTokenizer;

public class ass14 {
    public static void main(String[] args) {
        QuickR in = new QuickR();
        QuickW out = new QuickW();
        int a = in.nextInt();
        for (int i = 0; i < a; i++) {
            int b = in.nextInt();
            int c = in.nextInt();
            int arr1[] = new int[b];
            int arr2[] = new int[c];
            int arr3[];
            for (int j = 0; j < b; j++) {
                arr1[j] = in.nextInt();
            }
            for (int j = 0; j < c; j++) {
                arr2[j] = in.nextInt();
            }
            arr3 = MergeSort(arr1, arr2);
            for (int j = 0; j < arr3.length; j++) {
                out.print(arr3[j] + " ");
            }
            out.println("");
        }
        out.close();
    }

    public static int[] MergeSort(int arr1[], int arr2[]) {
        int arr3[] = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while (index3 < arr3.length) {
            if (index1 == arr1.length  || index2 == arr2.length ) {
                break;
            }
            if (arr1[index1] < arr2[index2]) {
                arr3[index3++] = arr1[index1++];
            }
            else   {
                arr3[index3++] = arr2[index2++];
            }
        }
        while (index1 < arr1.length) {
            arr3[index3++] = arr1[index1++];
        }
        while (index2 < arr2.length) {
            arr3[index3++] = arr2[index2++];
        }
        return arr3;
    }
}

