import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LCS {
    private static final int diagonal = 1;
    private static final Set<String> results = new HashSet<>();
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "acbad";
        computeLcs(s1,s2);
    }
    private static void computeLcs(String s1, String s2) {
//        cost matrix
        int[][] cost = new int[s1.length()+1][s2.length()+1];
        int[][] direction = new int[s1.length()+1][s2.length()+1];
//        compute cost matrix
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++)  {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    cost[i][j] = cost[i-1][j-1] + 1;
                    direction[i][j] = diagonal;
                }else {
                    cost[i][j] = Math.max(cost[i][j-1] , cost[i-1][j]);
                }
            }
        }
        int maxLength = cost[s1.length()][s2.length()];
//        print cost matrix
        System.out.println("Cost Matrix");
        printMatrix(cost);

        System.out.println("Direction Matrix");
        printMatrix(direction);

        System.out.println("\nMaximum length of LCS : " + maxLength);
        printSequences(cost,direction,s1,s2,s1.length(),s2.length(),"");
//        printing sequences
        for(String s : results){
            System.out.println(s);
        }
    }
    private static void printMatrix(int[][] matrix){
        for (int[] a:   matrix) {
            System.out.println(Arrays.toString(a));
        }
    }
    private static void printSequences(int[][] cost, int[][] direction, String s1, String s2, int m, int n,String seq) {
        if(n==0 || m ==0){
            StringBuilder sb = new StringBuilder(seq);
            sb.reverse();
            results.add(sb.toString());
            return;
        }
        String helper = seq;
        if(direction[m][n] == diagonal){
            helper += s1.charAt(m-1);
            printSequences(cost,direction,s1,s2,m-1,n-1,helper);
        }else {
            if(cost[m-1][n] == cost[m][n-1]){
                printSequences(cost,direction,s1,s2,m-1,n,helper);
                printSequences(cost,direction,s1,s2,m,n-1,helper);
            }else if(cost[m-1][n] == cost[m][n]){
                printSequences(cost,direction,s1,s2,m-1,n,helper);
            }else{
                printSequences(cost,direction,s1,s2,m,n-1,helper);
            }
        }

    }
}
