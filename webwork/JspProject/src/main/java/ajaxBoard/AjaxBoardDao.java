package ajaxBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mysql.db.DbConnect;

public class AjaxBoardDao {
  DbConnect db = new DbConnect();

  public void insertBoard(AjaxBoardDto dto) {
    Connection conn = db.getConnection();
    PreparedStatement ps = null;

    String sql = "insert into ajaxboard (writer, subject, content, avata, writeday) "
        + "values(?, ?, ?, ?, now())";

    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, dto.getWriter());
      ps.setString(2, dto.getSubject());
      ps.setString(3, dto.getContent());
      ps.setString(4, dto.getAvata());

      ps.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  public ArrayList<AjaxBoardDto> getAllDatas() {
    ArrayList<AjaxBoardDto> list = new ArrayList<AjaxBoardDto>();

    Connection conn = db.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "select * from ajaxboard order by num desc";

    try {
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        AjaxBoardDto dto = new AjaxBoardDto();

        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setSubject(rs.getString("subject"));
        dto.setContent(rs.getString("content"));
        dto.setAvata(rs.getString("avata"));
        dto.setWriteday(rs.getTimestamp("writeday"));
        
        list.add(dto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(rs, ps, conn);
    }
    
    return list;
  }
}
