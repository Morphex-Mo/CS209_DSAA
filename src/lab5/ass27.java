package lab5;

import java.util.Scanner;

public class ass27 {

    static class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    static class Deque {
        Node fadeHead;
        Node fadeTail;

        void add(int value, boolean toFront) {
            Node node = new Node(value);
            if (toFront) {
                if (fadeHead != null) {
                    node.next = fadeHead;
                    fadeHead.prev = node;
                    fadeHead = node;
                } else {
                    fadeHead = fadeTail = node;
                }
            } else {
                if (fadeTail != null) {
                    node.prev = fadeTail;
                    fadeTail.next = node;
                    fadeTail = node;
                } else {
                    fadeHead = fadeTail = node;
                }
            }
        }

        int remove(boolean fromFront) {
            if (fromFront) {
                if (fadeHead == null) return -1;
                int value = fadeHead.value;
                fadeHead = fadeHead.next;
                if (fadeHead != null) fadeHead.prev = null;
                else fadeTail = null;
                return value;
            } else {
                if (fadeTail == null) return -1;
                int value = fadeTail.value;
                fadeTail = fadeTail.prev;
                if (fadeTail != null) fadeTail.next = null;
                else fadeHead = null;
                return value;
            }
        }

        void connect(Deque deque, boolean reverse) {
            if (reverse) {
                deque.reverse();
            }
            if (fadeTail == null) {
                fadeHead = deque.fadeHead;
                fadeTail = deque.fadeTail;
            } else if (deque.fadeHead != null) {
                fadeTail.next = deque.fadeHead;
                deque.fadeHead.prev = fadeTail;
                fadeTail = deque.fadeTail;
            }
            deque.clear();
        }

        void reverse() {
            Node current = fadeHead;
            Node temp;
            while (current != null) {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current = current.prev;
            }
            Node change = fadeHead;
            fadeHead = fadeTail;
            fadeTail = change;
        }

        void clear() {
            fadeHead = null;
            fadeTail = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            Deque[] deques = new Deque[n + 1];

            for (int i = 1; i <= n; i++) {
                deques[i] = new Deque();
            }

            for (int i = 0; i < q; i++) {
                int type = sc.nextInt();
                switch (type) {
                    case 1: {
                        int u = sc.nextInt();
                        int w = sc.nextInt();
                        int val = sc.nextInt();
                        if (w == 0) {
                            deques[u].add(val,true);
                        } else {
                            deques[u].add(val,false);
                        }
                        break;
                    }
                    case 2: {
                        int u = sc.nextInt();
                        int w = sc.nextInt();
                        int result = deques[u].remove(w == 0);
                        System.out.println(result);
                        break;
                    }
                    case 3: {
                        int u = sc.nextInt();
                        int v = sc.nextInt();
                        int w = sc.nextInt();
                        deques[u].connect(deques[v], w == 1);
                        break;
                    }
                    default:
                        break;
                }
            }
        }
        sc.close();
    }
}