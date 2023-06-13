class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int numberOfBulls = 0;
        int [] secretNumbers = new int[10];
        int [] guessNumbers = new int[10];
        
        for(int i=0;i<n;i++){
            if(secret.charAt(i) == guess.charAt(i)){
                numberOfBulls++;
            }
            else{
                secretNumbers[secret.charAt(i)-'0']++;
                guessNumbers[guess.charAt(i)-'0']++;
            }
        }
        
        int numberOfCows = 0;
        for(int i=0;i<10;i++){
            numberOfCows += Math.min(secretNumbers[i], guessNumbers[i]);
        }
        
        return numberOfBulls + "A" + numberOfCows + "B";
    }
}