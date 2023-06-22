package array.doublepointer;

import java.util.Scanner;

/**
 * 1到i的排列中，最大位置减去最小位置 + 1= 1到i的个数
 */
public class Main {
    static char[][] chs;
    static boolean[][] visited;
    static int N = 200010;
    static int[] pos = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++){
                int a = sc.nextInt();
                pos[a] = i;
            }
            int min = Integer.MAX_VALUE, max = 0;
            int ans = 0;
            for (int i = 1; i <= n; i++){
                min = Math.min(min,pos[i]);
                max = Math.max(max,pos[i]);
                if (max - min + 1 == i){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

}