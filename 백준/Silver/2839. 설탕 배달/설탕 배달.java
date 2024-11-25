import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalHeight = Integer.parseInt(br.readLine());
        int result = 0;
        int count = 0;
        while (totalHeight >= 0) {
            if (totalHeight % 5 == 0) {
                result = totalHeight / 5 + count;
                System.out.println(result);
                return;
            } else {
                totalHeight -= 3;
                ++count;
            }
        }
        System.out.println(-1);
    }
}
