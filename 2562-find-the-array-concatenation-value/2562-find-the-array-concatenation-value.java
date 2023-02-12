class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long result = 0;
        
        int i = 0;
        int j = nums.length-1;
        
        while(i < j){
            int num1 = nums[i];
            int num2 = nums[j];
            int count = 0;
            while(num2 > 0){
               num2 = num2/10;
                count++;
            }
            
            for(int k=0;k<count;k++){
                num1 *= 10;  
            }
            
            result += (num1 + nums[j]);
            i++;
            j--;
        }
        
        if(i == j){
            //System.out.println("Hi");
            result += nums[i];
        }
        
        return result;
    }
}