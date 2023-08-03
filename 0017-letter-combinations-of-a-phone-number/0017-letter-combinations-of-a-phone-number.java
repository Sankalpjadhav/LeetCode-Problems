class Solution {
    String [] keypad = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
    public List<String> letterCombinations(String digits) {        
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        
        return backtrack(digits);
    }
    
    private List<String> backtrack(String digits){
        if(digits.length() == 0){
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        int num = digits.charAt(0) - '0';
        String firstNum = keypad[num];
        String remainingString = digits.substring(1);
        List<String> remainingResult = backtrack(remainingString);
        List<String> result = new ArrayList<>();
        
        for(int i=0;i<firstNum.length();i++){
            char ch = firstNum.charAt(i);
            for(String str: remainingResult){
                result.add(ch+str);
            }
        }
        
        return result;
    }
}