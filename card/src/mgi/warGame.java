/*******************************************************************************
 * ** Date: May 8, 2014 
 * ** Name: Udean Mbano    MGI2012-3244
 * ** Name: Siphiwe Matore MGI2011-1572
 * ** Name: Christelle Kanyembo Kasongo MGI2012-0814
 * ** Purpose: a Java program that plays the card game of war between 
 * two computer players
 * Version:14.2
 ******************************************************************************/
package mgi;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;
import mgi.warGame;
//import the sun.audio package for sound
import  sun.audio.*;    
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.*;
import java.awt.Color;
import java.util.*;
import javax.swing.plaf.ColorUIResource;
import mgi.DisplayLabel;
public class warGame extends JFrame {

	private static final long serialVersionUID = 1L;
	
  AudioFormat audioFormat;
  AudioInputStream audioInputStream;
  SourceDataLine sourceDataLine;
  boolean stopPlayback = false;  
  // creating two sources for sound when playing card from the deck by player and when game drawn by both players
  final JTextField textField =
                       new JTextField("shuffling-cards-1.wav");
  final JTextField draw =
                       new JTextField("Skyrim Sound Effects - Civil War Battle Cry.wav");
 	public static void main(String[] args) {
	//change the color of JOptionPane dialog
        UIManager uim=new UIManager();
        uim.put("OptionPane.background",new ColorUIResource(Color.BLACK));
        uim.put("Panel.background",new ColorUIResource(Color.WHITE));
        uim.put("Panel.foreground",new ColorUIResource(Color.WHITE));  	
            SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		warGame thisClass = new warGame();
		thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //change to automatically fit all components on the game
                 thisClass.setSize(800,570);
                 //frame is not resizable
                 thisClass.setResizable(false);
                //change game appears at a position relative in the center
                 thisClass.setLocationRelativeTo(null);
	         thisClass.setVisible(true);
              
			}
		});

	}

	/**
	 * This method initializes ControlPanel
	 * 
	 * @return javax.swing.JPanel
	 */

	// these arrays are for the deck of cards.
	// You have have as many or as few cards as you choose.
	private String[] cardrank = { "2", "3", "4", "5", "6", "7", "8", "9", "t", "j",
			"q", "k", "a" };
	private String[] cardsuit = { "s", "h", "d", "c" };
	private String[] cardDeck = new String[52];

 
    
	// set the background Image for the deck.
        //declare an image array
       //set icons for game buttons
	private ImageIcon backgroundImage = new ImageIcon("cards/vietnam-war-01.gif");
        private ImageIcon backgroundImage2 = new ImageIcon("icon_start.gif");
        private ImageIcon backgroundImage3 = new ImageIcon("production_icon.png");
        private ImageIcon backgroundImage4 = new ImageIcon("i-quit-must-dash--icon-1.jpg");
	// these vectors hold the players hands
	private Vector<String> WarPlayerA = new Vector<String>();
	private Vector<String> WarPlayerB = new Vector<String>();

	// these variables keep track of the number of battles
	private int battle = 0;
	private int battleA = 0, battleB = 0;

	// GUI panels and components
	private JPanel jContentPane = null;
	private JLabel WarPlayerACard = null;
	private JLabel WarPlayerBCard = null;
	private JPanel ControlPanel = null;
        private JPanel radios=null;
	private Border blackline = BorderFactory.createLineBorder(Color.black);
	private Border raisedetched = BorderFactory
	.createEtchedBorder(EtchedBorder.RAISED);
	private Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	private Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	private JButton Play = null;
	private JButton Quit = null;
	private JLabel ACardsRemaining = null;
	private JLabel BCardsRemaining = null;
	private JLabel AWarSlot1 = null;
	private JLabel AWarSlot2 = null;
	private JLabel BWarSlot1 = null;
	private JLabel BWarSlot2 = null;
	private JTextArea messagebox = null;
	private JLabel jLabelA = null;
	private JLabel jLabelB = null;
	private JLabel lblRemainA = null;
	private JLabel lblRemainB = null;
	private JButton StartGame = null;
         // A combo Box to select an image
     //adding radio buttons to select a new message box color
        private JRadioButton jrbRed = new JRadioButton("Red");
        private JRadioButton jrbGray = new JRadioButton("Gray");
        private JRadioButton jrbBlue = new JRadioButton("Blue");
        private JRadioButton jrbWhite= new JRadioButton("White");
 // creating a lineBorder for the message box
          Border lineBorder= new LineBorder(Color.BLACK,2);
      
      /**
	 * This is the default constructor
	 */
	public warGame() {
		super();
      
     initialize();
	}
   
	// this method deals each player 26 cards
	private void carddealcardDeck() {
		int i = 0;
		do {
	        this.WarPlayerA.addElement(this.cardDeck[i]);
		this.WarPlayerB.addElement(this.cardDeck[i + 1]);
		i += 2;
		} while (i < this.cardDeck.length);

		// this puts the number of cards in the box underneath the players hand
		this.ACardsRemaining.setText(Integer.toString(this.WarPlayerA.size()));
		this.BCardsRemaining.setText(Integer.toString(this.WarPlayerB.size()));
	}

	// this method takes the cardsuit and cardrank, then combines them into a full deck
	private void getCards() {
		int index = 0;
		for (int i = 0; i < this.cardsuit.length; i++) {
		for (int j = 0; j < this.cardrank.length; j++) {
		this.cardDeck[index] = this.cardrank[j] + this.cardsuit[i];
		index++;
			}
		}

	}
            // font for the message box to be displayed in the main panel
            Font font1=new Font("SansSerif",Font.BOLD,20);
//panel for radio button
        private JPanel radios()
        {
             if(this.radios==null)
            {
        this.radios = new JPanel();
        this.radios.setLayout(new GridLayout(4,1));
        this.radios.setBounds(30,300,100,100);
        this.radios.add(jrbRed );
        this.radios.add(jrbGray);
        this.radios.add(jrbBlue);
        this.radios.add(jrbWhite);
         ButtonGroup group = new ButtonGroup();
         group.add(jrbRed);
         group.add(jrbGray);
         group.add(jrbBlue);
         group.add(jrbWhite);
            }
             this.radios.setCursor(new Cursor(Cursor.HAND_CURSOR));
          jrbRed.setBackground(Color.darkGray);
          jrbRed.setForeground(Color.WHITE);
          jrbGray.setBackground(Color.darkGray);
          jrbGray.setForeground(Color.WHITE);
          jrbBlue.setBackground(Color.darkGray);
          jrbBlue.setForeground(Color.WHITE);
          jrbWhite.setBackground(Color.darkGray);
          jrbWhite.setForeground(Color.WHITE);
            //Shortcut keys for the radio buttons
          jrbRed.setMnemonic('R');
          jrbGray.setMnemonic('G');
          jrbBlue.setMnemonic('B');
          jrbWhite.setMnemonic('W');
             //register listeners for checkButtons
          jrbRed.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(ActionEvent e)
          {
              messagebox.setBackground(Color.red);
              messagebox.setFont(font1);
          }
        });
          jrbGray.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(ActionEvent e)
          {
              messagebox.setBackground(Color.DARK_GRAY);
              messagebox.setFont(font1);
              messagebox.setForeground(Color.WHITE);
          }
        });
            jrbBlue.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(ActionEvent e)
          {
              messagebox.setBackground(Color.BLUE);
              messagebox.setFont(font1);
              messagebox.setForeground(Color.WHITE);
             
          }
        });
              jrbWhite.addActionListener(new ActionListener()
        {
          @Override
          public void actionPerformed(ActionEvent e)
          {
              messagebox.setBackground(Color.WHITE);
              messagebox.setFont(font1);
              messagebox.setForeground(Color.BLUE);
          }
        });
            return this.radios;
        }
      

	// the panel for the game
	private JPanel getControlPanel() {
                       //create a panel for radio buttons
    
		if (this.ControlPanel == null) {
		this.ControlPanel = new JPanel();
              this.ControlPanel.setBorder(this.raisedetched);
		// changed layout to borderLayout center
                this.ControlPanel.setLayout(new BorderLayout());
                // this.ControlPanel.add(radios,BorderLayout.WEST);
                this.add(ControlPanel,BorderLayout.CENTER); 
                this.ControlPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                               
		}
		return this.ControlPanel;
	}

	// gets the card image when needed
	private ImageIcon getImage(String card) {
	ImageIcon cardIcon = new ImageIcon("cards/" + card + ".gif");
		return cardIcon;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {

		if (this.jContentPane == null) {
			// GUI panels and components
                        
       		this.jLabelA = new JLabel();
		this.jLabelA.setBounds(new Rectangle(40, 75, 75, 30));
		this.jLabelA.setText("WarPlayer A's Hand");
		this.messagebox = new JTextArea();
		this.messagebox.setBounds(new Rectangle(170, 300, 390, 100));
                this.messagebox.setBorder(lineBorder);
                this.messagebox.setText("");
		messagebox.setBackground(new Color(51, 204, 51));
		this.messagebox.setEditable(false);
		this.WarPlayerACard = new JLabel();
		this.WarPlayerACard.setText("WarPlayerA");
		this.WarPlayerACard.setBounds(new Rectangle(80, 100, 77, 97));
		this.WarPlayerACard.setIcon(this.backgroundImage);
		this.WarPlayerACard.setBorder(this.raisedbevel);
		this.AWarSlot1 = new JLabel();
		this.AWarSlot1.setBounds(new Rectangle(240, 50, 73, 97));
		this.AWarSlot1.setText("");
		this.AWarSlot1.setBackground(Color.black);
		this.AWarSlot1.setBorder(this.loweredbevel);
		this.AWarSlot2 = new JLabel();
		this.AWarSlot2.setBounds(new Rectangle(390, 50, 73, 97));
		this.AWarSlot2.setText("");
		this.AWarSlot2.setBackground(Color.black);
		this.AWarSlot2.setBorder(this.loweredbevel);
		this.ACardsRemaining = new JLabel();
		this.ACardsRemaining.setBounds(new Rectangle(60, 200, 50, 20));
		this.ACardsRemaining.setText("0");
		this.ACardsRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		this.ACardsRemaining.setBorder(this.blackline);
		this.ACardsRemaining.setForeground(Color.black);
		this.lblRemainA = new JLabel();
		this.lblRemainA.setBounds(new Rectangle(30, 220, 100, 25));
		this.lblRemainA.setText("Cards Remaining");
		this.jLabelB = new JLabel();
		this.jLabelB.setBounds(new Rectangle(520, 75, 75, 30));
		this.jLabelB.setText("WarPlayer B's Hand");
	        this.WarPlayerBCard = new JLabel();
		this.WarPlayerBCard.setText("WarPlayerB");
		this.WarPlayerBCard.setBounds(new Rectangle(530, 99, 77, 97));
		this.WarPlayerBCard.setIcon(this.backgroundImage);
		this.WarPlayerBCard.setBorder(this.raisedbevel);
		this.BWarSlot1 = new JLabel();
		this.BWarSlot1.setBounds(new Rectangle(240, 150, 73, 97));
		this.BWarSlot1.setText("");
		this.BWarSlot1.setBackground(Color.black);
		this.BWarSlot1.setBorder(this.loweredbevel);
		this.BWarSlot2 = new JLabel();
		this.BWarSlot2.setBounds(new Rectangle(390, 150, 73, 97));
		this.BWarSlot2.setText("");
		this.BWarSlot2.setBackground(Color.black);
		this.BWarSlot2.setBorder(this.loweredbevel);
		this.lblRemainB = new JLabel();
		this.lblRemainB.setBounds(new Rectangle(520, 220, 100, 25));
		this.lblRemainB.setText("Cards Remaining");
		this.BCardsRemaining = new JLabel();
		this.BCardsRemaining.setBounds(new Rectangle(540, 200, 50, 20));
		this.BCardsRemaining.setText("0");
		this.BCardsRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		this.BCardsRemaining.setBorder(this.blackline);
		this.BCardsRemaining.setForeground(Color.black);
	        this.jContentPane = new JPanel();
			
                this.jContentPane.setLayout(new BorderLayout(15,15));
		this.jContentPane.setBackground(Color.LIGHT_GRAY);
		this.jContentPane.add(this.WarPlayerACard);	
                this.jContentPane.add(this.WarPlayerBCard);	
       		this.jContentPane.add(getPlay(), null);
		this.jContentPane.add(getQuit(), null);
		this.jContentPane.add(this.ACardsRemaining, null);
		this.jContentPane.add(this.BCardsRemaining, null);
		this.jContentPane.add(this.AWarSlot1, null);
		this.jContentPane.add(this.AWarSlot2, null);
	        this.jContentPane.add(this.BWarSlot1, null);	
                this.jContentPane.add(this.BWarSlot2, null);
		this.jContentPane.add(this.messagebox, null);
		this.jContentPane.add(this.jLabelA, null);
		this.jContentPane.add(this.jLabelB, null);
	        this.jContentPane.add(this.lblRemainA, null);
		this.jContentPane.add(this.lblRemainB, null);
                this.jContentPane.add(getStartGame(), null);
                this.jContentPane.add(radios());
                this.add(jContentPane,BorderLayout.CENTER);
                this.jContentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                 
		return this.jContentPane;
                       
	          }

	/**
	 * This method initializes StartGame
	 * 
	 * @return javax.swing.JButton
	 */
  
     
	private JButton getStartGame() {
		if (this.StartGame == null) {
			this.StartGame = new JButton();
			this.StartGame.setBounds(new Rectangle(580, 300, 102, 102));
                        this.StartGame.setIcon(backgroundImage2);
                        this.StartGame.setToolTipText("Start");
                        //Shortcut for new game
                        this.StartGame.setMnemonic('S');
			this.StartGame.grabFocus();
					this.StartGame.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					// initializes variables and players hands for a new game
					warGame.this.WarPlayerA.removeAllElements();
					warGame.this.WarPlayerB.removeAllElements();
					warGame.this.battle = 0;
					warGame.this.battleA = 0;
					warGame.this.battleB = 0;
					warGame.this.ACardsRemaining.setForeground(Color.black);
					warGame.this.BCardsRemaining.setForeground(Color.black);
					String msg = "";
					warGame.this.messagebox.setText(msg);
					warGame.this.WarPlayerACard.setIcon(warGame.this.backgroundImage);
					warGame.this.AWarSlot1.setIcon(null);
					warGame.this.AWarSlot2.setIcon(null);
					warGame.this.WarPlayerBCard.setIcon(warGame.this.backgroundImage);
					warGame.this.BWarSlot1.setIcon(null);
					warGame.this.BWarSlot2.setIcon(null);

					// get the cards into a new deck
					getCards();
					// shuffle the deck
					shuffleCards();
					// deal the deck to each player
					carddealcardDeck();
				}
			});
		}
		return this.StartGame;
	}

	/**
	 * This method initializes Play
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getPlay() {
		if (this.Play == null) {
			this.Play = new JButton();
			this.Play.setBounds(new Rectangle(290, 411, 102, 102));
                        this.Play.setToolTipText("Play Card");
                        //shortcut to play game
                        this.Play.setMnemonic('P');
                        this.Play.setIcon(backgroundImage3);
						this.Play.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
                                         playAudio();
					// initialize each battles variables to 0 or null
					int winner = 0;
					String msg = "";
					warGame.this.messagebox.setText(msg);
					warGame.this.AWarSlot1.setIcon(null);
					warGame.this.AWarSlot2.setIcon(null);
					warGame.this.BWarSlot1.setIcon(null);
					warGame.this.BWarSlot2.setIcon(null);

					// if both players hands are empty, we must start a new game
					if ((warGame.this.WarPlayerA.size() == 0)
							&& (warGame.this.WarPlayerB.size() == 0)) {
                                            //changed message box option to JDialog message   
                                            
                                            JOptionPane.showMessageDialog(null,"You must start a new game first!");
					} else if ((warGame.this.WarPlayerA.size() == 0)
							|| (warGame.this.WarPlayerB.size() == 0)) {

						// if one players cards are zero, this game is over
						// print statistics
						msg += "\nThis war had " + warGame.this.battle
						+ " battles.\nWarPlayer A won "
						+ warGame.this.battleA
						+ " battles.\nWarPlayer B won "
						+ warGame.this.battleB + " battles";

						// keep the text but show the winner of the game
						warGame.this.messagebox.setText(msg);
						if (warGame.this.WarPlayerA.size() == 0) {
							msg += "\nWarPlayer B wins the war!";
							warGame.this.messagebox.setText(msg);
						} else if (warGame.this.WarPlayerB.size() == 0) {
							msg += "\nWarPlayer A wins the war!";
							warGame.this.messagebox.setText(msg);
						}

						// remove both players hands after the game is over
						warGame.this.WarPlayerA.removeAllElements();
						warGame.this.WarPlayerB.removeAllElements();
					}

					// if both players still have cards, play a battle
					if ((warGame.this.WarPlayerA.size() != 0)
							&& (warGame.this.WarPlayerB.size() != 0)) {

						// the war method is the battle itself and returns the
						// winner
						// WarPlayerA is winner 1, WarPlayerB is winner 2
						// the winner will only be 0 if one player runs out of
						// cards
						// during a war
						winner = war();
						warGame.this.battle += 1;

						// if one player runs out of cards, the player with the
						// most
						// cards wins by forfeit
						if (winner == 0) {
							if (warGame.this.WarPlayerA.size() > warGame.this.WarPlayerB
									.size()) {

								// increase number of battles won by A
								warGame.this.battleA += 1;
								msg = "WarPlayer B forfeits this battle.";
								warGame.this.messagebox.setText(msg);
								warGame.this.WarPlayerB.removeAllElements();

							} else if (warGame.this.WarPlayerB.size() > warGame.this.WarPlayerA
									.size()) {

								// increase number of battles won by B
								warGame.this.battleB += 1;
								msg = "WarPlayer A forfeits this battle.";
								warGame.this.messagebox.setText(msg);
								warGame.this.WarPlayerA.removeAllElements();

							}
						} else if (winner == 1) {

							// increase number of battles won by A
							warGame.this.battleA += 1;

							// this will keep the current message, useful in
							// cases
							// of war
							msg = warGame.this.messagebox.getText();
							msg += "WarPlayer A wins battle #" + warGame.this.battle;
							warGame.this.messagebox.setText(msg);
						} else if (winner == 2) {

							// increase number of battles won by B
							warGame.this.battleB += 1;

							// this will keep the current message, useful in
							// cases
							// of war
							msg = warGame.this.messagebox.getText();
							msg += "WarPlayer B wins battle #" + warGame.this.battle;
							warGame.this.messagebox.setText(msg);
						}

						// update box showing number of cards remaining for A
						warGame.this.ACardsRemaining.setText(Integer
								.toString(warGame.this.WarPlayerA.size()));

						// if the number of cards is 5 or less, change the color
						// to red
						if (warGame.this.WarPlayerA.size() <= 5) {
							warGame.this.ACardsRemaining.setForeground(Color.red);
						} else
							warGame.this.ACardsRemaining
							.setForeground(Color.black);

						// update box showing number of cards remaining for B
						warGame.this.BCardsRemaining.setText(Integer
								.toString(warGame.this.WarPlayerB.size()));

						// if the number of cards is 5 or less, change the color
						// to red
						if (warGame.this.WarPlayerB.size() <= 5) {
							warGame.this.BCardsRemaining.setForeground(Color.red);
						} else
							warGame.this.BCardsRemaining
							.setForeground(Color.black);

					}
				}
			});
		}
		return this.Play;
	}

	/**
	 * This method initializes Quit
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getQuit() {
		if (this.Quit == null) {
			this.Quit = new JButton();
                        //shortcut keys to quit the game
                        this.Quit.setMnemonic('Q');
			this.Quit.setBounds(new Rectangle(580, 410, 102, 102));
                        this.Quit.setIcon(backgroundImage4);
			this.Quit.setToolTipText("Return to Main Menu");
			this.Quit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// Returns to the main menu
                                    
                      DisplayLabel frame= new DisplayLabel();
                      // Display the frame
                     frame.setSize(500,300);
                    frame.setBackground(Color.WHITE);
                    frame.setForeground(Color.BLUE);
                        dispose();
                 // Center the frame
                   frame.setVisible(true);
                       }
			});
		}
		return this.Quit;
	}

	// initializes the main frame
	private void initialize() {
		//this.setSize(810, 520);
                this.setContentPane(getJContentPane());
		this.add(getControlPanel());
		this.setTitle("WAR");

	}

	// shuffle  the deck -- this swaps random index numbers with each card
	// and performs this 5 times.
	private void shuffleCards() {
		int tempNum = 0;
		String tempStr = "";
		for (int shuffleCards = 0; shuffleCards < 5; shuffleCards++) {
			for (int x = 0; x < 52; x++) {
				tempNum = (int) Math.floor(Math.random() * 52);
				tempStr = this.cardDeck[tempNum];
				this.cardDeck[tempNum] = this.cardDeck[x];
				this.cardDeck[x] = tempStr;
			}
		}
	}

	private int war() {

		// variables to determine winner, round of war, cards played, and value
		// of them
		int win = 0;
		int pos = 0;
		int round = 1;
		Character ch1 = ' ';
		Character ch2 = ' ';
		String played1 = "";
		String played2 = "";
		int firstvalue = 0;
		int secondvalue = 0;

		// this vector holds the cards in case of war
		Vector<String> table = new Vector<String>();

		do {
			if ((pos < this.WarPlayerA.size()) && (pos < this.WarPlayerB.size())) {

				// this returns the card at the proper position
				played1 = this.WarPlayerA.elementAt(pos);
				played2 = this.WarPlayerB.elementAt(pos);

				if (pos == 0) {
					// this displays the card on the players deck
					this.WarPlayerACard.setIcon(getImage(played1));
					this.WarPlayerBCard.setIcon(getImage(played2));
				} else {
					// this displays a background
					// and the next playable card on the table in case of WAR
					this.AWarSlot1.setIcon(this.backgroundImage);
					this.AWarSlot2.setIcon(getImage(played1));
					this.BWarSlot1.setIcon(this.backgroundImage);
					this.BWarSlot2.setIcon(getImage(played2));
				}

				// returns the first character of the card to determine the
				// value
				ch1 = played1.charAt(0);
				switch (ch1) {
				case 't':
					firstvalue = 10;
					break;
				case 'j':
					firstvalue = 11;
					break;
				case 'q':
					firstvalue = 12;
					break;
				case 'k':
					firstvalue = 13;
					break;
				case 'a':
					firstvalue = 14;
					break;
				default:
					firstvalue = Integer.parseInt(ch1.toString());
				}

				// returns the first character of the card to determine the
				// value
				ch2 = played2.charAt(0);
				switch (ch2) {
				case 't':
					secondvalue = 10;
					break;
				case 'j':
					secondvalue = 11;
					break;
				case 'q':
					secondvalue = 12;
					break;
				case 'k':
					secondvalue = 13;
					break;
				case 'a':
					secondvalue = 14;
					break;
				default:
					secondvalue = Integer.parseInt(ch2.toString());

				}

				// if firstvalue is larger than secondvalue, playerA wins
				if (firstvalue > secondvalue) {
					win = 1;
					for (int i = 0; i <= pos; i++) {

						// add the cards to the table vector and remove them
						// from the players hand
						table.addElement(this.WarPlayerA.elementAt(0));
						table.addElement(this.WarPlayerB.elementAt(0));
						this.WarPlayerA.removeElementAt(0);
						this.WarPlayerB.removeElementAt(0);
					}
					// add the cards in the table vector to WarPlayerA's hand
					for (int i = 0; i < table.size(); i++) {
						this.WarPlayerA.addElement(table.elementAt(i));
					}
                                     this.jContentPane.setBackground(Color.magenta);
                                   				} else if (secondvalue > firstvalue) {
					// if secondvalue is larger than firstvalue, playerB wins
					win = 2;
					for (int i = 0; i <= pos; i++) {
						// add the cards to the table vector and remove them
						// from the players hand
						table.addElement(this.WarPlayerB.elementAt(0));
						table.addElement(this.WarPlayerA.elementAt(0));
						this.WarPlayerB.removeElementAt(0);
						this.WarPlayerA.removeElementAt(0);
					}
					// add the cards in the table vector to WarPlayerA's hand
					for (int i = 0; i < table.size(); i++) {
						this.WarPlayerB.addElement(table.elementAt(i));
					}
                                          // Added a new color grey to show player B won
                                   this.jContentPane.setBackground(Color.BLUE);
   				} else if (firstvalue == secondvalue) {
                               
                               		// in cases of a draw (WAR) print the message
                                        // and increase position by 2 since one card is buried.
                                         playAudio2();
					  this.messagebox.setText("I DO DECLARE " + round
							+ " ROUND(S) OF WAR! \n");
                                                                                 round += 1;
                                     
					pos += 2;
                                                                          
                                        
					win = 0;
                                      			}
			} else
				// this will break if a winner is not declared in case one
				// player
				// does not have enough cards to finish a hand
				break;
		} while (win == 0);
		return win;

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

  private void playAudio2() {
    try{
      File soundFile =
                   new File(draw.getText());
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
      //stopBtn.setEnabled(false);
      //playBtn.setEnabled(true);
      stopPlayback = false;
    }catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }//end catch
  }//end run
}//end inner class PlayThread
//===================================//
}