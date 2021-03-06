package day0214;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex02_SwingIconButton extends JFrame {

  JButton btn1, btn2, btn3, btn4;
  ImageIcon icon1 = new ImageIcon("C:\\sist\\image\\Jquary_image\\01.png");
  ImageIcon icon2 = new ImageIcon("C:\\sist\\image\\Jquary_image\\02.png");
  ImageIcon icon3 = new ImageIcon("C:\\sist\\image\\Jquary_image\\03.png");
  ImageIcon icon4 = new ImageIcon("C:\\sist\\image\\swingimage\\leftDown.gif");
  ImageIcon icon5 = new ImageIcon("C:\\sist\\image\\swingimage\\LEFT.GIF");
  ImageIcon icon6 = new ImageIcon("C:\\sist\\image\\Jquary_image\\a01.png");
  
  public Ex02_SwingIconButton(String title) {
    super(title);

    this.setBounds(200, 100, 400, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(255, 217, 236));

    initDesign();
    this.setVisible(true);
  }

  public void initDesign() {
    // 레이아웃 직접 배치할 경우
    this.setLayout(new GridLayout(2, 2)); //버튼을 2행 2열로 배치

    btn1 = new JButton("hello", icon1);
    btn1.setHorizontalTextPosition(JButton.CENTER); // 텍스트 가로위치
    btn1.setVerticalTextPosition(JButton.BOTTOM); // 텍스트 세로위치
    this.add(btn1);

    btn1.setRolloverIcon(icon4); // 마우스 올리면 icon4 소환
    btn1.setPressedIcon(icon5); // 클릭하면 icon5 소환
    
    btn2 = new JButton(icon2);
    this.add(btn2);
    
    btn3 = new JButton(icon2);
    this.add(btn3);
    
    btn4 = new JButton("Hi", icon6);
    this.add(btn4);
  }

  public static void main(String[] args) {
    new Ex02_SwingIconButton("");
  }
}
