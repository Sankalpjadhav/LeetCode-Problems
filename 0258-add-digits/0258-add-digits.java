class Solution {
    public int addDigits(int num) {
        int sum = 0;
        
        while(true){
            sum += (num % 10);
            num/=10;
            if(num == 0){
                num = sum;
                sum = 0;
                if(num >=0 && num < 10){
                    return num;
                }
            }
        }
    }
}