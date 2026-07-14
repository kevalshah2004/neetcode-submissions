class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {

    public void bfs(int i, int j, char[][] board){
        int m = board.length;
        int n = board[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(i, j));

        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k<4; k++){
                int newx = x + rowDir[k];
                int newy = y + colDir[k];
                if(newx >= 1 && newx < m-1 && newy >=1 && newy<n-1 && board[newx][newy]=='O'){
                    board[newx][newy] = '#';
                    q.add(new Pair(newx, newy));
                }
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i<m; i++){
            if(board[i][0] == 'O'){
                bfs(i, 0, board);
            }
            if(board[i][n-1] == 'O'){
                bfs(i, n-1, board);
            }
        }

        for(int j = 0; j<n; j++){
            if(board[0][j] == 'O')
                bfs(0, j, board);
            if(board[m-1][j] == 'O')
                bfs(m-1, j, board);
        }

        for(int i = 1; i<m-1; i++){
            for(int j = 1; j<n-1; j++){
                if(board[i][j] == '#')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                        board[i][j] = 'X';
            }
        }

        
    }
}
