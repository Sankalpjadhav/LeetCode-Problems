class Solution {
    class Pair{
        int temp, index;
        Pair(int _temp, int _index){
            temp = _temp;
            index = _index;
        }
    }
    
    /*
    Optimal approach: O(2N): Here the approach is to store the index with its temperatures and maintain the stack in the increasing
    order and pop the temperatures which are less than the current temperature. The temperature at the top of the stack will be warmer
    than the current temperature. Since we are storing the index, it is easy to calculate the number of days.
    */

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] result = new int[n];
        Stack<Pair> container = new Stack<Pair>();
        for(int i=n-1;i>=0;i--){
            while(!container.isEmpty() && container.peek().temp <= temperatures[i]){
                container.pop();
            }
            if(container.isEmpty()){
                result[i] = 0;
            }
            else{
                result[i] = container.peek().index - i;
            }
            container.push(new Pair(temperatures[i], i));
        }

        return result;
    }
}

/*
Brute force approach: O(N^2)
Approach: 
For every temperature find out the the temperature to the right which is warmer than the current temperature. Then calculate the
number of days which will be j-i
*/