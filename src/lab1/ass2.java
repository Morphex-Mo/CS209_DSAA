package lab1;

import lab3.QuickR;
import lab3.QuickW;

import java.io.*;
import java.util.*;

public class ass2 {
    public static void main(String[] args) {
        //sample
        QuickR in = new QuickR();
        QuickW out = new QuickW();
        int n = in.nextInt();
        long arrOfA[]=new long[n];
        for (int i = 0; i < n; i++) {
            arrOfA[i]=in.nextLong();
        }
        int T = in.nextInt();
        long arrOfB[]=new long[T];
        for (int i = 0; i < T; i++) {
            arrOfB[i]=in.nextLong();
        }
        int equal[]=new int[arrOfB.length];
        Set<Long> setA = new HashSet<>();
        for (long value : arrOfA) {
            setA.add(value);
        }

        // 检查 arrOfB 中的元素是否在 setA 中
        for (int i = 0; i < arrOfB.length; i++) {
            if (setA.contains(arrOfB[i])) {
                out.println("yes");
            } else {
                out.println("no");
            }
        }
        out.close();
    }
}

