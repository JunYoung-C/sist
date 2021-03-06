package day0211;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Ex06_SwingGibon extends JFrame {
  
  Container cp;
  
  public Ex06_SwingGibon(String title) {
    super(title); // JFrame 부모생성자를 통해서 창제목 보내기
    
    cp = this.getContentPane(); // 프레임 위에 기본 패널
    
    // 메인 프로그램 종료시 프로그램 종료
//    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // 내부 클래스 호출로 메인 프로그램 종료시 프로그램 종료 설정
//    this.addWindowListener(new Winclose());
    
    this.setBounds(200, 100, 300, 300); // 시작위치, 너비, 높이
//    cp.setBackground(new Color(200, 255, 200)); // 원하는 색으로
    cp.setBackground(Color.magenta);
    this.setVisible(true); // 프레임이 보이게
  }
  
//  class Winclose extends WindowAdapter {
//    @Override
//    public void windowClosing(WindowEvent e) {
//      // TODO Auto-generated method stub
//      super.windowClosing(e);
//      System.exit(0);
//    }
//  }

  public static void main(String[] args) {
    new Ex06_SwingGibon("스윙기본연습");
  }
}
