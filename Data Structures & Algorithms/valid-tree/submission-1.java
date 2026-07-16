class Solution {

    public boolean validTree(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean vis[] = new boolean[n];
        vis[0] = true;
        long totalDegree = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            totalDegree+=adj.get(node).size();
            for(int neighbor : adj.get(node)){
                if(!vis[neighbor]){
                    q.add(neighbor);
                    vis[neighbor] = true;
                }
            }
        }
        if(totalDegree/2 == n-1) return true;
        return false;
    }
}
