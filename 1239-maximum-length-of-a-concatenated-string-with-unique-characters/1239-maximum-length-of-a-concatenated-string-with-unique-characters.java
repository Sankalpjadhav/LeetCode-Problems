class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        String [] answer = new String[1];
        answer[0] = "";
        helper(0, n, "", answer, arr);
        return answer[0].length();
    }
    
    private void helper(int index, int n, String possibleAnswer, String [] answer, List<String> arr){
        if(index == n){
            if(subsequenceHasUniqueChars(possibleAnswer)){
                if(answer[0].length() < possibleAnswer.length()){
                    answer[0] = possibleAnswer;
                }
            }
            return;
        }
        
        helper(index+1, n, possibleAnswer+"", answer, arr);
        helper(index+1, n, possibleAnswer+arr.get(index), answer, arr);
    }
    
    private boolean subsequenceHasUniqueChars(String str){
        int [] alphabets = new int[26];
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(alphabets[ch - 'a'] > 0){
                return false;
            }
            else{
                alphabets[ch - 'a'] = 1;
            }
        }
        
        return true;
    }
}