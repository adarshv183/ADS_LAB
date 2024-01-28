public class ExtendedGCD {

    // Helper class to store the result of the extended gcd
    static class ExtendedGCDResult {
        int gcd;
        int x;
        int y;

        ExtendedGCDResult(int gcd, int x, int y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }

    // Function to perform extended gcd
    static ExtendedGCDResult extendedGCD(int a, int b) {
        if (b == 0) {
            return new ExtendedGCDResult(a, 1, 0);
        }

        ExtendedGCDResult previousResult = extendedGCD(b, a % b);
        int x = previousResult.y;
        int y = previousResult.x - (a / b) * previousResult.y;

        return new ExtendedGCDResult(previousResult.gcd, x, y);
    }

    public static void main(String[] args) {
        // Example usage
        int a = 55;
        int b = 80;

        ExtendedGCDResult result = extendedGCD(a, b);
        System.out.println("GCD(" + a + ", " + b + ") = " + result.gcd);
        System.out.println("Coefficients (x, y) : (" + result.x + ", " + result.y + ")");
    }
}
