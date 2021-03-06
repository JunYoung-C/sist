package day0211;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex07_SwingLay extends JFrame {
  Container cp;
  JButton btn1;

  public Ex07_SwingLay(String title) {
    super(title);

    cp = this.getContentPane();
    this.setBounds(200, 100, 400, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 200, 155));
    this.setVisible(true);
    
    // 버튼 생성
    btn1 = new JButton("버튼1");
    // 프레임에 버튼 추가
    // 프레임은 기존 레이아웃이 BorderLayout
    // 이 경우에는 추가할 때 위치를 지정해야한다.
    this.add("North", btn1); // 첫글자 대문자로
    
    // 생성과 동시에 프레임에 추가
    this.add("South", new JButton("아래쪽"));
//    this.add("West", new JButton("왼쪽"));
//    this.add("East", new JButton("오른쪽"));
    this.add("Center", new JButton("가운데"));
    
    this.add(new JButton("왼쪽"), BorderLayout.WEST);
    this.add(new JButton("오른쪽"), BorderLayout.EAST);
    
    btn1.setBackground(Color.yellow);
    btn1.setForeground(Color.red);
  }

  public static void main(String[] args) {
    new Ex07_SwingLay("보더 레이아웃 연습");
  }
}
