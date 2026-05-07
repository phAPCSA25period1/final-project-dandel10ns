public class Ticket {
    //initalize variables
    double basePrice = 2.5;
    double discount = .5;
    double price;
    User userType;
    int numTickets;

    //create constructor
    public Ticket(int numTickets){
        this.numTickets = numTickets;
        if (userType.isDiscountEligible()){
            this.price = basePrice*discount*numTickets;
        }
        else {
            this.price = basePrice*numTickets;
        }
    }

    /**
     * Getter method that returns the user price.
     * @return ticket price
     */
    public double getPrice(){
        return price;
    }
}
