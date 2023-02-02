class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int [] indexArray = new int[26];
        
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            indexArray[ch-'a'] = i; 
        }
        
        for(int i=1;i<words.length;i++){
            String currentWord = words[i];
            String prevWord = words[i-1];

            int j = 0, k = 0;
            boolean flag = false;
            while(j<prevWord.length() && k<currentWord.length()){
                char ch1 = prevWord.charAt(j);
                char ch2 = currentWord.charAt(k);
                if(ch1 != ch2){
                    flag = true; // We have find out atleast one char which is not equal that means we need not consider the length of prevWord and currentWord
                    if(indexArray[ch1-'a'] > indexArray[ch2-'a']){
                        return false;
                    }
                    else{
                        break;
                    }
                }    
                j++;
                k++;
            }
            if(!flag && prevWord.length() > currentWord.length()){
                return false;
            }
        }
        
        return true;
    }
}