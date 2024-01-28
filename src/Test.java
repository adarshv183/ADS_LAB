/* Challenge 2 description

There is an array A made of N integers. Your task is to choose as many integers from A as possible so that, when they are put in ascending order, all of the differences between all pairs of consecutive integers are equal.

For example, for A = [4, 3, 5, 1, 4, 4], you could choose 1, 3 and 5 (with differences equal to 2) or 4, 4 and 4 (with differences equal to 0).

What is the maximum number of integers that can be chosen?

Write a function:

class solution { public int solution(int[] A); }

that, given an array A made of N integers, returns the maximum number of integers that can be chosen following the rules described above.

Examples:

1. For A = [4, 7, 1, 5, 3], the function should return 4. It is possible to choose four integers (7,1,5 and 3). When put in ascending order, the difference between all consecutive integers is 2.

2. For A = [12, 12, 12, 15, 10], the function should return 3. It is optimal to choose all integers with a value of 12.

3. For A= [18, 26, 18, 24, 24, 20, 221, the function should return 5. Five integers (18, 20, 22, 24, 26) can be chosen. Notice that we cannot pick any other integers, even though they occur more than once.

 */


public class Test {
    public static int func(int[] A, int sum, int l, int r){
        if(r-l+1 == 2 & A[l] + A[r] == sum){
            return 1;
        }
        if(r-l+1 > 2){
                int moves1 = 0, moves2 = 0, moves3 = 0;
                if(sum == A[l] + A[l+1]){
                    moves1 = 1 + func(A, sum, l+2, r);
                }
                if(sum == A[l] + A[r]){
                    moves2 = 1 + func(A, sum, l+1, r-1);
                }
                if(sum == A[r] + A[r-1]){
                    moves3 = 1 + func(A, sum, l, r-2);
                }
                return Math.max(Math.max(moves2,moves3),moves1);
        }
        return 0;
    }
    public static void main(String[] args) {
//        int[] A = new int[]{3,1,5,3,3,4,2};
//        int[] A = new int[]{4,1,4,3,3,2,5,2};

        int[] A = new int[]{1, 1, 2, 3, 1, 2, 2, 1, 1, 2};
//        deleting last 2
        int moves1 = 1 + func(A, A[A.length-2] + A[A.length-1], 0, A.length-3);
//        deleting first 2
        int moves2 = 1 + func(A, A[0] + A[1], 2, A.length-1);
//        deleting first and last
        int moves3 = 1 + func(A, A[0] + A[A.length-1], 1, A.length-2);

        System.out.println(Math.max(Math.max(moves2,moves3),moves1));

    }
}
