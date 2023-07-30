package leetcode.efen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class four {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < n || j < m){
            if (nums1[i] < nums2[j]){
                list.add(nums1[i]);
                i++;
            }else {
                list.add(nums2[j]);
                j++;
            }
        }
        if (i == n){
            while (j < m)   list.add(nums2[j++]);
        }
        if (j == m){
            while (j < n)   list.add(nums1[i++]);
        }
        if (list.size() % 2 == 1){
            double a = list.get(list.size() / 2);
            return a;
        }else {
            double a = list.get(list.size() - 1);
            double b = list.get(list.size());
            return (a + b) / 2.0;
        }
    }


    public static void main(String[] args) {
        four f = new four();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        f.findMedianSortedArrays(nums1,nums2);
    }
}
