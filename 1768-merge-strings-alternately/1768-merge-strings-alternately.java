class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1  = word1.length();
        int n2  = word2.length();
        
        int index1 = 0, index2 = 0;
        
        String result = "";
        
        while(index1 < n1 && index2 < n2){
            result += word1.charAt(index1);
            result += word2.charAt(index2);
            
            index1++;
            index2++;
        }
        
        if(index1 < n1){
            result += word1.substring(index1);
        }
        
        if(index2 < n2){
            result += word2.substring(index2);
        }
        
        return result;
    }
}