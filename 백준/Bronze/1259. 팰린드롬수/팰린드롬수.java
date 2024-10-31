import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(;;) {
            String input = br.readLine();
            if(input.equals("0")) break;
            boolean result = isThisPalindrome(input);
            System.out.println((result) ? "yes" : "no");
        }
    }

    public static boolean isThisPalindrome(String input) {
        int number = Integer.parseInt(input);
        String numberStr = String.valueOf(number);
        int[] arr = new int[numberStr.length()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = numberStr.charAt(i) - '0';
        }

        for(int i = 0; i < arr.length/2; i++) {
            if(arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }

        return true;
    }
}
