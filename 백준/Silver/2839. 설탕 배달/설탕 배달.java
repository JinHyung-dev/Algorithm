import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private final static int FAIL = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalHeight = Integer.parseInt(br.readLine());
        int result = 0;
        result = calc(totalHeight, 0);
        System.out.println(result);
    }

    private static int calc(int number, int count) {
        if (number < 0) {
            return FAIL;
        }
        if (number % 5 == 0) {
            return number / 5 + count;
        }
        return calc(number - 3, ++count);
    }
}
