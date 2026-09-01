import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startX = 0;
        int startY = 0;

        int[][] litter = new int[m][n];
        int litterCount = 0;

        // Find S and number every L
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    startX = i;
                    startY = j;
                }

                if (c == 'L') {
                    litter[i][j] = litterCount;
                    litterCount++;
                }
            }
        }


        if (litterCount == 0) {
            return 0;
        }

       
        int fullMask = (1 << litterCount) - 1;

      
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        Queue<int[]> queue = new LinkedList<>();

      
        queue.offer(new int[]{
            startX,
            startY,
            energy,
            fullMask
        });

        visited[startX][startY][energy][fullMask] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] state = queue.poll();

                int x = state[0];
                int y = state[1];
                int currEnergy = state[2];
                int mask = state[3];

                // All litter collected
                if (mask == 0) {
                    return moves;
                }

                for (int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // Outside grid
                    if (nx < 0 || nx >= m ||
                        ny < 0 || ny >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nx].charAt(ny) == 'X') {
                        continue;
                    }

                    // No energy to make the move
                    if (currEnergy == 0) {
                        continue;
                    }

                    int newEnergy = currEnergy - 1;
                    int newMask = mask;

                    // Collect litter
                    if (classroom[nx].charAt(ny) == 'L') {

                        int id = litter[nx][ny];

                        newMask &= ~(1 << id);
                    }

                    // Reset energy at R
                    if (classroom[nx].charAt(ny) == 'R') {
                        newEnergy = energy;
                    }

                    if (!visited[nx][ny][newEnergy][newMask]) {

                        visited[nx][ny][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                            nx,
                            ny,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}