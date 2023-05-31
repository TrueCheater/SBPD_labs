public class Main {
    public static void main(String[] args) {
        long x = 3L;
        long y = 10L;
        long p = 17L;

        SHDP shdp = new SHDP(x, y, p);

        Long mod = shdp.fastModularExponentiation();
        System.out.println("Result is " + mod);
    }
}
