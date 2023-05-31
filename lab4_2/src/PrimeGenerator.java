import java.util.Random;

public class PrimeGenerator {
    private final int k;

    public PrimeGenerator(int k) {
        this.k = k;
    }

    public long generatePrimeNumber() {
        Random random = new Random();
        long primeNumber = random.nextInt(Integer.MAX_VALUE) + 1;
        while (!isPrime(primeNumber, k)) {
            primeNumber = random.nextInt(Integer.MAX_VALUE) + 1;
        }
        return primeNumber;
    }

    public boolean isPrime(long number, int k) {

        if (number <= 1 || number == 4) {
            return false;
        }
        if (number <= 3) {
            return true;
        }

        long d = number - 1;
        while (d % 2 == 0) {
            d /= 2;
        }

        for (int i = 0; i < k; i++) {
            if (!millerRabinTest(d, number)) {
                return false;
            }
        }
        return true;
    }

    public boolean millerRabinTest(long d, long number) {
        Random random = new Random();
        long a = 2 + random.nextInt((int) (number - 4));
        long x = shdp(a, d, number);
        if (x == 1 || x == number - 1) {
            return true;
        }
        while (d != number - 1) {
            x = (x * x) % number;
            d *= 2;

            if (x == 1) {
                return false;
            }
            if (x == number - 1) {
                return true;
            }
        }
        return false;
    }

    public static long shdp(long base, long exponent, long modulus) {
        long result = 1;

        base = base % modulus;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % modulus;
            }
            exponent /= 2;
            base = (base * base) % modulus;
        }
        return result;
    }
}
