public class Longest {

    private static int[][] findMatrix(String s) {
        int n = s.length();
        int[][] matrix = new int[n][n];

        for (int t = 0; t < n; t++) {
            matrix[t][t] = 1;
        }

        for (int t = 0; t < n; t++) {
            for (int i = 0; i < n; i++) {
                System.out.print(matrix[t][i] + " ");
            }
            System.out.println();
        }

        int i, j, subLength;
        for (subLength = 2; subLength <= n; subLength++) {
            for (i = 0; i < n - subLength + 1; i++) {
                j = i + subLength - 1;
                boolean isSame = s.charAt(i) == s.charAt(j);
                if (isSame && (subLength == 2))
                    matrix[i][j] = 2;
                else if (isSame)
                    matrix[i][j] = matrix[i + 1][j - 1] + 2;
                else
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i + 1][j]);
            }
        }

        System.out.println();

        for (int t = 0; t < n; t++) {
            for (i = 0; i < n; i++) {
                System.out.print(matrix[t][i] + " ");
            }
            System.out.println();
        }

        System.out.println();

        return matrix;
    }

    public static int getScore(String s) {
        int res = Integer.MIN_VALUE;
        int[][] ans = findMatrix(s);
        for (int i = 0; i < s.length() - 1; i++) {
            int temp = ans[0][i] * ans[i + 1][s.length() - 1];
            if (res <= temp)
                res = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        Longest l = new Longest();
        System.out.println(getScore("axbawbaseksqke"));
    }

}