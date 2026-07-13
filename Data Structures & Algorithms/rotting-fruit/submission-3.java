
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

        List<Pair> rotten = new ArrayList<>();
        
        int total = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    rotten.add(new Pair(i, j, 0));
                    grid[i][j] = -1;
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();

        for(Pair p : rotten){
            q.add(p);
        }

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
                    grid[newx][newy] = -1;
                }
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return ans;
    }
}
