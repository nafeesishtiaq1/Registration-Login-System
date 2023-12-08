package loginsystem;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
  
  MyFrame(){
    this.add(new MyPanel());
    this.setTitle("Registration and Login");
    this.setSize(500,600);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
}
