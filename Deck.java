import java.util.Random;
import java.util.ArrayList;

public class Deck implements DeckInterface
{
   private final int CARDS_IN_DECK = 52;

   private ArrayList<Card> deck;
   
   /**
      constructor creates a new deck by calling freshDeck
   */
   public Deck()
   {
            freshDeck();
   }
   
   /**
      freshDeck creates a new deck of 52 cards
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
   
   /**
      dealCard will deal the top card from the deck
      @return a card object
   */
   public Card dealCard()
   {
      Card c = deck.remove(0);
      return new Card(c);
   }
   
   /**
      cardsRemaining will return the size of the deck
      @return the size of the deck
   */
   public int cardsRemaining()
   {  
      return deck.size();
   }
     
   /**
      isEmpty will return true if the deck is Empty
      @return a boolean true or false
   */
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   
   /**
      shuffle randomizes the deck
   */
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
}

