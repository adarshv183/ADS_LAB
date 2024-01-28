import java.util.Scanner;

public class KMP {
    public static void KMPSearch(String text, String pat){
        int n = text.length();
        int m = pat.length();
        int i = 0, j = 0;
        int[] lps = new int[m];
        computeLPSArray(pat,m,lps);
        int numberOfShifts = 0;
        while(i < n){
            if(text.charAt(i) == pat.charAt(j)){
                i+=1;
                j+=1;
            }else{
                if(j!=0){
                    j = lps[j-1];

                }else{
//                    if first character does not match, so simply we need to shift pattern
                    i+=1;
//                    System.out.println("Pattern shifted completely towards right by 1 step.");
                }
                numberOfShifts++;
            }
            if(j==m){
                System.out.println("Pattern found at index " + (i-j));
                j = lps[j-1];
            }
        }
        System.out.println("\nTotal Number of shifts: " + numberOfShifts);
    }
    public static void computeLPSArray(String pat, int m, int[] lps){
        int len=0,i = 1;
        lps[len] = 0;
        while(i < m){
            if(pat.charAt(len) == pat.charAt(i)){
                lps[i] = len+1;
                len++;
                i++;
            }else{
                if(len!=0){ //we have progressed by len
                    lps[i] = lps[len-1];
                }else{
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Text String: ");
        String text = scanner.nextLine();
        System.out.print("Enter Pattern String: ");
        String pattern = scanner.nextLine();
        KMPSearch(text,pattern);
    }
}
