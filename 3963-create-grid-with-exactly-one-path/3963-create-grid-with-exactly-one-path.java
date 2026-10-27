class Solution {
    public String[] createGrid(int m, int n) {
        char[][] ans=new char[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(ans[i], '#');
        }
            for(int j=0;j<n;j++){

            ans[0][j]='.';
        }
        for (int i = 0; i < m; i++) {
            ans[i][n - 1] = '.';
        }

        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(ans[i]);
        }

        return result;
        
    }
}