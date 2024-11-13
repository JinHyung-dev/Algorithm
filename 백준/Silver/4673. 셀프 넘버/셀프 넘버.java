import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> selfNumber = new HashSet<>();
        for(int i = 1; i < 10000; i++) {
            selfNumber.add(i);
        }
        for(int i = 1; i < 10000; i++) {
            int sum = i;
            String target = String.valueOf(i);
            int length = target.length();

            for(int j = 0; j < length; j++) {
                String[] targetArr = target.split("");
                sum += Integer.parseInt(targetArr[j % length]);
            }
            selfNumber.remove(sum);
        }
        selfNumber.forEach(System.out::println);
    }
}
