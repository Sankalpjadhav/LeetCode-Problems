class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int [] pairs = new int[n];
        for(int i=0;i<n;i++){
            int num = spells[i];
            int left = 0;
            int right = m-1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if((long) potions[mid] * num < success){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            pairs[i] = m - right - 1;
        }
        
        return pairs;
    }
}