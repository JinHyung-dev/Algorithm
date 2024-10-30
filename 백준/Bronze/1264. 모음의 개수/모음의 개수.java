import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String sentance = "";
    final static String vowel = "aeiouAEIOU";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        for(;;) {
            sentance = br.readLine();
            if(sentance.contains("#")) break;
            result = countVowel(sentance);
            System.out.println(result);
        }

    }

    public static int countVowel(String sentence) {
       int count = 0;
       for(char c : sentence.toCharArray()) {
           if(vowel.indexOf(c) >= 0) {
               count++;
           }
       }

        return count;
    }
}
