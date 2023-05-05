class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        
        int i = 0, j = 0;
        int count = 0;
        int maxCount = 0;
        while(j < n){
            if((j - i + 1) <= k){
                if(isVowel(j, s)){
                    //System.out.println(j+" v");
                    count++;
                }
                j++;
            }
            else{
                if(isVowel(i, s)){
                   count--;
                }
                i++;
            }
            maxCount = Math.max(count, maxCount);
        }
        
        return maxCount;
    }
    
    private boolean isVowel(int index, String s){
        char ch = s.charAt(index);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        
        return false;
    }
    
}