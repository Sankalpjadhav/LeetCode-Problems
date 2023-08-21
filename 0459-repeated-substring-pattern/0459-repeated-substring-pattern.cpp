class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        int len = s.length();
        
        for(int i=1;i<=len/2;i++){
            if(len % i == 0){
                string substring = s.substr(0, i);
                string repeatedString = "";

                for(int j=0;j<len/i;j++){
                    repeatedString += substring;
                } 
                
                if(repeatedString == s){
                    return true;
                }
            }
        }
        
        return false;
    }
};