package examples;

import repository.Client;
import repository.Show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    public static Client getClientInformation() {
        System.out.println("Welcome in our Cinema!");

        System.out.println("What's your name?");
        String name = scanner.nextLine();
        System.out.println("What's your surame?");
        String surname = scanner.nextLine();
        System.out.println("What's your email?");
        String email = scanner.nextLine();
        System.out.println("What's your phone number?");
        String phone = scanner.nextLine();

        return new Client(surname, name, email, phone);
    }

    public static Show getClientShow(List<Show> shows) {
        System.out.println("Which shows would you like to reserve?");
        for (Show show : shows) {
            System.out.println(shows.indexOf(show) + ". " + show.getTitle());
        }
        System.out.println("Number:");

        return shows.get(scanner.nextInt());
    }

    public static int numberOfSeats() {
        System.out.println("Number of seats:");
        return scanner.nextInt();
    }

    public static HashMap<Character, Integer> getSeats(Show show, int numberOfSeats) {
        HashMap<Character, Integer> seats = new HashMap<>();

        for (Character row : show.getAvailablePosition().keySet()) {
            System.out.print(row + " ");
            for (Map.Entry<Integer, Boolean> column : show.getAvailablePosition().get(row).entrySet()) {
                if(column.getValue()) {
                    System.out.print(column.getKey() + " ");
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();

        }
        System.out.println("x - mean the seat is actually reserved");


        for (int i = 0; i < numberOfSeats; i++) {
            System.out.println("Choose your row:");
            Character chosenRow = scanner.next().charAt(0);
            System.out.println("Choose your seat:");
            Integer chosenColumn = scanner.nextInt();
            seats.put(chosenRow, chosenColumn);
        }

        return seats;
    }
}
