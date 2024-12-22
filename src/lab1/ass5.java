package lab1;

import java.util.Scanner;

public class ass5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int arr[][] = new int[T][3];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < T; i++) {
            int b = 2 * arr[i][0] + 2 * arr[i][1] + 1;
            int a = 2 * arr[i][2] + 2 * arr[i][1] + 1;
            int c = arr[i][1];
            char[][] ThreeDimensions = new char[a][b];
            for (int j = 0; j < a; j++) {
                for (int k = 0; k < b; k++) {
                    ThreeDimensions[j][k] = '.';
                }
            }
            for (int j = 0; j < a; j++) {
                if (j % 2 == 0) {
                    for (int k = 2 * c; k < b - 2 * (arr[i][1] - c); k++) {
                        if (k % 2 == 0) {
                            ThreeDimensions[j][k] = '+';
                        }
                        if (k % 2 == 1) {
                            ThreeDimensions[j][k] = '-';
                        }
                    }
                    c--;
                    if (c < 0) {
                        c++;
                    }
                }
                if (j % 2 == 1 && j <= 2 * arr[i][1] - 1) {
                    for (int k = 2 * c + 1; k < b - 2 * (arr[i][1] - c) + 1; k++) {
                        if (k % 2 == 0) {
                            ThreeDimensions[j][k] = '.';
                        }
                        if (k % 2 == 1) {
                            ThreeDimensions[j][k] = '/';
                        }
                    }
                }
                if (j % 2 == 1 && j > 2 * arr[i][1] - 1) {
                    for (int k = 2 * c; k < b - 2 * (arr[i][1] - c) + 1; k++) {
                        if (k % 2 == 0) {
                            ThreeDimensions[j][k] = '|';
                        }
                    }
                }
            }
            int d = arr[i][1];
            for (int k = b - 2 * arr[i][1] - 1; k < b; k++) {
                if (k % 2 == 0) {
                    for (int j = 2 * d; j < a - 2 * (arr[i][1] - d); j++) {
                        if (j % 2 == 0) {
                            ThreeDimensions[j][k] = '+';
                        }
                        if (j % 2 == 1) {
                            ThreeDimensions[j][k] = '|';
                        }
                    }
                    if (d > 0) {
                        d--;
                    }
                }
                if (k % 2 == 1) {
                    for (int j = 2 * d; j < a - 2 * (arr[i][1] - d) + 2; j++) {
                        if (j % 2 == 1) {
                            ThreeDimensions[j][k] = '/';
                        }
                    }
                }
            }
//            System.out.println(2 * arr[i][0] - 1);
            for (int j = 0; j < a; j++) {
                for (int k = 0; k < b; k++) {
                    System.out.print(ThreeDimensions[j][k]);
                }
                System.out.println();
            }
        }
    }
}
