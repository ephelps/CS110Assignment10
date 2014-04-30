import javax.swing.*;

public interface CardInterface
{
   public Suite getSuite();
   public int getRank();
   public ImageIcon getPic();
   public boolean equals(Card card2);   
}