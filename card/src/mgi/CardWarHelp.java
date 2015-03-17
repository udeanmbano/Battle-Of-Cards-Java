/*******************************************************************************
 * ** Date: May 8, 2014 
 * ** Name: Udean Mbano    MGI2012-3244
 * ** Name: Siphiwe Matore MGI2011-1572
 * ** Name: Christelle Kanyembo Kasongo MGI2012-0814
 * ** Purpose: Sets the images and icons for the help display pane
 * Version:14.2
 ******************************************************************************/
package mgi;

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import mgi.HelpCardWar;  

 public class CardWarHelp extends JFrame {
 private String[] gamePlays = {"Main Menu","Menu Buttons","Sound",
 "About","Start Game","Playing Game","Play Button","Keyboard Control","Radio Button",
"Declare War","End War Game"};
 // Declare an ImageIcon array for the images of the 11 main parts of the game
 private ImageIcon[] gamePics = {
 new ImageIcon("mainmenu.jpg"),
 new ImageIcon("menuButtons.jpg"),
 new ImageIcon("sound.jpg"),
 new ImageIcon("about.png"),
 new ImageIcon("startGame.jpg"),
 new ImageIcon("playingGame.jpg"),
 new ImageIcon("playButton.jpg"),
 new ImageIcon("keyboard.jpg") ,
 new ImageIcon("radioButtons.jpg"),
 new ImageIcon("declareWar.jpg"),
 new ImageIcon("endWarGame.jpg")
 };
// Declare an array of strings for game page descriptions
private String[] gamePageDetail =new String[11];
// Declare and create a description panel
private HelpCardWar gameDetail = new HelpCardWar();
private JButton exit = new JButton("exit");

private JComboBox gameCombo = new JComboBox(gamePlays);
 public static void main(String[] args) {
 CardWarHelp frame = new CardWarHelp();
frame.setSize(1400,370);
// frame.pack();
 frame.setTitle("Card War Help");
 //frame is not resizable
 frame.setResizable(false);
 frame.setLocationRelativeTo(null);// Center the frame
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setVisible(true);
 }

 public CardWarHelp() {

//shortcut keys for buttons
     exit.setMnemonic('Q');

// Set text description for each image part of the game on the left of the description
 gamePageDetail[0] = "The main menu of the Card War Game The Battle Of Cards has the following buttons and music plays the track by \n "
         + "Creedence Clearwater Revival - Fortunate Son - Live 1969.wav war song : \n"
         + "1. New Game   Button : \n"
          + "\t 1.1 This button allows the user to proceed to the game  \n"
         + "2. Help Game  Button \n"
         + "\t 2.1 This button allows the user to proceed to the game help  \n"
         + "3. About Game Button \n"
          + "\t 3.1 This button allows the user to proceed to the about game   \n"
         + "4. Music On   Button \n"
           + "\t 4.1 This button allows the user to play the game while listening to music  \n"
         + "5. Music Off  Button \n"
          + "\t 5.1 This button allows the user to play the game while not listening to music  \n"
         + "6. Exit Game  Button \n"
          + "\t 6.1 This button allows the user to exit the game  \n"
         + "7. Message Dialogs  \n"
         + "\t 7.1 Proceed to the game yes or no to enter the game \n"
         + "\t 7.1 Proceed to the about the game yes or no to view about the game \n"
         + "\t 7.1 Proceed to the help game yes or no to view  the game help  \n"
         + "\t 7.1 Proceed to the game with music playing on or off  yes or to listen to music  \n";
 gamePageDetail[1] = "Menu buttons have icons set up on them with several descriptions for each  \n"
         + "The menu buttons all have tool tip text in gray blue background showing the use of each button ";
 gamePageDetail[2] = "Sound \n"
         + " Game Background Music track by:Creedence Clearwater Revival - Fortunate Son - Live 1969.wav war song \n"
         + "\t The background music can be controlled using the On or Off Button on the main game screen \n"
         + "Play Card sound: makes a shuffle sound by :shuffling-cards-1.wav \n"
         + "\t The sound is made when the user presses the play button on the actual game screen \n"
         + "Draw card or same value card played sound by:Skyrim Sound Effects - Civil War Battle Cry.wav \n"
        + "\t The sound is made when the user has cards of the same value";
 gamePageDetail[3] = "This a Java Game Project Assignment to evaluate criteria for the effectiveness and effieciency of GUI \n"
         + "War Card is game downloaded fom Planet Source forge code website for java game projects \n"
         + "This version 14.2 of Java was re-created using the exsisting code and adding features \n"
         + "Authors of the game:\n"
         + "\t * ** Name: Udean Mbano    MGI2012-3244 \n"
         + "\t * ** Name: Siphiwe Matore MGI2011-1572 \n"
         + "\t * ** Name: Christelle Kanyembo Kasongo MGI2012-0814 \n"
         + "\t Copyright© inc 2014 MIDRAND GRADUATE INSTITUTE SOUTH AFRICA \n";
 gamePageDetail[4] = "The start game button must be pressed to shuffle out cards \n"
         + "\t The game will not start if the start game button is not pressed \n"
         + "\t A message dialog instructing the user to start the game first! will pop out if \n"
         + " he presses the play button\n"
          + "\t without pressing the play button";
 gamePageDetail[6] = "To play the game the user has to first click on the start game button then the play button \n"
         + "The user has to click the play button every 5 seconds to play a card and it make s a shuffle card sound\n ";
   gamePageDetail[5] = "Playing the game\n"
           + "Each time a player clickes on the play button a card is drawn \n"
           + "The player with a greater card value wins that round of drawn cards \n"
           + "The player that loses a round loses a card \n"
           + "The player that wins the round gets an extra card.\n"
           + "The number of cards remaning for each player is shown beneath each card drawn \n"
           + "Each card has a special value character on it`s name  that gives a value \n"
           + "to determine who wins the shuffled round \n"
           + "\t t for 10`s:10\n"
	   + "\t j for Jack and Joker:11\n"
	   + "\t q for Queen:12\n"
           + "\t k for King:13\n"
	   + "\t a for Ace :14\n"
	   + "When eithier player has O cards remaining he loses the war and the other player wins  \n"
           + "A new game has to be started \n";
    gamePageDetail[8] = "The radio buttons are used to give the user a choice of changing the backgroung color of the \n"
         + "message box which player has one the round of cards or both players have cards with equal values\n"
         + "The option colors are red,gray,blue,white ";
     gamePageDetail[7] = "The KeyBoard Control shortcuts of the Card War Game The Battle Of Cards  has the following \n "
             + " buttons and music plays the track by \n "
         + "Creedence Clearwater Revival - Fortunate Son - Live 1969.wav war song : \n"
         + "1. Main Menu :\t\t\t   Key \n"
             + "\tNew Game  Button\t alt + N\n"
             + "\tHelp Game  Button\t alt + H\n"
             + "\tAbout Game Button\t alt + A\n"
             + "\tMusic On   Button\t alt + S\n"
             + "\tMusic Off  Button\t  alt + O\n"
             + "\tExit Game  Button\t  alt + E\n"
      + "2. Game Panel:\t\t\t    Key \n"
             + "\tStart Game  Button\t alt + S\n"
             + "\tQuit  Game Button\t alt + Q\n"
             + "\tPlay  Button \t\t  alt + P\n"
       + "3. About,Help Panel:\t\t   Key \n"
             + "\t Exit to main menu \t alt + Q";
                     gamePageDetail[9] = "Draw or Declare happens when two cards played have the same value \n"
         + "\t soundtrack is played to alert the player : Skyrim Sound Effects - Civil War Battle Cry.wav  \n ";
 gamePageDetail[10] = "When the game is over it one player has cards remaining displays on the message box which player has won A or B \n"
         + "\t If user tries to play a card a message dialog box pops up with a message start a new game first ";

// Set the first country (Canada) for display
 view(0);

 // Add combo box and description panel to the frame
 add(gameCombo, BorderLayout.NORTH);
 add(gameDetail, BorderLayout.CENTER);
 exit.setBackground(Color.DARK_GRAY);
exit.setForeground(Color.WHITE);
 add(exit,BorderLayout.SOUTH);
 // Register listener
 gameCombo.addItemListener(new ItemListener() {
 @Override/** Handle item selection */
 public void itemStateChanged(ItemEvent e) {
 view(gameCombo.getSelectedIndex());
 }
 });
 
    exit.addActionListener(new ActionListener()
  {
 @Override
         public void actionPerformed(ActionEvent e) {
             int option;
          
   option = JOptionPane.showConfirmDialog(null, "Proceed to Main Menu?", "About Game" ,JOptionPane.YES_NO_OPTION);
    if(option == JOptionPane.YES_OPTION)
    {
      
        DisplayLabel thisClass= new DisplayLabel();
       dispose();
    }
 }
 }
 );
 }
 

 /** Set display information on the description panel */
 public void view(int index) {
 gameDetail.setTitle(gamePlays[index]);
 gameDetail.setImageIcon(gamePics[index]);
 gameDetail.setDescription(gamePageDetail[index]);
 }
 }
 
 
 