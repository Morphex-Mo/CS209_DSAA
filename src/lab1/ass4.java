package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class ass4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int arr[] = new int[T];
        int result1[] = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = scanner.nextInt();
            scanner.nextLine();
            int arrNumber[] = new int[arr[i]];
            for (int j = 0; j < arrNumber.length; j++) {
                arrNumber[j] = scanner.nextInt();
//                System.out.print(arrNumber[j]+" ");
                int[] arr4 = new int[arrNumber.length - 1];
                int[] arrNumberMin = getMinFromRight(arrNumber);
//                System.out.println(Arrays.toString(arrNumberMin));
                for (int k = 1; k < arrNumber.length; k++) {
                    arr4[k - 1] = arrNumber[k - 1] - arrNumberMin[k];
                }
//                System.out.println(Arrays.toString(arr4));
                result1[i] = max(arr4);
            }

//            System.out.println(a);
//            System.out.println(b);
//            System.out.println(c);
        }
        for (int i = 0; i < result1.length; i++) {
            System.out.println(result1[i]);
        }


    }

    public static int[] getMinFromRight(int[] array) {
        int n = array.length;
        int[] result = new int[n];
        int min = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, array[i]);
            result[i] = min;
        }

        return result;
    }


    public static int max(int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            }
        }
        return max;
    }
}

