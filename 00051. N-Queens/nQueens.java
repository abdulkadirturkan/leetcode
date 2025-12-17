class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] cols = new int[n];
        backtrack(0, n, cols, result);
        return result;
    }

    private void backtrack(int row, int n, int[] cols, List<List<String>> result){
        if(row == n){
            result.add(buildBoard(cols,n));
            return;
        }
        for(int col = 0; col < n; col++){
            if(isSafe(row, col, cols)){
                cols[row] = col;
                backtrack(row+1, n, cols, result);
            }
        }
    }

    private boolean isSafe(int row, int col, int[] cols){
        for(int i = 0; i < row; i++){
            if(cols[i] == col || Math.abs(cols[i] - col) == row - i){
                return false;
            }
        }
        return true;
    }

    private List<String> buildBoard(int[] cols, int n){
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[cols[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
