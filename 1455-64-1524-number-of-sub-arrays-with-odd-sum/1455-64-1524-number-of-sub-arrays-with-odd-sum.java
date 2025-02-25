class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int numberOfOddSubarrays = 0, numberOfEvenSubarrays = 0;
        int sum = 0;

        for(int num: arr){
            if(num % 2 == 0){
                numberOfEvenSubarrays++;
            }
            else{
                // current num is odd, that means if we include this odd num in all the even subarrays we get odd subarrays
                int temp = numberOfOddSubarrays;
                numberOfOddSubarrays = numberOfEvenSubarrays + 1;
                numberOfEvenSubarrays = temp;
            }

            sum = (sum + numberOfOddSubarrays) % 1000000007;
        }

        return sum;
    }

    
    
}

/*
Recursion: TLE

public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        return helper(0, -1, 0, n, arr);
    }

    private int helper(int index, int prevIndex, int sum, int n, int [] arr){
        if(index == n){
            if(sum % 2 != 0){
                return 1;
            }

            return 0;
        }

        int notPick = helper(index+1, prevIndex, sum, n, arr);
        int pick = 0;
        if(prevIndex == -1 || prevIndex + 1 == index){
            pick = helper(index+1, index, sum + arr[index], n, arr);
        }
        
        return notPick + pick;
    }
*/