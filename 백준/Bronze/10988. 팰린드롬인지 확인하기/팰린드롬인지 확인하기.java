import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        if (word.length() == 1) {
            System.out.println(1);
            return;
        }

        // 투포인터 : 두 포인터가 교차될 때까지 진행
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                System.out.println(0);
                return;
            }
            start++;
            end--;
        }

        // 최종 출력
        System.out.println(1);
    }
}