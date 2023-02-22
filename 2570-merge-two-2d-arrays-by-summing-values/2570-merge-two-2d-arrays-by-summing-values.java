class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        for(int [] num : nums1){
            if(treeMap.containsKey(num[0])){
                int initial = treeMap.get(num[0]);
                treeMap.put(num[0], initial + num[1]);
            }
            else{
                treeMap.put(num[0], num[1]);
            }
        }
        
        for(int [] num : nums2){
            if(treeMap.containsKey(num[0])){
                int initial = treeMap.get(num[0]);
                treeMap.put(num[0], initial + num[1]);
            }
            else{
                treeMap.put(num[0], num[1]);
            }
        }
        
        int [][] result = new int[treeMap.size()][2];
        int index = 0;
        for(int key : treeMap.keySet()){
            result[index++] = new int[]{key, treeMap.get(key)};
        }
        
        return result;
    }
}