public class User {
    public static void main(String[] args) throws Exception {
        //create instance varibles
        String name;
        int userType;

        //create constructor
        public User(String name, int userType){
            this.name = name;
            this.userType = userType;
        }

        //create methods
        /**
         * Returns the user name.
         */
        public String getName(){
            return name;
        }

        /**
         * Returns the user type.
         */
        public int getUserType(){
            return userType;
        }

        /**
         * Finds if the user is eligble for a discount, making sure they are
         * either a student, vetren, or senior
         */
        public boolean isDiscountEligible(){
            if (userType != 0){
                return true;
            }
            return false;
        }
    }
}
