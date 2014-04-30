import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class WarGUI extends JFrame
{
   private War game = new War();
   private JPanel title, warButton, player1, player2, winner;
   private JButton round, war;
   private JLabel titleOfGame, winnerStatus, player1Score, player2Score;
   private ImageIcon player1Card, player2Card;
   
   private final int WINDOW_WIDTH = 750,
                     WINDOW_HEIGHT = 350;
                     
   private ArrayList<Card> cardsDrawn;
   
   public WarGUI()
   {
      setTitle("Game of War");
      
      setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setLayout(new BorderLayout());
      
      //create the five panels of the game
      title = new JPanel();
      warButton = new JPanel();
      player1 = new JPanel();
      player2 = new JPanel();
      winner = new JPanel();
      
      //create title of game label
      titleOfGame = new JLabel("Emily's War Game");
      title.add(titleOfGame);
       
      //create round button
      round = new JButton("Play");
      round.addActionListener(new roundButtonListener());
      warButton.add(round);
      
      //create war button            
      war = new JButton("War");
      war.addActionListener(new warButtonListener());
      warButton.add(war);
      war.setEnabled(false);

      
      //create winner label
      winnerStatus = new JLabel("Press Play to Flip the Cards");
      winner.add(winnerStatus);
      
      //set the pictures to the back default
      player1Card = new ImageIcon("back.jpg");
      player2Card = new ImageIcon("back.jpg");
            
      //set the scores
      player1Score = new JLabel("Cards Left: 26");
      player2Score = new JLabel("Cards Left: 26");
      
      player1Score.setIcon(player1Card);
      player2Score.setIcon(player2Card);

      player1.add(player1Score);
      player2.add(player2Score);
      
      //add panels to content pane
      add(title, BorderLayout.NORTH);
      add(warButton, BorderLayout.CENTER);
      add(player1, BorderLayout.WEST);
      add(player2, BorderLayout.EAST);
      add(winner, BorderLayout.SOUTH);
      
      setVisible(true);
   }
   
   private class roundButtonListener implements ActionListener
   {
      /**
         the actionPerformed method executes what happens when the user clicks on the round button
         @param e the event object
      */
      
      public void actionPerformed(ActionEvent e)
      {
         if(game.getCardsRemainingPlayer1() != 0 || game.getCardsRemainingPlayer2() != 0)
         {
            //get the two cards drawn
            cardsDrawn = game.playRound();
            
            //set the pics of those two items
            player1Score.setIcon(game.getC1().getPic());
            player2Score.setIcon(game.getC2().getPic());
            
            //see who won the round
            int winner = game.roundWinner(cardsDrawn);
            
            //if the winner is player 1
            if(winner == 1)
            {
               //roundWinner already added the cards the the deck
               //so just get the new cards remaining in the stacks
               player1Score.setText("Cards Remaining: " + game.getCardsRemainingPlayer1());
               player2Score.setText("Cards Remaining: " + game.getCardsRemainingPlayer2());
               
               //say that player 1 won the round
               winnerStatus.setText("Player 1 won the round");

            }
            
            //if the winner is player 2
            if(winner == 2)
            {
               //roundWinner already added the cards the the deck
               //so just get the new cards remaining in the stacks
               player1Score.setText("Cards Remaining: " + game.getCardsRemainingPlayer1());
               player2Score.setText("Cards Remaining: " + game.getCardsRemainingPlayer2());
               
               //say that player 2 won the round
               winnerStatus.setText("Player 2 won the round");

            }

            //if there was a tie          
            if (winner == 0)
            {  
               //say that there was a tie
               winnerStatus.setText("A tie has occurred. Press War button to resolve the war."); 
               round.setEnabled(false);
               war.setEnabled(true);              
            }
         }
         
         else
         {                  
            endOfGame();
         }
      }
   }
   
   private class warButtonListener implements ActionListener
   {
      /**
         the actionPerformed method executes what happens when the user clicks on the War button
         @param e the event object
      */
      
      public void actionPerformed(ActionEvent e)
      {         
         if(game.getCardsRemainingPlayer1() != 0 || game.getCardsRemainingPlayer2() != 0)
         {
            //call the war method, which draws two cards for each person
            ArrayList<Card> warCards = game.war(cardsDrawn);
            
            //set the pics of those two cards face up
            player1Score.setIcon(game.getC1().getPic());
            player2Score.setIcon(game.getC2().getPic());
            
            //determine who won the war
            int warWin = game.warWinner(warCards);
            
            //if the winner is player 1
            if(warWin == 1)
            {
               //warWinner already added the cards the the deck
               //so just get the new cards remaining in the stacks
               player1Score.setText("Cards Remaining: " + game.getCardsRemainingPlayer1());
               player2Score.setText("Cards Remaining: " + game.getCardsRemainingPlayer2());
                  
               //say that player 1 won the round
               winnerStatus.setText("Player 1 won the round");
               
               //war is now over so set the round button to work again and war button to not work
               round.setEnabled(true);
               war.setEnabled(false);
   
   
            }
               
            //if the winner is player 2
            if(warWin == 2)
            {
               //warWinner already added the cards the the deck
               //so just get the new cards remaining in the stacks
               player1Score.setText("Cards Remaining: " + game.getCardsRemainingPlayer1());
               player2Score.setText("Cards Remaining: " + game.getCardsRemainingPlayer2());
                  
               //say that player 2 won the round
               winnerStatus.setText("Player 2 won the round");
               
               //war is now over so set the round button to work again and war button to not work
               round.setEnabled(true);
               war.setEnabled(false);
   
            }
   
            //if there was another tie          
            if (warWin == 0)
            {  
               //say that there was a tie
               winnerStatus.setText("A tie has occurred. Press War button to resolve the war."); 
            }
         }
         
         else
         {                  
            endOfGame();
         }



      }
   }
   /**
      endOfGame will create a JOptionPane that tells you who won the game
   */
   private void endOfGame()
   {
      if (game.getCardsRemainingPlayer1() == 0 )
      {
         JOptionPane.showMessageDialog(null, "Player 1 has no cards remaining! Player 2 wins!"); 
      }
      
      if(game.getCardsRemainingPlayer2() == 0)
      {
         JOptionPane.showMessageDialog(null, "Player 2 has no cards remaining! Player 1 wins!"); 
      }
   }
   
   public static void main(String [] args)
   {
      new WarGUI();
   }
}