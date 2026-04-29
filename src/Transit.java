public class Transit {
    //create a new array
    String[][] lines = {
        //Blue Line row 0
        {"UTC", "Balboa Avenue", "Old Town", "Little Italy", "Courthouse", "City College", "12th and Imperial", "Barrio Logan", "San Ysidro"},
        //Copper Line row 1
        {"Santee", "Gillespie Field", "Arnele Avenue", "El Cajon", " ", " ", " ", " ", " ",},
        //Green Line row 2
        {"El Cajon", "Grossmont", "SDSU", "Stadium" "Mission Valley Center", "Old Town", "Little Italy", "Gaslamp Quarter", "12th and Imperial"},
        //Orange Line row 3
        {"El Cajon", "Grossmont", "La Mesa Blvd", "Lemon Grove Depot", "Euclid Avenue", "47th Street", "12th and Imperial", "City College", "Courthouse"}
    };

    //create a method to choose a destination
    public String whereTo(){
        Scanner scan = new Scanner(Sysem.in);

        System.out.println("What trolley stop would you like to go to?");
        int rowNew = lines.findStopRow(scan.nextLine());
        int colNew = lines.findStopCol(scan.nextLine());

        System.out.println("What stop are you at right now?");
        int row = lines.findStopRow(scan.nextLine());
        int col = lines.findStopCol(scan.nextLine());

        
    }

    //loops through lines array and returns index of trolley stop provided
    public int findStopRow(String stop){
        for (int row = 0; row < lines.length; row++){
            for (int col = 0; col < lines[0].length; col++){
                if (line[row][col].equals(stop)){
                    return row;
                }
            }
        }
    }

    public int findStopCol(String stop){
        for (int row = 0; row < lines.length; row++){
            for (int col = 0; col < lines[0].length; col++){
                if (line[row][col].equals(stop)){
                    return col;
                }
            }
        }
    }
}
