package tree.edgetree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {

    static HashMap<Integer,Integer>[] road;
    static int n;
    static int ans = 0;
    static boolean[] visited;
    static List<Integer>[] e;
    static String color;
    static int[] sz;   //sz[i]：i为根结点的个数
    static int[] r;    //红色个数
    static int[] g;    //绿色个数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            e[i] = new ArrayList<>();
        }
        for (int v = 2; v <= n; v++){
            int u = sc.nextInt();
            e[u].add(v);
            e[v].add(u);
        }
        color = sc.next();
        color = "#" + color;
        sz = new int[n + 1];
        r = new int[n + 1];
        g = new int[n + 1];
        dfs1(1,0);
        dfs2(1,0);
        System.out.println(ans);

    }

    /**
     * 枚举删掉u，v边是否可以时多彩树
     * @param u
     * @param fa
     */
    private static void dfs2(int u, int fa) {
        for (Integer v : e[u]) {
            if (v == fa){
                continue;
            }
            dfs2(v,u);
            if (r[v] <= 0 || g[v] <= 0 || (sz[v] - r[v] - g[v]) <= 0){
                continue;
            }
            if (r[1] - r[v] <= 0 || g[1] - g[v] <= 0 || (sz[1] - sz[v] - (r[1] - r[v]) - (g[1] - g[v])) <= 0){
                continue;
            }
            ans++;
        }
    }

    /**
     * 求已u为根结点的树有多少结点
     * @param u
     * @param fa
     */
    private static void dfs1(int u, int fa) {
        sz[u]++;
        if (color.charAt(u) == 'R'){
            r[u]++;
        }else if (color.charAt(u) == 'G'){
            g[u]++;
        }
        for (Integer v : e[u]) {
            if (v == fa){
                continue;
            }
            dfs1(v,u);
            sz[u] += sz[v];
            r[u] += r[v];
            g[u] += g[v];
        }
    }

}