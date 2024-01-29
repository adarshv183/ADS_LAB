import java.util.Scanner;

public class KMP {
    public static void KMPSearch(String text, String pat){
        int textLength = text.length();
        int patternLength = pat.length();
        int numberOfShifts = 0;
        int[] lps = new int[patternLength];
        computeLPSArray(pat,patternLength,lps);
//        2 pointers for traversing the text and the pattern
        int i = 0, j = 0;
        while(i < textLength){
            if(text.charAt(i) == pat.charAt(j)){
                i+=1;
                j+=1;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{ //if j == 0
                    i+=1;
                }
                numberOfShifts++;
            }
            if(j==patternLength){
//                pattern is found
                System.out.println("Pattern Found at index : " + (i-patternLength));
                j = lps[j-1];
            }
        }
        System.out.println("Total Number of Shifts: " + numberOfShifts);
    }
    public static void computeLPSArray(String pat, int patternLength, int[] lps){
        int length = 0;
        int i = 1;
        lps[length] = 0;
        while(i < patternLength){
            if(pat.charAt(i) == pat.charAt(length)){
                lps[i] = length+1;
                length+=1;
                i+=1;
            }else{
                if(length != 0){
                    length = lps[length-1];
                }else{
                    lps[i] = 0;
                    i += 1;
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
