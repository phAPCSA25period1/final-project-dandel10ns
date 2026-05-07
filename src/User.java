public class User {

    //create instance varibles
    String name;
    int userType;

    //create constructors
    public User(String name, int userType){
        this.name = name;
        this.userType = userType;
    }

    public User(String name){
        this.name = name;
        this.userType = 0;
    }

    //create methods
     /**
     * Returns the user name.
     *
     * @return user name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the user type.
     *
     * @return user type
     */
    public int getUserType(){
        return userType;
    }

    /**
     * Finds if the user is eligble for a discount, making sure they are
     * either a student, vetren, or senior
     *
     * @return boolean variable, true based on if the user is eligible for a discount or not
     */
    public boolean isDiscountEligible(){
        if (userType != 0){
            return true;
        }
        return false;
    }

}
