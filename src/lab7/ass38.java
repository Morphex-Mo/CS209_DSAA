package lab7;

import lab3.QuickR;
import lab3.QuickW;

import java.util.ArrayList;


public class ass38 {
    public static void main(String[] args) {
        QuickR sc=new QuickR();
        QuickW out=new QuickW();
        int t= sc.nextInt();
        for (int i = 0; i < t; i++) {
            int N= sc.nextInt();
            nodeAss38[] nodeAss38s=new nodeAss38[N+1];
            for (int j = 0; j < N+1; j++) {
                nodeAss38s[j]=new nodeAss38(j);
            }
            for (int j = 1; j < N; j++) {
                int ai= sc.nextInt();
                nodeAss38s[ai].children.add(nodeAss38s[j+1]);
            }
            nodeAss38[] queue=new nodeAss38[N+1];
            int front=0;
            int rear=0;
            queue[rear++]=nodeAss38s[1];
            while (front<rear){
                nodeAss38 h=queue[front++];
                out.print(h.val+" ");
                for (int j = 0; j < h.children.size(); j++) {
                    queue[rear++]=h.children.get(j);
                }
            }
            out.println("");
        }
        out.close();
    }
}
class nodeAss38{
    ArrayList<nodeAss38> children=new ArrayList<>();
    int val;
    public  nodeAss38(int val){
        this.val=val;
    }
}