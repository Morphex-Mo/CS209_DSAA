package lab4;

import lab3.QuickR;
import lab3.QuickW;

import java.util.Arrays;


class NodeAss23 {
    int index;
    int value;// 原始索引
    NodeAss23 next;   // 指向下一个节点
    NodeAss23 prev;   // 指向上一个节点
    NodeAss23 node[];
    NodeAss23 nodeNew[];

    NodeAss23(int index,int value) {
        this.index = index;
        this.value=value;
    }

}

public class ass23 {
    public static void main(String[] args) {
        QuickR sc = new QuickR();
        QuickW out = new QuickW();

        NodeAss23 fadeHead = new NodeAss23(-1, Integer.MIN_VALUE);
        NodeAss23 fadeTail = new NodeAss23(-1, Integer.MAX_VALUE);
        fadeHead.next = fadeTail; // 初始化链表
        fadeTail.prev = fadeHead;

        // 读取输入大小
        int n = sc.nextInt();
        int arr[][] =  new int[n][2];
        NodeAss23[] arr1 = new NodeAss23[n];
        NodeAss23[] arr2 = new NodeAss23[n];
        int[] result = new int[n]; // 存储最小差值的数组

        // 读取数组元素
        for (int i = 0; i < n; i++) {
            arr[i][0]= sc.nextInt();
            arr[i][1]= i;
            arr1[i] = new NodeAss23(i,arr[i][0]); // 创建新的 Node 实例
        }

        // 排序数组
        mergeSort(arr,0,n-1);
        int match[]=new int[n];
        for (int i = 0; i < n; i++) {
           match[i]= arr[i][1];
        }
        System.out.println(Arrays.toString(match));
        // 创建双向链表
        for (int i = 0; i < n; i++) {
            arr2[i]=new NodeAss23(i,arr[i][0]);
        }
        arr2[0].prev=fadeHead;
        arr2[n-1].next=fadeTail;
        for (int i = 0; i < n-1; i++) {
            arr2[i].next=arr2[i+1];
            arr2[i+1].prev=arr2[i];
        }
        for (int i = 0; i < n-1; i++) {
            if (Math.abs(arr2[i].value-arr2[i].prev.value)<=Math.abs(arr2[i].value-arr2[i].next.value)){
                out.print(Math.abs(arr2[i].value-arr2[i].prev.value)+" ");
            }else {
                out.print(Math.abs(arr2[i].value-arr2[i].next.value)+" ");
            }
            arr2[i].next=arr2[i+1].next;
            arr2[i+1].prev=arr2[i].prev;
        }


        // 输出结果
        out.close();
    }

    // 归并排序
    public static int[][] mergeSortWithPositions(int[] arr) {
        // 创建一个二维数组，存储位置和数值
        int[][] indexedArray = new int[arr.length][2];

        // 初始化二维数组
        for (int i = 0; i < arr.length; i++) {
            indexedArray[i][0] = i; // 存储原始位置
            indexedArray[i][1] = arr[i]; // 存储对应的数值
        }

        // 执行归并排序
        mergeSort(indexedArray, 0, indexedArray.length - 1);

        return indexedArray; // 返回排序后的二维数组
    }

    private static void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // 递归排序左右两半
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // 合并排序结果
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[][] arr, int left, int mid, int right) {
        // 创建临时数组
        int[][] temp = new int[right - left + 1][2];
        int i = left; // 左边数组的起始索引
        int j = mid + 1; // 右边数组的起始索引
        int k = 0; // 临时数组的索引

        // 合并两个部分
        while (i <= mid && j <= right) {
            if (arr[i][1] <= arr[j][1]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 将剩余的元素复制到临时数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 将临时数组复制回原数组
        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }
}