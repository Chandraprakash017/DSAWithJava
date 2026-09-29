class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
       
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        
   
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        
    
        int maxOpen = (m + n - 1) / 2;
        boolean[][][] visited = new boolean[m][n][maxOpen + 1];
        
        return dfs(grid, 0, 0, 0, visited, maxOpen);
    }
    
    private boolean dfs(char[][] grid, int r, int c, int open, boolean[][][] visited, int maxOpen) {
        int m = grid.length;
        int n = grid[0].length;
        
      
        if (grid[r][c] == '(') {
            open++;
        } else {
            open--;
        }
        
    
        if (open < 0 || open > maxOpen) {
            return false;
        }
        
  
        if (r == m - 1 && c == n - 1) {
            return open == 0;
        }
        
    
        if (visited[r][c][open]) {
            return false;
        }
        visited[r][c][open] = true;
        
        
        if (c + 1 < n && dfs(grid, r, c + 1, open, visited, maxOpen)) {
            return true;
        }
        if (r + 1 < m && dfs(grid, r + 1, c, open, visited, maxOpen)) {
            return true;
        }
        
        return false;
    }
}