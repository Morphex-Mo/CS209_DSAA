package lab4;

import java.util.Scanner;

class NodeAss22 {
    char value;
    NodeAss22 prev;
    NodeAss22 next;

    public NodeAss22(char value) {
        this.value = value;
    }
}

class VinuxEditor {
    private NodeAss22 head;
    private NodeAss22 tail;
    private NodeAss22 cursor;

    public VinuxEditor() {
        head = new NodeAss22('\0'); // Dummy head
        tail = new NodeAss22('\0'); // Dummy tail
        head.next = tail;
        tail.prev = head;
        cursor = head; // Start cursor at head
    }

    public void insert(char c) {
        NodeAss22 newNodeAss22 = new NodeAss22(c);
        newNodeAss22.prev = cursor;
        newNodeAss22.next = cursor.next;
        cursor.next.prev = newNodeAss22;
        cursor.next = newNodeAss22;
        cursor = newNodeAss22;
    }

    public void delete() {
        if (cursor.next != tail) {
            NodeAss22 toDelete = cursor.next;
            cursor.next = toDelete.next;
            toDelete.next.prev = cursor;
        }
    }

    public void moveLeft() {
        if (cursor != head) {
            cursor = cursor.prev;
        }
    }

    public void moveRight() {
        if (cursor.next != tail) {
            cursor = cursor.next;
        }
    }

    public void moveToHead() {
        cursor = head;
    }

    public void replace(char c) {
        if (cursor.next == tail) {
            NodeAss22 nodeAss22 = new NodeAss22(c);
            nodeAss22.prev = cursor;
            nodeAss22.next = cursor.next;
            cursor.next.prev = nodeAss22;
            cursor.next = nodeAss22;
          //  cursor = node;
        } else cursor.next.value = c;
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        NodeAss22 current = head.next;
        while (current != tail) {
            result.append(current.value);
            current = current.next;
        }
        return result.toString();
    }
}

public class ass22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String testCases[] = new String[a];
        for (int i = 0; i < a; i++) {
            int b = sc.nextInt();
            testCases[i] = sc.next();
        }
        for (String commands : testCases) {
            VinuxEditor editor = new VinuxEditor();
            for (int i = 0; i < commands.length(); i++) {
                char command = commands.charAt(i);
                if (command == 'r') {
                    i++;
                    if (i < commands.length()) {
                        char nextChar = commands.charAt(i);
                        editor.replace(nextChar);
                    }
                } else if (command == 'I') {
                    editor.moveToHead();
                } else if (command == 'H') {
                    editor.moveLeft();
                } else if (command == 'L') {
                    editor.moveRight();
                } else if (command == 'x') {
                    editor.delete();
                } else {
                    editor.insert(command);
                }
//                System.out.println(editor.getResult());
            }
            System.out.print(editor.getResult());
            System.out.println();
        }
    }
}