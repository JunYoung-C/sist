package day0211;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex08_SwingButton extends JFrame implements ActionListener {

  Container cp;
  JButton btn1, btn2, btn3;

  public Ex08_SwingButton(String title) {
    super(title);
    cp = this.getContentPane();
    this.setBounds(200, 100, 400, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 200, 155));

    initDesign();
    this.setVisible(true);

  }

  public void initDesign() {
    // 버튼을 레이아웃 생략시 - 보더 레이아웃
    // 1. 레이아웃 변경해서 생성
    this.setLayout(new FlowLayout()); // 옆으로 나열되는 레이아웃
    btn1 = new JButton("버튼1");
    btn2 = new JButton("버튼2");
    btn3 = new JButton("버튼3");

    // 프레임에 추가
    this.add(btn1);
    this.add(btn2);
    this.add(btn3);

    // 이벤트 발생 - 이벤트 핸들러 메서드와 이벤트 발생 객체 연결
    btn1.addActionListener(this);
    btn2.addActionListener(this);
    btn3.addActionListener(this);

    // 버튼 속성
    btn1.setBackground(Color.pink);
    btn2.setBackground(Color.cyan);
    btn3.setBackground(Color.gray);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    Object ob = e.getSource();

    // JOptionPane.showMessageDialog(this, "버튼 클릭!!");

    // 버튼의 어떤 메서드를 호출하는지 정확하게 지정해준다.
    if (ob == btn1) {
      JOptionPane.showMessageDialog(this, "1번째 버튼 클릭!!");
    } else if (ob == btn2) {
      JOptionPane.showMessageDialog(this, "2번째 버튼 클릭!!");
    } else if (ob == btn3) {
      JOptionPane.showMessageDialog(this, "3번째 버튼 클릭!!");
    }
  }

  public static void main(String[] args) {
    new Ex08_SwingButton("버튼연습");
  }

}
