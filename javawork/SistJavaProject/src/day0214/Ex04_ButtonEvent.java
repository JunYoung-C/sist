package day0214;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// 프레임 -> 패널 -> 버튼 등
public class Ex04_ButtonEvent extends JFrame {
  JButton btn1, btn2;

  public Ex04_ButtonEvent(String title) {
    super(title);

    this.setBounds(200, 100, 400, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(255, 200, 155));

    initDesign();

    this.setVisible(true);
  }

  public void initDesign() {
    this.setLayout(new FlowLayout());

    btn1 = new JButton("버튼 1");
    btn1.setBounds(80, 100, 80, 30);
    this.add(btn1);


    btn2 = new JButton("버튼 2");
    btn2.setBounds(200, 100, 80, 30);
    this.add(btn2);

    btn1.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        getContentPane().setBackground(Color.green);
      }
    });

    btn2.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        getContentPane().setBackground(Color.yellow);
      }
    });
  }

  public static void main(String[] args) {
    new Ex04_ButtonEvent("버튼이벤트 4");
  }
}
