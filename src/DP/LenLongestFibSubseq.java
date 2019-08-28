package DP;

public class LenLongestFibSubseq {

    public static void main(String[] args) {
        int[]a = {1,2,3,4,5,6,7,8};
        System.out.println(lenLongestFibSubseq(a));
    }
    public static int lenLongestFibSubseq(int[] A) {
        int len = A.length, ans = 0;
        for (int i = 0; i < len - 2; i++) {
            int pos = i + 2;
            for (int j = i + 1; j < len - 1; j++) {
                int sum = A[i] + A[j];
                while (pos < len && A[pos] < sum) pos++;
                if (pos == len) return ans;
                if (A[pos] != sum) continue;
                int b = sum, c = sum + A[j], curLen = 3, k = pos;
                while (true) {
                    while (k < len && A[k] < c) k++;
                    if (k == len) break;
                    if (A[k] != c) break;
                    curLen++;
                    c = c + b;
                    b = c - b;
                }
                ans = Math.max(ans, curLen);
            }
            if (pos == len) break;
        }
        return ans;
    }
}
