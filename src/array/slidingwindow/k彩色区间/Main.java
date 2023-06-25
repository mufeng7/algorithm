package array.slidingwindow.k彩色区间;

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
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int left = 0, right = 0;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while (right < n){
            int c = nums[right++];
            map.put(c,map.getOrDefault(c,0) + 1);
            while (left < right && map.size() > k){
                ans = Math.max(ans,right - left - 1);
                int d = nums[left++];
                int cnt = map.get(d);
                if (cnt == 1){
                    map.remove(d);
                }else {
                    map.put(d,cnt - 1);
                }
            }
            ans = Math.max(ans,right - left);
        }
        System.out.println(ans);
    }

}
