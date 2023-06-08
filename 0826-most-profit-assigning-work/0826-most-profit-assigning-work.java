class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(new int[]{difficulty[i],profit[i]});
        }
        list.sort((a,b)->(a[0]-b[0]!=0?a[0]-b[0]:b[1]-a[1]));
        int[] max = new int[n];
        max[0]=list.get(0)[1];// Maximum Value till a given index.
        for (int i=1;i<n;i++) {
            max[i]=Math.max(list.get(i)[1],max[i-1]); 
        }
        int ans=0;
        for(int w: worker) {
            int res = bs(w,list);
            ans+=res==-1?0:max[res];
        }
        return ans;
    }
	// Smallest index which is less than or equal to the given target.
    private int bs(int target,List<int[]> list) {
        int lo = 0;
        int hi = list.size()-1;
        if(target>=list.get(hi)[0]) {
            return hi;
        }
        int ans = -1;
        while (lo<hi) {
            int mid = (lo)+(hi-lo)/2;
            int val = list.get(mid)[0];
            if(target>=val) {
                ans=mid;
                lo=mid+1;
            } else {
                hi=mid;
            }
        }
        return ans;
    }
}