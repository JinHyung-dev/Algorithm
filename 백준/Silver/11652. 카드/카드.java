import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> numbers = new HashMap<>();
        
        // 입력값 저장
        for(int i = 0; i < num; i++) {
            long target = Long.parseLong(br.readLine());
            numbers.put(target, numbers.getOrDefault(target, 0) + 1);
        }
        
        // 가장 큰 값 계산
        int max = Integer.MIN_VALUE;
        long result = Long.MAX_VALUE;;
        for (Map.Entry<Long, Integer> entry : numbers.entrySet()) {
            long key = entry.getKey();
            int count = entry.getValue();
            if(count > max) {
                max = count;
                result = key;
                // 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
            } else if(count == max && key < result) {
                result = key;
            }
        };
        
        System.out.println(result);
    }
}