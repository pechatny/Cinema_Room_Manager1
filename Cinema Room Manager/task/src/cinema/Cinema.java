package cinema;


import java.util.Scanner;

public class Cinema {
    private static Scanner scanner = new Scanner(System.in);
    private static int rows;
    private static int seats;
    private static String[][] seatsSchema;
    private static int chosenRow;
    private static int chosenSeat;

    public static void main(String[] args) {
        start();
        EXIT:
        while (true) {
            int menuItem = getMenuItem();
            switch (menuItem) {
                case 1:
                    printSchema(rows, seats);
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    statistics();
                    break;
                case 0:
                    break EXIT;
            }
        }
    }

    private static void statistics() {
        int soldTickets = 0;
        double soldPercentage = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        for (int i = 0; i < seatsSchema.length; i++) {
            for (int j = 0; j < seatsSchema[i].length; j++) {
                String seatState = seatsSchema[i][j];
                int ticketPrice = getTicketPrice(i + 1, rows, seats * rows);
                totalIncome += ticketPrice;
                if (seatState == "B") {
                    soldTickets++;
                    currentIncome += ticketPrice;
                }
            }
        }

        soldPercentage = rows * seats > 0 ? soldTickets / (rows * seats / 100.0) : 0.0;

        System.out.printf("Number of purchased tickets: %d\n" +
                "Percentage: %.2f%%\n" +
                "Current income: $%d\n" +
                "Total income: $%d\n", soldTickets, soldPercentage, currentIncome, totalIncome);
    }

    private static void buyTicket() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter a row number:");
            chosenRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            chosenSeat = scanner.nextInt();
            final int numberOfSeats = rows * seats;

            if (chosenRow < 1 || chosenRow > rows || chosenSeat < 1 || chosenSeat > seats) {
                System.out.println("Wrong input!");
            } else if (seatsSchema[chosenRow - 1][chosenSeat - 1] == "B") {
                System.out.println("That ticket has already been purchased!");
            } else {
                seatsSchema[chosenRow - 1][chosenSeat - 1] = "B";
                System.out.println("Ticket price: $" + getTicketPrice(chosenRow, rows, numberOfSeats));
                exit = true;
            }
        }
    }

    private static int getMenuItem() {
        StringBuilder menu = new StringBuilder();
        menu.append("1. Show the seats\n");
        menu.append("2. Buy a ticket\n");
        menu.append("3. Statistics\n");
        menu.append("0. Exit\n");
        System.out.print(menu);
        return scanner.nextInt();
    }

    public static void start() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();
        seatsSchema = new String[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                seatsSchema[i][j] = "S";
            }
        }
    }

    public static int getTicketPrice(int row, int rows, int numberOfSeats) {
        int ticketCost = 0;
        if (numberOfSeats <= 60) {
            ticketCost = 10;
        } else {
            int firstHalfRows = rows / 2;
            ticketCost = row <= firstHalfRows ? 10 : 8;
        }

        return ticketCost;
    }

    public static void printSchema(int rows, int seats) {
        System.out.println("Cinema:");
        StringBuilder schema = new StringBuilder();
        schema.append("  ");
        for (int i = 1; i <= seats; i++) {
            schema.append(i + (i != seats ? " " : ""));
        }
        schema.append("\n");
        for (int i = 1; i <= rows; i++) {
            schema.append(i + " ");
            for (int j = 0; j < seats; j++) {
                schema.append(seatsSchema[i - 1][j]);
                schema.append((j != seats - 1 ? " " : ""));
            }
            schema.append("\n");
        }

        System.out.print(schema);
    }
}