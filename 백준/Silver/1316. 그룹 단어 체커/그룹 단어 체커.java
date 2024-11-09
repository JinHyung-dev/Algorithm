import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        for(int i = 0; i < count; i ++) {
            words.add(br.readLine());
        }

        for (int i = 0; i < words.size(); i++) {
            char[] chars = words.get(i).toCharArray();
            List<Character> prevChars = new ArrayList<>();
            int index = 0;
            for(int j = index+1; j < chars.length; j++) {
                char target = chars[index];
                if(target == chars[j]) { 
                    prevChars.add(target); 
                    index++; 
                    continue;
                }
                if(prevChars.contains(chars[j])) { 
                    count--; 
                    break; 
                }
                
                prevChars.add(target); 
                index++; 
            }
        }
        System.out.println(count);
    }
}
