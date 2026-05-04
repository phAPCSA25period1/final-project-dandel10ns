import java.util.Scanner;

public class Transit {
    //create a new array
    String[][] lines = {
        //Blue Line row 0
        {"UTC", "Balboa Avenue", "Old Town", "Little Italy", "Courthouse", "City College", "12th and Imperial", "Barrio Logan", "San Ysidro"},
        //Copper Line row 1
        {"Santee", "Gillespie Field", "Arnele Avenue", "El Cajon", " ", " ", " ", " ", " ",},
        //Green Line row 2
        {"El Cajon", "Grossmont", "SDSU", "Stadium", "Mission Valley Center", "Old Town", "Little Italy", "Gaslamp Quarter", "12th and Imperial"},
        //Orange Line row 3
        {"El Cajon", "Grossmont", "La Mesa Blvd", "Lemon Grove Depot", "Euclid Avenue", "47th Street", "12th and Imperial", "City College", "Courthouse"}
    };

    //create a method to choose a destination
    public void whereTo(){
        Scanner scan = new Scanner(System.in);

        System.out.println("What stop are you going to?");
        String destination = scan.nextLine();
        int rowNew = findStopRow(destination);
        int colNew = findStopCol(destination);

        System.out.println("What stop are you at right now?");
        String place = scan.nextLine();
        int row = findStopRow(place);
        int col = findStopCol(place);

        if(sameLine(row, rowNew) && row != -1){
            String lineName = whichLine(row);
            System.out.println("Take the " + lineName);
        }
        else {
            System.out.println("You may need to switch lines.");
        }


    }

    //loops through lines array and returns index of trolley stop provided
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

    //loops through lines array and returns index of trolley stop provided
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

    //find if trolley must switch lines
    public boolean sameLine(int row, int rowNew) {
        if (row == rowNew){
            return true;
        }
        return false;
    }

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

    public String findRoute(String startStation, String endStation){
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
                    return ("\"Take \" + startLine + \" to \" + transferStation + \", then switch to \" + endLine")
                }
            }
        }

        return ("No route found")
    }
}
