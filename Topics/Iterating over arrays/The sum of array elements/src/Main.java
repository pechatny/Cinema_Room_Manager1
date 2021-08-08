import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < numberOfElements; i++) {
            sum += scanner.nextInt();
        }

        System.out.print(sum);
    }
}