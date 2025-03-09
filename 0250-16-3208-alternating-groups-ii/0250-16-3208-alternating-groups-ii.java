class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int start = 0;
        int end = 1;
        int badPairs = 0; // While traversing through window we will keep track of bad pairs (0, 0) or (1, 1)
        
        // You might be thinking this should be end but we have a colors represting cycle, 
        // so every element in colors can be start of the window.
        while(start < n){ 
            if(colors[end % n] == colors[(end - 1) % n]) badPairs++;

            if(end - start + 1 == k){
                // Window of k formed
                if(badPairs == 0) count++;

                start++; // Move the left boundary one index right

                // Substract the effect of bad pair in the badPairs count
                if(colors[start%n] == colors[(start-1)%n]){
                    badPairs--;
                } 
            }
            
            end++;
        }

        return count;
    }
}

/*
Brute force: N*K

public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        for(int i=0;i<n;i++){
            boolean alternating = true;
            for(int j=i;j<i+k-1;j++){
                if(colors[j%n] == colors[(j+1)%n]){
                    alternating = false;
                }
            }
            if(alternating){
                count++;
            }
        }

        return count;
    }
*/