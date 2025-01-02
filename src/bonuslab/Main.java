package bonuslab;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class QuickR {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QuickW implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}

class MonotonicQueue {
    public Node head;
    public Node tail;

    public static class Node {
        int value;
        int index;
        Node next;
        Node prev;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public MonotonicQueue() {
        head = null;
        tail = null;
    }

    public void push(int index, int value) {
        // 添加新元素时，移除队列中所有小于等于当前值的元素
        while (tail != null && value >= tail.value) {
            tail = tail.prev;
        }

        Node newNode = new Node(value, index);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;

        // 更新尾指针
        if (tail == null) {
            tail = head;
        }
    }

    public int[] getNextGreater() {
        if (head != null) {
            return new int[]{head.value, head.index};
        }
        return new int[]{-1, -1};
    }

    public void pop(int index) {
        Node current = head;
        while (current != null) {
            if (current.index == index) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    // 公共方法获取头部
    public Node getHead() {
        return head;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        QuickR reader = new QuickR();
        QuickW writer = new QuickW();

        int T = reader.nextInt();
        while (T-- > 0) {
            int n = reader.nextInt();
            int[] indexes = new int[n];
            for (int i = 0; i < n; i++) {
                indexes[i] = reader.nextInt();
            }

            // 使用自定义的单调队列找出下一个更大元素的索引
            int[] nextGreaterDays = new int[n];
            MonotonicQueue queue = new MonotonicQueue();

            // 从后往前遍历
            for (int i = n - 1; i >= 0; i--) {
                while (!queue.isEmpty() && queue.getHead().value <= indexes[i]) {
                    queue.pop(queue.getHead().index); // 移除小于等于当前值的元素
                }
                nextGreaterDays[i] = queue.isEmpty() ? -1 : queue.getHead().index - i; // 计算天数差
                queue.push(i, indexes[i]); // 将当前元素推入队列
            }

            int q = reader.nextInt();
            while (q-- > 0) {
                int k = reader.nextInt() - 1;
                writer.println(nextGreaterDays[k]);
            }
        }

        writer.close();
    }
}