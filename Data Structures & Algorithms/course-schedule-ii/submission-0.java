class Solution {

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVisited, Stack<Integer> st){
        vis[node] = 1;
        pathVisited[node] = 1;

        for(int neighbor : adj.get(node)){
            if(vis[neighbor] == 0){
                dfs(neighbor, adj, vis, pathVisited, st);
            }
            else if(pathVisited[neighbor] == 1)
                return true;
        }
        st.push(node);
        pathVisited[node] = 0;
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

        int[] pathVisited = new int[numCourses];

        for(int i = 0; i<numCourses;i++){
            if(vis[i] == 0){
                if(dfs(i, adj, vis, pathVisited, st)){
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
