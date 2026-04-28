import java.util.Scanner;

public class TransitBot {
    public static void main(String[] args) {
        // TransitBot bot = new TransitBot();
        // bot.setUpUser();
    }

    // create scanner to get user input
    Scanner scan = new Scanner(System.in);

    // create instance variables
    User currentUser;

    /**
     * Prints out welcome message and asks for user information to initalize where they are going
     * and who they are.
     */
    public void setUpUser(){
        //create scanner
        Scanner scan = new Scanner(System.in);

        //welcome the user
        System.out.println("Welcome!");

        //save user name
        System.out.println("What is your name? ");
        String name = scan.nextLine();

        //save user type
        System.out.println("Do you qualify for a discount today? (y/n)");
        int type = 0;
        if(scan.nextLine().equals("y")){
            System.out.println("Are you a senior, veteran, student, or standard user? ");
             if (scan.nextLine().equals("student")){
                type = 1;
             }
            else if (scan.nextLine().equals("senior")){
                type = 2;
            }
            else if (scan.nextLine().equals("veteran")){
                type = 3;
            }
        }

        //create new user
        currentUser = new User(name, type);
    }

    // public void runMenu(){
    // System.out.println();
    // System.out.println("");
    // }
}
