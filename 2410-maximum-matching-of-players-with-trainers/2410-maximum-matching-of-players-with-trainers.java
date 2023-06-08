class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        Arrays.sort(trainers);
        Arrays.sort(players);
        
        int count = 0, i = 0, j = 0;
        while(i < players.length && j < trainers.length){
            if(players[i] <= trainers[j]){
                count++;
                i++;
                j++;
            }
            else{
                // players[i] > trainers[j]
                while(j < trainers.length && players[i] > trainers[j]){
                    j++;
                }
                if(i < players.length && j < trainers.length && players[i] <= trainers[j]){
                    count++;
                    i++;
                    j++;
                }
            }
        }
        return count;
    }
}