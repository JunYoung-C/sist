package day0215;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Ex02_SwingRadioCheck extends JFrame implements ActionListener{
  Container cp = this.getContentPane();
  JRadioButton[] radioButtons = new JRadioButton[4];
  JCheckBox[] checkBoxs = new JCheckBox[4];
  JLabel label;
  Color[] colors = {Color.red, Color.yellow, Color.green, Color.blue};

  public Ex02_SwingRadioCheck(String title) {
    super(title);
    this.setBounds(100, 100, 600, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 255, 155));

    setDesign();

    this.setVisible(true);
  }

  public void setDesign() {
    // 상단 패널에 보더로 감싼 4개의 라디오 버튼
    String[] str = {"빨강", "노랑", "초록", "파랑"};
    JPanel pTop = new JPanel(); // 디폴트는 flow 레이아웃
    TitledBorder border = new TitledBorder("글자색");
    border.setBorder(new LineBorder(Color.black));
    pTop.setBorder(border);
    this.add(pTop, BorderLayout.NORTH);

    // 라디오 버튼. 하나만 선택하기 위해선 그룹
    ButtonGroup buttonGroup = new ButtonGroup();

    for (int i = 0; i < radioButtons.length; i++) {
      radioButtons[i] = new JRadioButton(str[i], i == 1);
      pTop.add(radioButtons[i]);
      buttonGroup.add(radioButtons[i]);
      
      radioButtons[i].addActionListener(this);
      
    }
    
    ImageIcon icon = new ImageIcon("C:\\sist\\image\\Jquary_image\\01.png");
    label = new JLabel("Habe a Nice Day!!", icon, JLabel.CENTER);
    label.setHorizontalTextPosition(JLabel.LEFT);
    label.setBorder(new LineBorder(Color.red, 2));
    this.add("Center", label);
    
    // 하단에는 체크박스
    String[] str2 = {"자바", "오라클", "스프링" ,"자바스크립트"};
    
    JPanel pBottom = new JPanel();
    TitledBorder border2 = new TitledBorder("과목");
    border.setBorder(new LineBorder(Color.black));
    pBottom.setBorder(border2);
    this.add(pBottom, BorderLayout.SOUTH);
    
    for (int i = 0; i < checkBoxs.length; i++) {
      checkBoxs[i] = new JCheckBox(str2[i]);
      
      pBottom.add(checkBoxs[i]);
      checkBoxs[i].addActionListener(this);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object ob = e.getSource();
    
    for (int i = 0; i < radioButtons.length; i++) {
      if (ob == radioButtons[i]) {
        Font font = new Font("", Font.BOLD, 20);
        
        label.setFont(font);
        label.setForeground(colors[i]);
      }
    }
    
    String msg = "사용가능한 언어는 ";
    for (int i = 0; i < checkBoxs.length; i++) {
      if (checkBoxs[i].isSelected()) {
        msg += checkBoxs[i].getText() + " ";
      }
    }
    label.setText(msg);
  }

  public static void main(String[] args) {
    new Ex02_SwingRadioCheck("스윙라디오 체크 연습 2");
  }

}
