//Emily Phelps
//CS 110
//Card Class

/*represents a single playing card in a deck of 52
a card object is created with a rank, a suite, and a pic and cannot be mondified
two cards are equal if they contain the same rank
*/

import javax.swing.*;

public class Card
{
   //create enumerated data type for suite
   enum Suite {HEARTS, CLUBS, DIAMONDS, SPADES};
   
   //define enumerated rank constants
   enum Rank {JACK, QUEEN, KING, ACE};
   
   //define fields
   private int rank;
   private int suite;
   private ImageIcon pic;
   
   /**
      constructor will accept a rank and suite for a card and set them to rank and suite respectively
      will also set a pic to the card accordingly
      @param cardRank the rank of the card
      @param cardSuite the suite of the card
   */
   
   public Card(int suite, int rank)
   {
      this.rank = rank;
      this.suite = suite;
      pic = null;////////////////////////////////////////////////////////////////////////////////////////////////////
   }
   
   /** 
      getSuite will return an int of the suite
      @return the int # of the suite
   */
   
   public int getSuite()
   {
      return suite;
   }
   
   /**
      getRank will return an int of the rank
      @return the int # of the rank of the card
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