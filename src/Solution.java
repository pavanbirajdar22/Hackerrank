import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'findMatrix' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY a as parameter.
     */

    public static List<List<Integer>> findMatrix(List<List<Integer>> a) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            List<Integer> rowi = a.get(i);
            List<Integer> temp = new ArrayList<>();
            int prev = 0;
            for (int j = 0; j < rowi.size(); j++) {
                if (i == 0) {
                    int curr = rowi.get(j);
                    temp.add(prev + curr);
                    prev += curr;
                } else {
                    int curr = rowi.get(j);
                    int lastSum = res.get(i - 1).get(j);
                    temp.add(prev + curr + lastSum);
                    prev += curr;
                }
            }
            res.add(temp);
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

        int aRows = Integer.parseInt(bufferedReader.readLine().trim());
        int aColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> a = new ArrayList<>();

        IntStream.range(0, aRows).forEach(i -> {
            try {
                a.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> result = Result.findMatrix(a);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
