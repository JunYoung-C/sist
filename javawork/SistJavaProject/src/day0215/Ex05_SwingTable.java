package day0215;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Ex05_SwingTable extends JFrame {
  Container cp = this.getContentPane();
  JTable table1, table2, table3;
  JTextArea area;


  public Ex05_SwingTable(String title) {
    super(title);
    this.setBounds(100, 100, 600, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cp.setBackground(new Color(255, 255, 155));

    setDesign();

    this.setVisible(true);
  }

  public void setDesign() {
    this.setLayout(new GridLayout(2, 2));

    // 첫번째 테이블은 행, 열만 지정
    table1 = new JTable(5, 4);
    this.add(table1);

    // 두번재 테이블은 생성할 때 데이터 넣기
    String[] title1 = {"이름", "학과", "주소"};
    String[][] data1 =
        {{"최준영", "화학공학과", "서울특별시"}, {"김은지", "유아교욱", "안양시 만안구"}, {"신지환", "정보교육", "서울시 노원구"}};

    table2 = new JTable(data1, title1);
    this.add(new JScrollPane(table2)); // JScrollPane에 넣어야 제목, 스크롤바가 나타남
    // this.add(table2);

    // 세번째 테이블은 Model을 이용해서 생성(나중에 추가, 삭제가 가능)
    DefaultTableModel model = new DefaultTableModel(data1, title1);
    table3 = new JTable(model);
    this.add(new JScrollPane(table3));

    // table3는 모델을 이용했으므로 추가 가능
    String[] addData1 = {"유태호", "컴공", "경기도 용인시"};
    model.addRow(addData1);

    // 벡터로 생성 후 추가
    Vector<String> addData2 = new Vector<String>();
    addData2.add("유재석");
    addData2.add("멀티미디어");

    model.addRow(addData2);

    // 출력
    area = new JTextArea();
    this.add(new JScrollPane(area));

    int rowCount1 = table3.getRowCount();
    int rowCount2 = model.getRowCount();
    area.append("table3의 행 개수 : " + rowCount1 + "\n");
    area.append("table3의 행 개수 : " + rowCount2 + "\n");

    int colCount1 = table3.getColumnCount();
    int colCount2 = model.getColumnCount();
    area.append("table3의 열 개수 : " + colCount1 + "\n");
    area.append("table3의 열 개수 : " + colCount2 + "\n");

    area.append("1행1열의 값 : " + model.getValueAt(1, 1) + "\n");
    area.append("3행2열의 값 : " + model.getValueAt(3, 2) + "\n");
    area.append("3행2열의 값 : " + table3.getValueAt(3, 2) + "\n");

    table3.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
//        JTable t = (JTable) e.getSource();
        // TODO Auto-generated method stub
//        area.append( "클릭한 값 : " + model.getValueAt(t.getSelectedRow(), t.getSelectedColumn()) + "\n");
        int row = table3.getSelectedRow();
        int col = table3.getSelectedColumn();
        area.append(row + ", " + col + "===>" + table3.getValueAt(row, col) + "\n");
      }
    });
  }

  public static void main(String[] args) {
    new Ex05_SwingTable("라디오 & 체크");
  }
}
