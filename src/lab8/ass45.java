package lab8;

import java.io.*;
import java.util.StringTokenizer;

public class ass45 {

    public static void main(String[] args) {
        InputReader a = new InputReader();
        OutputWriter b = new OutputWriter();

        int c = a.nextInt();
        while (c-- > 0) {
            int d = a.nextInt();
            int[] e = new int[d];
            int[] f = new int[d];

            for (int g = 0; g < d; g++) {
                e[g] = a.nextInt();
            }
            for (int h = 0; h < d; h++) {
                f[h] = a.nextInt();
            }

            b.println(calculateMaxPower(d, e, f));
        }

        b.close();
    }

    public static int calculateMaxPower(int d, int[] e, int[] f) {
        int[][] aa = new int[d][2];
        for (int g = 0; g < d; g++) {
            aa[g][0] = e[g];
            aa[g][1] = f[g];
        }

        sortParticipants(aa, 0, d - 1);

        int[] bb = new int[d + 1];
        int cc = 0;

        for (int g = 0; g < d; g++) {
            int power = aa[g][0];
            int deadline = aa[g][1];

            if (cc < deadline) {
                cc++;
                addToHeap(bb, power, cc);
            } else if (cc > 0 && bb[1] < power) {
                removeFromHeap(bb, cc);
                addToHeap(bb, power, cc);
            }
        }

        int totalPower = 0;
        for (int g = 1; g <= cc; g++) {
            totalPower += bb[g];
        }

        return totalPower;
    }

    private static void addToHeap(int[] bb, int value, int size) {
        bb[size] = value;
        int currentIndex = size;

        while (currentIndex > 1 && bb[currentIndex] < bb[currentIndex / 2]) {
            swap(bb, currentIndex, currentIndex / 2);
            currentIndex /= 2;
        }
    }

    private static void removeFromHeap(int[] bb, int size) {
        bb[1] = bb[size];
        int currentIndex = 1;

        while (true) {
            int smallestIndex = currentIndex;
            int leftChild = 2 * currentIndex;
            int rightChild = 2 * currentIndex + 1;

            if (leftChild < size && bb[leftChild] < bb[smallestIndex]) {
                smallestIndex = leftChild;
            }
            if (rightChild < size && bb[rightChild] < bb[smallestIndex]) {
                smallestIndex = rightChild;
            }

            if (smallestIndex != currentIndex) {
                swap(bb, currentIndex, smallestIndex);
                currentIndex = smallestIndex;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] bb, int i, int j) {
        int temp = bb[i];
        bb[i] = bb[j];
        bb[j] = temp;
    }

    private static void sortParticipants(int[][] aa, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            sortParticipants(aa, left, mid);
            sortParticipants(aa, mid + 1, right);

            merge(aa, left, mid, right);
        }
    }

    private static void merge(int[][] aa, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[][] leftArray = new int[leftSize][2];
        int[][] rightArray = new int[rightSize][2];

        for (int g = 0; g < leftSize; ++g) {
            leftArray[g][0] = aa[left + g][0];
            leftArray[g][1] = aa[left + g][1];
        }
        for (int g = 0; g < rightSize; ++g) {
            rightArray[g][0] = aa[mid + 1 + g][0];
            rightArray[g][1] = aa[mid + 1 + g][1];
        }

        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i][1] < rightArray[j][1] || (leftArray[i][1] == rightArray[j][1] && leftArray[i][0] <= rightArray[j][0])) {
                aa[k][0] = leftArray[i][0];
                aa[k][1] = leftArray[i][1];
                i++;
            } else {
                aa[k][0] = rightArray[j][0];
                aa[k][1] = rightArray[j][1];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            aa[k][0] = leftArray[i][0];
            aa[k][1] = leftArray[i][1];
            i++;
            k++;
        }

        while (j < rightSize) {
            aa[k][0] = rightArray[j][0];
            aa[k][1] = rightArray[j][1];
            j++;
            k++;
        }
    }
}

class InputReader {
    private BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer b = new StringTokenizer("");

    private String readNextLine() {
        try {
            return a.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasMoreTokens() {
        while (!b.hasMoreTokens()) {
            String nextLine = readNextLine();
            if (nextLine == null) {
                return false;
            }
            b = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        b = new StringTokenizer("");
        return readNextLine();
    }

    public String next() {
        hasMoreTokens();
        return b.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class OutputWriter implements Closeable {
    private BufferedWriter a = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            a.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            a.write(object.toString());
            a.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            a.close();
        } catch (IOException e) {
            return;
        }
    }
}