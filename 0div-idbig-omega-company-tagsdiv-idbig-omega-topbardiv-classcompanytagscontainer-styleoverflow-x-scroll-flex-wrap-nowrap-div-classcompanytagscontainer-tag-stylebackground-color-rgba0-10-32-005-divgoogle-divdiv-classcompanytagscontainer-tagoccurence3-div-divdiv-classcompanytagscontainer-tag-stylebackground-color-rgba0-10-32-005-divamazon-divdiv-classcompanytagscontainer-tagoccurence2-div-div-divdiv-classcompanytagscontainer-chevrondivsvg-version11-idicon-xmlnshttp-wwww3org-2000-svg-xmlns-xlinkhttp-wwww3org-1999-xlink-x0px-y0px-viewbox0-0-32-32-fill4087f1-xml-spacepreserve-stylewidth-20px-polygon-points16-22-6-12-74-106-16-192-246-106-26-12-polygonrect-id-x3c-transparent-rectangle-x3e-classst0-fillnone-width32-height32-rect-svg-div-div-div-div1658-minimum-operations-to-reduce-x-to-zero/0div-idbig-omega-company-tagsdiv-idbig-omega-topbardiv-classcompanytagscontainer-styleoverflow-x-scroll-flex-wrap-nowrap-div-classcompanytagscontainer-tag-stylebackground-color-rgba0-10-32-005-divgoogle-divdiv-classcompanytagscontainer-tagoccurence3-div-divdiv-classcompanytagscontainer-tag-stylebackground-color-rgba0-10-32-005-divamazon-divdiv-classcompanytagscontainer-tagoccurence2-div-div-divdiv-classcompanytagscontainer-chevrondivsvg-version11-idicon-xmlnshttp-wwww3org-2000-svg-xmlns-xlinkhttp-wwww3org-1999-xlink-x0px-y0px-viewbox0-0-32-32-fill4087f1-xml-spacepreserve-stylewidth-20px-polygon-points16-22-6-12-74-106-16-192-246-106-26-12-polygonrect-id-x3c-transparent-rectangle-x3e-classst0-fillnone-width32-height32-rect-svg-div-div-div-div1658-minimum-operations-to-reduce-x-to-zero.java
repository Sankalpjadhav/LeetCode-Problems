class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        
        int target = totalSum - x;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLengthSubarray = -1;
        int prefixSum = 0;
        
        for(int i=0;i<n;i++){
            prefixSum += nums[i];
            map.put(prefixSum, i);
            if(map.containsKey(prefixSum - target)){
                maxLengthSubarray = Math.max(maxLengthSubarray, i - map.get(prefixSum - target));
            }
        }
        
        if(maxLengthSubarray == -1){
            return -1;
        }
        
        return n - maxLengthSubarray;
    }
}