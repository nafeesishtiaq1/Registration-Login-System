package loginsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{

  static final int SCREEN_WIDTH = 500;
  static final int SCREEN_HEIGHT = 600;

  JTextField textField1;
  JTextField textField2;
  JButton login_button;

  LoginPanel(){

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

    login_button = new JButton();
    login_button.setBounds(150,400,200,30);
    login_button.setText("Login");
		login_button.setFocusable(false);
    login_button.setBackground(new Color(51,255,51));
    this.add(login_button);

    login_button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        loginButtonAction();
      }
    });
 }
    public void loginButtonAction(){
      String enteredUsername = textField1.getText();
      String enteredPassword = textField2.getText();

      if(checkCredentials(enteredUsername, enteredPassword)){
        JOptionPane.showMessageDialog(null, "Login Successful");
      }
      else{
        JOptionPane.showMessageDialog(null, "Wrong username or password");
      }



    }

    public boolean checkCredentials(String enteredUsername, String enteredPassword){
      try(BufferedReader reader = new BufferedReader(new FileReader("users.txt"))){
        String line;

        while((line = reader.readLine()) != null){
          if(line.startsWith("username: ")){
            String existingUsername = line.substring("username: ".length());

            line = reader.readLine();

            if(line.startsWith("password: ")){
              String existingPassword = line.substring("password: ".length());

              if(existingUsername.equals(enteredUsername) && existingPassword.equals(enteredPassword)){
                return true;
              }
            }
          }
        }
      }
    catch(IOException ex){
      System.out.println("Something went wrong. " + ex.getMessage());

    }
    return false;
    }
}
