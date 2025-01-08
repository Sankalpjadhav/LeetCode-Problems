class Solution {
    /*
    Without using Stack:
    Approach:
    - We will sort based on position as Cars closer to the destination are processed first and reached first. 
    - We will calculate the time it is required for a car to reach the destination.
    - currTime: The time it will take for the current car to reach the destination.
    - prevTime: The time it will take for the last fleet (or car) to reach the destination.
    - A new fleet is formed only if the current car cannot catch up to the previous fleet.
    - For this to happen, the current car's currTime must be greater than the prevTime of the last fleet:
    - If currTime > prevTime: The current car will arrive at the destination after the previous fleet. It cannot merge with that fleet, so it forms a new fleet.
    - If currTime <= prevTime: The current car either catches up with the previous fleet or arrives at the destination at the same time, so it becomes part of the same fleet.
    */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int [][] pairs = new int[n][2];

        for(int i=0;i<n;i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b)->b[0]-a[0]);
        double prevTime = (double) (target - pairs[0][0])/pairs[0][1];
        int numberOfFleets = 1;
        for(int i=1;i<n;i++){
            double currTime = (double) (target - pairs[i][0])/pairs[i][1];
            if(currTime > prevTime){
                numberOfFleets++;
                prevTime = currTime;
            }
        }

        return numberOfFleets;
    }
}

/*
    Using Stack: O(nlogn + n)
    Approach:
    - We will sort based on position as Cars closer to the destination are processed first and reached first. 
    - We will calculate the time it is required for a car to reach the destination.
    - We will compare the time of two cars and if the current car time is less than or equal to prev car time
      then it results as they will be forming a fleet.
   
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int [][] pairs = new int[n][2];

        for(int i=0;i<n;i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b)->b[0]-a[0]);
        Stack<Double> container = new Stack<>();

        for(int [] pair: pairs){
            double timeRequiredToReachDest = (double) (target - pair[0])/pair[1];
            container.push(timeRequiredToReachDest);

            if(container.size() >=2 && container.peek() <= container.get(container.size()-2)){
                container.pop();
            }
        }

        return container.size();
    }

     */