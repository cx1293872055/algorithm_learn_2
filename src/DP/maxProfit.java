package DP;

public class maxProfit {
    public static void main(String[] args) {
        int[] a ={3,3,5,0,0,3,1,4};
        //System.out.println(maxProfit4(a));
        //System.out.println(maxProfit3(a));
        System.out.println(maxProfit55(a));
    }

    public static int maxProfit1(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = prices[0];
        for(int i = 0;i<prices.length;i++){
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        if(prices.length<=0)
            return 0;
        int sum = 0;
        for(int i = 0;i<prices.length-1;i++){
            int mod = prices[i+1]-prices[i];
            if(mod>0){
                sum+=mod;
            }
        }
        return sum;
    }

    public static int maxProfit4(int[] prices) {
        if(prices.length<=0)
            return 0;
        int[][] dp= new int[prices.length+1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for(int i = 1;i<= prices.length;i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
            System.out.println("dp[i][0]="+dp[i][0]+"-----dp[i][1]="+dp[i][1]);
        }
        return dp[prices.length][0];
    }
        public static int maxProfit3(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }
            return dp_i_0;
        }

        public static int maxProfit5(int[] prices) {
            /**
             对于任意一天考虑四个变量:
             fstBuy: 在该天第一次买入股票可获得的最大收益
             fstSell: 在该天第一次卖出股票可获得的最大收益
             secBuy: 在该天第二次买入股票可获得的最大收益
             secSell: 在该天第二次卖出股票可获得的最大收益
             分别对四个变量进行相应的更新, 最后secSell就是最大
             收益值(secSell >= fstSell)
             **/
            int fstBuy = Integer.MIN_VALUE, fstSell = 0;
            int secBuy = Integer.MIN_VALUE, secSell = 0;
            for(int p : prices) {
                fstBuy = Math.max(fstBuy, -p);
                fstSell = Math.max(fstSell, fstBuy + p);
                secBuy = Math.max(secBuy, fstSell - p);
                secSell = Math.max(secSell, secBuy + p);
            }
            return secSell;
    }
    public static int maxProfit55(int[] prices) {
        if(prices==null||prices.length<2) return 0;
        int res=0;
        int[] left=new int[prices.length+1];
        int[] right=new int[prices.length+1];
        int minl=prices[0];
        for(int i=1;i<=prices.length;i++){
            if(prices[i-1]<minl)
                minl=prices[i-1];
            left[i]=Math.max(left[i-1],prices[i-1]-minl);
        }
        int maxr=prices[prices.length-1];
        for(int i=prices.length-1;i>=1;i--){
            if(prices[i-1]>maxr)
                maxr=prices[i-1];
            right[i]=Math.max(right[i+1],maxr-prices[i-1]);
        }
        for(int i=0;i<=prices.length;i++){
            System.out.println("left[i]="+left[i]+"-----right[i]="+right[i]);
            if(res<left[i]+right[i])
                res=left[i]+right[i];
        }
        return res;
    }

}
