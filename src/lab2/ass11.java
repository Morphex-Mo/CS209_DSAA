package lab2;

import java.util.Arrays;
import java.util.Scanner;

public class ass11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long l = sc.nextInt();
            long n = sc.nextInt();
            long m = sc.nextInt();
            long arr[] = new long[(int) (n + 2)];
            for (int i = 1; i < n + 1; i++) {
                arr[i] = sc.nextInt();
            }
//            System.out.println(Arrays.toString(arr));
            arr[0] = 0;
            arr[(int) (n + 1)] = l;
            Arrays.sort(arr);
//            System.out.println(Arrays.toString(arr));
            long low = maxAdjacentDifference(arr);
            long high = l;
            long medium = low + (high - low) / 2;
            while (low < high) {
//                System.out.println("low is" + low);
//                System.out.println("high is" + high);
//                System.out.println("medium is" + medium);
                if (LengthIsShort(medium, arr, m)) {
                    high--;
                    medium = low + (high - low) / 2;
                } else {
                    low++;
                    medium = low + (high - low) / 2;
                }
                if (medium == low || medium == high) {
//                    System.out.println("low is" + low);
//                    System.out.println("high is" + high);
//                    System.out.println("medium is" + medium);
                    break;
                }
//                System.out.println("--------------------------------------------------");
            }
            System.out.println(medium);
        }
    }

    public static boolean LengthIsShort(long medium, long arr[], long m) {
        long lastPosition = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length - 1; i++) {
            // 如果下一个位置与最后一个放置位置的距离大于等于 maxDistance
            if (arr[i + 1] - lastPosition >= medium) {
                count++; // 在这里放置一个接力跑者
//                System.out.println("放人在这里 " + arr[i]);
                lastPosition = arr[i]; // 更新最后放置的位置

            } else if (arr[i] - lastPosition >= medium) {
                count++;
//                System.out.println("放人在这里 " + lastPosition);
                lastPosition = arr[i];

//                medium = (int) (medium - arr[i] + lastPosition);
//                System.out.println("还可以跑 "+ medium);
            }
        }
//        System.out.println("count is  " + count);
        return count <= m; // 成功放置足够的接力跑者
    }

    public static long maxAdjacentDifference(long[] arr) {


        long maxDiff = 0; // 初始化最大差值为0

        for (int i = 1; i < arr.length; i++) {
            long diff = arr[i] - arr[i - 1]; // 计算相邻元素的差
            if (diff < 0) {
                diff = -diff; // 如果差值为负，取其绝对值
            }
            if (diff > maxDiff) {
                maxDiff = diff; // 更新最大差值
            }
        }

        return maxDiff;
    }
}

