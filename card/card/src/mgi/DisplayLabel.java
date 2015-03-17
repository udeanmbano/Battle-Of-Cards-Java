/*******************************************************************************
 * ** Date: May 8, 2014 
 * ** Name: Udean Mbano    MGI2012-3244
 * ** Name: Siphiwe Matore MGI2011-1572
 * ** Name: Christelle Kanyembo Kasongo MGI2012-0814
 * ** Purpose: Displays the main menu of the game and buttons to play the game
 * Version:14.2
 ******************************************************************************/
package mgi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import  sun.audio.*;    //import the sun.audio package
import  java.io.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import mgi.warGame;
import mgi.AboutCardWar;
import mgi.CardWarHelp;
import javax.swing.plaf.ColorUIResource;
public class DisplayLabel extends JApplet {
  private ImageIcon myp =      new ImageIcon("325107_533271893370218_1031028754_o.jpg");
  private ImageIcon myEnd=     new ImageIcon("download.jpg");
  private ImageIcon myNew=     new ImageIcon("menu-new-game.png");
  private ImageIcon myHelp=    new ImageIcon("help.jpg");
  private ImageIcon myAbout=   new ImageIcon("Sections-of-Website-About-icon.png");
  private ImageIcon mySoundOn= new ImageIcon("Sound-on.ico");
  private ImageIcon mySoundOff= new ImageIcon("Sound-off.png");
  private JButton jbtNewGame=  new JButton(myNew);
  private JButton jbtEndGame=  new JButton(myEnd);
  private JButton jbtHelpGame= new JButton(myHelp);
  private JButton jbtAboutGame=new JButton(myAbout);
  final JButton stopBtn =      new JButton(mySoundOff);
  final JButton playBtn =      new JButton(mySoundOn);
  private JLabel jblImg=       new JLabel();
  AudioFormat audioFormat;
  AudioInputStream audioInputStream;
  SourceDataLine sourceDataLine;
  boolean stopPlayback = false;  
  final JTextField textField =new JTextField("Creedence Clearwater Revival - Fortunate Son - Live 1969.wav");
public DisplayLabel() {
 //** add this into your application code as appropriate
// Open an input stream  to the audio file.
 JPanel panel = new JPanel();
 panel.setLayout(new GridLayout(6,1));
 panel.setBackground(Color.DARK_GRAY);
 panel.add(jbtNewGame);
 jbtNewGame.setToolTipText("New Game");
   jbtNewGame.setBackground(Color.DARK_GRAY);
   
 panel.add(jbtHelpGame);
  jbtHelpGame.setToolTipText("Help Game");
    jbtHelpGame.setBackground(Color.DARK_GRAY);
 panel.add(jbtAboutGame);
  jbtAboutGame.setToolTipText("About Game");
    jbtAboutGame.setBackground(Color.DARK_GRAY);
      panel.add(stopBtn);
  stopBtn.setToolTipText("Music OFF");
  panel.add(playBtn);
   playBtn.setBackground(Color.DARK_GRAY);
  playBtn.setToolTipText("Music ON");
   stopBtn.setBackground(Color.DARK_GRAY);
 panel.add(jbtEndGame);
  jbtEndGame.setToolTipText("Exit Game");
  jbtEndGame.setBackground(Color.DARK_GRAY);
  //Shortcut keys for the buttons
jbtNewGame.setMnemonic('N');
jbtHelpGame.setMnemonic('H');
jbtAboutGame.setMnemonic('A');
jbtEndGame.setMnemonic('E');
stopBtn.setMnemonic('O');
playBtn.setMnemonic('S');
 JPanel panel2 = new JPanel(new BorderLayout());
    jblImg.setIcon(myp);
    panel2.add(jblImg);
    add(panel,BorderLayout.EAST);
    add(panel2,BorderLayout.WEST);
 //Plays the background music of the game
        playBtn.addActionListener(
      new ActionListener(){
        public void actionPerformed(
                                  ActionEvent e){
          stopBtn.setEnabled(true);
          playBtn.setEnabled(true);
          playAudio();//Play the file
        }//end actionPerformed
      }//end ActionListener
    );//end addActionListener()
//Stops the background music of the game
     stopBtn.addActionListener(
      new ActionListener(){
        public void actionPerformed(
                                  ActionEvent e){
          //Terminate playback before EOF
          stopPlayback = true;
        }//end actionPerformed
      }//end ActionListener
    );//end addActionListener()
    //Proceeds to the game
  jbtNewGame.addActionListener(new ActionListener()
  {
 @Override
         public void actionPerformed(ActionEvent e) {
             int option,option2;
  
  option2=JOptionPane.showConfirmDialog(null, "With your music playing proceed to the game", "Proceed to the game?" ,JOptionPane.YES_NO_OPTION);
   if(option2 == JOptionPane.YES_OPTION)
    {
         option = JOptionPane.showConfirmDialog(null, "Proceed to the game?", "Go For Battle Soldier" ,JOptionPane.YES_NO_OPTION);
        playAudio();
           if(option == JOptionPane.YES_OPTION)
    {
      
        warGame thisClass= new warGame();
        thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //change to automatically fit all components on the game
         thisClass.setSize(760,570);
         //change game appears at a position relative in the center
         thisClass.setLocationRelativeTo(null);
         thisClass.setVisible(true);
    }
         
    }
          if(option2 == JOptionPane.NO_OPTION)
    {
  
         option = JOptionPane.showConfirmDialog(null, "Proceed to the game?", "Go For Battle Soldier" ,JOptionPane.YES_NO_OPTION);
           stopThread();
           if(option == JOptionPane.YES_OPTION)
    {
      
   
        warGame thisClass= new warGame();
        thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //change to automatically fit all components on the game
         thisClass.setSize(760,570);
         //change game appears at a position relative in the center
         thisClass.setLocationRelativeTo(null);
         thisClass.setVisible(true);
    }
  }
         }
  }
 );
               
  //Proceeds to the help menu panel
   jbtHelpGame.addActionListener(new ActionListener()
  {
 @Override
         public void actionPerformed(ActionEvent e) {
             int option;
          
   option = JOptionPane.showConfirmDialog(null, "Proceed to the game help?", "Go For Battle Help" ,JOptionPane.YES_NO_OPTION);
    if(option == JOptionPane.YES_OPTION)
    {
      
       CardWarHelp thisClass= new CardWarHelp();
        thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //change to automatically fit all components on the game
        thisClass.setSize(1000,570);
         //change game appears at a position relative in the center
        thisClass.setLocationRelativeTo(null);
        thisClass.setVisible(true);
    }
 }
 }
 );
   //Proceeds to the about information panel
    jbtAboutGame.addActionListener(new ActionListener()
  {
 @Override
         public void actionPerformed(ActionEvent e) {
             int option;
   option = JOptionPane.showConfirmDialog(null, "Proceed to about game?", "About Card War" ,JOptionPane.YES_NO_OPTION);
    if(option == JOptionPane.YES_OPTION)
    {
        
         AboutCardWar thisClass= new AboutCardWar();
        thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //change to automatically fit all components on the game
         thisClass.setSize(1000,410);
         //change game appears at a position relative in the center
         thisClass.setLocationRelativeTo(null);
         thisClass.setVisible(true);
    }
 }
 }
 );
    //Ends the game
     jbtEndGame.addActionListener(new ActionListener()
  {
 @Override
         public void actionPerformed(ActionEvent e) {
 // closes the program
			            int option;
   option = JOptionPane.showConfirmDialog(null, "Exit the game?", "Exit Game" ,JOptionPane.YES_NO_OPTION);
    if(option == JOptionPane.YES_OPTION)
    {
        //closes the program
         System.gc();
         System.exit(0);
    }	
 }
 }
 );
     
     
 
 }
public static void main(String[] args) {
//change the color of JOptionPane dialog
UIManager uim=new UIManager();
uim.put("OptionPane.background",new ColorUIResource(Color.BLACK));
uim.put("Panel.background",new ColorUIResource(Color.WHITE));
uim.put("Panel.foreground",new ColorUIResource(Color.WHITE));  
//create a sound for the game

// Create a frame

JFrame frame = new JFrame("WAR CARD");
 // Create an instance of the applet
 DisplayLabel applet = new DisplayLabel();

 // Add the applet to the frame
 frame.add(applet);
 
 // Display the frame
 frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
 frame.setSize(500,260);
 frame.setBackground(Color.WHITE);
 frame.setForeground(Color.BLUE);
 //frame is not resizable
 frame.setResizable(false);
 frame.setLocationRelativeTo(null);// Center the frame
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setVisible(true);
 }
 //This method plays back audio data from an
  // audio file whose name is specified in the
  // text field.
  private void playAudio() {
    try{
      File soundFile =
                   new File(textField.getText());
      audioInputStream = AudioSystem.
                  getAudioInputStream(soundFile);
      audioFormat = audioInputStream.getFormat();
      System.out.println(audioFormat);

      DataLine.Info dataLineInfo =
                          new DataLine.Info(
                            SourceDataLine.class,
                                    audioFormat);

      sourceDataLine =
             (SourceDataLine)AudioSystem.getLine(
                                   dataLineInfo);

      //Create a thread to play back the data and
      // start it running.  It will run until the
      // end of file, or the Stop button is
      // clicked, whichever occurs first.
      // Because of the data buffers involved,
      // there will normally be a delay between
      // the click on the Stop button and the
      // actual termination of playback.
      new PlayThread().start();
    }catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }//end catch
  }//end playAudio
  //Inner class to play back the data from the
// audio file.
  
class PlayThread extends Thread{
  byte tempBuffer[] = new byte[10000];

  public void run(){
    try{
      sourceDataLine.open(audioFormat);
      sourceDataLine.start();

      int cnt;
      //Keep looping until the input read method
      // returns -1 for empty stream or the
      // user clicks the Stop button causing
      // stopPlayback to switch from false to
      // true.
      while((cnt = audioInputStream.read(
           tempBuffer,0,tempBuffer.length)) != -1
                       && stopPlayback == false){
        if(cnt > 0){
          //Write data to the internal buffer of
          // the data line where it will be
          // delivered to the speaker.
          sourceDataLine.write(
                             tempBuffer, 0, cnt);
        }//end if
      }//end while
      //Block and wait for internal buffer of the
      // data line to empty.
      sourceDataLine.drain();
      sourceDataLine.close();

      //Prepare to playback another file
      stopBtn.setEnabled(false);
      playBtn.setEnabled(true);
      stopPlayback = false;
    }catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }//end catch
  }//end run
}//end inner class PlayThread
//===================================//
//stop thread class and stops playback
public void stopThread()
{

 
    
       stopPlayback = true;
      
     }//end catch
  }//end run


 

