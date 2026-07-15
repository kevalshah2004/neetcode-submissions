class Solution {

    boolean dfs(int node, int parent, int[] vis, int[] pathVisited, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        pathVisited[node] = 1;

        for(int neighbor : adj.get(node)){
            if(vis[neighbor] == 0){
                if(dfs(neighbor, parent, vis, pathVisited, adj)) return true;
            }  
            else{
                if(pathVisited[neighbor] == 1){
                    return true;
                }
            }
        }
        pathVisited[node] = 0;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int[] vis = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        for(int i = 0; i<numCourses; i++){
            if(vis[i]!=1){
                if(dfs(i, -1, vis, pathVisited, adj)){
                    return false;
                }
            }
        }
        return true;
    }
}
