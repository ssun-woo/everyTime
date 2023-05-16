package dormitory;

public interface DormitoryService {
	
	public DormitoryDTO remainRoom(String m_id);
	public int updateRoom(String m_sName);
	public int cancleRoom(String m_sName);
}
