package day0214;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex03_SwingEvent extends JFrame implements ActionListener {
  JButton btn1, btn2, btn3, btn4;

  static final String ICON1 = "C:\\sist\\image\\swingimage\\img1.gif";
  static final String ICON2 = "C:\\sist\\image\\swingimage\\an08.gif";
  static final String ICON3 = "C:\\sist\\image\\swingimage\\ahiru_a001.gif";


  public Ex03_SwingEvent(String title) {
    super(title);

    this.setBounds(200, 100, 400, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(255, 217, 236));

    initDesign();
    this.setVisible(true);
  }

  public void initDesign() {
    this.setLayout(null);// 레이아웃 없애기
    btn1 = new JButton("Hello");
    btn1.setBounds(20, 30, 80, 30); // x, y, w, h
    this.add(btn1);

    btn2 = new JButton("버튼2", new ImageIcon(ICON1));
    btn2.setBounds(20, 70, 100, 50);
    this.add(btn2);

    btn3 = new JButton(new ImageIcon(ICON2));
    btn3.setBounds(150, 100, 150, 150);
    btn3.setPressedIcon(new ImageIcon(ICON3));
    this.add(btn3);
    
    btn1.addActionListener(this);
    btn2.addActionListener(this);
    btn3.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton ob = (JButton) e.getSource();
    if (ob == btn1) {
      JOptionPane.showMessageDialog(this, "버튼1 Hello를 클릭합니다.");
    } else if (ob == btn1) {
      JOptionPane.showMessageDialog(this, "버튼2 말 아이콘 클립합니다.");
    } else {
      JOptionPane.showMessageDialog(this, "버튼3 아이콘 클릭시 병아리가 됩니다.");
    } 
  }

  public static void main(String[] args) {
    new Ex03_SwingEvent("이렇게");
  }

}
