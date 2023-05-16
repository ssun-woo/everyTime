package score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ScoreServiceImpl implements ScoreService {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	ArrayList<ScoreDTO> list = null;
	ScoreDTO sdto = null;

	public ArrayList<ScoreDTO> scoreList(String m_id) {
		String sql = "select * from score where s_id = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				sdto = new ScoreDTO();
				sdto.setS_id(rs.getString("s_id"));
				sdto.setS_cName(rs.getString("s_cName"));
				sdto.setS_credit(rs.getInt("s_credit"));
				sdto.setS_grade(rs.getString("s_grade"));
				sdto.setS_mCheck(rs.getInt("s_mCheck"));
				sdto.setS_totalCredit(rs.getInt("s_totalCredit"));
				sdto.setS_goalCredit(rs.getInt("s_goalCredit"));

				list.add(sdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int inputScore(String cName, int credit, String grade, int mCheck) {
		String sql = "insert into score(s_cName, s_score, s_credit, s_mCheck) values (?,?,?,?) ";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cName);
			ps.setInt(2, credit);
			ps.setString(3, grade);
			ps.setInt(4, mCheck);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean searchCname(String id, String originCname) {
		String sql = "select * from score where s_id = ? and s_cname = ?";
		boolean bool = false;
		try {

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, originCname);
			rs = ps.executeQuery();
			if (rs.next()) {
				bool = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bool;
	}

	public int updateScore(String id, String originCname, String updateCname, int credit2, String grade2, int mCheck2) {
		String sql = "update score set s_cName = ?, s_credit = ?, s_grade = ? , s_mCheck = ? where s_Cname = ? and s_id = ?";
		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, updateCname);
			ps.setInt(2, credit2);
			ps.setString(3, grade2);
			ps.setInt(4, mCheck2);
			ps.setString(5, originCname);
			ps.setString(6, id);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public int updateGoal(String id, int goal) {
		String sql = "update score set s_goalcredit=? where s_id = ?";
		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, goal);
			ps.setString(2, id);
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

//	public int updatecName(String originCname, String updateCname) {
//		String sql = "update score set s_cName = ?, s_ where s_Cname = ?";
//		int result = 0;
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, updateCname);
//			ps.setString(2, originCname);
//			result = ps.executeUpdate();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	}

}

<<<<<<<HEAD

=======>>>>>>>master
