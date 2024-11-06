import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bw.readLine());
        String input = bw.readLine();
        String[] inputs = input.split(" ");
        int[] numbers = Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .toArray();
        
        Arrays.sort(numbers);
        
        int sum = 0;
        int target = 1;
        for(int i : numbers) {
            if(i > target) {
                break;
            }
            target += i;
        }
        System.out.println(target);
    }

}
