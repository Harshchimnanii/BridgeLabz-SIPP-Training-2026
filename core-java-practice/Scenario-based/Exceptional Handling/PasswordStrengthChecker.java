public class PasswordStrengthChecker {

    public static void checkPassword(String password){

        try{

            if(password == null)
                throw new NullPointerException();

            if(password.isEmpty()){
                System.out.println("Password cannot be empty.");
                return;
            }

            if(password.length() < 8){
                System.out.println("Password should contain at least 8 characters.");
                return;
            }

            if(!Character.isUpperCase(password.charAt(0))){
                System.out.println("First character must be uppercase.");
                return;
            }

            if(!Character.isDigit(password.charAt(password.length()-1))){
                System.out.println("Last character must be a digit.");
                return;
            }

            boolean special=false;

            for(char ch : password.toCharArray()){

                if("@#$%&*".indexOf(ch)!=-1){

                    special=true;

                    break;

                }

            }

            if(!special){

                System.out.println("Password must contain a special character.");

                return;

            }

            System.out.println("Strong Password.");

        }

        catch(NullPointerException e){

            System.out.println("Password cannot be null.");

        }

    }

    public static void main(String[] args){

        checkPassword("Java@123");

    }

}