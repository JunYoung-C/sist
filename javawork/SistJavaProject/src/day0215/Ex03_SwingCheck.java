package day0215;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class Ex03_SwingCheck extends JFrame implements ActionListener, ItemListener {
  Container cp = this.getContentPane();
  JRadioButton[] radioButtons = new JRadioButton[4]; // 전공
  JCheckBox[] cbCity = new JCheckBox[4]; // 취미
  JCheckBox cbDriver, cbBold;
  JLabel resultLabel;
  JButton btnOk;


  public Ex03_SwingCheck(String title) {
    super(title);
    this.setBounds(100, 100, 400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 255, 155));

    setDesign();

    this.setVisible(true);
  }

  public void setDesign() {
    this.setLayout(null);
    cbDriver = new JCheckBox("운전면허");
    cbDriver.setOpaque(false);
    cbDriver.setBounds(20, 20, 100, 30);
    this.add(cbDriver);
    cbDriver.addItemListener(this);
    
    cbBold = new JCheckBox("라벨을 굵게");
    cbBold.setOpaque(false);
    cbBold.setBounds(20, 60, 150, 30);
    this.add(cbBold);
    cbBold.addItemListener(this);
    
    // 상단 패널에 보더로 감싼 4개의 라디오 버튼
    resultLabel = new JLabel("결과 출력하는 곳", JLabel.CENTER);
    resultLabel.setBounds(20, 250, 350, 50);
    resultLabel.setBorder(new LineBorder(Color.pink, 5));
    this.add(resultLabel);

    String[] city = {"프라하", "토쿄", "빈", "시드니"};
    int xpos = 20;
    for (int i = 0; i < cbCity.length; i++) {
      cbCity[i] = new JCheckBox(city[i]);
      cbCity[i].setBounds(xpos, 100, 80, 30);
      cbCity[i].setOpaque(false);
      this.add(cbCity[i]);
      xpos += 80;
    }

    btnOk = new JButton("가보고 싶은 도시 알아보기");
    btnOk.setBounds(60, 140, 200, 30);
    this.add(btnOk);
    btnOk.addActionListener(this);
  }

  // 운전 면허, 라벨 굵기
  @Override
  public void itemStateChanged(ItemEvent e) {
    Object ob = e.getSource();
    if (ob == cbDriver) {
      String s = "체크상태: " + cbDriver.isSelected() + ", 텍스트: " + cbDriver.getText();
      resultLabel.setText(s);
    } else if (ob == cbBold) {
      if (cbBold.isSelected()) {
        resultLabel.setFont(new Font("", Font.BOLD, 20));
      } else {
        resultLabel.setFont(new Font("", Font.PLAIN, 12));
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int select = 0;
    String s = "내가 가고싶은 도시: ";
    for (int i = 0; i < cbCity.length; i++) {
      if (cbCity[i].isSelected()) {
        select++;
        s += "[" + cbCity[i].getText() + "]";
      }
    }

    if (select == 0) {
      s = "저는 가고싶은 도시가 없어요";
    } else {
      s += "를 가고 싶어요";
    }
    
    resultLabel.setText(s);
  }

  public static void main(String[] args) {
    new Ex03_SwingCheck("라디오 & 체크");
  }
}
