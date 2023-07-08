class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        
        int i = 0, j = 0;
        String result = "";
        
        while(i < n1 && j < n2){
            result += word1.charAt(i);
            result += word2.charAt(j);
            i++;
            j++;
        }
        
        for(int k=i;k<n1;k++){
            result += word1.charAt(k);
        }
        
        for(int k=j;k<n2;k++){
            result += word2.charAt(k);
        }
        
        return result;
    }
}