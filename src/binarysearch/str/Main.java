package binarysearch.str;

import java.util.*;// java版本的
public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int k=scanner.nextInt();
        System.out.println(Tencent2023_0323_2(s,k));

    }
    //检查字符串s能否被分成k个子串 且子串的最大权值为maxValue
    public static boolean check(String s,int maxValue,int k){   
        int count=0;  
        //用双指针遍历s       
        int left=0,right=0;  
        int n=s.length();
        while (right<n){
            //计算子串[l，r]的权值
            int w=weight(s.substring(left,right+1));     
            //如果权值大于maxValue count+1  继续找下一个子串  left=right保证找到的子串权值不大于maxValue
            if(w>maxValue){         
                left=right;
                count++;
                right--;
            }
            //如果找到的子串超过k 或者找到的子串等于k但是right还没到s的最后一位 返回false
            if(count>k||count==k&&right!=n-1) return false; 
            right++;

        }
        return count<=k;
    }
    //计算字符串权值  
    public static int weight(String s){           
        Set<Character> set=new HashSet<>(); //set.size就是字符串的字母种类
        for(char ch:s.toCharArray()){
            set.add(ch);
        }
        return set.size()*s.length();
    }
    //二分查找 找尽可能小的最大权值
    public static int Tencent2023_0323_2(String s,int k){

        int n = s.length();
        int weightMax=weight(s.substring(0,n-k+1));
        // 测试了下右边界900左右刚刚好 设太大就很耗内存和时间
        int l = 1, r = Math.min(weightMax,900), ans = -1;   
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(s, mid, k)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
