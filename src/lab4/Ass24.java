package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ass24 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a= sc.nextInt();
        for (int i = 0; i < a; i++) {
            int b= sc.nextInt();
            int arr[]=new int[b];
            for (int j = 0; j < b; j++) {
                arr[j]= sc.nextInt();
            }
            getIncreasingSequence(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static List<Integer> getIncreasingSequence(int[] arr) {
        List<Integer> currentList = new ArrayList<>();

        // 将数组转为列表以便操作
        for (int num : arr) {
            currentList.add(num);
        }

        boolean modified;
        do {
            modified = false;
            List<Integer> newList = new ArrayList<>();

            for (int i = 0; i < currentList.size(); i++) {
                // 如果当前元素是最后一个，直接添加
                if (i == currentList.size() - 1 || currentList.get(i) < currentList.get(i + 1)) {
                    newList.add(currentList.get(i));
                } else {
                    // 发现递减，标记修改
                    modified = true;
                    while (i < currentList.size() - 1 && currentList.get(i) >= currentList.get(i + 1)) {
                        i++; // 跳过递减部分
                    }
                    // 跳过递减部分的最后元素
                }
            }

            currentList = newList; // 更新当前列表
        } while (modified); // 继续循环直到没有修改

        return currentList; // 返回最终的递增数列
    }
}