package month03.day04;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sawon.respository.DbConnect;

public class SawonDbSwing extends JFrame implements ItemListener, ActionListener {

  DbConnect db = new DbConnect();

  Container cp;
  DefaultTableModel model;
  JTable table;
  JRadioButton[] rb = new JRadioButton[6];
  JButton addBtn, deleteBtn;

  int studentName;
  public SawonDbSwing(String title) {
    super(title);
    cp = this.getContentPane();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds(800, 100, 700, 500);
    cp.setBackground(new Color(255, 255, 100));

    initDesign();

    this.setVisible(true);
  }

  private void initDesign() {
    this.setLayout(null);

    String[] title = {"No.", "Id", "사원명", "부서명", "성별", "월급여"};
    model = new DefaultTableModel(title, 0); // 행 개수는 0으로 추가
    table = new JTable(model);
    JScrollPane js = new JScrollPane(table);
    js.setBounds(10, 100, 670, 350);
    this.add(js);

    ButtonGroup bg = new ButtonGroup();

    String[] rb_label = {"전체", "여자", "남자", "개발부", "홍보부", "교육부"};
    int xpos = 10;
    for (int i = 0; i < rb.length; i++) {
      // 라디오 버튼 생성
      rb[i] = new JRadioButton(rb_label[i], i == 0);
      rb[i].setBounds(xpos, 50, 90, 30);
      rb[i].setOpaque(false);
      // 이벤트 추가
      rb[i].addItemListener(this);
      bg.add(rb[i]);
      this.add(rb[i]);
      xpos += 100;
    }

    sawonTableWrite(1);

    addBtn = new JButton("추가");
    addBtn.setBounds(200, 0, 80, 40);
    addBtn.addActionListener(this);
    this.add(addBtn);

    deleteBtn = new JButton("삭제");
    deleteBtn.setBounds(380, 0, 80, 40);
    deleteBtn.addActionListener(this);
    this.add(deleteBtn);
  }

  // db 조회해서 테이블에 추가
  public void sawonTableWrite(int select) {
    String sql =
        "select rownum no, num id, name, buseo, gender, to_char(pay, 'L999,999,999') pay from sawon";
    switch (select) {
      case 2:
        sql += " where gender = '여자'";
        break;
      case 3:
        sql += " where gender = '남자'";
        break;
      case 4:
        sql += " where buseo = '개발부'";
        break;
      case 5:
        sql += " where buseo = '홍보부'";
        break;
      case 6:
        sql += " where buseo = '교육부'";
        break;
    }
    Connection conn = db.getOracle();
    Statement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);

      // 기존의 데이터 삭제 후 가져오기
      model.setRowCount(0);

      while (rs.next()) {
        Vector<String> data = new Vector<String>();

        data.add(rs.getString("no"));
        data.add(rs.getString("id"));
        data.add(rs.getString("name"));
        data.add(rs.getString("buseo"));
        data.add(rs.getString("gender"));
        data.add(rs.getString("pay"));

        model.addRow(data);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, stmt, conn);
    }


  }

  public void deleteSawon(String deleteNum) {
    Connection conn = db.getOracle();
    PreparedStatement ps = null;

    String sql = "delete from sawon where num = ?";

    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, deleteNum);
      ps.execute();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  // 라디오 버튼 이벤트
  @Override
  public void itemStateChanged(ItemEvent e) {
    Object o = e.getSource();

    for (int i = 0; i < rb.length; i++) {
      if (rb[i].isSelected()) {
        sawonTableWrite(i + 1);
        break;
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();

    if (o == addBtn) {
      //이름, 성별, 부서, 급여
      String name = JOptionPane.showInputDialog("학생명을 입력해주세요");
      String gender = JOptionPane.showInputDialog("성별을 입력해주세요", "남자");
      String buseo = JOptionPane.showInputDialog("부서를 입력해주세요", "홍보부");
      String pay = JOptionPane.showInputDialog("급여를 입력해주세요");
      
      String sql = "insert into sawon values(seq_sawon.nextval, ?, ?, ?, ?)";
      
      Connection conn = db.getOracle();
      PreparedStatement ps = null;
      
      try {
        ps = conn.prepareStatement(sql);
       
        ps.setString(1, name);
        ps.setString(2, gender);
        ps.setString(3, buseo);
        ps.setString(4, pay);
        ps.execute();
        
        this.sawonTableWrite(1);
      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    } else if (o == deleteBtn) {
      int row = table.getSelectedRow();
      if (row == -1) {
        JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요");
        return;
      }
      
      String num = (String) model.getValueAt(row, 1);
      System.out.println(num);
      deleteSawon(num);
      sawonTableWrite(1);
    }
  }

  public static void main(String[] args) {
    new SawonDbSwing("sawon db swing");
  }


}
