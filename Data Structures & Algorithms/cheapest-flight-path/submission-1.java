class Pair{
    int dst;
    int cost;

    Pair(int dst, int cost){
        this.dst = dst;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] flight : flights){
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        Queue<int[]> q = new ArrayDeque<>();
        int dist[] = new int[n];
        Arrays.fill(dist, (int)(1e8));
        dist[src] = 0;

        q.add(new int[]{src, 0, 0});

        while(!q.isEmpty()){
            int[] arr = q.remove();
            if(arr[1] > k) continue;

            for(Pair neigh : adj.get(arr[0])){
                if(arr[2] + neigh.cost < dist[neigh.dst]){
                    dist[neigh.dst] = arr[2] + neigh.cost;
                    q.add(new int[]{neigh.dst, arr[1]+1, dist[neigh.dst]});
                }
            }
        }

        return dist[dst] == (int)(1e8) ? -1 : dist[dst];
    }
}
