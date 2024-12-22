

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ass24 {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\myx\\Desktop\\test.txt"; // 输入文件路径
        String outputFilePath = System.getProperty("user.home") + "/Desktop/output.txt"; // 输出文件路径

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            int a = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < a; i++) {
                int len = Integer.parseInt(reader.readLine().trim());
                int[] sequence = new int[len];

                String[] values = reader.readLine().trim().split(" ");
                for (int j = 0; j < len; j++) {
                    sequence[j] = Integer.parseInt(values[j]);
                }

                sequence = removeDecreasingNumbers(sequence);
                printArray(sequence, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] removeDecreasingNumbers(int[] sequence) {
        boolean hasDecreasing = true;

        while (hasDecreasing) {
            hasDecreasing = false;
            boolean[] toDelete = new boolean[sequence.length];

            for (int i = 0; i < sequence.length; i++) {
                if (i > 0 && sequence[i - 1] > sequence[i]) {
                    toDelete[i] = true;
                    hasDecreasing = true;
                }
                if (i < sequence.length - 1 && sequence[i] > sequence[i + 1]) {
                    toDelete[i] = true;
                    hasDecreasing = true;
                }
            }

            int resultSize = 0;
            for (boolean mark : toDelete) {
                if (!mark) resultSize++;
            }

            if (resultSize == 0) {
                return new int[0];
            }

            int[] result = new int[resultSize];
            int index = 0;
            for (int i = 0; i < sequence.length; i++) {
                if (!toDelete[i]) {
                    result[index++] = sequence[i];
                }
            }

            sequence = result;
        }

        return sequence;
    }

    public static void printArray(int[] array, BufferedWriter writer) {
        try {
            if (array.length == 0) {
                writer.write("\n");
            } else {
                for (int value : array) {
                    writer.write(value + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}