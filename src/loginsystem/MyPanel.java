package loginsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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

    register_button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        registerButtonAction();
      }
    });

  }

  public void registerButtonAction(){

    String username = textField1.getText();
    String password = textField2.getText();
    
  if(checkUsername(username)){

    try(BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))){
      writer.write("username: " + username + "\n");
      writer.write("password: " + password + "\n\n");
      JOptionPane.showMessageDialog(null,"Successfully Registered");
      new LoginFrame();
    }
    catch(IOException ex){
      System.out.println("Something went wrong. " + ex.getMessage());
      JOptionPane.showMessageDialog(null,"Sorry. Something went wrong.");
    }
  }
  else{
    JOptionPane.showMessageDialog(null, "Username already exists. Please enter different username.");
  }
 }

  public boolean checkUsername(String newUsername){

    try(BufferedReader reader = new BufferedReader(new FileReader(("users.txt")))){

      String line;

      while((line = reader.readLine()) != null){
        if(line.startsWith("username: ")){

          String existingUsername = line.substring("username: ".length());
          
          if(existingUsername.equals(newUsername)){
            return false;
          }
        }
      }
    }
    catch(IOException ex){
      System.out.println("Error reading file: " + ex.getMessage());
    }
    return true;
  }
}
