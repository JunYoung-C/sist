package day0215;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex04_JTable extends JFrame {
  Container cp = this.getContentPane();
  JTable table;
  JLabel titleLabel, outLabel;


  public Ex04_JTable(String title) {
    super(title);
    this.setBounds(100, 100, 400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 255, 155));

    setDesign();

    this.setVisible(true);
  }

  public void setDesign() {
    String[][] data = {{"송혜교", "서울", "010-7777-8888"}, {"강호동", "제주", "010-8888-5274"},
        {"하하", "인천시", "010-1111-2222"},};

    String[] title = {"이름", "주소", "연락처"};

    // 라벨 생성
    titleLabel = new JLabel("JTable 연습", JLabel.CENTER);
    outLabel = new JLabel("결과 나오는 곳", JLabel.CENTER);
    
    table = new JTable(data, title);
    JScrollPane pane = new JScrollPane(table);
    
    table.addMouseListener(new TableEvent());
    this.add("North", titleLabel);
    this.add("Center", pane);
//    this.add("Center", table);
    this.add("South", outLabel);
  }

  // 마우스 이벤트. 테이블 클릭스
  class TableEvent extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
      super.mouseClicked(e);
      
      System.out.println("테이블 클릭!!");
      int rowNum = table.getSelectedRow();
      
      JOptionPane.showMessageDialog(Ex04_JTable.this, "행번호: " + rowNum);
      String str = "이름: " + table.getValueAt(rowNum, 0)
       + ",주소: " + table.getValueAt(rowNum, 1)
        + ",핸드폰: " + table.getValueAt(rowNum, 2);
      outLabel.setText(str);
    }
  }
  public static void main(String[] args) {
    new Ex04_JTable("라디오 & 체크");
  }
}
