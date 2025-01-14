class Solution {

    class Pair{
        int node, price, stop;
        Pair(int _node, int _price, int _stop){
            node = _node;
            price = _price;
            stop = _stop;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(i, new ArrayList<>());    
        }

        for(int [] flight: flights){
            adj.get(flight[0]).add(new Pair(flight[1], flight[2], 0));
        }

        int [] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)-> x.price - y.price);
        pq.add(new Pair(src, 0, -1));

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int city = pair.node;
            int price = pair.price;
            int stop = pair.stop;
            // System.out.println("City: "+city+" , price: "+price);

            if(stop > k || stops[city] < stop){
                continue;
            }

            stops[city] = stop;

            if(city == dst){
                return price;
            }

            for(Pair adjPair: adj.get(city)){
                int adjCity = adjPair.node;
                int adjCityPrice = adjPair.price;
                pq.add(new Pair(adjCity, adjCityPrice + price, stop+1));
            }
        }

        return -1;
    }
}

/*
Gives TLE

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            adj.get(from).add(new int[]{to, cost});
        }

        // PriorityQueue to store {cost, currentNode, stopsUsed}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int currentAirport = current[1];
            int stopsUsed = current[2];

            if (currentAirport == dst) {
                return currentCost;
            }

            if (stopsUsed > k) continue;

            for (int[] next : adj.get(currentAirport)) {
                int nextAirport = next[0];
                int nextAirportCost = next[1];
                pq.add(new int[]{currentCost + nextAirportCost, nextAirport, stopsUsed + 1});
            }
        }

        return -1;
    }
}

*/




