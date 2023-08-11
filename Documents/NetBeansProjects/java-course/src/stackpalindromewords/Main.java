
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String kelime = "kasaylabalyasak";

        Stack<Character> stack = new Stack<>();
        int yariUzunluk = kelime.length()/2;

        for (int i = 0; i < yariUzunluk; i++) {
            stack.push(kelime.charAt(i));
        }
        
        int start = (kelime.length() % 2 == 0) ? yariUzunluk : yariUzunluk+1;
        boolean flag = true;
        for (int i = start; i > 0; i--) {
            if (!stack.pop().equals(kelime.charAt(i))) {
                flag = false;
                break;

            }
        }
        if (flag) {
            System.out.println("Girdiginiz kelime Palindrome kelimedir.");

        } else {
            System.out.println("Girdiginiz kelime Palindrome kelimesi degildir.");
        }

    }

}