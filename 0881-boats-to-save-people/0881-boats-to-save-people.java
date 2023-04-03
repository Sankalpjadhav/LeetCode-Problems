class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        
        Arrays.sort(people);
        
        int numberOfBoats = 0;
        int lightWeight = 0;
        int heavyWeight = n-1;
        
        while(lightWeight <= heavyWeight){
            if(people[lightWeight] + people[heavyWeight] <= limit){
                // We will add both the person to the boat
                lightWeight++;
                heavyWeight--;
            }   
            else{
               // We can only consider adding heaviest person to the boat
                heavyWeight--;
            }
            
            numberOfBoats++;
        }
        
        return numberOfBoats;
    }
}