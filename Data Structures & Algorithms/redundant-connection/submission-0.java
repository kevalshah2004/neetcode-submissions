class Disjoint{
    int size[];
    int parent[];

    Disjoint(int n){

        size = new int[n+1];
        parent = new int[n+1];

        for(int i = 0; i<=n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findUPar(int node){
        if(node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    public boolean unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return true;

        size[ulp_u] += size[ulp_v];
        parent[ulp_v] = ulp_u;
        return false;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        Disjoint ds = new Disjoint(n);

        for(int i = 0; i<n; i++){
            if(ds.unionBySize(edges[i][0], edges[i][1])){
                return new int[]{edges[i][0], edges[i][1]};
            }
        }
        return new int[]{};
    }
}
