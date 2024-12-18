import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String[] black = {
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB"
    };
    private static final String[] white = {
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        String[] board = new String[m];
        for(int i = 0; i < m; i++) {
            board[i] = br.readLine();
        }

        // 최소 구역에서 최소 타일 색칠 갯수 세기
        int result = Integer.MAX_VALUE;
        // 보드를 슬라이딩 윈도우로 순회
        for (int i = 0; i <= m - 8; i++) {
            for (int j = 0; j <= n - 8; j++) {
                int countPattern1 = 0;
                int countPattern2 = 0;

                // 8×8 영역 검사
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        // 패턴1과 비교
                        if (board[i + x].charAt(j + y) != black[x].charAt(y)) {
                            countPattern1++;
                        }
                        // 패턴2와 비교
                        if (board[i + x].charAt(j + y) != white[x].charAt(y)) {
                            countPattern2++;
                        }
                    }
                }

                // 최소값 갱신
                result = Math.min(result, Math.min(countPattern1, countPattern2));
            }
        }
        System.out.println(result);
    }
}
