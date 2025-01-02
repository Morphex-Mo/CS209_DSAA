package bonuslab;

import java.util.Scanner;

class MyStack<T> {
    private Node<T> top;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class TreeNode {
    char value;
    TreeNode left, right;

    TreeNode(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class X {

    public static TreeNode buildTree(String prefix) {
        MyStack<TreeNode> stack = new MyStack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            if (Character.isLetter(ch)) {
                stack.push(new TreeNode(ch));
            } else {
                TreeNode node = new TreeNode(ch);
                node.left = stack.pop();
                node.right = stack.pop();
                stack.push(node);
            }
        }

        return stack.pop();
    }

    public static String inorderTraversal(TreeNode node) {
        if (node == null) return "";
        String left = inorderTraversal(node.left);
        String right = inorderTraversal(node.right);

        if (!left.isEmpty() || !right.isEmpty()) {
            return "(" + left + node.value + right + ")";
        }
        return String.valueOf(node.value);
    }

    public static String preorderTraversal(TreeNode node) {
        if (node == null) return "";
        return node.value + preorderTraversal(node.left) + preorderTraversal(node.right);
    }

    public static String postorderTraversal(TreeNode node) {
        if (node == null) return "";
        return postorderTraversal(node.left) + postorderTraversal(node.right) + node.value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String cleanedInput = input.replaceAll("[()]", "").replaceAll(",", "");

        TreeNode root = buildTree(cleanedInput);

        String inorderResult = inorderTraversal(root);
        String preorderResult = preorderTraversal(root);
        String postorderResult = postorderTraversal(root);

        System.out.println(inorderResult);
        System.out.println(preorderResult);
        System.out.println(postorderResult);

        scanner.close();
    }
}