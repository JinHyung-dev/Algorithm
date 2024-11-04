import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int length = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());
        String[] inputA = br.readLine().split(" ");
        String[] inputB = br.readLine().split(" ");

        int[] a = new int[length];
        int[] b = new int[length];
        Integer[] bIndex = new Integer[length];
        for(int i = 0; i < length; i++) {
            a[i] = Integer.parseInt(inputA[i]);
            b[i] = Integer.parseInt(inputB[i]);
            bIndex[i] = i;
        }
        Arrays.sort(a);
        //bIndex b 크기 순으로 인덱스 저장
        Arrays.sort(bIndex, (i, j) -> b[j] - b[i]);

        int result = 0;
        for(int i=0; i<length; i++) {
            result += a[i] * b[bIndex[i]];
        }
        System.out.println(result);
    
    }

}
