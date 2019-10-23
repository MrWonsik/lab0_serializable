package controllers;

import creators.ReadWriter;
import repository.Client;
import repository.Show;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    private static ReadWriter<Show> showsReadWriter = new ReadWriter<>(".//shows.dat");
    private static ReadWriter<Client> clientReadWriter = new ReadWriter<>(".//clients.dat");

    public static ReadWriter<Show> getShowsReadWriter() {
        return showsReadWriter;
    }

    public static void reservePosition(Show show, Client client, HashMap<Character, Integer> seats) {
        try {
            if(checkIsSeatsAreAvailable(show, seats)){
                client.setPosition(seats);
                updateShowSeats(show, seats);
                clientReadWriter.serialize(client);
            } else {
                System.out.println("You cannot reserve this seats!");
            }
        } catch (NullPointerException e) {
            System.out.println("You choose incorrect seats!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean checkIsSeatsAreAvailable(Show show, HashMap<Character, Integer> seats){
        for(Map.Entry<Character, Integer> entry : seats.entrySet()) {
            if (!show.getAvailablePosition().get(entry.getKey()).get(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    private static void updateShowSeats(Show show, HashMap<Character, Integer> seats) {
        try {
            for (Map.Entry<Character, Integer> entry : seats.entrySet()) {
                show.getAvailablePosition().get(entry.getKey()).replace(entry.getValue(), false);
                showsReadWriter.update();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
