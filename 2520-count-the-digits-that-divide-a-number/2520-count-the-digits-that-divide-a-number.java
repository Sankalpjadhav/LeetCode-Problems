class Solution {
    public int countDigits(int num) {
        
        String str = String.valueOf(num);
        int count = 0;
        for(char ch: str.toCharArray()){
            int n = Integer.parseInt(ch+"");
            if(num % n == 0){
                count++;
            }
        }
        
        return count;
        
    }
}