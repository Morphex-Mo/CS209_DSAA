package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class ass15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        quickSort(arr, 0, n - 1);
//        System.out.println(Arrays.toString(arr));
//        arr=removeDuplicates(arr);
        long result = countMagicWord(arr.length, m, arr);
        System.out.println(result);
    }


    private static void quickSort(long[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(long[] arr, int low, int high) {
        long pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static long[] calculateFrequencies(long[] arr, long[] bigArray) {
        long[] frequencies = new long[arr.length];

        // 统计频数
        for (int i = 0; i < arr.length; i++) {
            long count = 0;
            for (long num : bigArray) {
                if (num == arr[i]) {
                    count++;
                }
            }
            frequencies[i] = count;
        }

        return frequencies;
    }
    private static long countMagicWord(int n, long m, long[] arr) {
        long count1=0;
        long count[]=new long[3];
        long count3[] = new long[3];
        int count2=0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                long target = m - arr[i] - arr[j];
                int left = j + 1;
                int right = n - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (arr[mid] == target) {
                        count[0]=arr[i];
                        count[1]=arr[j];
                        count[2]=target;
                        System.out.println(Arrays.toString(count));
                        count3=calculateFrequencies(count,arr);
                        System.out.println(Arrays.toString(count3));
                        if (count[0]==count[1]&&count[0]==count[2]){
                            count1+=count3[0];
                        } else if (count[0]==count[1]||count[0]==count[2]||count[1]==count[2]) {
                            if (count[0]==count[1]){
                                count1+=count3[0]*count3[2];
                            } else if (count[0]==count[2]) {
                                count1+=count3[0]*count3[1];
                            }else count1+=count3[0]*count3[1];
                        }else count1++;
                        System.out.println(count1);
                        break;
                    } else if (arr[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return count1;
    }
    public static long[] removeDuplicates(long[] inputArray) {
        // 创建一个临时数组来存储不重复的元素
        long[] tempArray = new long[inputArray.length];
        int uniqueCount = 0;

        for (int i = 0; i < inputArray.length; i++) {
            boolean isDuplicate = false;

            // 检查当前元素是否已经在临时数组中
            for (int j = 0; j < uniqueCount; j++) {
                if (inputArray[i] == tempArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // 如果不是重复，则添加到临时数组
            if (!isDuplicate) {
                tempArray[uniqueCount] = inputArray[i];
                uniqueCount++;
            }
        }

        // 创建一个结果数组并复制不重复的元素
        long[] resultArray = new long[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            resultArray[i] = tempArray[i];
        }

        return resultArray;
    }
}