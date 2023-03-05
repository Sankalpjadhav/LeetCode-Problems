class Solution {
    public int passThePillow(int n, int time) {
        if(n > time){
            return time+1;
        }
        boolean flag = true;
        int start  = 1;

        while(time-- > 0){
            if(flag == true){
                start++;
                if(start == n){
                    flag = false;
                }
            }
            else{
                start--;
                if(start == 1){
                    flag = true;
                }
            }
        }
        
        return start;
    }
}