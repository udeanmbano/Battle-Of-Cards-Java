/*******************************************************************************
 * ** Date: May 8, 2014 
 * ** Name: Udean Mbano    MGI2012-3244
 * ** Name: Siphiwe Matore MGI2011-1572
 * ** Name: Christelle Kanyembo Kasongo MGI2012-0814
 * ** Purpose: Displays information about the game played
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
//import the sun.audio package
import  sun.audio.*;    
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.*;
import java.util.*;
import mgi.DescribeCardWar;
import mgi.DisplayLabel; 
import javax.swing.plaf.ColorUIResource;
public class AboutCardWar extends JFrame {
 // Declare and create a description panel
private DescribeCardWar descriptionPanel = new DescribeCardWar();
private JButton exit = new JButton("exit");
 public static void main(String[] args) {
 AboutCardWar frame = new AboutCardWar();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //change to automatically fit all components on the game
         frame.setSize(1000,390);
         //change game appears at a position relative in the center
         frame.setTitle("About War Card Game");
         frame.setLocationRelativeTo(null);
         //frame is not resizable
         frame.setResizable(false);
         frame.setVisible(true);

 }

 public AboutCardWar() {
 // Set title, text, and image in the description panel
 descriptionPanel.setTitle("Card War");
 String description =  "This a Java Game Project Assignment to evaluate criteria \n"
         + "For the effectiveness and effieciency of GUI \n"
         + "War Card is game downloaded fom Planet Source forge code website for java game projects \n"
         + "This version 14.2 of Java was re-created using the exsisting code and adding features \n"
         + "Authors of the game:\n"
         + " ** Name: Udean Mbano    MGI2012-3244 \n"
         + " ** Name: Siphiwe Matore MGI2011-1572 \n"
         + " ** Name: Christelle Kanyembo Kasongo MGI2012-0814 \n"
         + " Copyright© inc 2014 MIDRAND GRADUATE INSTITUTE SOUTH AFRICA \n";
 descriptionPanel.setImageIcon(new ImageIcon("325107_533271893370218_1031028754_o.jpg"));
 descriptionPanel.setDescription(description);
exit.setBackground(Color.DARK_GRAY);
exit.setForeground(Color.WHITE);
//shortcut keys
exit.setMnemonic('Q');
 // Add the description panel to the frame
 setLayout(new BorderLayout());
 add(descriptionPanel, BorderLayout.CENTER);
 add(exit,BorderLayout.SOUTH);
 //Exits out of the about Panel to the main menu panel
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
 }