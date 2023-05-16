package score;

public class ScoreDTO {
	private String s_id; // 학생 id
	private String s_cName; // 수업이름
	private int s_credit; // 학점
	private String s_grade; // 등급
	private int s_mCheck; // 전공인지 아닌지(전공이면 1, 전공이 아니면 0)
	private int s_totalCredit; // 지금까지 받은 학점
	private int s_goalCredit; // 목표학점

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getS_cName() {
		return s_cName;
	}

	public void setS_cName(String s_cName) {
		this.s_cName = s_cName;
	}

	public int getS_credit() {
		return s_credit;
	}

	public void setS_credit(int s_credit) {
		this.s_credit = s_credit;
	}

	public String getS_grade() {
		return s_grade;
	}

	public void setS_grade(String s_grade) {
		this.s_grade = s_grade;
	}

	public int getS_mCheck() {
		return s_mCheck;
	}

	public void setS_mCheck(int s_mCheck) {
		this.s_mCheck = s_mCheck;
	}

	public int getS_totalCredit() {
		return s_totalCredit;
	}

	public void setS_totalCredit(int s_totalCredit) {
		this.s_totalCredit = s_totalCredit;
	}

	public int getS_goalCredit() {
		return s_goalCredit;
	}

	public void setS_goalCredit(int s_goalCredit) {
		this.s_goalCredit = s_goalCredit;
	}

}
