package hw8_22001622_PhamVanNam.exc4;

public class EulerCircuit {
    public boolean solution(int[][] map) {
        int check =0;
        int count;
        for (int i = 0; i < map.length; i++) {
            count=0;
            for (int j = 0; j < map.length; j++) {
                if (map[i][j]!=0) count++;
            }
            if (count%2!=0) check++;
            if (check>2) return false;
        }
        return true;
    }
}
