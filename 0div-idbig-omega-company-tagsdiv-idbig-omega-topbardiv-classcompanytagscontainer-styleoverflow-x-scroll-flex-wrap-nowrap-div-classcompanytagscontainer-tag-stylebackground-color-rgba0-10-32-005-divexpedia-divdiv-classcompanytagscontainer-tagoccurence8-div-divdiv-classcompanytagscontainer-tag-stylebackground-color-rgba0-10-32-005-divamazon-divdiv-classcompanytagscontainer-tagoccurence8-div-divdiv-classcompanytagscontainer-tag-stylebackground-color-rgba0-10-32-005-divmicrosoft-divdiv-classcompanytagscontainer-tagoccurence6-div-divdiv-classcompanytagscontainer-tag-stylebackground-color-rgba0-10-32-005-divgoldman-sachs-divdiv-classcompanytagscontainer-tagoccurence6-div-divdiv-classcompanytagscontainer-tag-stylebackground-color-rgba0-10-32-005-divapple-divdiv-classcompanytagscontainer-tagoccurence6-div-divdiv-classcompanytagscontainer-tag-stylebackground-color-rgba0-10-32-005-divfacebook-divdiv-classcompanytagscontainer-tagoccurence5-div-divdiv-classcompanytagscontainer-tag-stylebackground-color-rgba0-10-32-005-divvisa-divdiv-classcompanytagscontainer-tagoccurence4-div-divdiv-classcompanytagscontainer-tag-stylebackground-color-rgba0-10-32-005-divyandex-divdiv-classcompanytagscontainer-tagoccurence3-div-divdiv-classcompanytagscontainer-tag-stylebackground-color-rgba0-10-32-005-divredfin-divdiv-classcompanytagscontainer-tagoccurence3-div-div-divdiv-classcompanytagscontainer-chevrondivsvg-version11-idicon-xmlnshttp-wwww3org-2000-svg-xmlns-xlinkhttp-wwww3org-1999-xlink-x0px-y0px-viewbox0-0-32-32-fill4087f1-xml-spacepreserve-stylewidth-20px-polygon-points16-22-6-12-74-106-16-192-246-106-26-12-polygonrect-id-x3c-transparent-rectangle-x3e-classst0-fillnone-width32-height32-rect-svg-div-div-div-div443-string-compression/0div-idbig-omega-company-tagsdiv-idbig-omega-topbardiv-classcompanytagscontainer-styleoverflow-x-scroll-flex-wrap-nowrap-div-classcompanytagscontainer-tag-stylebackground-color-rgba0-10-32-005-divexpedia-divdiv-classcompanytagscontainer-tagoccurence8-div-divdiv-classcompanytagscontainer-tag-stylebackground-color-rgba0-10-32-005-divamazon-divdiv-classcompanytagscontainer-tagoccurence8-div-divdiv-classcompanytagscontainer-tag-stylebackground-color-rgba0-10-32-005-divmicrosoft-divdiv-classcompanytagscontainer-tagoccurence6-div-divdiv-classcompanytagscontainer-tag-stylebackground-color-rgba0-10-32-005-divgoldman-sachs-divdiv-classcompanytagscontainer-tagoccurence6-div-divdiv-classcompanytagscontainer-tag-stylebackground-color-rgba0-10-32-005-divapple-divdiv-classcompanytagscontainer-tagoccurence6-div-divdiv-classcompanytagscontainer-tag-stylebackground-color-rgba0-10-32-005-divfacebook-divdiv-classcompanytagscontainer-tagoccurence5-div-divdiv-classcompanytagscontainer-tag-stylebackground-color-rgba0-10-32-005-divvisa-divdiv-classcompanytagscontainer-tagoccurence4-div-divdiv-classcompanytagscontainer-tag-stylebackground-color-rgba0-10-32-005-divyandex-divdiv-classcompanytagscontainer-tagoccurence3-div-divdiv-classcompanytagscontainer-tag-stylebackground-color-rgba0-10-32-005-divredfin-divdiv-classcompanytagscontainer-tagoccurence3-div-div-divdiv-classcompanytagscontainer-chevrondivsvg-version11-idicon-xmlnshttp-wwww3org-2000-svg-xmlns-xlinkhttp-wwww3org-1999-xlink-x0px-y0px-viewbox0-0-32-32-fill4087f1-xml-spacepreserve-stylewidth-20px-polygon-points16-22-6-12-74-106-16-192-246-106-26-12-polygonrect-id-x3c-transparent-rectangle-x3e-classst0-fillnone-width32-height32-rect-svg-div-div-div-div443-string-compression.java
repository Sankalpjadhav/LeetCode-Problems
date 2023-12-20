class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        
        if(n == 1){
            return n;
        }
        
        int i = 0, j = 0;
        
        while(j < n){
            int k = j;
            
            while(k < n && chars[k] == chars[j]){
                k++;
            }
            
            String count = k - j + "";
            
            if(Integer.parseInt(count) == 1){
                chars[i] = chars[j];
                i++;
                
            }
            else{
                chars[i] = chars[j];
                i++;
                int l = 0;
                while( l < count.length()){
                    chars[i++] = count.charAt(l);
                    l++;
                }
            }
            
            j = k;
        }
        
        return i;
    }
}