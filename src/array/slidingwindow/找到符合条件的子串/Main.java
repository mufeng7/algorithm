package array.slidingwindow.找到符合条件的子串;

import java.util.*;

/**
 * P1098. 2023.03.21-第二题-红白染色树
 */
public class Main {


    static List<Integer>[] e;
    static String color;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        color = sc.next();
        color = "#" + color;
        e = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            e[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            e[u].add(v);
            e[v].add(u);
        }
        System.out.println(Math.min(dfs(1,0,'R'),dfs(1,0,'W')));
    }

    /**
     * 已u的颜色为c时，需要修改的颜色个数
     * @param u
     * @param fa
     * @param c
     * @return
     */
    private static int dfs(int u, int fa, char c) {
        int res = 0;
        if (color.charAt(u) != c){    //前序遍历的位置
            res++;
        }
        for (Integer v : e[u]) {
            if (v == fa){
                continue;
            }
            res += dfs(v,u,c == 'R' ? 'W' : 'R');
            //后序遍历的位置
        }
        return res;
    }

}
