public class OnlineQuiz {

    public static void main(String[] args) {

        String answers[] = {"A","B","C","D"};

        for(int i=0;i<=5;i++){

            try{

                if(answers[i].equals("A")){

                    System.out.println("Answer " + i + " is Correct");

                }

            }

            catch(ArrayIndexOutOfBoundsException e){

                System.out.println("Invalid Answer Index : " + i);

            }

            catch(NullPointerException e){

                System.out.println("Answer is Null.");

            }

        }

    }
}