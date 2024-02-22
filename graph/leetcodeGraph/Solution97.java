class Solution79 {
    public boolean dfs(char[][] board, String word, int row, int column, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != word.charAt(index)) {
            return false;
        }
        char temp = board[row][column];
        board[row][column] = '*'; // Mark visited
        boolean found = dfs(board, word, row + 1, column, index + 1) ||
                         dfs(board, word, row - 1, column, index + 1) ||
                         dfs(board, word, row, column + 1, index + 1) ||
                         dfs(board, word, row, column - 1, index + 1);
        board[row][column] = temp; // Reset back
        return found;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}

