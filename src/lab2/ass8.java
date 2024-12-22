package lab2;

import java.util.Scanner;

public class ass8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int arr[] = new int[T];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println((LiFangHe(arr[i]) % 1000000007) * (LiFangHe(arr[i]) % 1000000007) % 1000000007);
        }
    }

    public static long LiFangHe(long a) {
        return a * (a + 1) / 2;
    }
}
