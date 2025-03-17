class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int totalPairs = 0;
        for(Map.Entry<Integer, Integer> kv: map.entrySet()){
            totalPairs += kv.getValue() / 2;
        }

        return (totalPairs == n/2);
    }
}