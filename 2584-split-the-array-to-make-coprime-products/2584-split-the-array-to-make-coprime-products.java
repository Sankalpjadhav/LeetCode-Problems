class Solution {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            factorsMap(num, map);
        }
        
        HashMap<Integer, Integer> currentMap = new HashMap<>();
        
        for(int cut=0;cut<n-1;cut++){
            factorsMap(nums[cut], currentMap);
            boolean flag = true;
            for(int key : currentMap.keySet()){
                if(map.get(key) - currentMap.get(key) > 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return cut;
            }
        }
        
        return -1;
    }
    
    private void factorsMap(int num, HashMap<Integer, Integer> map){
        int temp = num;
        for(int i=2;i*i<=num;i++){
            while(temp % i == 0){
                map.put(i, map.getOrDefault(i, 0)+1);
                temp/=i;
            }
        }
        
        if(temp > 0){
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }
    }
}

// Was not able to solve at first attempt: https://www.youtube.com/watch?v=VVFwmafwI0A