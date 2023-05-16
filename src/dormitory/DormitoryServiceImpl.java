package dormitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DormitoryServiceImpl implements DormitoryService{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	DormitoryDTO ddto = null;
	
	public DormitoryDTO remainRoom(String m_sName) {
		String sql = "select * from dormitory where d_sName = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m_sName);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ddto = new DormitoryDTO();
				ddto.setD_room(rs.getInt("d_room"));
				ddto.setD_sName(m_sName);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ddto;
	}
	
	public int updateRoom(String m_sName) {
		String sql = "update dormitory set d_room = d_room-1 where d_sName = ?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m_sName);
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

	public int cancleRoom(String m_sName) {
		String sql = "update dormitory set d_room = d_room+1 where d_sName = ?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m_sName);
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
		
}
