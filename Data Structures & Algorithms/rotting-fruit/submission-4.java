
class Pair{
    int x;
    int y;
    int time;
    Pair(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Solution {

    public void findRotten(int[][] grid, List<Pair> rotten){
        int m = grid.length;
        int n = grid[0].length;

        
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int freshOranges = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    grid[i][j] = -1;
                }
                else if(grid[i][j] == 1) freshOranges++;
            }
        }

        if(freshOranges == 0) return 0;

        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};

        int ans = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int time = p.time;
            ans = Math.max(time, ans);
            for(int k = 0; k<4; k++){
                int newx = x + rowDir[k];
                int newy = y + colDir[k];
                int newTime = time + 1;
                if(newx >=0 && newx <m && newy >=0 && newy < n && grid[newx][newy] == 1){
                    q.add(new Pair(newx, newy, newTime));
                    freshOranges--;
                    grid[newx][newy] = -1;
                }
            }
        }

        if(freshOranges != 0) return -1;
        return ans;
    }
}
