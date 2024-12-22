package lab3;

import java.util.Scanner;

public class ass13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int arr[] = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = scanner.nextInt();
            int arr1[] = new int[arr[i]];
            int arr2[] = new int[arr[i]];
            for (int j = 0; j < arr1.length; j++) {
                arr1[j] = scanner.nextInt();
            }
            arr2=bubbleSort(arr1);
            if (arr2[2]==arr2[1]||arr2.length>=4&&arr2[2]==arr2[3]){
                System.out.println("wa");
            }else System.out.println(arr2[2]);
        }

    }

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
        return arr;
    }

}
