class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int start = 0, end = 0;
        int res = 0;
        int countT = 0, countF = 0;
        while(end < n){
            if(answerKey.charAt(end) == 'T'){
                countT++;
            }
            else{
                countF++;
            }
            
            while(Math.min(countT, countF) > k){
                if(answerKey.charAt(start) == 'T'){
                    countT--;
                }
                else{
                    countF--;
                }
                start++;
            }
            
            res = Math.max(res, end - start);
            end++;
        }
        
        return res+1;
    }
}