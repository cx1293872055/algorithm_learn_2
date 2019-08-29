package DP;

import java.util.Arrays;

public class egg {

    public static void main(String[] args) {
        System.out.println(superEggDrop(3,50));
    }
    public static int superEggDrop(int K, int N) {
        int[] res=new int[K];
        Arrays.fill(res,1);
        while (res[K-1]<N){
            for (int i=K-1;i>=1;i--){
                res[i]=res[i]+res[i-1]+1;
                System.out.print(res[i]+"\t");
            }
            res[0]++;
            System.out.print(res[0]+"\t");
            System.out.println();
        }
        return res[0];
    }

}
