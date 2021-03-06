package day0214;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Ex07_TestLabel extends JFrame {
  JTextField text1, text2;
  Container cp;
  JLabel label1, label2, label3, label4, lblResult;
  JButton btn;
  Icon icon1 = new ImageIcon("C:\\sist\\image\\swingimage\\an07.gif");
  Icon icon2 = new ImageIcon("C:\\sist\\image\\swingimage\\an08.gif");

  public Ex07_TestLabel(String title) {
    super(title);
    cp = this.getContentPane();
    this.setBounds(200, 100, 800, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 200, 155));

    initDesign();

    this.setVisible(true);
  }

  public void initDesign() {
    this.setLayout(null);
    
    text1 = new JTextField();
    text1.setBounds(10, 20, 90, 30);
    this.add(text1);
    
    text2 = new JTextField("Have a Nice Day!!");
    text2.setBounds(10, 60, 150, 30);
    this.add(text2);
    
    label1 = new JLabel("안녕하세요", JLabel.CENTER);
    label1.setBounds(10, 100, 200, 30);
    label1.setBackground(Color.gray);
    label1.setOpaque(true);
    this.add(label1);
    
    label2 = new JLabel("Today", icon1, JLabel.RIGHT);
    label2.setBounds(10, 150, 200, 30);
    //Border인터페이스 구현한 LineBorder, TitleBorder
    label2.setBorder(new LineBorder(Color.red));
    this.add(label2);
    
    label3 = new JLabel("스윙공부중", icon2, JLabel.CENTER);
    label3.setBounds(10, 210, 200, 50);
    label3.setBorder(new TitledBorder("SIST"));
    this.add(label3);
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 MM시 mm분");
    label4 = new JLabel(sdf.format(new Date()), icon1, JLabel.CENTER);
    label4.setBounds(10, 260, 250, 50);
    label4.setBorder(new LineBorder(Color.pink));
    this.add(label4);
    
    lblResult = new JLabel("빈 라벨", JLabel.CENTER);
    lblResult.setBorder(new TitledBorder("결과 확인"));
    lblResult.setBounds(250, 100, 200, 50);
    this.add(lblResult);
  
    btn = new JButton("버튼");
    btn.setBounds(300, 200, 70, 30);
    btn.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String s1 = text1.getText();
        String s2 = text2.getText();
        lblResult.setText(s2);
      }
    });
    this.add(btn);
  }


  public static void main(String[] args) {
    new Ex07_TestLabel("텍스트 라벨 7");
  }

}
