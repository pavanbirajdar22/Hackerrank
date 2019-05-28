import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    private static final Scanner scanner = new Scanner(System.in);

    static String isBalanced(String s) {
        if (s.length()==0) return "YES";
        if (s.length()%2 != 0 ) return "NO";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isOpeningBracket(s.charAt(i))) stack.push(s.charAt(i));
            else {
                char curr = s.charAt(i);
                if (stack.empty()) return "NO";
                char popped = stack.pop();
                if(compare(curr, popped)) return "NO";
            }
        }
        if (!stack.empty()) return "NO";
        return "YES";
    }

    private static boolean compare(char curr, char popped) {
        if (curr == ')' && popped == '(') return false;
        if (curr == ']' && popped == '[') return false;
        if (curr == '}' && popped == '{') return false;
        return true;
    }

    private static boolean isOpeningBracket(char charAt) {
        return charAt == '[' || charAt == '{' || charAt == '(';
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUPUT.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
