public class War
{  

   private Stack s;
   private int cardsPlayer1;
   private int cardsPlayer2;
   
   /**
      constructor creates a new stack object and sets
      the cards for each player to the default 26 each
   */
   public War()
   {
      s = new Stack();
      cardsPlayer1 = s.cardsRemainingPlayer1();
      cardsPlayer2 = s.cardsRemainingPlayer2();  
   }
   
   /**
      play draws a card from each persons stack, 
      sends the cards to roundWinner to determine the winner
      and then sends the number of cards each player has to loser to 
   */
   public void play()
   {
      Card c1 = s.dealCardPlayer1();
      Card c2 = s.dealCardPlayer2();
      
      System.out.println(c1.toString());
      System.out.println(c2.toString());
      int theWinner = roundWinner(c1,c2);  
      
      if(theWinner == -1)//if player 2 won, player 1's card should be added to their pile
      {
         System.out.println(c1.toString() + " was less than " + c2.toString());
         s.addCardPlayer2(c1);
         s.addCardPlayer2(c2);
      }
      
      if(theWinner == 1)//if player 1 won, player 2's card should be added to their pile
      {
         System.out.println(c2.toString() + " was less than " + c1.toString());
         s.addCardPlayer1(c2);
         s.addCardPlayer1(c1);
      }  
      
      if(theWinner == 0)
      {
         System.out.println("The cards were equal- war will commence");
         war(c1,c2);
      }
      
      if(theWinner == 1111)
      {
         System.out.println("An error occurred");
      }
      
      cardsPlayer1 = s.cardsRemainingPlayer1();
      cardsPlayer2 = s.cardsRemainingPlayer2();
      
      System.out.println("Player 1 has " + cardsPlayer1 + " cards remaining and Player 2 has " + cardsPlayer2 + " cards remaining");
      
      if (cardsPlayer1 == 0 || cardsPlayer2==0)
      {
         loser(cardsPlayer1, cardsPlayer2);
      }
   }
   
   /**
      winner takes in two card objects, determine who wins or if their is a war
      if -1 is returned player 2 won
      if 1 returned player 1 won
      if 0 returned the cards were equal- their should be a war
      @param c1 player 1's card
      @param c2 player 2's card
   */
   public int roundWinner(Card c1, Card c2)
   {
      int winnerNumber = 1111;
      
      if(c1.equals(c2))
      {
         winnerNumber = 0;
      }
      
      else
      {
         if (c1.getRank() > c2.getRank())
         {
            winnerNumber = 1;
         }
         
         else
            winnerNumber = -1;
      }
      
      return winnerNumber;
   }
   
   /**
      war will play a war for the game
      @param c1 player 1's equal card
      @param c2 player 2's equal card
   */
   public void war(Card c1, Card c2)
   {  
         //draw one card from each person
         Card c1FaceDown = s.dealCardPlayer1();
         Card c2FaceDown = s.dealCardPlayer2();
                     
         Card c1FaceUp = s.dealCardPlayer1();
         Card c2FaceUp = s.dealCardPlayer2();
            
         System.out.println(c1FaceUp.toString());
         System.out.println(c2FaceUp.toString());
            
         //send the face up cards to roundWinner
         int warWinner = roundWinner(c1FaceUp, c2FaceUp);
            
            if(warWinner == -1)//if player 2 won, player 1's cards should be added to their pile
            {
               s.addCardPlayer2(c1);
               s.addCardPlayer2(c1FaceDown);
               s.addCardPlayer2(c1FaceUp);
               s.addCardPlayer2(c2);
               s.addCardPlayer2(c2FaceDown);
               s.addCardPlayer2(c1FaceUp);

               System.out.println(c1FaceUp.toString() + " was less than " + c2FaceUp.toString());
               System.out.println("The cards "+ c1.toString() + ", " + c1FaceDown.toString() + 
                                    " and " + c1FaceUp.toString() + " were added to Player 2's stack");
            }
         
            if(warWinner == 1)//if player 1 won, player 2's cards should be added to their pile
            {
               s.addCardPlayer1(c2);
               s.addCardPlayer1(c2FaceDown);
               s.addCardPlayer1(c2FaceUp);
               s.addCardPlayer1(c1);
               s.addCardPlayer1(c1FaceDown);
               s.addCardPlayer1(c1FaceUp);
               System.out.println(c2FaceUp.toString() + " was less than " + c1FaceUp.toString());
               System.out.println("The cards "+ c2.toString() + ", " + c2FaceDown.toString() + 
                                    " and " + c2FaceUp.toString() + " were added to Player 1's stack");

            }
            
            cardsPlayer1 = s.cardsRemainingPlayer1();
            cardsPlayer2 = s.cardsRemainingPlayer2();

            if(warWinner == 1111)
            {
               System.out.println("An error occurred");
            }
         
            if(cardsPlayer1 <= 1 || cardsPlayer2 <= 1)
            {
               cardsPlayer1 = s.cardsRemainingPlayer1();
            cardsPlayer2 = s.cardsRemainingPlayer2();
            System.out.println("Not enough cards to continue war");
            loser(cardsPlayer1, cardsPlayer2);
         }
      
   }  
   
   /**
         loser determines who lost the game
         @param s1 the number of cards in player 1's stack
         @param s2 the number of cards in player 2's stack
   */
   
   public void loser(int s1, int s2)
   {
      if (s1 == 0)
      {
         System.out.println("Player 1 lost");
      }
      
      if (s2 == 0)
      {
         System.out.println("Player 2 lost");
      }
      
      else
      {
      
      }
   }
}