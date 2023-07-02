package greedy;

import java.util.*;


/**
 * 如果可以分为两块，则证明所有值异或后的值为0.因为一部分异或起来与另一部分的异或值相等
 * 因为两部分都是可以异或为0，则只需减去最小的那个部分
 */

public class candy {

    static int MAXN = 1000010;
    static int[] prime = new int[MAXN];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            min = Math.min(min,nums[i]);
            sum += nums[i];
        }
        int t = 0;
        for (int i = 0; i < n; i++) {
            t ^= nums[i];
        }
        if (t != 0){
            System.out.println("NO");
        }else {
            System.out.println(sum - min);
        }

    }


}
