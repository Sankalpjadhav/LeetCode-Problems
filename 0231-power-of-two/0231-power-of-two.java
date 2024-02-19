class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        int value = (n & (n-1));
        if(value==0){
            return true;
        }
        
        return false;
    }
}