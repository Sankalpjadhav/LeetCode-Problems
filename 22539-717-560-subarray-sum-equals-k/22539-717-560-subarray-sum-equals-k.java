class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(sum,1);
        
       /* Very important to add : Because what if we have subarray at the start whose sum equals k. 
        Then according to the derived logic sum(k) - k = 0 -> does map contains 0? true. 
       */
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}