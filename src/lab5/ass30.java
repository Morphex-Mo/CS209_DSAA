package lab5;

import lab3.QuickR;
import lab3.QuickW;

public class ass30 {
    public static void main(String[] args) {
        QuickR input=new QuickR();
        QuickW out=new QuickW();
        int a=input.nextInt();
        int b=input.nextInt();
        int arr[]=new int[b];
        for (int i = 0; i < b; i++) {
            arr[i]=input.nextInt();
        }
        int Max[]=new int[b];
        int Min[]=new int[b];
        int topOfMax=0;
        int topOfMin=0;
        int left=0;
        int right=0;
        int result1=0;
        Max[topOfMax]=arr[0];
        Min[topOfMin]=arr[0];
        while (left<=right&&right<=b-1){
            if (Max[topOfMax]-Min[topOfMin]<=a){
                right++;
                if (Max[topOfMax]>arr[right]){
                    Max[topOfMax++]=arr[right];
                }else Max[topOfMax--]=arr[right]; 


            }else{
                left++;
            }
        }
        out.println(result1);
        out.close();
    }
}
