class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        
        Arrays.sort(intervals, new Comparator<>(){
           @Override
            public int compare(int [] a, int [] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                else{
                    return a[0] - b[0];
                }
            }
        });
        
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        
        for(int [] interval: intervals){
            if(stack.isEmpty()){
                stack.push(new Pair(interval[0], interval[1]));
            }
            else{
                Pair<Integer, Integer> top = stack.peek();
                if(top.getValue() <= interval[0]){
                    stack.push(new Pair(interval[0], interval[1]));
                }
                else if(top.getValue() < interval[1]){
                    
                }
                else if(top.getValue() >= interval[1]){
                    stack.pop();
                    stack.push(new Pair(interval[0], interval[1]));
                }
            }
        }
        
        return n - stack.size();
    }
}