public class Ticket {
    //initalize variables
    int basePrice = 2.5;
    int discount = .5;
    User userType;

    //create method to calculate ticket price
    public int ticketPrice(User userType){
        if (User userType.isDiscountEligble()){
            return basePrice*discount;
        }
        else {
            return basePrice;
        }
    }
}
