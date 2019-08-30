package DP;

class Solution {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 5}, {3, 2, 1}};
        System.out.println(minPathSum(a));
    }
    public static int minPathSum(int[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return 0;
        int rows = grid.length;
        int col = grid[0].length;
        int[][] a = new int[rows+1][col+1];
        for(int i = 0;i<col+1;i++){
            a[0][i] = Integer.MAX_VALUE;
        }
        for(int i = 0;i<rows+1;i++){
            a[i][0] = Integer.MAX_VALUE;
        }
        for(int i = 1;i<rows+1;i++){
            for(int j = 1;j<col+1;j++){
                if(i==1&&j==1)
                a[i][j] = grid[i-1][j-1];
                else
                a[i][j] = grid[i-1][j-1]+Math.min(a[i-1][j],a[i][j-1]);
            }
        }
        return a[rows][col];
    }
}