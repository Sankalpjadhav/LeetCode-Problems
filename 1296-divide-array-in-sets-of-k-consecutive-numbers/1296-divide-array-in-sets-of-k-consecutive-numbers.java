class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : nums){
            pq.add(num);
        }
        
        while(!pq.isEmpty()){
            int currentNum = pq.poll();
            for(int i=1;i<k;i++){ // not doing i<=k bcoz currentNum will be one candidate in that group
                if(!pq.contains(currentNum+i)){
                    return false;
                }
                else{
                    pq.remove(currentNum+i);
                }
            }
        }
        
        return true;
    }
}