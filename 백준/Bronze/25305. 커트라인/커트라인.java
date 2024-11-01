import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int memberCount = parseInt(input[0]);
        int winnerCount = parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        int[] members = sort(input2);

        System.out.println(members[winnerCount - 1]);

    }

    public static int[] sort(String[] input2) {
        int[] members = Arrays.stream(input2)
                                .mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < members.length; i++) {
            for(int j = 0; j < members.length - i - 1; j++) {
                if(members[j] < members[j + 1]) {
                    int temp = members[j];
                    members[j] = members[j + 1];
                    members[j + 1] = temp;
                }
            }
        }
        return members;
    }
}
