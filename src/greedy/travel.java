package greedy;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

/**
 * 求导求最值，注意：那个才是变量，那些事参数
 */
public class travel {

    static List<Integer>[] e;
    static String s;
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00000");
        Scanner sc= new Scanner(System.in);
        int v = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        double a = x * x;
        double b = 2 * v * x;
        double c = v * v - x * y;
        double ans = (y * 1.0) / v;
        if (b * b - 4 * a * c >= 0){
            double t = (-b + Math.sqrt(b * b - 4 * a * c)) / (2.0 * a);
            double tt = (-b - Math.sqrt(b * b - 4 * a * c)) / (2.0 * a);
            if (t > 0){
                ans = Math.min(ans,t + y / (v + t * x));

            }
            if (tt > 0) ans = Math.min(ans,tt + y / (v + tt * x));
        }
        System.out.println(df.format(ans));
    }

}