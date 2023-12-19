class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String [] wordArray = s.split(" ");
        String result = "";
        
        for(int i=wordArray.length-1;i>=0;i--){
            String word = wordArray[i].trim();
            if(word.length() != 0){
                if(i == 0){
                    result += word;
                }
                else{
                    result += word + " ";
                }
            }
        }
        
        return result;
    }
}