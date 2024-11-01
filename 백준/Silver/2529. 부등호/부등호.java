import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int k;
    static String[] arr;
    static boolean[] ck;
    static String max = "";
    static String min = "9999999999"; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");
        ck = new boolean[10]; 

        backTrackMax(0, new StringBuilder());
        System.out.println(max);
        ck = new boolean[10];
        backTrackMin(0, new StringBuilder());
        System.out.println(min);
    }

    private static void backTrackMax(int count, StringBuilder result) {
        if (count == k + 1) {
            String resultStr = result.toString();
            if (max.isEmpty() || resultStr.compareTo(max) >0) {
                max = resultStr;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!ck[i]) {
                if (count == 0 || checkCondition(count - 1, result.charAt(count - 1) - '0', i)) {
                    ck[i] = true;
                    result.append(i);
                    backTrackMax(count + 1, result);
                    result.deleteCharAt(result.length() - 1);
                    ck[i] = false;
                }
            }
        }
    }

    private static void backTrackMin(int count, StringBuilder result) {
        if (count == k + 1) {
            String resultStr = result.toString();
            if (resultStr.compareTo(min) < 0) {
                min = resultStr;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!ck[i]) {
                if (count == 0 || checkCondition(count - 1, result.charAt(count - 1) - '0', i)) {
                    ck[i] = true;
                    result.append(i);
                    backTrackMin(count + 1, result);
                    result.deleteCharAt(result.length() - 1);
                    ck[i] = false;
                }
            }
        }
    }

    private static boolean checkCondition(int index, int prevDigit, int currentDigit) {
        if (arr[index].equals("<")) {
            return prevDigit < currentDigit;
        } else {
            return prevDigit > currentDigit;
        }
    }
}
