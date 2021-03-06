package day0216;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Ex03_SwingFileDialog extends JFrame implements ActionListener, ItemListener{
  Container cp;
  JComboBox<String> combo;
  String[] names = {"조정언", "류슬영", "이다솔", "김주찬"};
  JTextField tfName;
  JButton btnAdd, btnDel;
  JLabel resultLabel;
  int idx = -1; // 멤버변수는 0으로 자동초기화되는데 0번 삭제를 막기 위해서

  public Ex03_SwingFileDialog(String title) {
    super(title);
    cp = this.getContentPane();
    this.setBounds(100, 100, 400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 255, 155));

    setDesign();

    this.setVisible(true);
  }


  public void setDesign() {
    this.setLayout(null);
    combo = new JComboBox<String>(names);
    combo.setBounds(30, 30, 100, 30);
    this.add(combo);
    
    tfName = new JTextField();
    tfName.setBounds(30, 90, 100, 30);
    this.add(tfName);
    
    btnAdd = new JButton("추가");
    btnAdd.setBounds(150, 90, 80, 30);
    this.add(btnAdd);
    
    btnDel = new JButton("삭제");
    btnDel.setBounds(250, 90, 80, 30);
    this.add(btnDel);
    
    resultLabel = new JLabel("Result", JLabel.CENTER);
    resultLabel.setBounds(20, 250, 350, 30);
    resultLabel.setBorder(new LineBorder(Color.pink, 4));
    this.add(resultLabel);
    
    
    combo.addItemListener(this);
    btnAdd.addActionListener(this);
    btnDel.addActionListener(this);
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    // TODO Auto-generated method stub
    idx = combo.getSelectedIndex();
    String item = (String)combo.getSelectedItem();
    resultLabel.setText(idx + "번 인덱스의 " + item + "선택!!");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    Object ob = e.getSource();
    
    if (ob == btnAdd) {
      String text = tfName.getText().trim();
      
      if (text.length() == 0) {
        JOptionPane.showMessageDialog(this, "이름을 입력 후 추가버튼 누르세요");
      } else {
        combo.addItem(text); // 콤보에 추가
        tfName.setText("");
        resultLabel.setText("해당 항목이 추가됨");
      }
    } else if (ob == btnDel) {
      
      if (idx == -1) {
        JOptionPane.showMessageDialog(this, "삭제할 항목 선택바람");
      } else {
        combo.removeItemAt(idx);
        resultLabel.setText("해당 항목을 삭제함");
      }
    }
  }

  public static void main(String[] args) {
    new Ex03_SwingFileDialog("스윙 파일 저장 2");
  }
}
