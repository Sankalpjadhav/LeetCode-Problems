class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftMinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
        long ans = 0;
        int i = 0, j = costs.length - 1;
        for(int l=0;l<k;l++){
            while(leftMinHeap.size() < candidates && i<=j){
                leftMinHeap.add(costs[i++]);
            }
            
            while(rightMinHeap.size() < candidates && j >= i){
                rightMinHeap.add(costs[j--]);
            }
            
            int minCostFromLeft = leftMinHeap.size() > 0 ? leftMinHeap.peek() : Integer.MAX_VALUE;
            int minCostFromRight = rightMinHeap.size() > 0 ? rightMinHeap.peek() : Integer.MAX_VALUE;
            
            if(minCostFromLeft <= minCostFromRight){
                ans += minCostFromLeft;
                leftMinHeap.poll();
            }
            else{
                ans += minCostFromRight;
                rightMinHeap.poll();
            }
            
        }
        
        return ans;
    }
}