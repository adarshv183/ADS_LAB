import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LCS {
//    values for direction

    private static int diagonal = 1;
    private static int maxLength = 0;

    private static Set<String> results = new HashSet<>();

    public static void main(String[] args) {
        String s1 = "abaaba";
        String s2 = "babbab";
        computeLcs(s1,s2);
    }

    private static void computeLcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
//        cost matrix
        int[][] cost = new int[n+1][m+1];
        int[][] direction = new int[n+1][m+1];
//        compute cost matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)  {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    cost[i][j] = cost[i-1][j-1] + 1;
                    direction[i][j] = diagonal;
                }else {
                    cost[i][j] = Math.max(cost[i][j-1] , cost[i-1][j]);
                }
            }
        }
        maxLength = cost[n][m];
//        print cost matrix
        System.out.println("Cost Matrix");
        printMatrix(cost);

        System.out.println("Direction Matrix");
        printMatrix(direction);

        System.out.println("\nMaximum length of LCS : " + maxLength);
        printSequences(cost,direction,s1,s2,n,m,"");
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
    private static void printSequences(int[][] cost, int[][] direction, String s1, String s2, int n, int m,String seq) {
        if(n==0 || m ==0){
            results.add(seq);
            return;
        }
        String helper = seq;
        if(direction[n][m] == diagonal){
            helper += s1.charAt(m-1);
            printSequences(cost,direction,s1,s2,n-1,m-1,helper);
        }else {
            if(cost[n-1][m] == cost[n][m-1]){
                printSequences(cost,direction,s1,s2,n-1,m,helper);
                printSequences(cost,direction,s1,s2,n,m-1,helper);
            }else if(cost[n-1][m] == cost[n][m]){
                printSequences(cost,direction,s1,s2,n-1,m,helper);
            }else{
                printSequences(cost,direction,s1,s2,n,m-1,helper);
            }

        }

    }
}
