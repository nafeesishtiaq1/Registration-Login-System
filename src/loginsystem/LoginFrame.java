package loginsystem;

import javax.swing.JFrame;

public class LoginFrame extends JFrame{
  
  LoginFrame(){
    this.add(new LoginPanel());
    this.setTitle("Registration and Login");
    this.setSize(500,600);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setVisible(true);
  }
}
