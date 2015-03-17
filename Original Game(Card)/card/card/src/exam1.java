/*******************************************************************************
 * ** Date: Mar. 7, 2007 
 * ** Name: Felicia Hendrickson 
 * ** Purpose: a Java program that plays the card game of war between 
 * two computer players
 ******************************************************************************/

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class exam1 extends JFrame {
 
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
                            
				exam1 thisClass = new exam1();
                          	thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	private String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "t", "j",
			"q", "k", "a" };
	private String[] suit = { "s", "h", "d", "c" };
	private String[] Deck = new String[52];

	// set the background Image for the deck.
	private ImageIcon backgroundImage = new ImageIcon("cards/felicia_baghdad.gif");

	// these vectors hold the players hands
	private Vector<String> PlayerA = new Vector<String>();
	private Vector<String> PlayerB = new Vector<String>();

	// these variables keep track of the number of battles
	private int battle = 0;
	private int battleA = 0, battleB = 0;

	// GUI panels and components
	private JPanel jContentPane = null;
	private JLabel PlayerACard = null;
	private JLabel PlayerBCard = null;
	private JPanel ControlPanel = null;
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
	private JButton NewGame = null;

	/**
	 * This is the default constructor
	 */
	public exam1() {
		
            super();	
            initialize();
	}

	// this method deals each player 26 cards
	private void dealDeck() {
		int i = 0;
		do {
			this.PlayerA.addElement(this.Deck[i]);
			this.PlayerB.addElement(this.Deck[i + 1]);
			i += 2;
		} while (i < this.Deck.length);

		// this puts the number of cards in the box underneath the players hand
		this.ACardsRemaining.setText(Integer.toString(this.PlayerA.size()));
		this.BCardsRemaining.setText(Integer.toString(this.PlayerB.size()));
	}

	// this method takes the suit and rank, then combines them into a full deck
	private void getCards() {
		int index = 0;
		for (int i = 0; i < this.suit.length; i++) {
			for (int j = 0; j < this.rank.length; j++) {
				this.Deck[index] = this.rank[j] + this.suit[i];
				index++;
			}
		}

	}

	// the panel for the game
	private JPanel getControlPanel() {
		if (this.ControlPanel == null) {
			this.ControlPanel = new JPanel();
			this.ControlPanel.setBorder(this.raisedetched);
			this.ControlPanel.setLayout(new GridBagLayout());
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
			this.jLabelA.setBounds(new Rectangle(40, 75, 100, 30));
			this.jLabelA.setText("Player A's Hand");
			this.messagebox = new JTextArea();
			this.messagebox.setBounds(new Rectangle(50, 300, 375, 100));
			this.messagebox.setText("");
			messagebox.setBackground(new Color(51, 204, 51));
			this.messagebox.setEditable(false);
			this.PlayerACard = new JLabel();
			this.PlayerACard.setText("PlayerA");
			this.PlayerACard.setBounds(new Rectangle(50, 100, 73, 97));
			this.PlayerACard.setIcon(this.backgroundImage);
			this.PlayerACard.setBorder(this.raisedbevel);
			this.AWarSlot1 = new JLabel();
			this.AWarSlot1.setBounds(new Rectangle(200, 50, 73, 97));
			this.AWarSlot1.setText("");
			this.AWarSlot1.setBackground(Color.black);
			this.AWarSlot1.setBorder(this.loweredbevel);
			this.AWarSlot2 = new JLabel();
			this.AWarSlot2.setBounds(new Rectangle(350, 50, 73, 97));
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
			this.lblRemainA.setBounds(new Rectangle(40, 220, 100, 25));
			this.lblRemainA.setText("Cards Remaining");
			this.jLabelB = new JLabel();
			this.jLabelB.setBounds(new Rectangle(490, 75, 100, 30));
			this.jLabelB.setText("Player B's Hand");
			this.PlayerBCard = new JLabel();
			this.PlayerBCard.setText("PlayerB");
			this.PlayerBCard.setBounds(new Rectangle(500, 99, 73, 97));
			this.PlayerBCard.setIcon(this.backgroundImage);
			this.PlayerBCard.setBorder(this.raisedbevel);
			this.BWarSlot1 = new JLabel();
			this.BWarSlot1.setBounds(new Rectangle(200, 150, 73, 97));
			this.BWarSlot1.setText("");
			this.BWarSlot1.setBackground(Color.black);
			this.BWarSlot1.setBorder(this.loweredbevel);
			this.BWarSlot2 = new JLabel();
			this.BWarSlot2.setBounds(new Rectangle(350, 150, 73, 97));
			this.BWarSlot2.setText("");
			this.BWarSlot2.setBackground(Color.black);
			this.BWarSlot2.setBorder(this.loweredbevel);
			this.lblRemainB = new JLabel();
			this.lblRemainB.setBounds(new Rectangle(490, 220, 100, 25));
			this.lblRemainB.setText("Cards Remaining");
			this.BCardsRemaining = new JLabel();
			this.BCardsRemaining.setBounds(new Rectangle(510, 200, 50, 20));
			this.BCardsRemaining.setText("0");
			this.BCardsRemaining.setHorizontalAlignment(SwingConstants.CENTER);
			this.BCardsRemaining.setBorder(this.blackline);
			this.BCardsRemaining.setForeground(Color.black);
			this.jContentPane = new JPanel();
			this.jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(51, 204, 51));
			this.jContentPane.add(this.PlayerACard);
			this.jContentPane.add(this.PlayerBCard);
			this.jContentPane.add(getControlPanel());
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
			this.jContentPane.add(getNewGame(), null);
		}
		return this.jContentPane;
	}

	/**
	 * This method initializes NewGame
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getNewGame() {
            		if (this.NewGame == null) {
			this.NewGame = new JButton();
			this.NewGame.setBounds(new Rectangle(450, 300, 170, 25));
                        this.NewGame.grabFocus();
			this.NewGame.setText("New Game");
			this.NewGame.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					// initializes variables and players hands for a new game
					exam1.this.PlayerA.removeAllElements();
					exam1.this.PlayerB.removeAllElements();
					exam1.this.battle = 0;
					exam1.this.battleA = 0;
					exam1.this.battleB = 0;
					exam1.this.ACardsRemaining.setForeground(Color.black);
					exam1.this.BCardsRemaining.setForeground(Color.black);
					String msg = "";
					exam1.this.messagebox.setText(msg);
					exam1.this.PlayerACard.setIcon(exam1.this.backgroundImage);
					exam1.this.AWarSlot1.setIcon(null);
					exam1.this.AWarSlot2.setIcon(null);
					exam1.this.PlayerBCard.setIcon(exam1.this.backgroundImage);
					exam1.this.BWarSlot1.setIcon(null);
					exam1.this.BWarSlot2.setIcon(null);

					// get the cards into a new deck
					getCards();
					// shuffle the deck
					shuffle();
					// deal the deck to each player
					dealDeck();
				}
			});
		}
		return this.NewGame;
	}

	/**
	 * This method initializes Play
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getPlay() {
		if (this.Play == null) {
			this.Play = new JButton();
			this.Play.setBounds(new Rectangle(450, 350, 70, 25));
			this.Play.setText("Play");
			this.Play.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					// initialize each battles variables to 0 or null
					int winner = 0;
					String msg = "";
					exam1.this.messagebox.setText(msg);
					exam1.this.AWarSlot1.setIcon(null);
					exam1.this.AWarSlot2.setIcon(null);
					exam1.this.BWarSlot1.setIcon(null);
					exam1.this.BWarSlot2.setIcon(null);

					// if both players hands are empty, we must start a new game
					if ((exam1.this.PlayerA.size() == 0)
							&& (exam1.this.PlayerB.size() == 0)) {
						exam1.this.messagebox
						.setText("You must start a new game first!");
					} else if ((exam1.this.PlayerA.size() == 0)
							|| (exam1.this.PlayerB.size() == 0)) {

						// if one players cards are zero, this game is over
						// print statistics
						msg += "\nThis war had " + exam1.this.battle
						+ " battles.\nPlayer A won "
						+ exam1.this.battleA
						+ " battles.\nPlayer B won "
						+ exam1.this.battleB + " battles";

						// keep the text but show the winner of the game
						exam1.this.messagebox.setText(msg);
						if (exam1.this.PlayerA.size() == 0) {
							msg += "\nPlayer B wins the war!";
							exam1.this.messagebox.setText(msg);
						} else if (exam1.this.PlayerB.size() == 0) {
							msg += "\nPlayer A wins the war!";
							exam1.this.messagebox.setText(msg);
						}

						// remove both players hands after the game is over
						exam1.this.PlayerA.removeAllElements();
						exam1.this.PlayerB.removeAllElements();
					}

					// if both players still have cards, play a battle
					if ((exam1.this.PlayerA.size() != 0)
							&& (exam1.this.PlayerB.size() != 0)) {

						// the war method is the battle itself and returns the
						// winner
						// PlayerA is winner 1, PlayerB is winner 2
						// the winner will only be 0 if one player runs out of
						// cards
						// during a war
						winner = war();
						exam1.this.battle += 1;

						// if one player runs out of cards, the player with the
						// most
						// cards wins by forfeit
						if (winner == 0) {
							if (exam1.this.PlayerA.size() > exam1.this.PlayerB
									.size()) {

								// increase number of battles won by A
								exam1.this.battleA += 1;
								msg = "Player B forfeits this battle.";
								exam1.this.messagebox.setText(msg);
								exam1.this.PlayerB.removeAllElements();

							} else if (exam1.this.PlayerB.size() > exam1.this.PlayerA
									.size()) {

								// increase number of battles won by B
								exam1.this.battleB += 1;
								msg = "Player A forfeits this battle.";
								exam1.this.messagebox.setText(msg);
								exam1.this.PlayerA.removeAllElements();

							}
						} else if (winner == 1) {

							// increase number of battles won by A
							exam1.this.battleA += 1;

							// this will keep the current message, useful in
							// cases
							// of war
							msg = exam1.this.messagebox.getText();
							msg += "Player A wins battle #" + exam1.this.battle;
							exam1.this.messagebox.setText(msg);
						} else if (winner == 2) {

							// increase number of battles won by B
							exam1.this.battleB += 1;

							// this will keep the current message, useful in
							// cases
							// of war
							msg = exam1.this.messagebox.getText();
							msg += "Player B wins battle #" + exam1.this.battle;
							exam1.this.messagebox.setText(msg);
						}

						// update box showing number of cards remaining for A
						exam1.this.ACardsRemaining.setText(Integer
								.toString(exam1.this.PlayerA.size()));

						// if the number of cards is 5 or less, change the color
						// to red
						if (exam1.this.PlayerA.size() <= 5) {
							exam1.this.ACardsRemaining.setForeground(Color.red);
						} else
							exam1.this.ACardsRemaining
							.setForeground(Color.black);

						// update box showing number of cards remaining for B
						exam1.this.BCardsRemaining.setText(Integer
								.toString(exam1.this.PlayerB.size()));

						// if the number of cards is 5 or less, change the color
						// to red
						if (exam1.this.PlayerB.size() <= 5) {
							exam1.this.BCardsRemaining.setForeground(Color.red);
						} else
							exam1.this.BCardsRemaining
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
			this.Quit.setBounds(new Rectangle(550, 350, 70, 25));
			this.Quit.setText("Quit");
			this.Quit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// closes the program
					System.gc();
					System.exit(0);
				}
			});
		}
		return this.Quit;
	}

	// initializes the main frame
	private void initialize() {
		this.setSize(650, 450);
		this.setContentPane(getJContentPane());
		this.add(getControlPanel());
		this.setTitle("WAR");

	}

	// shuffles the deck -- this swaps random index numbers with each card
	// and performs this 5 times.
	private void shuffle() {
		int tempNum = 0;
		String tempStr = "";
		for (int shuffle = 0; shuffle < 5; shuffle++) {
			for (int x = 0; x < 52; x++) {
				tempNum = (int) Math.floor(Math.random() * 52);
				tempStr = this.Deck[tempNum];
				this.Deck[tempNum] = this.Deck[x];
				this.Deck[x] = tempStr;
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
		int val1 = 0;
		int val2 = 0;

		// this vector holds the cards in case of war
		Vector<String> table = new Vector<String>();

		do {
			if ((pos < this.PlayerA.size()) && (pos < this.PlayerB.size())) {

				// this returns the card at the proper position
				played1 = this.PlayerA.elementAt(pos);
				played2 = this.PlayerB.elementAt(pos);

				if (pos == 0) {
					// this displays the card on the players deck
					this.PlayerACard.setIcon(getImage(played1));
					this.PlayerBCard.setIcon(getImage(played2));
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
					val1 = 10;
					break;
				case 'j':
					val1 = 11;
					break;
				case 'q':
					val1 = 12;
					break;
				case 'k':
					val1 = 13;
					break;
				case 'a':
					val1 = 14;
					break;
				default:
					val1 = Integer.parseInt(ch1.toString());
				}

				// returns the first character of the card to determine the
				// value
				ch2 = played2.charAt(0);
				switch (ch2) {
				case 't':
					val2 = 10;
					break;
				case 'j':
					val2 = 11;
					break;
				case 'q':
					val2 = 12;
					break;
				case 'k':
					val2 = 13;
					break;
				case 'a':
					val2 = 14;
					break;
				default:
					val2 = Integer.parseInt(ch2.toString());

				}

				// if val1 is larger than val2, playerA wins
				if (val1 > val2) {
					win = 1;
					for (int i = 0; i <= pos; i++) {

						// add the cards to the table vector and remove them
						// from the players hand
						table.addElement(this.PlayerA.elementAt(0));
						table.addElement(this.PlayerB.elementAt(0));
						this.PlayerA.removeElementAt(0);
						this.PlayerB.removeElementAt(0);
					}
					// add the cards in the table vector to PlayerA's hand
					for (int i = 0; i < table.size(); i++) {
						this.PlayerA.addElement(table.elementAt(i));
					}

				} else if (val2 > val1) {
					// if val2 is larger than val1, playerB wins
					win = 2;
					for (int i = 0; i <= pos; i++) {
						// add the cards to the table vector and remove them
						// from the players hand
						table.addElement(this.PlayerB.elementAt(0));
						table.addElement(this.PlayerA.elementAt(0));
						this.PlayerB.removeElementAt(0);
						this.PlayerA.removeElementAt(0);
					}
					// add the cards in the table vector to PlayerA's hand
					for (int i = 0; i < table.size(); i++) {
						this.PlayerB.addElement(table.elementAt(i));
					}

				} else if (val1 == val2) {

					// in cases of a draw (WAR) print the message
					// and increase position by 2 since one card is buried.
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
/**
 * This enum encapsulates all the sound effects of a game, so as to separate the sound playing
 * codes from the game codes.
 * 1. Define all your sound effect names and the associated wave file.
 * 2. To play a specific sound, simply invoke SoundEffect.SOUND_NAME.play().
 * 3. You might optionally invoke the static method SoundEffect.init() to pre-load all the
 *    sound files, so that the play is not paused while loading the file for the first time.
 * 4. You can use the static variable SoundEffect.volume to mute the sound.
 */
public enum SoundEffect {
   EXPLODE("Creedence Clearwater Revival - Fortunate Son - Live 1969.wav"),   // explosion
   GONG("Creedence Clearwater Revival - Fortunate Son - Live 1969.wav"),        // gong
   SHOOT("Creedence Clearwater Revival - Fortunate Son - Live 1969.wav");       // bullet
   
   // Nested class for specifying volume
   public static enum Volume {
      MUTE, LOW, MEDIUM, HIGH
   }
   
   public static Volume volume = Volume.LOW;
   
   // Each sound effect has its own clip, loaded with its own sound file.
   private Clip clip;
   
   // Constructor to construct each element of the enum with its own sound file.
   SoundEffect(String soundFileName) {
      try {
         // Use URL (instead of File) to read from disk and JAR.
         URL url = this.getClass().getClassLoader().getResource(soundFileName);
         // Set up an audio input stream piped from the sound file.
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
         // Get a clip resource.
         clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioInputStream);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   
   // Play or Re-play the sound effect from the beginning, by rewinding.
   public void play() {
      if (volume != Volume.MUTE) {
         if (clip.isRunning())
            clip.stop();   // Stop the player if it is still running
         clip.setFramePosition(0); // rewind to the beginning
         clip.start();     // Start playing
      }
   }
   
   // Optional static method to pre-load all the sound files.
   static void init() {
      values(); // calls the constructor for all the elements
   }
}

}