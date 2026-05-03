class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] square = new boolean[9][10];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.') continue;
                int value = board[i][j]-'0';
                int boxNum = (i/3)*3+(j/3);
                if(square[boxNum][value]) return false;
                square[boxNum][value]=true;
                if(cols[j][value]) return false;
                cols[j][value]=true;
                if(rows[i][value]) return false;
                rows[i][value]=true;
            }
        }
        return true;
    }
}
