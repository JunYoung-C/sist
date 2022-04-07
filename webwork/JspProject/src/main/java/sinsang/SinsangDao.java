package sinsang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import mysql.db.DbConnect;

public class SinsangDao {
  DbConnect db = new DbConnect();

  public void insertSinsang(SinsangDto dto) {
    Connection conn = db.getConnection();
    PreparedStatement ps = null;

    String sql = "insert into sinsang values (null, ?, ?, ?, ?)";

    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, dto.getName());
      ps.setString(2, dto.getBlood());
      ps.setString(3, dto.getHp());
      ps.setString(4, dto.getBirth());

      ps.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  public Vector<SinsangDto> getAllDatas() {
    Vector<SinsangDto> list = new Vector<SinsangDto>();

    Connection conn = db.getConnection();
    Statement stmt = null;
    ResultSet rs = null;

    String sql = "select * from sinsang order by num desc";
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);

      while (rs.next()) {
        SinsangDto dto = new SinsangDto();

        dto.setNum(rs.getString("num"));
        dto.setName(rs.getString("name"));
        dto.setBlood(rs.getString("blood"));
        dto.setHp(rs.getString("hp"));
        dto.setBirth(rs.getString("birth"));

        list.add(dto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(rs, stmt, conn);
    }
    return list;
  }

  public void deleteSinsang(String num) {
    Connection conn = db.getConnection();
    Statement stmt = null;

    String sql = "delete from sinsang where num = " + num;

    try {
      stmt = conn.createStatement();
      stmt.execute(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(stmt, conn);
    }
  }

  public SinsangDto getData(String num) {
    SinsangDto dto = new SinsangDto();

    Connection conn = db.getConnection();
    Statement stmt = null;
    ResultSet rs = null;

    String sql = "select * from sinsang where num=" + num;

    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);

      if (rs.next()) {
        dto.setNum(rs.getString("num"));
        dto.setName(rs.getString("name"));
        dto.setBlood(rs.getString("blood"));
        dto.setHp(rs.getString("hp"));
        dto.setBirth(rs.getString("birth"));
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return dto;
  }
  
  public void updateSinsang(SinsangDto dto) {
    Connection conn = db.getConnection();
    PreparedStatement ps = null;

    String sql = "update sinsang set name=?, blood=?, hp=?, birth=? where num = ?";

    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, dto.getName());
      ps.setString(2, dto.getBlood());
      ps.setString(3, dto.getHp());
      ps.setString(4, dto.getBirth());
      ps.setString(5, dto.getNum());

      ps.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }
}
