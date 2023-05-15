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
		String sql="insert into newst(contents) values(?) where num=?";
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
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setTitle(rs.getString("title"));
				dto.setDate(rs.getString("date"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public int bWirte(BoardDTO bd) {
		String sql="insert into board(num,id,title,contents,pwd) values(board_seq.nextval,?,?,?,?)";
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
	

		



