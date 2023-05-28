class Solution {
    public String removeTrailingZeros(String num) {
        if(num.length() == 1){
            return num.charAt(0) == '0' ? "" : num;
        }
        
        char [] array = num.toCharArray();
        int index = 0;
        for(int i=array.length-1;i>=0;i--){
            if(array[i] != '0'){
                index = i;
                break;
            }
        }
        
        String result = "";
        for(int j=0;j<=index;j++){
            result += array[j];
        }
        
        return result;
    }
}