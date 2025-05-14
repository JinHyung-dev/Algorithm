import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][2];
        
        // 좌표 저장
        for(int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }
        
        // 정렬 : 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서
        Arrays.sort(arr, (a,b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        
        // 최종 출력
        StringBuilder sb = new StringBuilder();
        for(int[] a : arr) {
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }
        System.out.print(sb);
    }
}