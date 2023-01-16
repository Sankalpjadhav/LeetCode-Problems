class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }
        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
        
        int i = 0;
        // Add all intervals that are non-overlapping with newIntervals
        while(i < n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        
        // Merge newInterval with all overlapping intervals
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        list.add(newInterval);
        
        // Add remaining intervals
        while(i < n){
            list.add(intervals[i]);
            i++;
        }
        
        int [][] result = new int[list.size()][2];
        for(int j=0; j<list.size(); j++){
            result[j] = list.get(j);
        }
        
        
        return result;
    }
}