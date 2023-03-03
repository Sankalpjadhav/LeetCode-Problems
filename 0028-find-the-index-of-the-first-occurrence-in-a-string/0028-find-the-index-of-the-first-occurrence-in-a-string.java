class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int i = 0;
        
        while(i < n){
            char ch = haystack.charAt(i);
            if(ch == needle.charAt(0)){
                int j = i;
                boolean flag = false;
                for(int k=0;k<m;k++){
                    if(j >= n){
                        return -1;
                    }
                    if(haystack.charAt(j) != needle.charAt(k)){
                        flag = true; 
                        break;
                    }
                    j++;
                }
                if(flag == false){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}