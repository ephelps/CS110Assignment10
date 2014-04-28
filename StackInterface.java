public interface StackInterface
{
   public Card dealCardPlayer1() 
                        throws ArrayIndexOutOfBoundsException;
   public Card dealCardPlayer2()
                        throws ArrayIndexOutOfBoundsException;
   public int cardsRemainingPlayer1();
   public int cardsRemainingPlayer2();
   public void addCardPlayer1(Card c);
   public void addCardPlayer2(Card c);
}