class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],i);
        }
        
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(k+nums[i]) && map.get(k+nums[i])!=i) {
                count++;
                map.remove(k+nums[i]);
            }
        }
        return count;
    }
}