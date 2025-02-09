class Solution {
    public long countBadPairs(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     map.put(i, nums[i]);
        // }
        
        // for(int i=0;i<nums.length-1;i++){
        //     for (Map.Entry<Integer,Integer> entry : map.entrySet()){
        //         if(i < entry.getKey() && (entry.getKey() - i)!=entry.getValue()-nums[i]){
        //             badPairs++;
        //         }
        //     }
        // }
        HashMap<Integer, Integer> seen = new HashMap<>();
        long count = 0;
        for(int i = 0; i < nums.length; i++){
            int diff = i - nums[i];
            if(seen.containsKey(diff)){
                count += (i - seen.get(diff));
            }else{
                count += i;
            }
            seen.put(diff, seen.getOrDefault(diff, 0) + 1);
        }
        return count;
    }
}