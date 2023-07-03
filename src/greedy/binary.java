package greedy;

import java.util.*;


/**
 * 贪心，考虑数位，当所有数位都相等就是每个数都一样
 */

public class binary {

    static int MAXN = 1000010;
    static int[] prime = new int[MAXN];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] arr = new int[32];
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            String s = Integer.toBinaryString(a);
            StringBuilder sb = new StringBuilder(s);
            s = sb.reverse().toString();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1'){
                    arr[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                ans += Math.min(arr[i],n - arr[i]);
            }
        }
        System.out.println(ans);
    }

}
/**
 * 给出的答案
 */


/**
 *import java.util.*;
 *
 *
 * public class Main {
 *
 *     static List<Integer>[] e;
 *     static int[][] count = new int[35][2];  //count[i][0]:第i为有多少个0
 *     public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         int n = sc.nextInt();
 *         for (int i = 0; i < n; i++) {
 *             long a = sc.nextLong();
 *             for (int j = 0; j < 34; j++) {
 *                 int v = (int) ((a >> j) & 1);
 *                 count[j][v]++;
 *             }
 *         }
 *         int ans = 0;
 *         for (int i = 0; i < 34; i++) {
 *             ans += Math.min(count[i][0],count[i][1]);
 *         }
 *         System.out.println(ans);
 *     }
 * }x
 */