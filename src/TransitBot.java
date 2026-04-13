import java.util.Scanner;

public class TransitBot {
    public static void main(String[] args) throws Exception {
        //create scanner to get user input
        Scanner scan = new Scanner(System.in);

        //create instance variables
        User currentUser;

    }

    public String setUpUser(){
        //welcome the user
        System.out.println("Welcome!");
        //save user name
        System.out.println("What is your name? ");
        String name = scan.nextLine();
        //save user type
        System.out.println("Are you a senior, vetren, student, or standard user? ");
        int type;
        if (scan.nextLine.equals(standerd)){
            type = 0;
        }
        else if (scan.nextLine.equals(student)){
            type = 1;
        }
        else if (scan.nextLine.equals(senior)){
            type = 2;
        }
        else if (scan.nextLine.equals(vetren)){
            type = 3;
        }
        //create new user
        User new = newUser User(name, type);
    }
}
