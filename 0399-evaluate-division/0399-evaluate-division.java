class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);
        
        double [] answer = new double[queries.size()];
        Arrays.fill(answer, -1);
        
        for(int i=0; i<queries.size(); i++){
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            
            if(dividend.equals(divisor) && graph.containsKey(dividend)){
                answer[i] = 1;
                continue;
            }
            
            if(!graph.containsKey(divisor) || !graph.containsKey(dividend)){
                answer[i] = -1;
                continue;
            }
            
            Set<String> visited = new HashSet<>();
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(dividend, 1.0));
            visited.add(dividend);
            
            while(!queue.isEmpty()){
                Pair pair = queue.poll();
                String s = pair.getStr();
                double value = pair.getValue();
                
                for(String neighbour: graph.get(s).keySet()){
                    if(!visited.contains(neighbour)){
                        if(neighbour.equals(divisor)){
                            answer[i] =  graph.get(s).get(neighbour) * value;
                            break;
                        }
                        
                        queue.add(new Pair(neighbour, graph.get(s).get(neighbour) * value));
                        visited.add(neighbour);
                    }
                }
            }
            
        }
        
        return answer;
    }
    
    
    
    private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double [] values){
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        int i=0;
        for(List<String> equation : equations){
            String node1 = equation.get(0);
            String node2 = equation.get(1);
            double value = values[i];
            i++;
            
            if(!graph.containsKey(node1)){
                graph.put(node1, new HashMap<String, Double>());
            }
            graph.get(node1).put(node2, value);
            
            if(!graph.containsKey(node2)){
                graph.put(node2, new HashMap<String, Double>());
            }
            graph.get(node2).put(node1, 1.0/value);
        }
        
        return graph;
    }
}

class Pair{
    private String str;
    private double value;
    
    Pair(String str, double value){
        this.str = str;
        this.value = value;
    }
    
    public String getStr(){
        return str;
    }
    
    public double getValue(){
        return value;
    }
}