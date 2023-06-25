package tree.longestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2023.3.5-最长的通讯路径
 * dp[i][0]：表示已i为根节点的子树中，且与i的连边为蓝色的所有陆家嘴最长的
 * dp[i][1]：表示已i为根节点的子树中，且与i的连边为红色的所有陆家嘴最长的
 * max(dp[i][0] + dp[i][1])
 */

public class Main {
    static class Node{
        int first;
        int second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


    static List<Node>[] e;
    static String color;
    static int maxn = 0;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        e = new List[n + 1];
        dp = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            e[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            char c = sc.next().charAt(0);
            int t = c == 'R' ? 0 : 1;
            e[u].add(new Node(v,t));
            e[v].add(new Node(u,t));
        }
        dfs(1,0);
        System.out.println(maxn);
    }

    private static void dfs(int u, int fa) {
        if (e[u].size() == 1 && e[u].get(0).first == fa)  return;
        for (Node node : e[u]) {
            int v = node.first;
            if (v == fa){
                continue;
            }
            dfs(v,u);
            int col = node.second;
            dp[u][col] = Math.max(dp[u][col],dp[v][col ^ 1] + 1);
            maxn = Math.max(maxn,dp[u][0] + dp[u][1]);
        }
    }


}
