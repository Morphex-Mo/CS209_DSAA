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
/*
题目描述
Given two arrays A with length n and B with length T. We want to know whether each element in array B is in array A or not.



Since the input is large, you may need fast I/O (in Java). Java Faster I/O is shown via following links: https://pastebin.ubuntu.com/p/zBd3g4j366/

输入
The 1st line is a positive integer n
 (n≤106)

The 2nd line contains n
 integers: a1,a2...an.For each ai,0≤ai≤105

The 3rd line contains a positive integer T(T≤106)

The 4th line contains T
 integers b1,b2,...bT.For each bi,0≤bi≤105

输出
For each element in B
, print "yes" (in a single line, without quotes) if it is in A
, otherwise print "no"
样例输入
4
2 3 9999 1
2
3 99
样例输出
yes
no
提示

Note that the integer value ranges are different in Problem 1 and 2.
 */

