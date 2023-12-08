package loginsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel{

  static final int SCREEN_WIDTH = 500;
  static final int SCREEN_HEIGHT = 600;

  JTextField textField1;
  JTextField textField2;

  MyPanel(){

    this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
    this.setBackground(new Color(0,0,51));
    this.setFocusable(true);
    
    this.setLayout(null);
    textField1 = new JTextField(20);
    textField1.setBounds(10, 10, 100, 30);
    this.add(textField1);

    textField2 = new JTextField(20);
    textField2.setBounds(10, 100, 100, 30);
    this.add(textField2);

  }


}
