class Pair{
    int node;
    int dist;

    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int[n+1];

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> Integer.compare(a.dist, b.dist));
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.add(new Pair(k,0));
        dist[k] = 0;

        while(!q.isEmpty()){
            Pair pair = q.poll();
            int curr = pair.node;
            for(Pair p : adj.get(curr)){
                int neighbor =  p.node;
                int currDist = p.dist;
                int newDist = currDist + dist[curr];
                if(newDist < dist[neighbor]){
                    q.add(new Pair(neighbor, newDist));
                    dist[neighbor] = newDist;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            if(dist[i] > max) max = dist[i];
        }
        return max;
    }
}
