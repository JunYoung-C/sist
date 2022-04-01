package team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mysql.db.DbConnect;

public class TeamDao {
  DbConnect db = new DbConnect();

  public void teamInsert(TeamDto dto) {
    String sql = "insert into team(name, driver, addr, writeday) values(?, ?, ?, now())";

    Connection conn = db.getConnection();
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement(sql);

      ps.setString(1, dto.getName());
      ps.setString(2, dto.getDriver());
      ps.setString(3, dto.getAddr());

      ps.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  public ArrayList<TeamDto> getAllData() {
    ArrayList<TeamDto> list = new ArrayList<TeamDto>();

    Connection conn = db.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "select * from team order by num";
    try {
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        TeamDto dto = new TeamDto();

        dto.setNum(rs.getString("num"));
        dto.setName(rs.getString("name"));
        dto.setDriver(rs.getString("driver"));
        dto.setAddr(rs.getString("addr"));
        dto.setWriteday(rs.getTimestamp("writeday"));

        // list에 추가
        list.add(dto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(rs, ps, conn);
    }

    return list;
  }

  public void teamDelete(String num) {
    String sql = "delete from team where num = ?";

    Connection conn = db.getConnection();
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, num);

      ps.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

}
