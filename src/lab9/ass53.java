package lab9;

import java.util.Scanner;

public class ass53 {
    static int maxSum;
    static int N, M;
    static int[][] matrix;
    static boolean[][] selected;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            N = scanner.nextInt(); // Rows
            M = scanner.nextInt(); // Columns
            matrix = new int[N][M];
            selected = new boolean[N][M]; // Selection tracking

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            maxSum = 0;
            // Start DFS from the first cell
            dfs(0, 0, 0);
            System.out.println(maxSum);
        }

        scanner.close();
    }

    static void dfs(int row, int col, int currentSum) {
        // Update the maximum sum found
        maxSum = Math.max(maxSum, currentSum);

        // Iterate over the remaining cells
        for (int i = row; i < N; i++) {
            for (int j = (i == row ? col : 0); j < M; j++) {
                if (!selected[i][j]) { // If the cell is not selected
                    // Check if we can select this cell
                    if (canSelect(i, j)) {
                        // Select the current cell
                        selected[i][j] = true;
                        currentSum += matrix[i][j];

                        // Continue DFS to the next cell
                        dfs(i, j + 1, currentSum);

                        // Backtrack: deselect the current cell and update the sum
                        selected[i][j] = false;
                        currentSum -= matrix[i][j];
                    }
                }
            }
        }
    }

    static boolean canSelect(int row, int col) {
        // Check the 3x3 area around the cell to see if any are selected
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M) {
                    if (selected[newRow][newCol]) {
                        return false; // Cannot select if any adjacent cell is selected
                    }
                }
            }
        }
        return true; // Can select the cell
    }
}