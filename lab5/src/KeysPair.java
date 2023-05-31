import java.math.BigInteger;
import java.util.Random;

public class KeysPair {
    private final BigInteger n;
    private final BigInteger p1;
    private final BigInteger p2;
    private final int bitLength;
    private final BigInteger phi;

    public BigInteger getN() {
        return n;
    }

    public BigInteger getPrivateKey() {
        return generateDForPrivateKey();
    }

    public BigInteger getPublicKey() {
        return generateEForPublicKey();
    }

    public KeysPair(int bitLength) {
        this.bitLength = bitLength;
        this.p1 = generatePrimeNumber();
        this.p2 = generatePrimeNumber();
        this.n = p1.multiply(p2);
        this.phi = calculatePhi();
    }

    public BigInteger generatePrimeNumber() {
        Random random = new Random();
        return BigInteger.probablePrime(bitLength / 2, random);
    }

    public BigInteger calculatePhi() {
        return p1.subtract(BigInteger.ONE).multiply(p2.subtract(BigInteger.ONE));
    }

    public BigInteger generateEForPublicKey() {
        BigInteger e = BigInteger.valueOf(2L);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }
        return e;
    }

    public BigInteger generateDForPrivateKey() {
        return generateEForPublicKey().modInverse(phi);
    }
}