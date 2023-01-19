class Solution {

    public int subarraysDivByK(int[] A, int K) {
        int n = A.length;
        
        int currentSum = 0;
        int count = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0; i<n; i++){
            currentSum += A[i];
            currentSum %= K;
            if(currentSum < 0){
                currentSum += K;
            }
            count += map.getOrDefault(currentSum, 0);
            //System.out.println(A[i]+"->"+count);
            map.put(currentSum, map.getOrDefault(currentSum, 0)+1);
        }
        
        return count;
    }
}