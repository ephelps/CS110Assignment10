//Emily Phelps
//CS 110
//Card Class

/*represents a single playing card in a deck of 52
a card object is created with a rank, a suite, and a pic and cannot be mondified
two cards are equal if they contain the same rank
*/

import javax.swing.*;

public class Card implements CardInterface
{
   //define rank constants
   public final static int ACE = 1,          
                           JACK = 11,        
                           QUEEN = 12,       
                           KING = 13;   
   //define fields
   private int rank;
   private Suite suite;
   private ImageIcon pic;
   
   /**
      constructor will accept a rank and suite for a card and set them to rank and suite respectively
      will also set a pic to the card accordingly
      @param rank the rank of the card
      @param suite the suite of the card
   */
   
   public Card(Suite suite, int rank)
   {
      this.rank = rank;
      this.suite = suite;
      
      //make strings so you can assign a pic
      String rankString = null;
      String suiteString = null;
      String thepic;
      
      //get the correct rank on the card name
      if (rank < 11 && rank > 1)
      {
         rankString = rank+"";
      }
      
      else if (rank == 11)
      {
         rankString = "jack";
      }
      
      else if (rank == 12)
      {
         rankString = "queen";
      }
      
      else if (rank == 13)
      {
         rankString = "king";
      }
      
      else if (rank == 1)
      {
         rankString = "ace";
      }
      
      //get correct suite format for card name
      if(suite == suite.HEARTS)
         suiteString = "h";
      else if(suite == suite.DIAMONDS)
         suiteString = "d";
      else if(suite == suite.SPADES)
         suiteString = "s";
      else if(suite == suite.CLUBS)
         suiteString = "c";
      
      thepic = rankString + suiteString + ".jpg";
      
      pic = new ImageIcon(thepic);

   }
   
   /**
      copy constructor accepts a card object and recreates it
      @param c a card object
   */
   public Card(Card c)
   {
      rank = c.getRank();
      suite = c.getSuite();
      pic = c.getPic();
      
   }
   
   /** 
      getSuite will return an int of the suite
      @return the enum object of the suite
   */
   
   public Suite getSuite()
   {
      return suite;
   }
   
   /**
      getRank will return an int of the rank
      @return the int of the rank of the card
   */
   
   public int getRank()
   {
      return rank;
   }
   
   /**
      getPic will return the pic attached to the card
      @return a ImageIcon pic of a card
   */
   public ImageIcon getPic()
   {
      return pic;
   }
   
   /**
      equals will accept a Card object, compare, and if they are equal return a boolean true
      @param card2 a Card object to be compared
      @return boolean true or false
   */
   
   public boolean equals(Card card2)
   {
      boolean status;
      
      if (rank == card2.rank)
      {
         status = true;
      }
      
      else
      {
         status = false;
      }
      
      return status;
   }
}