import java.util.Scanner;

public class WarTester
{
   public static void main(String [] args)
   {
      War w = new War();
      String answer = "y";
      Scanner keyboard = new Scanner(System.in);
      while (answer.equals("y"))
      {
         w.play();
         System.out.println();
         System.out.print("Do you want to continue? ");
         answer = keyboard.nextLine();
      }
      
      
   }
}

