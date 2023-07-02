package greedy;

import java.util.Scanner;

/**
 * 贪心，先让c去补全a（a事小的那个），最后剩余的 / 2再加到a中就可以计算最后的答案了
 */

public class duck {

    static int MAXN = 1000010;
    static int[] prime = new int[MAXN];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long t = n * (n - 1) / 2;
        long ans = 0;
        ans = (long) Math.pow(2,t);
        System.out.println(ans);
    }

}

