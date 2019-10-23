package examples;


import java.util.HashMap;

public class PositionCreator {
    /**
     * This method is for create HashMap<Character, HashMap<Integer, Boolean>>.
     * @param row - row in Cinema Hall.
     * @param grid - grid in CinemaHall
     * @return - HashMap<Character, HashMap<Integer, Boolean>>.
     */
    public static HashMap<Character, HashMap<Integer, Boolean>> createAvabilablePositionMap(int row, int grid) {

        HashMap<Integer, Boolean> gridInHall = new HashMap<>();
        HashMap<Character, HashMap<Integer, Boolean>> rowInHall = new HashMap<>();

        for (int i = 0; i < row; i++) {
            gridInHall.put(i + 1, true);
        }

        for (int j = 0; j < grid; j++) {
            rowInHall.put((char)(65+j), (HashMap<Integer, Boolean>) gridInHall.clone());
        }
        return rowInHall;
    }

}
