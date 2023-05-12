class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int [][] memo = new int[n][4];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(0, 2, n-1, memo, obstacles);
    }
    
    private int helper(int point, int lane, int lastPoint, int [][] memo, int [] obstacles){
        if(point == lastPoint){
            return 0;
        }
        
        if(obstacles[point] == lane){
            return Integer.MAX_VALUE;
        }
        
        if(memo[point][lane] != -1){
            return memo[point][lane];
        }
        
        if(obstacles[point+1] != lane){
            // Meaning there is no obstacle at the next point on the same lane.
            return memo[point][lane] = helper(point+1, lane, lastPoint, memo, obstacles);
        }
        
        // Meaning there is obstacle at the next point on the same lane so we need to make side jumps.
        if(lane == 1){
            // We can jump to lane 2 and lane 3
            return memo[point][lane] = 1 + Math.min(helper(point, 2, lastPoint, memo, obstacles), helper(point, 3, lastPoint, memo, obstacles));
        }
        else if(lane == 2){
            // We can jump to lane 1 and lane 3
            return memo[point][lane] = 1 + Math.min(helper(point, 1, lastPoint, memo, obstacles), helper(point, 3, lastPoint, memo, obstacles));
        }
        // lane == 3
        // We can jump to lane 1 and lane 2
        return memo[point][lane] = 1 + Math.min(helper(point, 1, lastPoint, memo, obstacles), helper(point, 2, lastPoint, memo, obstacles));
    }
}