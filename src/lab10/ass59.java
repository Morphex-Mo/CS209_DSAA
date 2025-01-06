package lab10;

import java.util.ArrayList;
import java.util.Scanner;

public class ass59 {
    static int n, m, S;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> sccGraph;
    static int[] low, dfn, sccId;
    static boolean[] inStack;
    static MyStack stack;
    static int index, sccCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        S = scanner.nextInt() - 1; // 0-based index

        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1; // 0-based index
            int v = scanner.nextInt() - 1; // 0-based index
            graph.get(u).add(v);
        }

        low = new int[n];
        dfn = new int[n];
        sccId = new int[n];
        inStack = new boolean[n];
        stack = new MyStack(n);
        index = 0;
        sccCount = 0;

        // Find Strongly Connected Components
        for (int i = 0; i < n; i++) {
            if (dfn[i] == 0) {
                tarjan(i);
            }
        }

        // Create the SCC graph
        sccGraph = new ArrayList<>(sccCount);
        for (int i = 0; i < sccCount; i++) {
            sccGraph.add(new ArrayList<>());
        }

        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                if (sccId[u] != sccId[v]) {
                    sccGraph.get(sccId[u]).add(sccId[v]);
                }
            }
        }

        // Count the number of source SCCs
        boolean[] hasIncoming = new boolean[sccCount];
        for (int u = 0; u < sccCount; u++) {
            for (int v : sccGraph.get(u)) {
                hasIncoming[v] = true;
            }
        }

        int sourceCount = 0;
        int startScc = sccId[S];
        for (int i = 0; i < sccCount; i++) {
            if (!hasIncoming[i] && i != startScc) {
                sourceCount++;
            }
        }

        System.out.println(sourceCount);
    }

    static void tarjan(int u) {
        low[u] = dfn[u] = ++index;
        stack.push(u);
        inStack[u] = true;

        for (int v : graph.get(u)) {
            if (dfn[v] == 0) {
                tarjan(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                low[u] = Math.min(low[u], dfn[v]);
            }
        }

        if (low[u] == dfn[u]) {
            int v;
            do {
                v = stack.pop();
                inStack[v] = false;
                sccId[v] = sccCount;
            } while (v != u);
            sccCount++;
        }
    }
}

class MyStack {
    private int[] data;
    private int top;

    public MyStack(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        data[++top] = value;
    }

    public int pop() {
        return data[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}