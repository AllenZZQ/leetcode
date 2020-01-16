package backtrack;

/**
 * @see hashtable.P36
 */
public class P37 {

    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c ++) {
                        if (valid(board, i, j, c)) {
                            board[i][j] = c;
                            if (helper(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i ++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
        }
        for (int p = (row / 3) * 3; p < (row / 3) * 3 + 3; p++) {
            for (int q = (col / 3) * 3; q < (col / 3) * 3 + 3; q++) {
                if (board[p][q] == c) {
                   return false;
                }
            }
        }
        return true;
    }

}
