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

        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.add(k);
        dist[k] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(Pair p : adj.get(curr)){
                int neighbor =  p.node;
                int currDist = p.dist;
                int newDist = currDist + dist[curr];
                if(newDist < dist[neighbor]){
                    q.add(neighbor);
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
