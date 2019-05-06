package assignment;


public class CommonText {

    private int[][] createMatrix(String[] first, String[] second) {
        int[][] result = new int[first.length][second.length];
        for (int i = 1; i < first.length; i++) {
            for (int j = 1; j < second.length; j++) {
                if (second[j].equals(first[i])) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                }
            }
        }

        return result;
    }

    public String find(String first, String second) {
        String[] splitFirstText = first.split(" ");
        String[] splitSecondText = second.split(" ");

        int[][] matrix = createMatrix(splitFirstText, splitSecondText);

        int a = 0;
        int b = 0;
        int max = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    a = i;
                    b = j;
                }
            }
        }

        String result = "";
        while (matrix[a][b] > 0) {
            result = splitFirstText[a] + (result.length() > 0 ? " " : "") + result;
            a--;
            b--;
        }

        return result;
    }
}
