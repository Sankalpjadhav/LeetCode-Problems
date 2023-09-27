class Solution {
    public String decodeAtIndex(String inputString, int k) {
         long decodedLength = 0; // Total length of the decoded string

        for (char character : inputString.toCharArray()) {
            if (Character.isDigit(character)) {
                // If the character is a digit, update the decoded length accordingly
                decodedLength *= (character - '0');
            } else {
                // If the character is a letter, increment the decoded length
                decodedLength++;
            }
        }

        // Traverse the input string in reverse to decode and find the kth character
        for (int i = inputString.length() - 1; i >= 0; i--) {
            char currentChar = inputString.charAt(i);

            if (Character.isDigit(currentChar)) {
                // If the character is a digit, adjust the length and k accordingly
                decodedLength /= (currentChar - '0');
                k %= decodedLength;
            } else {
                // If the character is a letter, check if it's the kth character
                if (k == 0 || decodedLength == k) {
                    return String.valueOf(currentChar); // Return the kth character as a string
                }
                decodedLength--;
            }
        }

        return ""; // Return an empty string if no character is found

    }

}



/*
Correct: but memory limit accepted.

public String decodeAtIndex(String S, int K) {
        if(K==1){
            return Character.toString(S.charAt(0));
        }
        String decoded="";
        for(int i=0;i<S.length();i++){
            char s=S.charAt(i);
            if(Character.isLetter(s)){
                decoded+=s;
            }
            else{
                int d = S.charAt(i)-'0'-1;
                //System.out.println(d);
                decoded+= repeat(decoded,d);
            }
        }
        //System.out.println(decoded);
        char result=decoded.charAt(K-1);
        return Character.toString(result);

    }
    
    public static String repeat(String s, int d){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<d;i++){
            sb.append(s);
        }
        return sb.toString();
    }
*/