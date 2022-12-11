package Final;

public class NumberOfIsland {
	
	public static int numberOfIsland(int[][] grid) {
		int ans = 0;
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1 && !visited[i][j]) {
					dfs(grid, i, j, visited);
					ans++;
				}
			}
		}
		return ans;
	}
	
	public static void dfs(int[][] grid, int row, int col, boolean[][] visited) {
		int m = grid.length;
		int n = grid[0].length;
		if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == 0) {
			return;
		}
		visited[row][col] = true;
		dfs(grid, row + 1, col, visited);
		dfs(grid, row - 1, col, visited);
		dfs(grid, row, col + 1, visited);
		dfs(grid, row, col - 1, visited);
	}

	public static void main(String[] args) {
		int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
		System.out.println(numberOfIsland(grid));
		// TODO Auto-generated method stub

	}
	//T:O(mn)

}
