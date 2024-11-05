import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        java.io.BufferedReader br = new java.io.BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        int []arr = new int[length];

        for(int i=0; i<length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i=0; i<length; i++){
            bw.write(arr[i]+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
