import java.util.Arrays;
import java.util.Scanner;

public class MCM {
    static char name = 'A';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 5;
//        int[] dimensions = new int[n];
        int[] dimensions = new int[]{5,4,6,2,7};
        System.out.println("Enter dimensions: ");
//        for (int i = 0; i < n; i++) {
//            dimensions[i] = scanner.nextInt();
//        }
        int[][] cost = new int[n][n];
        int[][] partition = new int[n][n];
        int j, min, q;
        for(int d = 1; d < n-1;d++){
            for(int i = 1; i < n-d; i++){
                j = i+d;
                min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    q = cost[i][k] + cost[k+1][j] + (dimensions[i-1]*dimensions[j]*dimensions[k]);
                    if(q<min){
                        min=q;
                        partition[i][j] = k;
                    }
                }
                cost[i][j] = min;
            }
        }
        for(int[] row: cost){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        for(int[] row: partition){
            System.out.println(Arrays.toString(row));
        }
        printParanthesis(1,n-1,n,partition);
    }


    private static void printParanthesis(int i, int j, int n, int[][] partition) {
        if(i==j){
            System.out.print(name++);
            return;
        }
        System.out.print('(');
        printParanthesis(i,partition[i][j],n,partition);
        printParanthesis(partition[i][j]+1,j,n,partition);
        System.out.print(')');
    }
}

/*  Algorithm for printing with parenthesis
// Prints parenthesize in subexpression (i, j)
printParenthesis(i, j, bracket[n][n], name)
{
    // If only one matrix left in current segment
    if (i == j)
    {
        print name;
        name++;
        return;
    }

    print "(";

    // Recursively put brackets around subexpression
    // from i to bracket[i][j].
    printParenthesis(i, bracket[i][j], bracket, name);

    // Recursively put brackets around subexpression
    // from bracket[i][j] + 1 to j.
    printParenthesis(bracket[i][j]+1, j, bracket, name);

    print ")";
}
* */
