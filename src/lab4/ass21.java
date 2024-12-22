package lab4;

import java.util.Scanner;

public class ass21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 测试用例数量
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt(); // 队员数量
            int M = sc.nextInt(); // 交换操作数量

            NodeAss21 dummyHead = new NodeAss21(-1);
            NodeAss21 dummyTail = new NodeAss21(-1);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;

            NodeAss21[] nodes = new NodeAss21[N];

            for (int j = 0; j < N; j++) {
                int id = sc.nextInt();
                nodes[j] = new NodeAss21(id);
                nodes[j].prev = dummyHead;
                dummyHead.next = nodes[j];
                dummyHead = nodes[j];
            }
            dummyHead.next = dummyTail; // 链接最后一个节点到假尾
            dummyTail.prev = nodes[N - 1]; // 链接假尾到最后一个节点
            for (int j = 0; j < N; j++) {
                System.out.print(nodes[j].index+" ");
            }
            // 处理每个交换操作
            for (int j = 0; j < M; j++) {
                int x1 = sc.nextInt(); // 第一个段的开始ID
                int y1 = sc.nextInt(); // 第一个段的结束ID
                int x2 = sc.nextInt(); // 第二个段的开始ID
                int y2 = sc.nextInt(); // 第二个段的结束ID
                int start1=findPosition(x1,nodes);
                int end1=findPosition(y1,nodes);
                int start2=findPosition(x2,nodes);
                int end2=findPosition(y2,nodes);

                // 验证位置

                swap(nodes, start1, end1, start2, end2);
            }

            // 输出最终顺序
            NodeAss21 current = dummyTail.prev; // 从最后一个节点开始
            while (current != dummyHead) {
                System.out.print(current.index + " ");
                current = current.prev; // 移动到前一个节点
            }
            System.out.println();
        }
        sc.close();
    }

    private static int findPosition(int id, NodeAss21[] nodes) {
        int i=0;
        while (id!=nodes[i].index){
            i++;
        }
        return i;
    }

    private static void swap(NodeAss21[] nodes, int x1, int y1, int x2, int y2) {
        // 进行节点交换
        NodeAss21 a = nodes[x1].prev;
        NodeAss21 b=nodes[y1].next;
        NodeAss21 c=nodes[x2].prev;
        NodeAss21 d = nodes[y2].next;
        if (nodes[y1].next==nodes[x2]){
            a.next=nodes[x2];
            nodes[x2].prev=a;
            nodes[y2].next=nodes[x1];
            nodes[x1].prev=nodes[y2];
            nodes[y1].next=d;
            d.prev=nodes[y1];
        }else {
            a.next=nodes[x2];
            nodes[x2].prev=a;
            b.prev=nodes[y2];
            nodes[y2].next=b;
            c.next=nodes[x1];
            nodes[x1].prev=c;
            d.prev=nodes[y1];
            nodes[y1].next=d;
        }
    }
}


class NodeAss21 {
    int index; // 队员ID
    NodeAss21 next; // 指向下一个节点的指针
    NodeAss21 prev; // 指向前一个节点的指针
    public NodeAss21(int index) {
        this.index = index;
        this.next = null;
        this.prev = null;
    }
}