package lab1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ass3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String arr[][] = new String[T][13];
        int arr1[][] = new int[T][13];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 13; j++) {
                arr[i][j] = sc.next();
            }
        }
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 13; j++) {
                arr1[i][j] = getNumber(arr[i][j]);
            }
        }
        for (int i = 0; i <T ; i++) {
            sortArray(arr1[i]);
        }
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 13; j++) {
                arr[i][j] = getObject(arr1[i][j]);
            }
        }
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }
    public static void sortArray(int[] array) {
        Arrays.sort(array);
    }

    public static int getNumber(String s) {
        switch (s) {
            case "W1":
                return 1;
            case "W2":
                return 2;
            case "W3":
                return 3;
            case "W4":
                return 4;
            case "W5":
                return 5;
            case "W6":
                return 6;
            case "W7":
                return 7;
            case "W8":
                return 8;
            case "W9":
                return 9;
            case "T1":
                return 10;
            case "T2":
                return 11;
            case "T3":
                return 12;
            case "T4":
                return 13;
            case "T5":
                return 14;
            case "T6":
                return 15;
            case "T7":
                return 16;
            case "T8":
                return 17;
            case "T9":
                return 18;
            case "Y1":
                return 19;
            case "Y2":
                return 20;
            case "Y3":
                return 21;
            case "Y4":
                return 22;
            case "Y5":
                return 23;
            case "Y6":
                return 24;
            case "Y7":
                return 25;
            case "Y8":
                return 26;
            case "Y9":
                return 27;
            case "E":
                return 28;
            case "S":
                return 29;
            case "W":
                return 30;
            case "N":
                return 31;
            case "B":
                return 32;
            case "F":
                return 33;
            case "Z":
                return 34;
            default:
                return Integer.MAX_VALUE;
        }

    }

    public static String getObject(int num) {
        switch (num) {
            case 1:
                return "W1";
            case 2:
                return "W2";
            case 3:
                return "W3";
            case 4:
                return "W4";
            case 5:
                return "W5";
            case 6:
                return "W6";
            case 7:
                return "W7";
            case 8:
                return "W8";
            case 9:
                return "W9";
            case 10:
                return "T1";
            case 11:
                return "T2";
            case 12:
                return "T3";
            case 13:
                return "T4";
            case 14:
                return "T5";
            case 15:
                return "T6";
            case 16:
                return "T7";
            case 17:
                return "T8";
            case 18:
                return "T9";
            case 19:
                return "Y1";
            case 20:
                return "Y2";
            case 21:
                return "Y3";
            case 22:
                return "Y4";
            case 23:
                return "Y5";
            case 24:
                return "Y6";
            case 25:
                return "Y7";
            case 26:
                return "Y8";
            case 27:
                return "Y9";
            case 28:
                return "E";
            case 29:
                return "S";
            case 30:
                return "W";
            case 31:
                return "N";
            case 32:
                return "B";
            case 33:
                return "F";
            case 34:
                return "Z";
            default:
                return null;
        }
    }


}