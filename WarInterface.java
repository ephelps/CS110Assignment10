import java.util.ArrayList;

public interface WarInterface
{
   public ArrayList<Card> play();
   public int roundWinner(ArrayList<Card> warCards);
   public void war(ArrayList<Card> warCards);
   public void loser();
   public Card getC1();
   public Card getC2();
   public int getCardsRemainingPlayer1();
   public int getCardsRemainingPlayer2();
}