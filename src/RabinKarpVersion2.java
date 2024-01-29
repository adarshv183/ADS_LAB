public class RabinKarpVersion2 {
    private static final int PRIME = 101;
    private static  double calculateHash(String str){
        double hash = 0;
        for(int i  = 0; i < str.length(); i++){
            hash = hash + str.charAt(i) * Math.pow(PRIME,i);
        }
        return hash;
    }
    private static double updateHash(double oldHash, char oldChar, char newChar, int patternLength){
        double newHash = (oldHash - oldChar)/PRIME;
        newHash = newHash + newChar * Math.pow(PRIME,patternLength-1);
        return newHash;
    }
    public static void search(String text, String pat){
        int patternLength = pat.length();
        double patHash = calculateHash(pat);
        double textHash = calculateHash(text.substring(0,pat.length()));
        for(int i = 0 ; i <= text.length() - patternLength; i++){
            if(textHash == patHash){
//               check whether it is spurious or not
                if(pat.equals(text.substring(i,i+patternLength))){
                    System.out.println("Pattern found at index " + i);
                }
            }
//            update hash
            if(i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
    }
    public static void main(String[] args) {
         search("abcddabcd","abcd");
    }
}
