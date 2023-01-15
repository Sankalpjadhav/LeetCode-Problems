class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        long res = 0;
        long val = 0;
        int first = 0;
        
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                val += map.get(nums[i]);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            
            while(val >= k){
                res += n - i;
                int cancel = map.get(nums[first]);
                val -= cancel - 1;
                if(cancel == 1){
                    map.remove(nums[first]);
                }
                else{
                    map.put(nums[first], cancel - 1);
                }
                first++;
            }
        }
        
        
        return res;
    }
}