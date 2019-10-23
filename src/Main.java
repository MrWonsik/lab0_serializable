import controllers.Controller;
import examples.Menu;
import repository.Client;
import repository.Show;

import java.util.*;

public class Main {



    public static void main(String[] args) {

        List<Show> shows = new ArrayList<>();

        try {
            shows = Controller.getShowsReadWriter().getList();
        } catch (Exception e){
            e.printStackTrace();
        }

        Client newClient = Menu.getClientInformation();
        Show chosenShow = Menu.getClientShow(shows);
        int numberOfSeats = Menu.numberOfSeats();
        HashMap<Character, Integer> seats = Menu.getSeats(chosenShow, numberOfSeats);

        Controller.reservePosition(chosenShow, newClient, seats);
    }
}
