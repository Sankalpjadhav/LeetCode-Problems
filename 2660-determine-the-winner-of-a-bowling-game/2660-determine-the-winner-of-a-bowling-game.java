class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int n = player1.length;
        Set<Integer> turnAtWhichPlayer1HitTen = new HashSet<>();
        Set<Integer> turnAtWhichPlayer2HitTen = new HashSet<>();
        
        for(int i=0;i<player1.length;i++){
            if(player1[i] == 10){
                turnAtWhichPlayer1HitTen.add(i);
            }   
        }
        
        //System.out.println("set1"+turnAtWhichPlayer1HitTen);
        
        for(int i=0;i<player2.length;i++){
            if(player2[i] == 10){
                turnAtWhichPlayer2HitTen.add(i);
            }   
        }
        
        //System.out.println("set2"+turnAtWhichPlayer2HitTen);
        
        int score1 = 0;
        for(int i=0;i<player1.length;i++){
            if(turnAtWhichPlayer1HitTen.contains(i-1) || turnAtWhichPlayer1HitTen.contains(i-2)){
                score1 += 2*player1[i];
            }
            else{
                score1 += player1[i];
            }
        }
        
        
        int score2 = 0;
        for(int i=0;i<player2.length;i++){
            if(turnAtWhichPlayer2HitTen.contains(i-1) || turnAtWhichPlayer2HitTen.contains(i-2)){
                score2 += 2*player2[i];
            }
            else{
                score2 += player2[i];
            }
        }
        
        //System.out.println("Score1: "+score1+" - Score2: "+score2);
        
        if(score1 > score2){
            return 1;
        }
        else if(score2 > score1){
            return 2;
        }        
        
        return 0;
    }
}