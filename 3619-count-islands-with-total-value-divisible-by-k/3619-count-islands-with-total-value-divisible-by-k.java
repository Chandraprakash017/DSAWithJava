class Solution {
    public int countIslands(int[][] grid, int k) {
        int row=grid.length;
        int col=grid[0].length;
        int iscount=0;

        for(int i=0;i<row;i++){

            for(int j=0;j<col;j++){
                if(grid[i][j]>0){
                    long island=dfs(grid,i,j);
                    if(island%k==0){
                        iscount++;
                    }

                }
                

            }

        }
        return iscount;
        
    }
    private long dfs(int[][] grid, int r, int c) {
        
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] <= 0) {
            return 0;
        }
        
        long currentVal = grid[r][c];
        
       
        grid[r][c] = 0;
        
        long totalSum = currentVal 
                      + dfs(grid, r + 1, c) 
                      + dfs(grid, r - 1, c) 
                      + dfs(grid, r, c + 1) 
                      + dfs(grid, r, c - 1);
                      
        return totalSum;
    }
}