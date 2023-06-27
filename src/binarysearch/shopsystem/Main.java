package binarysearch.shopsystem;

import java.util.List;
import java.util.Scanner;

/**
 * 找出对应关系
 */
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
        a = new long[100010];
        int n = 0;
        while (sc.hasNext()){
            a[++n] = sc.nextLong();
        }
        th = a[n];
        long sum = 0;
        for (int i = 1; i < n; i++){
            sum += a[i];
        }
        if (sum <= th){
            System.out.println(-1);
            return;
        }
        int left = 0, right = 100001;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (check01(mid,n) <= th){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        System.out.println(right - 1);
    }

    private static long check01(long mid,int n) {
        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += Math.min(a[i],mid);
        }
        return sum;
    }

}

