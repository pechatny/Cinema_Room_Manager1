import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int seats = scanner.nextInt();
        int[][] seatMatrix = new int[rows][seats];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                seatMatrix[i][j] = scanner.nextInt();
            }
        }
        int requiredConsecutiveSeats = scanner.nextInt();
        int foundRow = 0;

        DONE:
        for (int i = 0; i < rows; i++) {
            int seatsCount = 0;
            for (int j = 0; j < seats; j++) {
                int currentSeatPlace = seatMatrix[i][j];
                if (currentSeatPlace == 0) {
                    seatsCount++;
                    if (seatsCount == requiredConsecutiveSeats) {
                        foundRow = i;
                        foundRow++;
                        break DONE;
                    }
                } else {
                    seatsCount = 0;
                }
            }
        }

        System.out.print(foundRow);
    }
}