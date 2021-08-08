import java.util.Scanner;

class Main {
    static  Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] numbers = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int greaterThanNumber = scanner.nextInt();
        for (int number : numbers) {
            if (number > greaterThanNumber) {
                sum += number;
            }
        }

        System.out.println(sum);
    }
}