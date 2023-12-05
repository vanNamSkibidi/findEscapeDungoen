package hw8_22001622_PhamVanNam.geeksForGeeks;

public class exc10 {
    public int isPossible(int[][] paths) {
        // Code here
        for (int i = 0; i < paths.length; i++) {
            int temp = 0;
            for (int j = 0; j < paths.length; j++) {
                if (paths[i][j] == 1)
                    temp++;
            }
            if (temp % 2 != 0)
                return 0;
        }
        return 1;
    }
}
