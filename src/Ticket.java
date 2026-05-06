public class Ticket {
    //initalize variables
    double basePrice = 2.5;
    double discount = .5;
    double price;
    User userType;

    //create constructor
    public Ticket(double price){
        ticketPrice(userType);
        this.price = price;
    }

    //create method to calculate ticket price
    public void ticketPrice(User userType){
        if (userType.isDiscountEligible()){
            price = basePrice*discount;
        }
        else {
            price = basePrice;
        }
    }
}
