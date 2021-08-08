import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] numbers = new int[arrayLength];
        int tripletCount = 0;
        for (int i = 0; i < arrayLength; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 1; i < arrayLength - 1; i++) {
            if (numbers[i - 1] == numbers[i] - 1 && numbers[i + 1] == numbers[i] + 1) {
                tripletCount++;
            }
        }
        System.out.println(tripletCount);
    }
}