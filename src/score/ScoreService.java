package score;

import java.util.ArrayList;

public interface ScoreService {
	public ArrayList<ScoreDTO> scoreList(String m_id);
	public int inputScore(String cName, int credit, String grade, int mCheck);
	public boolean searchCname(String id, String updateCname);
	public int updateScore(String id, String originCname, String updateCname, int credit2,String grade2, int mCheck2);
	public int updateGoal(String id, int goal);
}
