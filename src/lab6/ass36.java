package lab6;

import java.util.Arrays;
import java.util.Scanner;

public class ass36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mimabiao[] = new String[27];
        for (int i = 0; i < 26; i++) {
            mimabiao[i] = sc.next();
        }
        String str = sc.next();
        char wenzhang[] = new char[str.length()];
        String mimiwenAndmiwen[] = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            wenzhang[i] = str.charAt(i);
        }
        for (int i = 0; i < str.length(); i++) {
            mimiwenAndmiwen[i] = mimabiao[wenzhang[i] - 'a'];
        }
        String dawenzhang = concatenateStringArrays(wenzhang, mimiwenAndmiwen);
//        System.out.println(Arrays.toString(findNext(dawenzhang)));
        int arr[] = findNext(dawenzhang);
        int j = arr[2 * str.length() - 1];
        while (j > str.length() / 2) {
            j = arr[j - 1];
        }
        System.out.println(str.length() - j);
    }

    public static String concatenateStringArrays(char[] array1, String[] array2) {
        StringBuilder result = new StringBuilder();

        // 拼接第一个数组
        for (char str : array1) {
            result.append(str);
        }

        // 拼接第二个数组
        for (String str : array2) {
            result.append(str);
        }

        return result.toString();
    }

    public static int[] findNext(String S) {
        int n = S.length();
        int[] next = new int[n];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && S.charAt(i) != S.charAt(j)) {
                j = next[j - 1];
            }
            if (S.charAt(i) == S.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
