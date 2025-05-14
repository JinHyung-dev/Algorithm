import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] arr = new String[word.length()];
        
        //맨 앞부터 잘라내 배열에 저장
        for(int i = 0; i < arr.length; i++) {
            arr[i] = word.substring(i);
        }
        
        //맨 앞글자를 기점으로 배열 정렬
        Arrays.sort(arr);
        
        for(String s : arr) {
            System.out.println(s);
        }
    }
}