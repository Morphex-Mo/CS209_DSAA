package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class ass6 {
    static boolean qjflag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] pai = new String[T];
        boolean[] flag = new boolean[T];

        for (int i = 0; i < T; i++) {
            qjflag = false;
            pai[i] = scanner.next();
            int[][] arr = new int[4][9];
            String[] card = pai[i].split("");

            for (int k = 1; k < card.length; k++) {
                if (k % 2 == 1) {
                    int num = Integer.parseInt(card[k - 1]) - 1;
                    switch (card[k]) {
                        case "w":
                            arr[0][num]++;
                            break;
                        case "s":
                            arr[1][num]++;
                            break;
                        case "b":
                            arr[2][num]++;
                            break;
                        case "z":
                            arr[3][num]++;
                            break;
                    }
                }
            }
            flag[i] = Win(arr);
        }

        for (int i = 0; i < T; i++) {
            if (flag[i]){
                System.out.println("Blessing of Heaven");
            }else System.out.println("Bad luck");
        }
    }

    public static boolean check(int[] arr) {
        if (Arrays.stream(arr).allMatch(x -> x == 0)) {
            return true;
        }

        for (int j = 0; j < 9; j++) {
            if (arr[j] >= 3) {
                arr[j] -= 3;
                if (check(arr)) {
                    return true;
                }
                arr[j] += 3;
            }
            if (j < 7 && arr[j] > 0 && arr[j + 1] > 0 && arr[j + 2] > 0) {
                arr[j]--;
                arr[j + 1]--;
                arr[j + 2]--;
                if (check(arr)) {
                    return true;
                }
                arr[j]++;
                arr[j + 1]++;
                arr[j + 2]++;
            }
        }

        return false;
    }

    public static boolean checkZi(int[] arr) {
        if (Arrays.stream(arr).allMatch(x -> x == 0)) {
            return true;
        }
        for (int j = 0; j < 9; j++) {
            if (arr[j] >= 3) {
                arr[j] -= 3;
                if (checkZi(arr)) {
                    return true;
                }
                arr[j] += 3;
            }
        }

        return false;
    }
    public static boolean Win(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] >= 2) {
                    arr[i][j] -= 2;
                    if (check(arr[0]) && check(arr[(1)]) && check(arr[2]) && checkZi(arr[3])) {
                        return true;
                    }
                    arr[i][j] += 2;
                }
            }
        }
        return false;
    }
}