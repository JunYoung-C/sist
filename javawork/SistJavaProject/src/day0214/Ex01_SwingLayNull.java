package day0214;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex01_SwingLayNull extends JFrame {

  JButton btn1, btn2;

  public Ex01_SwingLayNull(String title) {
    super(title);
    this.setBounds(200, 100, 400, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(255, 217, 236));

    initDesign();
    this.setVisible(true);
  }

  public void initDesign() {
    // 레이아웃 직접 배치할 경우
    this.setLayout(null);

    btn1 = new JButton("◁");
    btn2 = new JButton("▷");

    // 프레임에 버튼 추가
    this.add(btn1);
    this.add(btn2);

    // 버튼의 위치 및 크기 직접 지정
    btn1.setBounds(80, 100, 80, 30);
    btn2.setBounds(200, 100, 80, 30);

    btn1.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(getContentPane(), "왼쪽으로 이동");
      }
    });

    btn2.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(rootPane, "오른쪽으로 이동");
      }
    });
  }

  public static void main(String[] args) {
    new Ex01_SwingLayNull("맘대로 레이아웃 연습");
  }
}
