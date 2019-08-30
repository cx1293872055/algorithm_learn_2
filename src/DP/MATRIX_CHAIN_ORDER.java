package DP;

public class MATRIX_CHAIN_ORDER {
    public static void main(String[] args) {
        int[] m = {30,35,15,5,10,20,25};
        MATRIX_CHAIN_ORDER_method(m);
    }

    public static void MATRIX_CHAIN_ORDER_method(int[] p) {
        int n = p.length +1 ;
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        output(m, n, n);
        output(s, n, n);
    }

    public static void output(int[][] p,int rows,int col) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(p[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
