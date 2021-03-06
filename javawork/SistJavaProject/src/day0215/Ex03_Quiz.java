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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

public class Ex03_Quiz extends JFrame {
  Container cp = this.getContentPane();
  JRadioButton[] radioButtons = new JRadioButton[4]; // 전공
  JCheckBox[] checkBoxes = new JCheckBox[4]; // 취미
  JLabel label;

  public Ex03_Quiz(String title) {
    super(title);
    this.setBounds(100, 100, 600, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(Color.white);

    setDesign();

    this.setVisible(true);
  }

  public void setDesign() {
    // 상단 패널에 보더로 감싼 4개의 라디오 버튼
    JPanel panel1 = new JPanel(); // 디폴트는 flow 레이아웃
    this.add(panel1, BorderLayout.NORTH);

    JPanel panel2 = new JPanel(); // 디폴트는 flow 레이아웃
    this.add(panel2, BorderLayout.SOUTH);

    label = new JLabel("전공이나 취미를 선택해보세요");
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(new Font("", Font.BOLD, 20));
    this.add(label);

    // 라디오 : 전공
    ButtonGroup bottonGroup = new ButtonGroup();
    String[] majors = {"화학공학과", "기계공학과", "전기공학과", "컴퓨터공학과"};
    for (int i = 0; i < radioButtons.length; i++) {
      radioButtons[i] = new JRadioButton(majors[i]);
      panel1.add(radioButtons[i]);
      bottonGroup.add(radioButtons[i]);
      radioButtons[i].addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          JRadioButton btn = (JRadioButton)e.getSource();
          label.setText("전공 : " + btn.getText());
        }
      });
    }

    // 체크박스 : 취미
    String[] hobbies = {"독서", "운동", "게임", "노래"};
    for (int i = 0; i < checkBoxes.length; i++) {
      checkBoxes[i] = new JCheckBox(hobbies[i]);
      panel2.add(checkBoxes[i]);
      checkBoxes[i].addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          String msg = "취미 : ";
          for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()) {
              msg += checkBoxes[i].getText() + " ";
            }
          }
          label.setText(msg.trim());
        }
      });
    }


  }

  public static void main(String[] args) {
    new Ex03_Quiz("라디오 & 체크");
  }

}
