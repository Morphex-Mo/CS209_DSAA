package lab5;


import java.util.Scanner;

public class ass28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = scanner.nextInt();
            }

            // 创建一个数组 arr2 存储历史最小值
            int[] arr2 = new int[n];
            int min = Integer.MAX_VALUE;

            // 从右往左遍历 arr1，找到历史最小值
            for (int i = n - 1; i >= 0; i--) {
                if (arr1[i] < min) {
                    min = arr1[i];
                }
                arr2[i] = min;
            }

            // 创建栈 arr3
            int[] arr3 = new int[n];
            int stackTop = 0;  // 栈顶指针
            int resultIndex = 0; // 结果数组索引
            int[] result = new int[n];

            // 从第二个元素开始处理
            for (int i = 0; i < n; i++) {
//                System.out.println("zuixiaozhi "+arr2[i]);
//                System.out.println("dangqianpai "+arr1[i]);
//                System.out.println("zhandingpai "+arr3[stackTop]);
                // 比较栈顶与 arr2[i] 的大小关系
                if (arr1[i]>arr2[i]){
                    arr3[stackTop++]=arr1[i];
//                    System.out.println(Arrays.toString(arr3));
                }else {
                    result[resultIndex++]=arr1[i];
                }
                ; // 将当前元素放入栈
            }
            stackTop--;
            for (int i = resultIndex; i < n; i++) {
                result[i]=arr3[stackTop--];
            }


            // 处理栈中的剩余元素
//            while (stackTop >= 0) {
//                result[resultIndex++] = arr3[stackTop--];
//            }

            // 打印结果

            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }
}