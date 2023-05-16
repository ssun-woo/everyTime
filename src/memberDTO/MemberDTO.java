package memberDTO;


public class MemberDTO {
private String m_id;
private String m_pwd;
private String m_name;
private String m_sName;
private String m_major;
private int m_logon;
private int m_dorcheck=0;
private String is_admin;

public String getM_id() {
	return m_id;
}
public void setM_id(String m_id) {
	this.m_id = m_id;
}
public String getM_pwd() {
	return m_pwd;
}
public void setM_pwd(String m_pwd) {
	this.m_pwd = m_pwd;
}
public String getM_name() {
	return m_name;
}
public void setM_name(String m_name) {
	this.m_name = m_name;
}
public String getM_sName() {
	return m_sName;
}
public void setM_sName(String m_sName) {
	this.m_sName = m_sName;
}
public String getM_major() {
	return m_major;
}
public void setM_major(String m_major) {
	this.m_major = m_major;
}
public int getM_logon() {
	return m_logon;
}
public void setM_logon(int m_logon) {
	this.m_logon = m_logon;
}
public int getM_dorcheck() {
	return m_dorcheck;
}
public void setM_dorcheck(int m_dorcheck) {
	this.m_dorcheck = m_dorcheck;
}
public String getIs_admin() {
    return is_admin;
}

public void setIs_admin(String is_admin) {
    this.is_admin = is_admin;
}
}
