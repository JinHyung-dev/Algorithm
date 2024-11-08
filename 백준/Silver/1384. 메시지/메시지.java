import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int groupCount = 1;

        while (true) {
            int memberCount = Integer.parseInt(br.readLine());
            if (memberCount == 0) break;

            String[] names = new String[memberCount];
            String[][] messages = new String[memberCount][memberCount - 1];

            // 입력 받기
            for (int i = 0; i < memberCount; i++) {
                String input = br.readLine();
                names[i] = input.substring(0, input.indexOf(" "));
                String[] messageArr = input.substring(names[i].length() + 1).split(" ");
                messages[i] = messageArr;
            }

            System.out.println("Group " + groupCount++);

            boolean hasNasty = false; // 부정적인 말을 쓴 사람이 있는지 확인하는 변수
            for (int i = 0; i < memberCount; i++) {
                for (int j = 0; j < memberCount - 1; j++) {
                    if (messages[i][j].equals("N")) {
                        hasNasty = true;
                        int writerIndex = (i - j - 1 + memberCount) % memberCount;  // 부정적인 말을 한 사람 계산
                        System.out.println(names[writerIndex] + " was nasty about " + names[i]);
                    }
                }
            }

            // 부정적인 말을 한 사람이 없으면 출력
            if (!hasNasty) {
                System.out.println("Nobody was nasty");
            }
            System.out.println();
        }
    }
}
