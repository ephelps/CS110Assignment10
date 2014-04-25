import java.util.ArrayList;

public class Stack extends Deck
{  
   //stacks for each of the players
   ArrayList<Card> stackPlayer1;
   ArrayList<Card> stackPlayer2;

   /**
      constructor will take in a deck, split the deck in two and assign each half 
      of the deck to each players array
      @param d a Deck object
   */
   public Stack(Deck d)
   {
   
   }
   
   /**
      dealCardPlayer1 will return a card from player 1's stack
      @return a card objects
   */
   public Card dealCardPlayer1()
   {
      Card player1 = stackPlayer1.remove(0);
      
      return new Card(player1);
   }
   
   /**
      dealCardPlayer2 will return a card from player 2's stack
      @return a card objects
   */
   public Card dealCardPlayer2()
   {
      Card player2 = stackPlayer2.remove(0);
      
      return new Card(player2);
   }
   
   /**
      cardsRemainingPlayer1 will return the number of cards in the players stack
      @return an int of the number of cards
   */
   public int cardsRemainingPlayer1()
   {
      return stackPlayer1.size();
   }
   
   /**
      cardsRemainingPlayer2 will return the number of cards in the players stack
      @return an int of the number of cards
   */
   public int cardsRemainingPlayer2()
   {
      return stackPlayer2.size();
   }
   
   /**
      addCardPlayer1 will add a card object to a player 1's stack
      @param a card object to be added
   */
   public void addCardPlayer1(Card c)
   {
      stackPlayer1.add(c);
   }
   
   /**
      addCardPlayer2 will add a card object to a player 2's stack
      @param a card object to be added
   */
   public void addCardPlayer2(Card c)
   {
      stackPlayer2.add(c);
   }
}