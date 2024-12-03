import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] paper = new int[100][100];
        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++) {
            String input = br.readLine();
            String[] arr = input.split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);

            for(int j = x; j < x + 10; j++) {
                for(int z = y; z < y + 10; z++) {
                    paper[j][z] = 1;
                }
            }
        }

        int total = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(paper[i][j] == 1) total++;
            }
        }
        System.out.println(total);
    }
}
