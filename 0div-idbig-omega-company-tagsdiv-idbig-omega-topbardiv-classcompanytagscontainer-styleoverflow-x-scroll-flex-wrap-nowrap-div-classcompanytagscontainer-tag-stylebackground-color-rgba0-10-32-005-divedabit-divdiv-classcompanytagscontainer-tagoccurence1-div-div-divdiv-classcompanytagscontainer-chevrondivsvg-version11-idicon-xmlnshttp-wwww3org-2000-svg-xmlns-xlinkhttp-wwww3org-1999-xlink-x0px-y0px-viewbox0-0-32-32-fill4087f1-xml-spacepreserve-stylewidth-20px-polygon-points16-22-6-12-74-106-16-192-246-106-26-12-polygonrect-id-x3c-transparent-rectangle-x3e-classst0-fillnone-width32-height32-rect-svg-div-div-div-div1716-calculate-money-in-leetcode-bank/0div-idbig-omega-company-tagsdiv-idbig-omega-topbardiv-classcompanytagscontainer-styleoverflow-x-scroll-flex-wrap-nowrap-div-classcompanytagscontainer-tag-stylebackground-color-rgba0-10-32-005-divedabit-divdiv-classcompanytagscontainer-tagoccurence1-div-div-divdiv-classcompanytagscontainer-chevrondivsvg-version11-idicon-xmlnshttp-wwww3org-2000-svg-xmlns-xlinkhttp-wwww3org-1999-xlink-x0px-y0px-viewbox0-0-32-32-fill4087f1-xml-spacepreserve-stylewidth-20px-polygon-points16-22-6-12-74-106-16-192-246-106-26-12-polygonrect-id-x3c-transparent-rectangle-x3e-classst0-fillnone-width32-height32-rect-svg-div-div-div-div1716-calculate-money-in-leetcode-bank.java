class Solution {
    public int totalMoney(int n) {
        if(n<=7){
            return (n*(n+1))/2;
        }
        int sum=0;
        int rem = n%7;
        int div = n/7;
        for(int i=0;i<div;i++){
            sum += (28 + i*7);
        }
        for(int j=div+1;j<=div+rem;j++){
            sum += j;
        }
        
        return sum;
    }
}