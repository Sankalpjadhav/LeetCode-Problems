class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
		
		// keep count of occurances of all elements
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
		
        int out = 1, curr = 1;
        for (int i = 0; curr <= arr.length && i < arr.length; ) {
            out = Math.max(curr, out);

			// if current element exists, we can directly jump to current index + count since it satisfies the given condition.
            if (map.containsKey(curr)) {
                i+= map.get(curr);
            } else {
			   // need this to not accidentally update i with the total count but rather with the remaining (checkout 49th test case [1,209 (10000 times), 10000 (1 time)].
                map.put(arr[i], map.get(arr[i]) - 1);
				
                i++;
            }
            curr += 1;
        }
        return out;
    }
}