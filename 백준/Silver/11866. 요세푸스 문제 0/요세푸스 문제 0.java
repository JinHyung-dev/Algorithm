import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        Queue<Integer> circle = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            circle.add(i+1);
        }

        System.out.print("<");
        while (!circle.isEmpty()) {
            // (k-1)번 앞으로 보냄
            for (int i = 1; i < k; i++) {
                circle.add(circle.poll());
            }
            // k번째 값 출력
            System.out.print(circle.poll());
            if (!circle.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
