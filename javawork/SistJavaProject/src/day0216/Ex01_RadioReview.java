package day0216;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

public class Ex01_RadioReview extends JFrame implements ActionListener {
  Container cp;
  JRadioButton manRadioBtn, womanRadioBtn;
  JRadioButton[] radiobtnColors = new JRadioButton[6];
  JLabel resultLabel;
  String[] strColors = {"노랑", "빨강", "초록", "블루", "회색", "핑크"};
  Color[] bgColor = {Color.yellow, Color.red, Color.green, Color.blue, Color.gray, Color.pink};


  public Ex01_RadioReview(String title) {
    super(title);
    cp = this.getContentPane();
    this.setBounds(100, 100, 600, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 255, 155));

    setDesign();

    this.setVisible(true);
  }

  public void setDesign() {
    this.setLayout(null);
    
    manRadioBtn = new JRadioButton("남자", true);
    manRadioBtn.setBounds(20,  30,  60,  30);
    manRadioBtn.setOpaque(false);
    this.add(manRadioBtn);
    
    womanRadioBtn = new JRadioButton("여자", true);
    womanRadioBtn.setBounds(100,  30,  60,  30);
    womanRadioBtn.setOpaque(false);
    this.add(womanRadioBtn);
    
    ButtonGroup bgGender = new ButtonGroup();
    bgGender.add(manRadioBtn);
    bgGender.add(womanRadioBtn);
    
    // 성별 라디오 버튼에 이벤트 추가
    manRadioBtn.addActionListener(this);
    womanRadioBtn.addActionListener(this);
    
    resultLabel = new JLabel("결과 출력하는 곳");
    resultLabel.setFont(new FontUIResource("", Font.BOLD, 18));
    resultLabel.setBorder(new LineBorder(Color.pink, 5));
    resultLabel.setOpaque(true);
    resultLabel.setBounds(20, 250, 350, 50);
    this.add(resultLabel);
    
    ButtonGroup bg = new ButtonGroup();
    int xpos = 10;
    for (int i = 0; i < radiobtnColors.length; i++) {
      radiobtnColors[i] = new JRadioButton(strColors[i]);
      bg.add(radiobtnColors[i]);
      radiobtnColors[i].setBounds(xpos, 90, 70, 30);
      radiobtnColors[i].setOpaque(false);
      this.add(radiobtnColors[i]);
      xpos += 60;
      
      int idx = i;
      radiobtnColors[i].addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
          // TODO Auto-generated method stub
          resultLabel.setBackground(bgColor[idx]);
        }
      });
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub

  }

  public static void main(String[] args) {
    new Ex01_RadioReview("스윙 라디오 1");
  }

}
