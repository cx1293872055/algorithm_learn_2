package DP;

public class MEMOIZAED_CUT_ROD {

    public static void main(String[] args) {
        int[] p = {0,1,5,8,9,10,17,17,20,24,30};
        System.out.println(dp1(p,5));
    }
    public static int dp(int[] p, int n) {
        int[] a = new int[n+1];
        a[0] = 0;
        for (int j = 1; j <= n; j++) {
            a[j] = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                a[j] = Math.max(a[j],p[i]+a[j-i]);
            }
            System.out.println(a[j]);
        }
        return a[n];
    }
    public static int dp1(int[] p, int n) {
        int[] a = new int[n + 1];
        int[] s = new int[n + 1];
        a[0] = 0;
        for (int j = 1; j <= n; j++) {
            a[j] = Integer.MIN_VALUE;
            int q = a[j];
            for (int i = 1; i <= j; i++) {
                if (q < p[i] + a[j - i]) {
                     q= p[i]+a[j-i];
                    s[j] = i;
                }
            }
            a[j] = q;
        }
        for (int i = 0; i < n + 1; i++) {
            System.out.println(a[i]+"----"+s[i]);
        }
            return a[n];
    }
}
