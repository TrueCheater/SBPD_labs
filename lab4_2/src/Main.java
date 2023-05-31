public class Main {
    public static void main(String[] args) {
        PrimeGenerator primeGenerator = new PrimeGenerator(4);
        long primeNumber = primeGenerator.generatePrimeNumber();
        System.out.println("Single prime number: " + primeNumber);
    }
}
