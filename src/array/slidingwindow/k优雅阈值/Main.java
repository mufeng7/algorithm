package array.slidingwindow.k优雅阈值;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1到i的排列中，最大位置减去最小位置 + 1= 1到i的个数
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        while (right < n){
            int c = nums[right++];
            map.put(c,map.getOrDefault(c,0) + 1);
            while (left < right && map.get(c) >= x){
                ans += (n - right + 1);
                int d = nums[left++];
                int cnt = map.get(d);
                map.put(d,cnt - 1);
            }
        }
        System.out.println(ans);
    }

}
