import java.util.ArrayList;
import java.util.List;

public class MatrixMultiply {

    private static double[][] mult(double[][] a, double[][] b) {
        if (a.length == 0) return new double[0][0];
        if (a[0].length != b.length) return null; //invalid dims
        int n = a[0].length;
        int m = a.length;
        int p = b[0].length;
        double[][] ans = new double[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ans;
    }

    public static List<List<Double>> power(int n, List<List<Double>> in_A) {
        int len = in_A.size();
        double[][] mat = new double[len][len];

        //list to array
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                mat[i][j] = in_A.get(i).get(j);
            }
        }

        double[][] res = new double[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                res[i][j] = in_A.get(i).get(j);
            }
        }

        for (int i = 2; i <= n; i++) {
            res = mult(mat, res);
        }

        //array to list
        List<List<Double>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            List<Double> temp = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                temp.add(res[i][j]);
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};

        List<Double> list = new ArrayList<>(arr.length);

        for (double i : arr) {
            list.add(i);
        }
        List<List<Double>> s = new ArrayList<>();
        s.add(list);
        s.add(list);
        System.out.println(power(10, s));
    }

}
