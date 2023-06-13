class Solution {
    public boolean isFascinating(int n) {
        int twoN = n * 2;
        int threeN = n * 3;
        
        String result = n +""+ twoN +""+ threeN;
        boolean [] numbers = new boolean[10];
        
        for(int i=0;i<result.length();i++){
            char ch = result.charAt(i);
            if(ch == '0'){
                return false;
            }
            if(numbers[ch - '0'] == true){
                return false;
            }
            else{
                numbers[ch-'0'] = true;
            }
        }
        
        for(int i=1;i<10;i++){
            if(numbers[i] == false){
                return false;
            }
        }
        
        return true;
    }
}