class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> results = new Stack<>();
        String answer = "";
        int index = 0;
        
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            }
            else if(s.charAt(index) == '['){
                results.push(answer);
                answer = "";
                index++;
            }
            else if(s.charAt(index) == ']'){
                StringBuilder tempString = new StringBuilder(results.pop());
                int times = counts.pop();
                for(int i=0;i<times;i++){
                    tempString.append(answer);
                }
                answer = tempString.toString();
                index++;
            }
            else{
                answer += s.charAt(index);
                index++;
            }
        }
        
        return answer;
    }
}