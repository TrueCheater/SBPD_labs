import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter message: ");
        String originalMessage = scanner.nextLine();
        scanner.close();

        RSA rsa = new RSA(originalMessage);
        BigInteger encryptedMessage = rsa.encrypt();
        BigInteger signature = rsa.generateSignature();
        String decryptedMessage = rsa.decrypt();
        boolean isValid = rsa.verifySignature();

        System.out.println("Original Message: " + originalMessage);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
        System.out.println("Signature: " + signature);
        System.out.println("Check signature: " + isValid);
    }
}
