import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); //세 수 입력받기
        String arr[] = input.split(" "); //배열로 변환
        int arrInt[] = new int[arr.length];
        //int로 변환
        for(int i = 0; i < arr.length; i++){
            int target= Integer.parseInt(arr[i]);
            arrInt[i] = target;
        }
        //정렬
        Arrays.sort(arrInt);
        System.out.println(arrInt[1]);
    }
}
