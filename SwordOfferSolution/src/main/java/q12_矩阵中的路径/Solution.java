package q12_矩阵中的路径;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;
        //把字符串变为字符数组，方便操作
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                return DFS(board, i, j, words, 0);
            }
        }
        return false;
    }

    //i, j表示单元格在举证中的位置
    private boolean DFS(char[][] board, int i, int j, char[] words, int charIndex) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[charIndex])
            return false;
        if (charIndex == words.length - 1) return true;
        //把当前单元格字符变为' '，防止走"回头路"
        //由于后面匹配不成功时需要回溯返回，所以要把当前字符保存到temp中
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean res = DFS(board, i - 1, j, words, charIndex + 1) ||
                DFS(board, i + 1, j, words, charIndex + 1) ||
                DFS(board, i, j - 1, words, charIndex + 1) ||
                DFS(board, i, j + 1, words, charIndex + 1);
        //回溯时取消标记
        board[i][j] = temp;
        return res;
    }


}
