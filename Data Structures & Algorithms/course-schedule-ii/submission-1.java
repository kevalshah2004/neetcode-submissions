class Solution {

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st){
        vis[node] = 1;

        for(int neighbor : adj.get(node)){
            if(vis[neighbor] == 0){
                dfs(neighbor, adj, vis, st);
            }
            else if(vis[neighbor] == 1)
                return true;
        }
        st.push(node);
        vis[node] = 2;
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int vis[] = new int[numCourses];

        for(int i = 0; i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<numCourses;i++){
            if(vis[i] == 0){
                if(dfs(i, adj, vis, st)){
                    return new int[]{};
                }
            }
        }

        if(st.size() < numCourses) return new int[] {};
        int[] ans = new int[numCourses];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    }
}
