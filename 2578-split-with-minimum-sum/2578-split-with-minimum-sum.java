class Solution {
    public int splitNum(int num) {
        char [] array = Integer.toString(num).toCharArray();
        Arrays.sort(array);
        
        int num1 = 0, num2 = 0;
        int n = array.length;
        
        for(int i=0;i<n;i++){
            int digit = array[i] - '0';
            if(i % 2 == 0){
                num1 *= 10;
                num1 += digit;
            }
            else{
                num2 *= 10;
                num2 += digit; 
            }
        }
        
        return num1 + num2;
    }
}