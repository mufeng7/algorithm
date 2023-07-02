package binarysearch;

import java.util.*;


/**
 * 二分答案
 * 分的糖果数量（x） n个孩子（y），寻找右边界
 */

public class candy {

    static int MAXN = 1000010;
    static int[] prime = new int[MAXN];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int left = 1, right = a + b;
            while (left < right){
                int mid = left + (right - left) / 2;
                if(check11(mid,n,a,b)){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            System.out.println(left - 1);
        }

    }

    private static boolean check11(int mid, int n, int a, int b) {
        int cnt = 0;
        while (a > 0){
            if (a < mid) {
                break;
            }
            a -= mid;
            cnt++;
        }
        while (b > 0){
            if (b < mid) {
                break;
            }
            b -= mid;
            cnt++;
        }
        return cnt >= n;
    }


}