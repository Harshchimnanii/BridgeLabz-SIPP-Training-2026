public class SmartLibrarySystem {

    static String books[] = {"Java","Python",null,"C++"};

    public static int getBookLength(int index){

        try{

            return books[index].length();

        }

        catch(ArrayIndexOutOfBoundsException e){

            System.out.println("Invalid Book Index.");

        }

        catch(NullPointerException e){

            System.out.println("Book Entry is Empty.");

        }

        return -1;

    }

    public static void main(String[] args){

        System.out.println(getBookLength(2));

        System.out.println(getBookLength(6));

    }

}