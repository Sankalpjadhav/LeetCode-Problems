class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        long sum = 0;
        for(int i=queries.length-1; i>=0; i--) {
            long currSum = 0;
            if(queries[i][0] == 0) {
                int row = queries[i][1];
                if(rows.contains(row))
                    continue;
                rows.add(queries[i][1]);
                int count = n - cols.size();
                
                currSum = (long) queries[i][2] * count;
            } else {
                int col = queries[i][1];
                if(cols.contains(col))
                    continue;
                
                cols.add(queries[i][1]);
                int count = n - rows.size();
                
                currSum = (long) queries[i][2] * count;
            }
            
            sum += currSum;
        }
        
        return sum;
    }
}

/*
Memory limit exceeded:
    public long matrixSumQueries(int n, int[][] queries) {
        int [][] matrix = new int[n][n];
        long sum = 0;
        
        for(int [] query: queries){
            if(query[0] == 0){
                int row = query[1];
                for(int j=0;j<n;j++){
                    // Substract the previous value from the sum
                    sum -= matrix[row][j];
                    matrix[row][j] = query[2];
                    // Add the new value to sum
                    sum += matrix[row][j];
                }
            }
            else{
                int col = query[1];
                for(int i=0;i<n;i++){
                    // Substract the previous value from the sum
                    sum -= matrix[i][col];
                    matrix[i][col] = query[2];
                    // Add the new value to sum
                    sum += matrix[i][col];
                }
            }
        }
        
        return sum;
    }

*/