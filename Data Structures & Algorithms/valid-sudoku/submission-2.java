class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rowSet = new ArrayList<>();
        List<Set<Character>> colSet = new ArrayList<>();
        List<List<Set<Character>>> innerMatrixSet = new ArrayList<>();

        boolean isValid = true;
        for(int i=0;i<board.length;i++){

            if( innerMatrixSet.size() <= (i/3)){ //innerMatrixSet.size() == 0 ||
                innerMatrixSet.add(new ArrayList<>());
            }
            for(int j=0;j<board[i].length;j++){

                

                if( innerMatrixSet.get(i/3).size() <= (j/3)){ //innerMatrixSet.get(i/3).size() == 0 ||
                    innerMatrixSet.get(i/3).add(new HashSet<>());
                }

                if((board[i][j] != '.')&&(innerMatrixSet.get(i/3).get(j/3).contains(board[i][j]))){
                    isValid = false;
                    // System.out.println("Not valid sudoku");
                    break;
                }

                if((board[i][j] != '.')&&(rowSet != null && rowSet.size() > i && rowSet.get(i) != null) && rowSet.get(i).contains(board[i][j])){
                    isValid = false;
                    // System.out.println("Not valid sudoku");
                    break;
                }

                if((board[i][j] != '.')&&(colSet != null && colSet.size() > j &&  colSet.get(j) != null && colSet.get(j).contains(board[i][j]))){
                    isValid = false;
                    // System.out.println("not a valid sudoku");
                    break;
                }
                if( rowSet.size() <= i || rowSet.get(i) == null){
                    rowSet.add(new HashSet<>());
                }

                // System.out.println("i "+i+" j "+j);
                // System.out.println("rowSet "+rowSet);
                // System.out.println("board "+board[i][j]);
                rowSet.get(i).add(board[i][j]);

                if( colSet.size() <= j ||  colSet.get(j) == null ){
                    colSet.add(new HashSet<>());
                }

                 colSet.get(j).add(board[i][j]);

                 innerMatrixSet.get(i/3).get(j/3).add(board[i][j]);
            }
            if(isValid == false){
                break;
            }
        }

        System.out.println(rowSet);
        System.out.println(colSet);
        System.out.println(innerMatrixSet);

        // System.out.println(isValid ? "valid sudoku" : "not a valid sudoku");
        return isValid;
    }
}
