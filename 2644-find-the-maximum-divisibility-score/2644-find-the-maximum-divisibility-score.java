class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxDivisiblityScore = 0;
        int ans = (int) 1e9;
        for(int div: divisors){
            int count = 0;
            for(int num: nums){
                if(num % div == 0){
                    //System.out.println(div);
                    count++;
                }
            }
            if(count == maxDivisiblityScore){
                ans = Math.min(ans, div);
            }
            
            if(count > maxDivisiblityScore){
                maxDivisiblityScore = count;
                ans = div;
            }
        }
        
        return ans;
    }
}