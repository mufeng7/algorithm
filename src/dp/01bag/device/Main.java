package 01bag.device

import java.util.List;
import java.util.Scanner;


public class Main {


    static List<Integer>[] e;
    static int MOD = (int) (1e9 + 7);
    static int[][] count = new int[35][2];  //count[i][0]:第i为有多少个0
    static int N;
    static int[][] s;
    static long[] a;
    static long th;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int[] dp = new int[p + 1];
        for (int i = 0; i < n; i++) {
            for (int j = p; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
        }
        System.out.println(dp[p]);
    }


}