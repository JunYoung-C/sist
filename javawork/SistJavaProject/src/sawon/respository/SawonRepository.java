package sawon.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import month03.day04.DbConnect;
import sawon.domain.Sawon;

public class SawonRepository {

	DbConnect db = new DbConnect();

	public List<Sawon> findAll(int select) {
		List<Sawon> sawons = new Vector<Sawon>();

		String sql = "select num id, name, buseo, gender, pay from sawon";
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

			while (rs.next()) {

				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String buseo = rs.getString("buseo");
				String gender = rs.getString("gender");
				Long pay = rs.getLong("pay");

				sawons.add(new Sawon(id, name, buseo, gender, pay));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}

		return sawons;
	}

	public void deleteById(String id) {
		Connection conn = db.getOracle();
		PreparedStatement ps = null;

		String sql = "delete from sawon where num = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(ps, conn);
		}
	}

	public void save(Sawon sawon) {
		String sql = "insert into sawon values(seq_sawon.nextval, ?, ?, ?, ?)";

		Connection conn = db.getOracle();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, sawon.getName());
			ps.setString(2, sawon.getGender());
			ps.setString(3, sawon.getBuseo());
			ps.setLong(4, sawon.getPay());
			ps.execute();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
