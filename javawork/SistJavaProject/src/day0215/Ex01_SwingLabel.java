package day0215;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex01_SwingLabel extends JFrame implements ActionListener {
  JLabel[] labels = new JLabel[9];
  String[] str = {"그리스", "이탈리아", "터키", "오스트리아", "체코", "일본", "영국", "캐나다", "미국"};
  JButton btnOk;
  Container cp = this.getContentPane();

  public Ex01_SwingLabel(String title) {
    super(title);
    this.setBounds(100, 100, 600, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 255, 155));

    setDesign();

    this.setVisible(true);
  }

  public void setDesign() {
    // 프레임에 패널
    Panel pCenter = new Panel(new GridLayout(3, 3));
    this.add(pCenter, BorderLayout.CENTER);

    for (int i = 0; i < labels.length; i++) {
      labels[i] = new JLabel(str[i], JLabel.CENTER);
      labels[i].setOpaque(true);
      changeLabelColor(labels[i]);
      
      labels[i].setFont(new Font("궁서체", Font.BOLD, 15));
      pCenter.add(labels[i]);
    }

    btnOk = new JButton("라벨 색상 변경");

//    labels[7].add(btnOk);
    this.add(btnOk, BorderLayout.SOUTH);
    btnOk.setBounds(24, 120, 150, 50);
    btnOk.addActionListener(this);
  }

  void changeLabelColor(JLabel label) {
    int r = (int) (Math.random() * 256);
    int g = (int) (Math.random() * 256);
    int b = (int) (Math.random() * 256);
    label.setBackground(new Color(r, g, b));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < labels.length; i++) {
      changeLabelColor(labels[i]);
    }
  }

  public static void main(String[] args) {
    new Ex01_SwingLabel("2/14일 숙제");
  }


}
