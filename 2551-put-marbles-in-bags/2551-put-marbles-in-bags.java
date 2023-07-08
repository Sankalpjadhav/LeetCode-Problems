class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if(k == 1 || k == n){
            return 0;
        }
        
        List<Long> list = new ArrayList<>();
        
        for(int i=1;i<n;i++){
            list.add((long)(weights[i-1] + weights[i]));
        }
        
        Collections.sort(list);
        long left = 0, right = 0;
        for(int i=0;i+1<k;i++){
            left += list.get(i);
            right += list.get(list.size()- 1 - i);
        }
        
        return right - left;
    }
}