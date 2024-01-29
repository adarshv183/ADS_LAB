public class ExtendedGCD {

    // Helper class to store the result of the extended gcd
    public static class GcdObject{
        int gcd,x,y;
        public GcdObject(int gcd, int x, int y){
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }
    public static GcdObject computeGcd(int a, int b){
        if(b==0){
            return new GcdObject(a,1,0);
        }
        GcdObject prevObject = computeGcd(b, a%b);
        int x = prevObject.y;
        int y = prevObject.x - (a/b) * prevObject.y;
        return new GcdObject(prevObject.gcd, x, y);
    }
    public static void main(String[] args) {
        int a = 10, b = 25;
        GcdObject res = computeGcd(a,b);
        System.out.println("gcd:" + res.gcd + "\n\nx:" + res.x + "\n\ny:" + res.y);
    }
}
