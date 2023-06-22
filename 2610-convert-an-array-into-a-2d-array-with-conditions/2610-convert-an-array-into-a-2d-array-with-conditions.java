class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(num));
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<maxFreq;i++){
            List<Integer> list = new ArrayList<>();
            
            for(Integer key: freqMap.keySet()){
                if(freqMap.get(key) > 0){
                    list.add(key);
                    freqMap.put(key, freqMap.get(key) - 1);
                }    
            }
            
            result.add(list);
        }
        
        return result;
    }
}