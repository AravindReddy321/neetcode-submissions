class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            Set<Character> rset = new HashSet<Character>();
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.') continue;
                if(rset.contains(board[i][j])) { print("rowset");return false;}
                rset.add(board[i][j]);
            }
        }
        for(int i=0;i<board.length;i++){
            Set<Character> cset = new HashSet<Character>();
            for(int j=0;j<board.length;j++){
                if(board[j][i]=='.') continue;
                if(cset.contains(board[j][i])) { print("colset");return false;}
                cset.add(board[j][i]);
            }
        }
        // for(int i=0;i<board.length;i=i+3){
        //     for(int j=0;j<board.length;j=j+3){
        //         Set<Character> sqset = new HashSet<>();
        //         for(int r=i;r<i+3;r++){
        //             for(int c=j;c<j+3;c++){
        //                 if(board[r][c]=='.') continue;
        //                 if(sqset.contains(board[r][c])) { print("square board"+r+" "+c);return false;}
        //                 sqset.add(board[r][c]);
        //             }
        //         }
        //     }
        // }
        List<Set<Character>> ls = new ArrayList<>();
        for(int i=0;i<9;i++){
            ls.add(new HashSet<>());
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.') continue;
                int boxNum = (i/3)*3+(j/3);
                if(ls.get(boxNum).contains(board[i][j])) { print("square board"+i+" "+j);return false;}
                ls.get(boxNum).add(board[i][j]);
            }
        }
        return true;
    }

    void print(String s){
        System.out.println(s);
    }
    
}
