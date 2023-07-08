class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<2;i++){
            result.add(new ArrayList<>());
        }
        
        for(int num:nums1){
            map1.put(num, 1);
        }
        
        for(int num: nums2){
            map2.put(num, 1);
        }
        
        for(int i=0;i<nums1.length;i++){
            if(!map2.containsKey(nums1[i]) && !set1.contains(nums1[i])){
                set1.add(nums1[i]);
                result.get(0).add(nums1[i]);
            }
        }
        
        for(int i=0;i<nums2.length;i++){
            if(!map1.containsKey(nums2[i]) && !set2.contains(nums2[i])){
                set2.add(nums2[i]);
                result.get(1).add(nums2[i]);
            }
        }
        
        return result;
    }
}