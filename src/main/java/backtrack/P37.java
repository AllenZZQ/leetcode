package backtrack;

import java.util.HashSet;
import java.util.Set;

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

    private Set<Integer> find(char[][] board, int i, int j) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        for (int p = 0; p < 9; p++) {
            if (board[i][p] != '.') {
                set.remove(Integer.valueOf(String.valueOf(board[i][p])));
            }
        }
        for (int p = 0; p < 9; p++) {
            if (board[p][j] != '.') {
                set.remove(Integer.valueOf(String.valueOf(board[p][j])));
            }
        }
        for (int p = (i / 3) * 3; p < (i / 3) * 3 + 3; p++) {
            for (int q = (j / 3) * 3; q < (j / 3) * 3 + 3; q++) {
                if (board[p][q] != '.') {
                    set.remove(Integer.valueOf(String.valueOf(board[p][q])));
                }
            }
        }
        return set;
    }

}
