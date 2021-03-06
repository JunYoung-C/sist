package day0214;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex05_SwingArray extends JFrame implements ActionListener{
  JButton[] btn = new JButton[6];
  String[] btnLabel = {"Red", "Cyan", "Magenta", "Yellow", "Gray", "Blue"};
  Color[] btnColor = {Color.red, Color.cyan, Color.magenta, Color.yellow, Color.gray, Color.blue};

  public Ex05_SwingArray(String title) {
    super(title);

    this.setBounds(200, 100, 400, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(255, 200, 155));

    initDesign();

    this.setVisible(true);
  }

  public void initDesign() {
    // 패널 생성. default는 flow 레이아웃
    JPanel panel = new JPanel(new GridLayout(6, 1));
    panel.setBackground(Color.orange);
//    this.add(panel, BorderLayout.NORTH);
    this.add(panel, BorderLayout.WEST);
   

    for (int i = 0; i < btn.length; i++) {
      btn[i] = new JButton(btnLabel[i]);
      btn[i].setBackground(btnColor[i]);
      panel.add(btn[i]);
      btn[i].addActionListener(this);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    Object ob = e.getSource();
    
    for (int i = 0; i < btn.length; i++) {
      if (ob == btn[i]) {
        getContentPane().setBackground(btnColor[i]);
        this.setTitle("Color: " + btnLabel[i]);
      }
    }
  }

  public static void main(String[] args) {
    new Ex05_SwingArray("스윙 배열 연습 5");
  }

}
