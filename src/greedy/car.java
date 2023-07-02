package greedy;

import java.util.*;


/**
 * 先把速度排好序（递增），再排序位置（递增），最后把位置填进去
 * 因为最后的输入顺序，最后还需要对id再排一次序
 */

public class car {

    static int MAXN = 1000010;
    static int[] prime = new int[MAXN];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] poses = new int[n];
        node[] nodes = new node[n];
        for (int i = 0; i < n; i++) {
            poses[i] = sc.nextInt();
            int a = sc.nextInt();
            nodes[i] = new node(i,a);
        }
        Arrays.sort(poses);
        Arrays.sort(nodes, (o1, o2) -> o1.v - o2.v);
        for (int i = 0; i < n; i++) {
            nodes[i].pos = poses[i];
        }
        Arrays.sort(nodes, (o1, o2) -> o1.id - o2.id);
        for (int i = 0; i < n; i++) {
            System.out.println(nodes[i].pos + " " + nodes[i].v);
        }
    }


}

class node{
    int id,pos,v;

    public node(int id,int v) {
        this.id = id;
        this.v = v;
    }
}
