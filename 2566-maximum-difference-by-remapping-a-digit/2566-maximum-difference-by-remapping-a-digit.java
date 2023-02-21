class Solution {
    public int minMaxDifference(int num) {
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        
        String num1 = String.valueOf(num);
        
        for(char ch1='0';ch1<='9';ch1++){
            for(char ch2='0';ch2<='9';ch2++){
                StringBuilder temp = new StringBuilder(num1);
                for(int k=0;k<temp.length();k++){
                    if(temp.charAt(k) == ch1){
                        temp.setCharAt(k, ch2);
                    }
                }
                
                int newNum = Integer.parseInt(temp.toString());
                if(newNum < minNum){
                    minNum = newNum;
                }
                if(newNum > maxNum){
                    maxNum = newNum;
                }
            }
        }
        
        
        return maxNum - minNum;
    }
}