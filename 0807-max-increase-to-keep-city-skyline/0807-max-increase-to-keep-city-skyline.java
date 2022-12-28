class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        // grid.length == grid[0].length  given in constraints

        int [] maxValueRows = new int[n]; // It will store max value at each row.
        int [] maxValueCols = new int[n]; // It will store max value at each col.

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                maxValueRows[i] = Math.max(maxValueRows[i], grid[i][j]);
                maxValueCols[j] = Math.max(maxValueCols[j], grid[i][j]);
            }
        }

        int sum = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum+= Math.min(maxValueRows[i], maxValueCols[j]) - grid[i][j];
            }
        }

        return sum;
    }
}