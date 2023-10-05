class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1, num2 = -2, count1 = 0, count2 = 0;
        int len = nums.length;
        for(int element : nums){
            if(element == num1){
                count1++;
            }
            else if(element == num2){
                count2++;
            }
            else if(count1 == 0){
                num1 = element; 
                count1 = 1;
            }
            else if(count2 == 0){
                num2 = element;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        int c1 = 0, c2 = 0;
        for(int element : nums){
            if(element == num1){
                c1++;
            }
            else if(element == num2){
                c2++;
            }
        }
        
        if(c1 > len/3){
            res.add(num1);
        }
        if(c2 > len/3){
            res.add(num2);
        }
        
        return res;
    }
}