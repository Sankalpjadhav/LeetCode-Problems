class Solution {
    public int trailingZeroes(int n) {
        if(n < 5) return 0;
        int count = 0;

        while(n != 0){
            n = n / 5;
            count += n;
        }

        return count;
    }
}

/*
Brute force solution:

public int trailingZeroes(int n) {
        if(n < 5) return 0;
        long num = getFactorial(n);
        String strNum = String.valueOf(num);
        int count = 0;
        for(int i=strNum.length()-1;i>=0;i--){
            if(strNum.charAt(i) == '0'){
                count++;
            }
            else{
                break;
            }
        }

        return count;
    }

    private long getFactorial(int n){
        long num = 1;
        while(n > 0){
            num *= n;
            n--;
        }

        return num;
    }

*/