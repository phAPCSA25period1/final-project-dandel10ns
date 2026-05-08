import java.util.Scanner;

public class Transit {
    //create a new array
    private String[][] lines;

    public Transit(){
        lines = new String[][]{
            {"UTC", "Balboa Avenue", "Old Town", "Little Italy", "Courthouse", "City College", "12th and Imperial", "Barrio Logan", "San Ysidro"},
        //Copper Line row 1
        {"Santee", "Gillespie Field", "Arnele Avenue", "El Cajon", " ", " ", " ", " ", " ",},
        //Green Line row 2
        {"El Cajon", "Grossmont", "SDSU", "Stadium", "Mission Valley Center", "Old Town", "Little Italy", "Gaslamp Quarter", "12th and Imperial"},
        //Orange Line row 3
        {"El Cajon", "Grossmont", "La Mesa Blvd", "Lemon Grove Depot", "Euclid Avenue", "47th Street", "12th and Imperial", "City College", "Courthouse"}
        };
    }

    /**
     * Uses various methods and takes in user input to try to connect the user to which line they are traveling on.
     * Prints out the train stations a user must transfer to to get to their stop.
     */
    public void whereTo(){
        Scanner scan = new Scanner(System.in);

        System.out.println("What stop are you going to?");
        String destination = scan.nextLine();
        int rowNew = findStopRow(destination);

        System.out.println("What stop are you at right now?");
        String place = scan.nextLine();
        int row = findStopRow(place);

        if(sameLine(row, rowNew) && row != -1){
            String lineName = whichLine(row);
            System.out.println("Take the " + lineName);
        }
        else {
            findRoute(destination, place);
        }

        scan.close();
    }

    /**
     * Loops through the lines array of trolley stop and returns the index of the indicated trolley stop row.
     *
     * @param stop - String value of an actual trolley stop
     * @return row index of the trolley stop the user is trying to get to
     */
    public int findStopRow(String stop){
        for (int row = 0; row < lines.length; row++){
            for (int col = 0; col < lines[0].length; col++){
                if (lines[row][col].equals(stop)){
                    return row;
                }
            }
        }
        return -1;
    }

    /**
     * Loops through the lines array of trolley stop and returns the index of the indicated trolley stop column.
     *
     * @param stop - String value of an actual trolley stop
     * @return col index of the trolley stop the user is trying to get to
     */
    public int findStopCol(String stop){
        for (int row = 0; row < lines.length; row++){
            for (int col = 0; col < lines[0].length; col++){
                if (lines[row][col].equals(stop)){
                    return col;
                }
            }
        }
        return 0;
    }

    /**
     * Returns a boolean based on whether or not the two trolley stops are the same.
     * @param row row index of the user's current destination
     * @param rowNew row index of the stop the user is trying to get to
     * @return boolean value of whether or not the two values are equal
     */
    public boolean sameLine(int row, int rowNew) {
        if (row == rowNew){
            return true;
        }
        return false;
    }

    /**
     * Based on the row index, it returns the String value of each line so that the user knows where they are going.
     * @param row row index of the trolley stop
     * @return String value of the trolley line
     */
    public String whichLine(int row){
        if (row == 0){
            return ("Blue Line");
        }
        else if (row == 1){
            return ("Copper Line");
        }
        else if (row == 2){
            return ("Green Line");
        }
        else if (row == 3){
            return ("Orange Line");
        }
        return "Unknown Line";
    }

    /**
     * Gemini provided me with a starting psuedo code to base the algorithm off of.
     *
     * Uses the row indexs to decide if the user is
     * @param startStation
     * @param endStation
     */
    public void findRoute(String startStation, String endStation){
        int startRow = findStopRow(startStation);
        int stopRow = findStopCol(endStation);

        if (startRow == stopRow){
            String lineNames = whichLine(startRow);
            System.out.println("Take the " + lineNames);
        }
        String transferStation = " ";
        for (int i = 0; i < startRow; i++){
            for (int j = 0; j < stopRow; j++){
                if (lines[startRow][i].equals(lines[stopRow][j])){
                    transferStation = lines[startRow][i];
                    System.out.println("Take " + startStation + " to " + transferStation + ", then switch to " + endStation);
                }
            }
        }

        System.out.println("No route found");
    }
}
