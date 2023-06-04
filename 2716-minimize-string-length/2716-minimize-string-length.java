class Solution {
    public int minimizedStringLength(String s) {
        int n = s.length();
        
        char [] array = s.toCharArray();
        
        for(int i=0;i<n;i++){
            char ch = array[i];
            if(ch >= 'a' && ch <= 'z'){
                for(int j=i-1;j>=0;j--){
                    if(ch == array[j]){
                        array[j] = 'A';
                        break;
                    }
                }
                
                for(int k=i+1;k<n;k++){
                    if(ch == array[k]){
                        array[k] = 'A';
                        break;
                    }
                }
            }
        }
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            char ch = array[i];
            if(ch >= 'a' && ch <= 'z'){
                count++;
            }
        }
        
        return count;
    }
}