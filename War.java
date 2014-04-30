import java.util.ArrayList;
import javax.swing.JOptionPane;

public class War implements WarInterface
{  

   private Stack s;
   private ArrayList<Card> warCards;
   
   /**
      constructor creates a new stack object and sets
      the cards for each player to the default 26 each
   */
   public War()
   {
      s = new Stack();
      warCards = new ArrayList<Card>();
   }
   
   /**
      play draws a card from each persons stack
      adds the cards to an array 
      @return the array
   */
   public ArrayList<Card> playRound()
   {
      Card c1 = s.dealCardPlayer1();
      Card c2 = s.dealCardPlayer2();
      
      warCards.add(c2);
      warCards.add(c1);
      
      return warCards;
   }
   
   /**
      winner takes in two card objects, determine who wins or if their is a war
      if 2 is returned player 2 won
      if 1 returned player 1 won
      if 0 returned the cards were equal- their should be a war
      @param warCards an array of cards
      @return an int of the winner
   */
   public int roundWinner(ArrayList<Card> warCards)
   {
      int winnerNumber = 999;
      
      Card cardPlayer1 = warCards.get(warCards.size()-1);
      Card cardPlayer2 = warCards.get(warCards.size()-2);
      
      if(cardPlayer1.equals(cardPlayer2))
      {
         winnerNumber = 0;
      }
      
      else
      {
         if (cardPlayer1.getRank() > cardPlayer2.getRank())
         {
            winnerNumber = 1;
            
            //add the two cards in the array to player 1's hand
            for(int i = 0; i <= warCards.size(); i++)
            {
               Card c = warCards.remove(0);
               s.addCardPlayer1(new Card(c));
            }
         }
         
         else
         {
            winnerNumber = 2;
            
            //add the cards to player 2's hand
            for(int i = 0; i <= warCards.size(); i++)
            {
               Card c = warCards.remove(0);
               s.addCardPlayer2(new Card (c));
            }

         }
      }
      
      return winnerNumber;
   }
   
   /**
      war will play a war for the game
      @param warCards an array of Cards
      @return an array the cards
   */
   
   public ArrayList<Card> war(ArrayList<Card> warCards)
   {  
      //draw one card from each person
      Card c1FaceDown = s.dealCardPlayer1();
      Card c2FaceDown = s.dealCardPlayer2();
         
      //add cards to array
      warCards.add(c2FaceDown);
      warCards.add(c1FaceDown);
         
      //check to see that there are not 0 cards left in either persons deck
      loser();
         
      //draw the second card on each pile            
      Card c1FaceUp = s.dealCardPlayer1();
      Card c2FaceUp = s.dealCardPlayer2();
         
      //add cards to array
      warCards.add(c2FaceUp);
      warCards.add(c1FaceUp);
      
      return warCards;            
   }  
   
   /**
      warWinner returns who won the war
      @param warCards the cards already drawn
      @return an int of who won the war
   */
   public int warWinner(ArrayList<Card> warCards)
   {
      //send the cards to roundWinner
      int warWinner = roundWinner(warCards);         
      
      if(warWinner == 1)//if player 1 won, player 2's cards should be added to their pile
      {
         for(int i = 0; i <= warCards.size(); i++)
         {
            Card c = warCards.remove(0);
            s.addCardPlayer2(c);
         }
      }
   
      if(warWinner == 2)//if player 2 won, player 1's cards should be added to their pile
      {
         for(int i = 0; i <= warCards.size(); i++)
         {
            Card c = warCards.remove(0);
            s.addCardPlayer2(c);
         }               
      }
            
      return warWinner;
   }

   /**
         loser determines if someone lost the game
  */
   
   public void loser()
   {      
      if (s.cardsRemainingPlayer1() == 0 )
      {
         JOptionPane.showMessageDialog(null, "Player 1 has no cards remaining! Player 2 wins!"); 
      }
      
      if(s.cardsRemainingPlayer2() == 0)
      {
         JOptionPane.showMessageDialog(null, "Player 2 has no cards remaining! Player 1 wins!"); 
      }

   }
   
   /**
      getC1 method will return the flipped card when play is called
      @return a card object
   */
   public Card getC1()
   {
      return warCards.get(warCards.size()-1);
   }
   
   /**
      getC2 method will return the flipped card when play is called
      @return a card object
   */
   public Card getC2()
   {
      return warCards.get(warCards.size()-2);
   }
   
   /**
      getCardsRemainingPlayer1 will return the number of cards remaining 
      in player 1's hand
      @return an int of the cards
   */
   public int getCardsRemainingPlayer1()
   {
      return s.cardsRemainingPlayer1();
   }
   
   /**
      getCardsRemainingPlayer2 will return the number of cards remaining 
      in player 2's hand
      @return an int of the cards
   */
   public int getCardsRemainingPlayer2()
   {
      return s.cardsRemainingPlayer2();
   }   
}