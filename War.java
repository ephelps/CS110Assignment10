import java.util.ArrayList;

public class War
{  

   private Stack s;
   private int cardsPlayer1;
   private int cardsPlayer2;
   private ArrayList<Card> warCards;
   
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
            
      int theWinner = roundWinner(c1,c2);  
      
      if(theWinner == -1)//if player 2 won, player 1's card should be added to their pile
      {
         s.addCardPlayer2(c1);
         s.addCardPlayer2(c2);
      }
      
      if(theWinner == 1)//if player 1 won, player 2's card should be added to their pile
      {
         s.addCardPlayer1(c2);
         s.addCardPlayer1(c1);
      }  
      
      if(theWinner == 0)
      {
         war(c1,c2);
      }
      
      cardsPlayer1 = s.cardsRemainingPlayer1();
      cardsPlayer2 = s.cardsRemainingPlayer2();
            
      if (cardsPlayer1 == 0 || cardsPlayer2==0)
      {
         loser();
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
      int winnerNumber = 999;
      
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
   
   //USE ARRAYS AND WHILE LOOP add all cards at the end of the loop- when war winner !=0
   public void war(Card c1, Card c2)
   {  
      int warWinner = 0;
      
      warCards = new ArrayList<Card>();
      
      warCards.add(c1);
      warCards.add(c2);
      
      while (warWinner == 0)
      {    
         //draw one card from each person
         Card c1FaceDown = s.dealCardPlayer1();
         Card c2FaceDown = s.dealCardPlayer2();
         
         //add cards to array
         warCards.add(c1FaceDown);
         warCards.add(c2FaceDown);
         
         //check to see that there are not 0 cards left in either persons deck
         loser();
         
         //draw the second card on each pile            
         Card c1FaceUp = s.dealCardPlayer1();
         Card c2FaceUp = s.dealCardPlayer2();
         
         //add cards to array
         warCards.add(c1FaceUp);
         warCards.add(c2FaceUp);
                                 
         //send the face up cards to roundWinner
         warWinner = roundWinner(c1FaceUp, c2FaceUp);
         
      }
         
      if(warWinner == -1)//if player 2 won, player 1's cards should be added to their pile
      {
         for(int i = 0; i <= warCards.size(); i++)
         {
            Card c = warCards.get(0);
            s.addCardPlayer2(c);
         }               
      }
            
      if(warWinner == 1)//if player 1 won, player 2's cards should be added to their pile
      {
         for(int i = 0; i <= warCards.size(); i++)
         {
            Card c = warCards.get(0);
            s.addCardPlayer2(c);
         }
      }
   }  
   
   /**
         loser determines if someone lost the game
   */
   
   public void loser()
   {
      cardsPlayer1 = s.cardsRemainingPlayer1();
      cardsPlayer2 = s.cardsRemainingPlayer2();  

      if (cardsPlayer1 == 0)
      {
      
      }
      
      if (cardsPlayer2 == 0)
      {
      }

   }
}