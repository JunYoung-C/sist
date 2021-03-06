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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Quiz extends JFrame {
  JTextField ltText, rtText;
  JLabel resultLabel;
  JButton operationBtn;

  public Quiz(String title) {
    super(title);
    this.setBounds(200, 100, 400, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(255, 200, 155));

    initDesign();

    this.setVisible(true);
  }

  public void initDesign() {
    this.setLayout(null);
    
    ltText = new JTextField();
    ltText.setBounds(50, 10, 100, 30);
    this.add(ltText);
    
    rtText = new JTextField();
    rtText.setBounds(200, 10, 100, 30);
    this.add(rtText);
    
    resultLabel = new JLabel("", JLabel.CENTER);
    resultLabel.setBounds(125, 110, 100, 50);
    TitledBorder border = new TitledBorder("결과 확인");
    border.setBorder(new LineBorder(Color.black));
    resultLabel.setBorder(border);
    this.add(resultLabel);
    
    operationBtn = new JButton("연산");
    operationBtn.setBounds(125, 60, 100, 30);
    this.add(operationBtn);
    operationBtn.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        int lt = Integer.parseInt(ltText.getText());
        int rt = Integer.parseInt(rtText.getText());
        int result = lt + rt;
        resultLabel.setText(String.valueOf(result));
      }
    });
  }


  public static void main(String[] args) {
    new Quiz("2/14일 숙제");
  }

}
