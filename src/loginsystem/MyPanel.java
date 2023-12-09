package loginsystem;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel{

  static final int SCREEN_WIDTH = 500;
  static final int SCREEN_HEIGHT = 600;

  JTextField textField1;
  JTextField textField2;
  JButton register_button;

  MyPanel(){

    this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
    this.setBackground(new Color(0,0,51));
    this.setFocusable(true);
    
    this.setLayout(null);
    textField1 = new JTextField(20);
    textField1.setBounds(150, 200, 200, 40);
    this.add(textField1);

    textField2 = new JTextField(20);
    textField2.setBounds(150, 300, 200, 40);
    this.add(textField2);

    register_button = new JButton();
    register_button.setBounds(150,400,200,30);
    register_button.setText("Register");
		register_button.setFocusable(false);
    register_button.setBackground(new Color(51,255,51));
    this.add(register_button);

  }
}
