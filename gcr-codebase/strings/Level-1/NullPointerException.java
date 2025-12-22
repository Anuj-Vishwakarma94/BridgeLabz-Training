//Created class Named NullPointerException
public class NullPointerException{
   public static void main(String[]args){

    //call method to handle NullPointerException
    handleException();
   }

   //method to generate NullPointerException
   public static void generateException(){
       String text=null;

       //this will generate NullPointerException
       System.out.println(text.length());
   }

   //method to handle NullPointerException using try-catch
   public static void handleException(){
       try{
           generateException();
       }
       catch(NullPointerException e){
           System.out.println("NullPointerException handled successfully");
       }
   }
}
