class Solution {
    // Optimal: Using backtracking i.e generating valid strings only instead of all the strings
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder parenthesis = new StringBuilder();
        backtrack(0, 0, parenthesis, result, n);
        return result;
    }

    private void backtrack(int numberOfOpen, int numberOfClose, StringBuilder parenthesis, List<String> result, int n){
        if(numberOfOpen == numberOfClose && numberOfOpen == n)
        {
            result.add(parenthesis.toString());
            return;
        }

        if(numberOfOpen < n){
            parenthesis.append('(');
            backtrack(numberOfOpen+1, numberOfClose, parenthesis, result, n);
            parenthesis.deleteCharAt(parenthesis.length()-1); // backtracking
        }

        if(numberOfClose < numberOfOpen){ // very imp condition
            parenthesis.append(')');
            backtrack(numberOfOpen, numberOfClose+1, parenthesis, result, n);
            parenthesis.deleteCharAt(parenthesis.length()-1); // backtracking
        }
    }
    
}


/*
Brute Force: Expponential Time complexity: (2^n)*n
Approach: 
1. Generate all strings of parenthesis.
2. Add to the result only if the parenthesis is valid.
3. A parenthesis is considered as valid if the number of open and closed are same and are in correct order.
4. Order is determined by counting i.e adding +1 for open, and -1 for close. At any time if the count < 0 meaning 
we have encountered close before open bracket.

public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", result, n);
        return result;
    }

    private void generate(String parenthesis, List<String> result, int n){
        if(parenthesis.length() == 2*n){
            if(valid(parenthesis)){
                result.add(parenthesis);
            }
            return;
        }

        generate(parenthesis+"(", result, n);
        generate(parenthesis+")", result, n);
    }

    private boolean valid(String paranthesis){
        int count = 0;
        for(char ch: paranthesis.toCharArray()){
            count += (ch == '(') ? 1 : -1;
            if(count < 0){
                return false;
            }
        }

        return count == 0; // At the end the number of open and close will be same which leads to count storing 0
    }
*/