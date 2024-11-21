import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int lineCount = 1;
        int sum = 0;
        while(sum + lineCount < x) {
            sum += lineCount;
            lineCount++;
        }

        int index = x - sum; // 총 숫자 중 지나온 수 빼기
        int numerator, denominator;
        if (lineCount % 2 == 0) {
            numerator = index;
            denominator = lineCount - index + 1;
        } else {
            numerator = lineCount - index + 1;
            denominator = index;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
