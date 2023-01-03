class Solution {
    int m, n;
    Set<String> set;
    
    public Solution(int m, int n) {
        set = new HashSet<>();
        this.m=m;
        this.n=n;
    }
    
    public int[] flip() {

        int i=(int)(Math.random()*(m));
        int j=(int)(Math.random()*(n));

        String s=i+" "+j;

        while(set.contains(s)){
            // generate till you get pair of indices which are not present in set.
            i=(int)(Math.random()*(m)); // generate random number btw 0 - m-1
            j=(int)(Math.random()*(n)); // generate random number btw 0 - n-1
            s=i+" "+j;
        }

        set.add(s);

        return new int[]{i,j};
    }
    
    public void reset() {
        set.clear();
    }
}

/*

SOLUTION: TLE: 19/20 cases passed
class Solution {
    int [][] matrix;
    Queue<int[]> queue;
    
    public Solution(int m, int n) {
        matrix = new int[m][n];
        queue = new LinkedList<>();
        addIndexes();
    }
    
    public int[] flip() {
        int [] indexes = queue.poll();
        int i = indexes[0];
        int j = indexes[1];
        matrix[i][j] = 1;
        
        return indexes;
    }
    
    public void reset() {
        for(int i=0;i<matrix.length;i++){
            Arrays.fill(matrix[i], 0);
        }
        addIndexes();
    }
    
    private void addIndexes(){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                queue.add(new int[]{i,j});
            }
        }
    }
}

*/

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */