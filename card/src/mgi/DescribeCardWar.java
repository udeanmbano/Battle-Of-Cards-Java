/*******************************************************************************
 * ** Date: May 8, 2014 
 * ** Name: Udean Mbano    MGI2012-3244
 * ** Name: Siphiwe Matore MGI2011-1572
 * ** Name: Christelle Kanyembo Kasongo MGI2012-0814
 * ** Purpose: Gives the description in the describe war panel for the about game page
 * Version:14.2
 ******************************************************************************/
package mgi;
import javax.swing.*;

import java.awt.*;

 public class DescribeCardWar extends JPanel {
 /** Label for displaying an image icon and a title */
 private JLabel jlblImageTitle = new JLabel();

 /** Text area for displaying text */
 private JTextArea jtaDescription = new JTextArea();

 public DescribeCardWar() {
 // Center the icon and text and place the text under the icon
 jlblImageTitle.setHorizontalAlignment(JLabel.CENTER); 
 jlblImageTitle.setHorizontalTextPosition(JLabel.CENTER);
 jlblImageTitle.setVerticalTextPosition(JLabel.BOTTOM);
 // Set the font in the label and the text field
 jlblImageTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
 jtaDescription.setFont(new Font("Serif", Font.PLAIN, 14));
jtaDescription.setEditable(false);
 // Set lineWrap and wrapStyleWord true for the text area




 // Create a scroll pane to hold the text area
 JScrollPane scrollPane = new JScrollPane(jtaDescription);

 // Set BorderLayout for the panel, add label and scroll pane
 setLayout(new BorderLayout(15,10));
 add(scrollPane, BorderLayout.CENTER);
add(jlblImageTitle, BorderLayout.WEST);
 }

 /** Set the title */
 public void setTitle(String title) {
 jlblImageTitle.setText(title);
 }

 /** Set the image icon */
 public void setImageIcon(ImageIcon icon) {
 jlblImageTitle.setIcon(icon);
 }

 /** Set the text description */
 public void setDescription(String text) {
 jtaDescription.setText(text);
 }
 }
