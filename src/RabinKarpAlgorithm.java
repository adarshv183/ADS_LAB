import java.util.Scanner;

public class RabinKarpAlgorithm{

//    public static int getAlphabetValue(char ch) {
//        ch = Character.toLowerCase(ch);
//        if (Character.isLetter(ch)) {
//            return ch - 'a' + 1;
//        } else {
//            // Return -1 for non-alphabetic characters
//            return -1;
//        }
//    }
    private static void searchPattern(String text, String pattern, int d, int q)
    {
        int n = text.length(), m = pattern.length();
        int p = 0, t = 0;
        int h = 1;

//        hash function
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        for (int s = 0; s <= n - m; s++) {
            if (p == t) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(s + j) != pattern.charAt(j)) {
                        break;
                    }
                }

                if (j == m) {// found
                    System.out.println("Pattern found at index " + s);
                }
            }

            if (s < n - m) {
                t = (d * (t - text.charAt(s) * h) + text.charAt(s + m)) % q;
                if (t < 0)
                    t = t + q;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = "cddabcdd";
        String pattern = "cdd";
        int d = 10; // a to j
        int q = 101; //prime number
        searchPattern(text,pattern,d,q);
    }
}
