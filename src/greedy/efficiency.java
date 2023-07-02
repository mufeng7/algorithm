package greedy;

import java.util.*;


/**
 * 贪心，一开始没有机器人，都是原来的0.8，然后一个人多一个机器人会增加2K，其后事1K，1K，1K
 * 选出最大的k个增量
 */

public class efficiency {

    static int MAXN = 1000010;
    static int[] prime = new int[MAXN];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] power = new int[n];
        Integer[] arr = new Integer[n * 4];
        int ans = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = a / 5 * 4;
            ans += b;
            arr[idx] = a / 5;
            arr[idx + 1] = a/ 10;
            arr[idx + 2] = a / 10;
            arr[idx + 3] = a / 10;
            idx += 4;
        }
        Arrays.sort(arr, (a, b) -> (b - a));
        idx = 0;
        while (k-- > 0 && idx < arr.length){
            ans += arr[idx++];
        }
        System.out.println(ans);
    }

}