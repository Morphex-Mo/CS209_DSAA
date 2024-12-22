package lab5;

import java.util.Scanner;

public class ass29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 测试用例数量
        for (int t = 1; t <= T; t++) {
            int n = scanner.nextInt(); // 学生数量
            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = scanner.nextInt(); // 输入每个学生的高度
            }

            // 左右伙伴
            int[] leftPartners = new int[n];
            int[] rightPartners = new int[n];

            // 模拟栈来找左伙伴
            int[] stack = new int[n];
            int top = 0; // 栈顶指针
            stack[0]=heights[0];
            int result[]=new int[n];
            for (int i = 0; i < n; i++) {
                // 找左伙伴
                if (stack[top]<heights[i]){
                    result[i]=stack[top];
                    
                }
                stack[i] = i;
            }

            // 清空栈以查找右伙伴
            top = -1; // 重置栈顶指针

            for (int i = n - 1; i >= 0; i--) {
                // 找右伙伴
                while (top >= 0 && heights[stack[top]] < heights[i]) {
                    top--; // 只丢掉比当前学生矮的高度
                }
                // 如果栈不为空，栈顶就是当前学生的右伙伴
                rightPartners[i] = (top >= 0) ? stack[top] + 1 : 0; // 1-based index
                // 将当前学生的索引入栈
                stack[++top] = i;
            }

            // 输出结果
            System.out.println("Case " + t + ":");
            for (int i = 0; i < n; i++) {
                System.out.println(leftPartners[i] + " " + rightPartners[i]);
            }
        }

        scanner.close();
    }
}