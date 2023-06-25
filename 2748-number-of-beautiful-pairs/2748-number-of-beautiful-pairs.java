class Solution {
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int firstDigit = String.valueOf(nums[i]).charAt(0) - '0';
                int lastDigit = nums[j] % 10;
                if(gcd(firstDigit, lastDigit) == 1){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private int gcd(int num1, int num2){
        if(num2 == 0){
            return num1;
        }
        
        return gcd(num2, Math.abs(num2-num1));
    }
}