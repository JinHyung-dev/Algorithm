import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine());
        String[] arr =  new String[sum];
        for(int i = 0; i < sum; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> {
            int numA = Integer.parseInt(a.split(" ")[0]);
            int numB = Integer.parseInt(b.split(" ")[0]);
            return Integer.compare(numA, numB);
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
