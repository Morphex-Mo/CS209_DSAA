package lab5;

import java.util.Scanner;

public class ass25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String result[] = new String[a];
        for (int i = 0; i < a; i++) {
            result[i] = "NO";
        }
        for (int i = 0; i < a; i++) {
            int count1=0;
            int count2=0;
            int top = 0;
            int b = sc.nextInt();
            char arr[] = new char[b];
            String str = sc.next();
            if (b % 2 != 0) {
                result[i] = "NO";
            } else {
                for (int j = 0; j < b; j++) {
                    if (str.charAt(j) == '(' || str.charAt(j) == '{' || str.charAt(j) == '[') {
                        arr[top++] = str.charAt(j);
                        count1++;
                    } else {
                        count2++;
                        if (top - 1 < 0) {
                            result[i] = "NO";
                        } else if (arr[top - 1] == '(' && str.charAt(j) == ')') {
                            top--;
                        } else if (arr[top - 1] == '{' && str.charAt(j) == '}') {
                            top--;
                        } else if (arr[top - 1] == '[' && str.charAt(j) == ']') {
                            top--;
                        } else result[i] = "NO";
                    }
                }
                if (top == 0) {
                    result[i] = "YES";
                }
                if (count1 !=count2) {
                    result[i] = "NO";
                }
            }
        }
        for (
                int i = 0;
                i < a; i++) {
            System.out.println(result[i]);
        }
    }
}
