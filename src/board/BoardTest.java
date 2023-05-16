package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardTest {
	BoardDTO dbto = new BoardDTO();
	
	Connection con; 
	PreparedStatement ps; 
	ResultSet rs;
	
	public int bEdit(int choice, String contents) {
		String sql="insert into board(contents) values(?) where num=?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, contents);
			ps.setInt(2,choice);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<BoardDTO> bVeiw() {
		String sql ="select * from board";
		ArrayList<BoardDTO> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("b_num"));
				dto.setId(rs.getString("b_id"));
				dto.setTitle(rs.getString("b_title"));
				dto.setDate(rs.getString("date"));;
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	
	}
	
	
	public BoardDTO bVeiw_con(int bnum) {
		String sql ="select * from board where b_num = ?";
		BoardDTO dto = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bnum);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new BoardDTO();
				dto.setNum(rs.getInt("b_num"));
				dto.setId(rs.getString("b_id"));
				dto.setTitle(rs.getString("b_title"));
				dto.setContents(rs.getString("b_contents"));
				dto.setDate(rs.getString("b_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;	
	}
	

	public int bWirte(BoardDTO bd) {
		String sql="insert into board(num,id,title,contents,pwd) values(board_seq.nextval,?,?,?,?,sysdadte)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bd.getId());
			ps.setString(2,bd.getTitle() );
			ps.setString(3, bd.getContents());
			ps.setString(4, bd.getPwd());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int search(String ID) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId()==(ID)) {
				return i;
			}
		}
		return -1;
	}
	
	public int bDelete(int choice) {
		String sql="delete from board where num=?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,choice);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
	

		



