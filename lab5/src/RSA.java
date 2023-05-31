import java.math.BigInteger;

public class RSA {
    private final String message;
    private final KeysPair keysPair;
    private BigInteger encrypted;

    public RSA(String message) {
        this.message = message;
        this.keysPair = new KeysPair(1024);
    }

    public BigInteger encrypt() {
        BigInteger m = new BigInteger(message.getBytes());
        encrypted = m.modPow(keysPair.getPublicKey(), keysPair.getN());
        return encrypted;
    }

    public String decrypt() {
        BigInteger decrypted = encrypted.modPow(keysPair.generateDForPrivateKey(), keysPair.getN());
        byte[] decryptedBytes = decrypted.toByteArray();
        return new String(decryptedBytes);
    }

    public BigInteger generateSignature() {
        BigInteger m = new BigInteger(message.getBytes());
        return m.modPow(keysPair.getPrivateKey(), keysPair.getN());
    }

    public boolean verifySignature() {
        byte[] messageBytes = message.getBytes();
        BigInteger m = new BigInteger(messageBytes);
        BigInteger decrypted = generateSignature().modPow(keysPair.getPublicKey(), keysPair.getN());
        return decrypted.equals(m);
    }
}