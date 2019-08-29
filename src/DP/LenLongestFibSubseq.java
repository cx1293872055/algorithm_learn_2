package DP;

public class LenLongestFibSubseq {

    public static void main(String[] args) {
        int[]a = {1,2,4,7,12,20,33};
        System.out.println(lenLongestFibSubseq(a));
    }
    public static int lenLongestFibSubseq(int[] A) {
        int len = A.length, ans = 0;
        for (int i = 0; i < len - 2; i++) {
            System.out.println("i=" + i);

            int pos = i + 2;
            for (int j = i + 1; j < len - 1; j++) {
                System.out.println("j=" + j);

                int sum = A[i] + A[j];
                while (pos < len && A[pos] < sum) pos++;
                System.out.println("pos=" + pos);

                if (pos == len) return ans;
                if (A[pos] != sum) continue;
                int b = sum, c = sum + A[j], curLen = 3, k = pos;
                while (true) {
                    System.out.println("k=" + k);
                    System.out.println("c="+c+"----b="+b);
                    while (k < len && A[k] < c) k++;
                    System.out.println("k=" + k);
                    if (k == len) break;
                    if (A[k] != c) break;
                    curLen++;
                    c = c + b;
                    b = c - b;
                    System.out.println();
                }
                System.out.println("curLen="+curLen);
                ans = Math.max(ans, curLen);
                System.out.println("-----------");
            }
            if (pos == len) break;
        }
        return ans;
    }
}
