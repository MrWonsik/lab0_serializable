package examples;

import creators.ReadWriter;
import repository.Show;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;

public class ExampleShows {
    /**
     * This method is use once only for create example shows and save them in shows.dat file.
     */
    public static void createExampleShows() {
        HashMap<Character, HashMap<Integer, Boolean>> hallOne = PositionCreator.createAvabilablePositionMap(10, 4);
        HashMap<Character, HashMap<Integer, Boolean>> hallTwo = PositionCreator.createAvabilablePositionMap(6, 3);
        HashMap<Character, HashMap<Integer, Boolean>> hallThree = PositionCreator.createAvabilablePositionMap(8, 5);
        HashMap<Character, HashMap<Integer, Boolean>> hallFour = PositionCreator.createAvabilablePositionMap(5, 3);

        Show panTadeusz = new Show(
                "Pan Tadeusz",
                LocalDateTime.of(2019, 11, 11, 15, 00, 00),
                12,
                15.0f,
                hallOne
        );

        Show glupiIGlupszy = new Show(
                "Glupi i glupszy",
                LocalDateTime.of(2019, 11, 12, 19, 30, 00),
                16,
                15.0f,
                hallTwo
        );

        Show IndianaJones = new Show(
                "Indiana Jones",
                LocalDateTime.of(2019, 11,10,16,00,00),
                12,
                15.0f,
                hallThree
        );

        Show ParkJurajski3d = new Show(
                "Park Jurajski 3D",
                LocalDateTime.of(2019, 11, 9, 12, 30, 00),
                7,
                22.0f,
                hallFour
        );

        try {
            ReadWriter<Show> shows = new ReadWriter<>(".//shows.dat");
            shows.serialize(Arrays.asList(panTadeusz, glupiIGlupszy, IndianaJones, ParkJurajski3d));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
