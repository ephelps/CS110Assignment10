public interface DeckInterface
{
   public void freshDeck();
   public Card dealCard() 
                  throws ArrayIndexOutOfBoundsException;
   public int cardsRemaining();
   public boolean isEmpty();
   public void shuffle();
}