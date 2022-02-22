package day0214;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex06_ArrayNullButton extends JFrame {
  JButton[] btn = new JButton[6];
  String[] text = {"파랑", "노랑", "분홍", "회색", "자홍", "연파랑"};
  Color[] colors = {Color.blue, Color.yellow, Color.pink, Color.gray, Color.magenta, Color.cyan};
  MyButton myButton = new MyButton();

  Container cp;

  public Ex06_ArrayNullButton(String title) {
    super(title);
//    cp = this.getContentPane();
    this.setBounds(200, 100, 400, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    cp.setBackground(new Color(255, 200, 155));
    this.getContentPane().setBackground(new Color(255, 200, 155));

    initDesign();

    this.setVisible(true);
  }

  public void initDesign() {
    this.setLayout(null);
    int top = 20;
    for (int i = 0; i < btn.length; i++) {
      btn[i] = new JButton(text[i]);

      btn[i].setBounds(20, top, 90, 30);
      top += 40;
      this.add(btn[i]);

      btn[i].addActionListener(myButton);
    }
  }

  class MyButton implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      Object ob = e.getSource();

      for (int i = 0; i < btn.length; i++) {
        if (ob == btn[i]) {
          getContentPane().setBackground(colors[i]);
        }
      }
    }
  }

  public static void main(String[] args) {
    new Ex06_ArrayNullButton("레이아웃 없이 배열 버튼 연습6");
  }

}
