package hw.hw8_22001622_PhamVanNam.geeksForGeeks;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        exc11 test = new exc11();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lists.add(new ArrayList<>());
        }
        lists.get(0).add(1);
        lists.get(0).add(2);
        lists.get(1).add(2);
        lists.get(1).add(3);
        lists.get(2).add(3);
        lists.get(2).add(4);
        lists.get(3).add(2);
        lists.get(3).add(4);
        System.out.println(test.check(4, 4, lists));
    }
}
