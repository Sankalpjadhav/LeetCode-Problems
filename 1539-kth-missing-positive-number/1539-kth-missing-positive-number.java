class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = k + arr.length;
        Set<Integer> set = new HashSet<>();
        
        for(int num: arr){
            set.add(num);
        }
        
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                k--;
            }
            if(k == 0){
                return i;
            }
        }
        
        return 0;
    }
}