// EZ DP, measure of rectangle's area
class NumMatrix {
    int [][] dp;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        this.dp = new int[m+1][n+1];
        
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] + dp[row1][col1] - dp[row1][col2+1] - dp[row2+1][col1];
    }
}
