package month03.day03;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SwingStuDb extends JFrame implements ActionListener {
  DbConnect db = new DbConnect();
  AddFrame addFrame = new AddFrame("성적추가폼");
  UpdateFrame updateFrame = new UpdateFrame("성적수정폼");
  Container cp;
  DefaultTableModel model;
  JTable table;
  JButton btnAdd, btnDel, btnUpdate;

  public SwingStuDb(String title) {
    super(title);
    cp = this.getContentPane();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds(200, 100, 400, 300);
    cp.setBackground(new Color(255, 255, 100));

    initDesign();

    this.setVisible(true);
  }

  public void initDesign() {
    String[] title = {"번호", "이름", "반", "Java", "Jsp", "Spring", "총점", "평균"};

    model = new DefaultTableModel(title, 0);
    table = new JTable(model);
    this.add("Center", new JScrollPane(table));

    // 테이블에 db데이터 출력
    tableWrite();

    JPanel pTop = new JPanel();
    this.add("North", pTop);

    btnAdd = new JButton("추가");
    btnAdd.addActionListener(this);
    pTop.add(btnAdd);

    btnDel = new JButton("삭제");
    btnDel.addActionListener(this);
    pTop.add(btnDel);

    btnUpdate = new JButton("수정");
    btnUpdate.addActionListener(this);
    pTop.add(btnUpdate);

    addFrame.btnAdd.addActionListener(this);
    updateFrame.btnMod.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object ob = e.getSource();

    if (ob == btnAdd) {
      System.out.println("add");
      addFrame.setVisible(true);
    } else if (ob == btnDel) {
      // System.out.println("del");
      String num = JOptionPane.showInputDialog("삭제할 데이터 번호를 입력해주세요");
      deleteData(num);
    } else if (ob == btnUpdate) {
      // System.out.println("update");
      String num = JOptionPane.showInputDialog("수정할 데이터의 번호를 입력하세요");

      String sql = "select * from studentinfo where num = " + num;

      Connection conn = db.getOracle();
      Statement stmt = null;
      ResultSet rs = null;

      try {
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        if (rs.next()) {
          updateFrame.num = num; // hidden으로 num값 넘긴다.
          updateFrame.tfName.setText(rs.getString("name"));
          updateFrame.tfJava.setText(rs.getString("java"));
          updateFrame.tfJsp.setText(rs.getString("jsp"));
          updateFrame.tfSpring.setText(rs.getString("spring"));
          updateFrame.cbBan.setSelectedItem(rs.getString("ban"));
          updateFrame.setVisible(true);
        } else {
          JOptionPane.showMessageDialog(this, "해당 번호는 없는 번호입니다.");
        }
      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      } finally {
        db.dbClose(rs, stmt, conn);
      }
    } else if (ob == addFrame.btnAdd) {
      // System.out.println("추가 프레임 액션 테스트");
      insertData();
      tableWrite();
      addFrame.tfName.setText("");
      addFrame.tfJava.setText("");
      addFrame.tfJsp.setText("");
      addFrame.tfSpring.setText("");
      addFrame.tfName.requestFocus();

      addFrame.setVisible(false);
    } else if (ob == updateFrame.btnMod){ 
      updateData();
      tableWrite();
    }
  }

  public void updateData() {
    
    String name = updateFrame.tfName.getText();
    String java = updateFrame.tfJava.getText();
    String jsp = updateFrame.tfJsp.getText();
    String spring = updateFrame.tfSpring.getText();
    String ban = (String) updateFrame.cbBan.getSelectedItem();

    int tot = Integer.parseInt(java) + +Integer.parseInt(jsp) + Integer.parseInt(spring);
    double avg = tot / 3.0;
    
    String sql = "update studentinfo set name = ?, java = ?, jsp = ?, spring = ?, total = ?, average = ?,  ban = ? where num = ?";

    Connection conn = db.getOracle();
    PreparedStatement ps = null;
    
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, name);
      ps.setString(2, java);
      ps.setString(3, jsp);
      ps.setString(4, spring);
      ps.setInt(5, tot);
      ps.setDouble(6, avg);
      ps.setString(7, ban);
      ps.setString(8, updateFrame.num);
      
      ps.execute();
      updateFrame.setVisible(false);
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  public void deleteData(String num) {
    System.out.println("num=" + num);
    String sql = "delete from studentinfo where num = " + num;

    // sql문 실행 후 해당 번호가 없으면 메세지, 삭제되면 새로고침
    // 새로고침의 의미는 tableWrite() 호출

    Connection conn = db.getOracle();
    Statement stmt = null;

    try {
      stmt = conn.createStatement();
      int a = stmt.executeUpdate(sql);

      if (a == 0) {
        JOptionPane.showMessageDialog(this, "없는 데이터 번호 입니다.");
      } else {
        tableWrite();
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(stmt, conn);
    }
  }

  public void insertData() {
    String name = addFrame.tfName.getText();
    String java = addFrame.tfJava.getText();
    String jsp = addFrame.tfJsp.getText();
    String spring = addFrame.tfSpring.getText();
    String ban = (String) addFrame.cbBan.getSelectedItem();

    int tot = Integer.parseInt(java) + +Integer.parseInt(jsp) + Integer.parseInt(spring);
    double avg = tot / 3.0;

    String sql = "insert into studentinfo values(seq_test.nextval, ?, ?, ?, ?, ?, ?, ?)";

    Connection conn = db.getOracle();
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, name);
      ps.setString(2, java);
      ps.setString(3, jsp);
      ps.setString(4, spring);
      ps.setInt(5, tot);
      ps.setDouble(6, avg);
      ps.setString(7, ban);

      ps.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  public void tableWrite() {
    // 테이블 초기화
    model.setRowCount(0);

    Connection conn = db.getOracle();
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "select * from studentinfo order by num asc";
    try {
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        System.out.println("1");
        Vector<String> data = new Vector<String>();
        String num = rs.getString("num");
        data.add(num);
        data.add(rs.getString("name"));
        data.add(rs.getString("ban"));
        data.add(rs.getString("java"));
        data.add(rs.getString("jsp"));
        data.add(rs.getString("spring"));
        data.add(rs.getString("total"));
        data.add(rs.getString("average"));
        System.out.println(num);
        model.addRow(data);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, ps, conn);
    }
  }

  public static void main(String[] args) {
    new SwingStuDb("성적관리DB");
  }

}
