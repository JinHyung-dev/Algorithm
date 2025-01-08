import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int member = Integer.parseInt(br.readLine());
        int[][] members = new int[member][3];
        int[] rank = new int[member];
        Arrays.fill(rank, 1);

        for(int i = 0; i < member; i++) {
            String[] input = br.readLine().split(" ");
            members[i][0] = Integer.parseInt(input[0]); // 몸무게
            members[i][1] = Integer.parseInt(input[1]); // 키
        }

        for(int i = 0; i < member; i++) {
            int[] a = members[i];
            int ax = a[0];
            int ay = a[1];
            for(int j = 0; j < member; j++) {
                if(i==j) continue;
                int[] b = members[j];
                int bx = b[0];
                int by = b[1];

                // i가 j보다 덩치가 작다면 i의 순위를 증가
                if(ax < bx && ay < by) {
                    rank[i]++;
                    continue;
                }
            }
        }
        for(int i = 0; i < rank.length; i++) {
            System.out.print(rank[i]);
            if(i != rank.length-1) {
                System.out.print(" ");
            }
        }
    }
}
