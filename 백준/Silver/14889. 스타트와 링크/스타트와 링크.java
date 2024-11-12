import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] ability;
    static boolean[] isTeamA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ability = new int[n][n];
        isTeamA = new boolean[n];
        for(int i = 0; i< n; i++){
            String[] target = br.readLine().split(" ");
            for(int j = 0; j < target.length; j++){
                ability[i][j] = Integer.parseInt(target[j]);
            }
        }

        backtrack(0, 0);
        System.out.println(min);
    }

    private static void backtrack(int idx, int teamALength){
        //모든 선수 배정시 백트래킹 종료
        if(teamALength == n/2){
            //각 팀의 총계 차이 최소값 구하기
            int difference = minCalc();
            //최소값일 경우 업데이트
            if(difference < min){
                min = difference;
            }
            return;
        }

        //팀배정
        for(int i = idx; i< n; i++){
            //선택이 안되어있다면 선택
            if(!isTeamA[i]){
                isTeamA[i] = true;
                backtrack(i + 1, teamALength + 1); //다음 선수로 이동
                isTeamA[i] = false; //최선의 경로가 아닐 경우 원상복구
            }
        }
    }

    private static int minCalc() {
        int sumA = 0;
        int sumB = 0;
        //팀별 능력치 합계 계산
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isTeamA[i] && isTeamA[j]){
                    sumA += ability[i][j] + ability[j][i];
                } else if(!isTeamA[i] && !isTeamA[j]){
                    sumB += ability[i][j] + ability[j][i];
                }
            }
        }
        return Math.abs(sumA - sumB);
    }
}
