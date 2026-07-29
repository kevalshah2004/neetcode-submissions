class Pair{
    int point;
    int dist;

    public Pair(int point, int dist){
        this.point = point;
        this.dist = dist;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        int n = points.length;

        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<n; i++){
            int[] p1 = points[i];
            for(int j = 0; j<n; j++){
                if(i == j) continue;
                int[] p2 = points[j];
                int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                adj.get(i).add(new Pair(j, dist));
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);

        int[] vis = new int[n];

        pq.add(new Pair(0, 0));

        int cost = 0;

        while(!pq.isEmpty()){
            int dist = pq.peek().dist;
            int p = pq.peek().point;
            pq.remove();

            if(vis[p] == 1) continue;

            cost+= dist;

            vis[p] = 1;

            for(Pair neighbor : adj.get(p)){
                if(vis[neighbor.point] == 0){
                    pq.add(new Pair(neighbor.point, neighbor.dist));
                }
            }
        }

        return cost;
    }
}
