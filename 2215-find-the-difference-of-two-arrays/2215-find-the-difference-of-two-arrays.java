class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<2;i++){
            result.add(new ArrayList<>());
        }
        
        Set<Integer> set1 = new HashSet<>();
        
        for(int num: nums1){
            set1.add(num);
        }
        
        Set<Integer> set2 = new HashSet<>();
        
        for(int num: nums2){
            set2.add(num);
        }
        
        for(int num: nums1){
            if(!set2.contains(num)){
                set2.add(num); // To handle case Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2], Output: [[3],[]] but my O/P was coming [[3,3],[]]
                result.get(0).add(num);
            }
        }
        
        for(int num: nums2){
            if(!set1.contains(num)){
                set1.add(num);
                result.get(1).add(num);
            }
        }
        
        return result;
    }
}