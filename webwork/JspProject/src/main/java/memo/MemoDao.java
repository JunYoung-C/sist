package memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import com.mysql.cj.xdevapi.Result;
import mysql.db.DbConnect;

public class MemoDao {
  DbConnect db = new DbConnect();

  public void insertMemo(MemoDto dto) {
    Connection conn = db.getConnection();
    PreparedStatement ps = null;

    String sql = "insert into memo values(null, ?, ?, ?, now())";

    try {
      ps = conn.prepareStatement(sql);

      ps.setString(1, dto.getWriter());
      ps.setString(2, dto.getContent());
      ps.setString(3, dto.getAvatar());

      ps.execute();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }

  }

  // 전체 출력 메서드
  public List<MemoDto> getAllDatas() {
    List<MemoDto> list = new Vector<MemoDto>();

    Connection conn = db.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "select * from memo order by num desc";

    try {
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        MemoDto dto = new MemoDto();

        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setContent(rs.getString("content"));
        dto.setAvatar(rs.getString("avatar"));
        dto.setWriteday(rs.getTimestamp("writeday"));

        list.add(dto);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return list;
  }

  public void deleteMemo(String num) {
    Connection conn = db.getConnection();
    PreparedStatement ps = null;

    String sql = "delete from memo where num = ?";

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

  public MemoDto getData(String num) {
    MemoDto dto = new MemoDto();

    Connection conn = db.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "select * from memo where num = ?";

    try {
      ps = conn.prepareStatement(sql);

      ps.setString(1, num);

      rs = ps.executeQuery();
      
      if (rs.next()) {
        dto.setNum(rs.getString("num"));
        dto.setWriter(rs.getString("writer"));
        dto.setContent(rs.getString("content"));
        dto.setAvatar(rs.getString("avatar"));
        dto.setWriteday(rs.getTimestamp("writeday"));

      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      db.dbClose(rs, ps, conn);
    }
    
    return dto;
  }
  
  public void updateMemo(MemoDto dto) {
    Connection conn = db.getConnection();
    PreparedStatement ps = null;
    
    String sql = "update memo set writer=?, content=?, avatar=? where num = ?";
    
    try {
      ps = conn.prepareStatement(sql);
      
      ps.setString(1, dto.getWriter());
      ps.setString(2, dto.getContent());
      ps.setString(3, dto.getAvatar());
      ps.setString(4, dto.getNum());
      
      ps.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }finally {
      db.dbClose(ps, conn);
    }
  }
}
