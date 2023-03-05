class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            List<Integer> indexes = map.getOrDefault(arr[i], new ArrayList<>());
            indexes.add(i);
            map.put(arr[i], indexes);
        }
        
        boolean [] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int numberOfJumps = -1;
        
        while(!queue.isEmpty()){
            numberOfJumps++;
            
            int size = queue.size();
            
            while(size-- > 0){
                int removedIndex = queue.poll();
                
                if(removedIndex == n-1){
                    return numberOfJumps;
                }
                
                int valAtRemovedIdx = arr[removedIndex];
                
                if(!visited[removedIndex]){
                    visited[removedIndex] = true;
                    
                    if(removedIndex > 0 && !visited[removedIndex-1]){
                        queue.add(removedIndex-1);
                    }
                    
                    if(removedIndex+1 < n && !visited[removedIndex+1]){
                        queue.add(removedIndex+1);
                    }
                    
                    for(int index : map.get(valAtRemovedIdx)){
                        if(!visited[index]){
                            queue.add(index);
                        }
                    }
                    
                    // If below line not written we will get MLE bcoz we are iterating again and again. To avoid iterating all the elements of list again if value is repeated
                    map.put(valAtRemovedIdx, new ArrayList<>());
                }
            }
        }
        
        return numberOfJumps;
         
    }
}



/*

Memoization wont work here : In this question DFS will work if used without memoization but will give TLE and if we use memoization, then we will get wrong answer because here, unlike the conventional Rat in a Maze type problems (where we are allowed to move only forward or down) we can jump back also, instead of only moving forward. This can cause the memoized values to be stored incorrectly.

Grid Example:
An easier example to visualize the differences of when DSF with memorization can be used and where it should not be used, are the "robot walking a grid" type of problems that have been used in some of the leetcode monthly problems. Assume we have a rectangular grid with a robot in the top left corner, and we want to find the shortest path for the robot to walk to the bottom right corner, and some squares of the grid contain obstacles that the robot must walk around.

If the robot can only walk right or down, then a DFS with memorization will work, because any path to a grid square cannot effect the path from that grid square to the end. The path can never loop back on itself because the robot can ONLY walk right or down.

If the problem is changed so the robot can now walk up, down, right, or left, then the path can loop back on itself, and some paths to a grid square may possibly block some of the paths from that grid square to the end, This is when BFS should be used instead of DFS. BFS will find the shortest path to a grid square by building all possible paths at the same time, building them all one step at a time. Some of the BFS paths being built can pass through other BFS paths being built, without causing any errors. Whichever BFS path arrives at the desired grid square first is the shortest.

Other graph algorithms may also be useful for these types of problems.


Recursion Code: 

Gives TLE:  15 / 33 test cases passed.

public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int num = arr[i];
            if(map.containsKey(num)){
                List<Integer> list = map.get(num);
                list.add(i);
                map.put(num, list);
            }
            else{
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(num, newList);
            }
        }
        
        boolean [] visited = new boolean[n];
        
        return helper(0, n-1, arr, map, visited);
    }
    
    private int helper(int index, int n, int [] arr, HashMap<Integer, List<Integer>> map, boolean [] visited){
        if(index > n || visited[index]){
            return (int)1e9;
        }
        if(index == n){
            return 0;
        }
        
        visited[index] = true;
        
        int forward = 1 + helper(index+1, n, arr, map, visited);
        
        int backward = (int)1e9;
        if(index-1 >= 0){
            backward = 1 + helper(index-1, n, arr, map, visited);
        }
        
        int sameValue = (int)1e9;
        List<Integer> indexes = map.get(arr[index]);
        for(int ind : indexes){
            if(ind!=index){
                sameValue = Math.min(sameValue, 1 + helper(ind, n, arr, map, visited));
            }
        }
        
        visited[index] = false;
        
        return Math.min(forward, Math.min(backward, sameValue));
    }


*/