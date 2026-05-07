import java.util.Scanner;

public class TransitBot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // TransitBot bot = new TransitBot();

         //welcome message
        System.out.println("Welcome to the transit ticket booth!");

        //user set up
        System.out.println();
        User currentUser = setUpUser();

        //loop to buy tickets
        System.out.println();
        System.out.println("Would you like to buy a ticket? (y/n) ");
        int count = 0;
        while (scan.nextLine().equals("y")){
            count++;
            currentUser.Transit.whereTo();
            System.out.println("Would you like to buy another ticket? (y/n) ");
        }

        //final price calculation
        System.out.println();
        Ticket purchase = new Ticket(count);
        System.out.println("You bought " + count + " tickets today! That will be " + purchase.getPrice());

        //end
        System.out.println("Thank you for shopping with us today!");
        System.out.println("Have fun where ever your journey takes you!");

        scan.close();
    }

    /**
     * Prints out welcome message and asks for user information to initalize where they are going
     * and who they are.
     *
     * @return User consturctor holding new user information of name and discount eligibility
     */
    public User setUpUser(){
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your name? ");

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

        //create a new user constructor
        User one = new User(scan.nextLine(), type);

        //close the scanner
        scan.close();

        //return the user constructor
        return one;
    }

}
