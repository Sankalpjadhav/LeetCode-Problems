class Solution {
    public int bestClosingTime(String customers) {
            int s = customers.length();
			List<Integer> y = new ArrayList<>();
        	List<Integer> n = new ArrayList<>();
			y.add(0);
			n.add(0);
			int cnt=0;
			for(int i=0;i<s;i++){
				if(customers.charAt(i) == 'N'){
                    cnt++;
                }
				n.add(cnt);
			}
        
			cnt=0;
        
			for(int i=s-1;i>=0;i--){
				if(customers.charAt(i) == 'Y'){
                    cnt++;
                }
				y.add(cnt);
			}
        
			Collections.reverse(y);
			int ans = (int) 1e9 ,ind = 0;
			for(int i=0;i<s+1;i++){
				int penalty = y.get(i) + n.get(i);
				if(penalty < ans){
					ans = penalty;
					ind = i;
				}
			}
        
			return ind;
    }
}