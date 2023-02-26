class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int [] divArray = new int[n];
        long remainder = 0;
        for(int i=0;i<n;i++){
            int digit = word.charAt(i) - '0';
            remainder = remainder * 10;
            remainder += digit;
            remainder = remainder % m;
            if(remainder == 0){
                divArray[i] = 1;
            }
        }
        
        return divArray;
    }
}

/*
Below solution gives number format exception bcoz it is exceeding Long range
public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int [] divArray = new int[n];
        
        for(int i=0;i<n;i++){
            String substring = word.substring(0,i+1);
            
            long num = Long.parseLong(substring);
            if(num % m == 0){
                divArray[i] = 1;
            }
        }
        
        return divArray;
    }
*/