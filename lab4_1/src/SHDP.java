public class SHDP {
    private long x;
    private long e;
    private final long p;

    public SHDP(long x, long e, long p) {
        this.x = x;
        this.e = e;
        this.p = p;
    }

    public Long fastModularExponentiation() {
        long res = 1L;
        x = findMod(x, p);
        while (e > 0) {
            if ((e & 1) != 0)
                res = multiply(res, x, p);
            e = e >> 1;
            x = squareTwo(x, p);
        }
        return res;
    }

    public Long add(Long a, Long b) {
        while (b != 0) {
            long c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }

    public Long multiply(Long a, Long b, Long p) {
        Long product = 0L;
        while (b > 0) {
            if ((b & 1) != 0)
                product = findMod(add(product, a), p);
            a = findMod(a << 1, p);
            b = b >> 1;
        }
        return product;
    }

    public Long squareTwo(Long num, Long p) {
        return multiply(num, num, p);
    }

    public Long findMod(Long dividend, Long divisor) {
        if (dividend == 0) {
            return 0L;
        }
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend >= divisor) {
            dividend -= divisor;
        }

        return isNegative ? -dividend : dividend;
    }
}

