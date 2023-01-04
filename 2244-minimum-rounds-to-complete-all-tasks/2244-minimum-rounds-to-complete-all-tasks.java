class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val < 2) {
                return -1;
            }
            else if (val <= 3) {
                count++;
            }
            else if (val > 3) {
                count += val % 3 == 0 ? val / 3 : val / 3 + 1;
            }
        }
        return count;
    }
}

/*


public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }
        
        int rounds = 0;
        
        for(Map.Entry<Integer, Integer> entry  : map.entrySet()){
            if(entry.getValue() == 1){
                return -1;
            }
            
            // try to make rounds for as many 3's as possible
            rounds += entry.getValue() / 3; 
			
			//	We can have 1 or 2 tasks remaining. We're not supposed to take task of count 1, but we can 'borrow' 1 from the previous
			//	ex. [5,5,5,5,5,5,5] -> [5,5,5][5,5,5][5]
			//	In this example, treat the last [5,5,5], [5] as [5,5], [5,5]
        
            if (entry.getValue() % 3 != 0) { 
                rounds++; 
            }
            
        }
        
        return rounds;
        
    }



*/