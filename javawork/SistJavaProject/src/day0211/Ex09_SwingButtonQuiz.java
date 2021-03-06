package day0211;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex09_SwingButtonQuiz extends JFrame implements ActionListener {
  Container cp;
  JButton btn1, btn2;

  public Ex09_SwingButtonQuiz(String title) {
    super(title);

    cp = this.getContentPane();
    this.setBounds(200, 100, 400, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 200, 155));

    initDesign();

    this.setVisible(true);
  }

  public void initDesign() {
    this.setLayout(new FlowLayout());
    btn1 = new JButton("◀");
    btn2 = new JButton("▶");

    this.add(btn1);
    this.add(btn2);
    
    btn1.addActionListener(this);
    btn2.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object ob = e.getSource();
    
    if (ob == btn1) {
      JOptionPane.showMessageDialog(this, "뒤로 가고 있습니다.");
    } else if (ob == btn2) {
      JOptionPane.showMessageDialog(this, "앞으로 가고 있습니다.");
    }
  }

  public static void main(String[] args) {
    new Ex09_SwingButtonQuiz("퀴즈");
  }
}
