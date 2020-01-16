package backtrack;

public class P79 {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (board[i][j] == word.charAt(0)) {
                   if (helper(board, word, i, j, 0)) {
                       return true;
                   }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '?'; // 设置占位符
        boolean result = helper(board, word, i - 1, j, index + 1) ||
                helper(board, word, i + 1, j, index + 1) ||
                helper(board, word, i, j - 1, index + 1) ||
                helper(board, word, i, j + 1, index + 1);
        board[i][j] = temp;
        return result;
    }


}
