class Solution {
    
    public List<String> reverse(List<String> answer){
        int left = 0;
        int right = answer.size()-1;
        while(left<right){
            String temp = answer.get(left);
            answer.set(left,answer.get(right));
            answer.set(right,temp);
            left++;
            right--;
        }
        return answer;
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String , PriorityQueue<String>> map = new HashMap<>();
        for(List<String> routes: tickets){
            String from = routes.get(0);
            String to = routes.get(1);
            if(!map.containsKey(from)){
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(to);
                map.put(from,pq);
            }
            else{
                PriorityQueue<String> pq = map.get(from);
                pq.add(to);
            }
        }
        
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        List<String> answer = new ArrayList<>();
        while(stack.size()!=0){
            String from = stack.peek();
            PriorityQueue<String> pq = map.get(from); 
            if(pq!=null && pq.size()!=0){
                stack.push(map.get(from).poll());
            }
            else{
                answer.add(stack.pop());
            }
        }
        reverse(answer);
        return answer;
    }
}