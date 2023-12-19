class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        char [] charArray1 = word1.toCharArray();
        char [] charArray2 = word2.toCharArray();
        
        char [] resultArray = new char[m+n];
        
        int i = 0;
        int j = 0;
        int k = 0;
    
        while(i < m && j < n){
            resultArray[k++] = charArray1[i++];
            resultArray[k++] = charArray2[j++];
        }
        
        while(i < m){
            resultArray[k++] = charArray1[i++];
        }
        
        while(j < n){
            resultArray[k++] = charArray2[j++];
        }
        
        return new String(resultArray);
    }
}