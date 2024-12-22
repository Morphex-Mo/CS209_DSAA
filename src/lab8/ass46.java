package lab8;

import java.util.ArrayList;
import java.util.Scanner;

public class ass46 {
    private static long last_ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong(); // 总时间
        long k = scanner.nextLong(); // k 值
        last_ans = scanner.nextLong(); // 初始 last_ans

        // 用于存储小顶堆的元素
        ArrayList<Long> minHeap = new ArrayList<>();

        for (long i = 1; i <= t; i++) {
            // 计算当前输入的数据
            long currentNumber = i + sumOfDigits(i + last_ans) + last_ans;

            // 维护小顶堆
            addToMinHeap(minHeap, currentNumber, k);

            // 每 100 秒输出一次
            if (i % 100 == 0) {
                // 输出堆顶元素，即当前的 k-th 最大值
                last_ans = minHeap.get(0);
                System.out.print(last_ans + " ");
            }
        }
    }

    // 计算数字 n 的各位数字和
    private static long sumOfDigits(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // 将元素添加到小顶堆
    private static void addToMinHeap(ArrayList<Long> heap, long num, long k) {
        if (heap.size() < k) {
            heap.add(num);
            siftUp(heap, heap.size() - 1);
        } else if (num > heap.get(0)) {
            heap.set(0, num);
            siftDown(heap, 0);
        }
    }

    // 上移调整堆
    private static void siftUp(ArrayList<Long> heap, int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) < heap.get(parentIndex)) {
                swap(heap, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // 下移调整堆
    private static void siftDown(ArrayList<Long> heap, int index) {
        int size = heap.size();
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < size && heap.get(leftChild) < heap.get(smallest)) {
                smallest = leftChild;
            }
            if (rightChild < size && heap.get(rightChild) < heap.get(smallest)) {
                smallest = rightChild;
            }
            if (smallest != index) {
                swap(heap, index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    // 手动交换数组元素
    private static void swap(ArrayList<Long> heap, int i, int j) {
        long temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}