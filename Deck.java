import java.util.Random;
import java.util.ArrayList;

public class Deck 
{
   final int CARDS_IN_DECK = 52;

   ArrayList<Card> deck;
   
   /**
      constructor creates a new deck by calling freshDeck
   */
   public Deck()
   {
            freshDeck();
   }
   
   /**
      freshDeck creates a new deck of cards
   */
   public void freshDeck()
   {
      deck = new ArrayList<Card>();

      for (int r = 1; r <= 13; r++)
      {
         deck.add(new Card(Suite.HEARTS,r));
         deck.add(new Card(Suite.CLUBS,r));
         deck.add(new Card(Suite.DIAMONDS,r));
         deck.add(new Card(Suite.SPADES,r));
      }
      
   }
   
   public Card dealCard()
   {
      Card c = deck.remove(0);
      return c;
   }
   
   
   public int cardsRemaining()
   {  
      return deck.size();
   }
   
   
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   
   
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
}

