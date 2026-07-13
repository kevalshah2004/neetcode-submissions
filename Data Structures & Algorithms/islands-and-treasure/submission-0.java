class Pair{
    int x, y, dist;
    Pair(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {

    public List<int[]> findCoordinate(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        List<int[]> ls = new ArrayList<>();

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 0){
                    ls.add(new int[]{i, j}); 
                }
            }
        }
        return ls;
    }

    public void islandsAndTreasure(int[][] grid) {
        int x = -1;
        int y = -1;

        int m = grid.length;
        int n = grid[0].length;

        List<int[]> coordinates = findCoordinate(grid);
        
        Queue<Pair> q = new LinkedList<>();

        for(int[] coordinate : coordinates){
            q.add(new Pair(coordinate[0], coordinate[1], 0));
        }

        int rowDir[] = {-1, 0, 1, 0};
        int colDir[] = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int cx = p.x;
            int cy = p.y;
            int dist = p.dist;
            for(int k = 0; k<4; k++){
                int newx = cx + rowDir[k];
                int newy = cy + colDir[k];
                int newDist = dist+1;
                if(newx >=0 && newx < m && newy >= 0 && newy < n && newDist < grid[newx][newy] && grid[newx][newy]!=-1){
                    grid[newx][newy] = newDist;
                    q.add(new Pair(newx, newy, newDist));
                }
            }
        }
    }
}
