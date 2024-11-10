import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String[] croatiaAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    private static int singleAlphabet = 0;
    private static final List<String> existCroatiaAlphabet = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        findAlphabet(word);

        System.out.println(existCroatiaAlphabet.size() + singleAlphabet);
    }

    private static void findAlphabet(String word) {
        if(word.length() == 1) {
            singleAlphabet++;
            return;
        }

        for(String s : croatiaAlphabet) {
            if(word.contains(s)) {
                hasCroaticAlphabet(word, s);
                return;
            }
        }
        singleAlphabet += word.length();
    }

    private static void hasCroaticAlphabet(String word, String s) {
        existCroatiaAlphabet.add(s);
        int targetIndex = word.indexOf(s);
        String preWord = word.substring(0, targetIndex);
        String afterWord = word.substring(targetIndex + s.length());

        if(!preWord.isEmpty()) {
            findAlphabet(preWord);
        }

        if(!afterWord.isEmpty()) {
            findAlphabet(afterWord);
        }
    }
}
