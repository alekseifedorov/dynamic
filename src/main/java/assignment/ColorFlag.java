package assignment;

import java.util.HashSet;
import java.util.Set;

public class ColorFlag {
    int color(char flag[][]) {
        int[][] flag1 = new int[flag.length][flag[0].length];

        int result = 1;
        for (int i = 0; i < flag1.length; i++) {
            for (int j = 0; j < flag1[0].length; j++) {
                fill(flag, flag1, i, j, flag[i][j], result++);
            }
        }

        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < flag1.length; i++) {
            for (int j = 0; j < flag1[0].length; j++) {
                res.add(flag1[i][j]);
            }
        }

        return res.size();
    }

    private void fill(char flag[][], int flag1[][], int i, int j, char source, int result) {
        if (flag1[i][j] != 0) {
            return;
        }
        if (flag[i][j] != source) {
            return;
        }

        flag1[i][j] = result;

        if (i > 0) {
            fill(flag, flag1, i - 1, j, source, result);
        }

        if (i < flag.length - 1) {
            fill(flag, flag1, i + 1, j, source, result);
        }

        if (j > 0) {
            fill(flag, flag1, i, j - 1, source, result);
        }

        if (j < flag[0].length - 1) {
            fill(flag, flag1, i, j + 1, source, result);
        }
    }
}
