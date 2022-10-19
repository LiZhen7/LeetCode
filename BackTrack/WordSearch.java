package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
	
    private int m, n;
    
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> startPos = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    startPos.add(new int[]{i, j});
                }
            }
        }
        for(int[] pos : startPos) {
            if(backtrack(board, word, pos[0], pos[1], 0, visited)) return true;
        }
        return false;
    }
    
    public boolean backtrack(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if(index == word.length()) return true;
        if(row < 0 || row >= m || col < 0 || col >= n || board[row][col] != word.charAt(index) || visited[row][col]) return false;
        
        boolean ans = false;
        visited[row][col] = true;
        ans = backtrack(board, word, row + 1, col, index + 1, visited) || backtrack(board, word, row - 1, col, index + 1, visited) || backtrack(board, word, row, col + 1, index + 1, visited) || backtrack(board, word, row, col - 1, index + 1, visited);
        visited[row][col] = false;
        return ans;
    }

}
