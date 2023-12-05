package hw8_22001622_PhamVanNam.geeksForGeeks;

public class exc7 {
    int count=0;
    public int numIslands(char[][] grid) {
        // Code here
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1') {
                    check(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void check(char[][] grid, int height, int width) {
        if (height<0 ||width<0||height>=grid.length
                ||width>=grid[0].length||grid[height][width]=='0') return;
        grid[height][width]='0';
        check(grid, height-1, width-1);
        check(grid, height-1, width);
        check(grid, height-1, width+1);
        check(grid, height, width+1);
        check(grid, height+1, width+1);
        check(grid, height+1, width);
        check(grid, height+1, width-1);
        check(grid, height, width-1);
    }
}
