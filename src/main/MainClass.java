package main;

import common.DBConnection;
import memberDTO.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) throws Exception {
		Connection con = null;
		PreparedStatement pstmt;
		ResultSet rs;
		Scanner sc = new Scanner(System.in);
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		while (true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				MemberDTO memberDTO = new MemberDTO();

				System.out.print("ID: ");
				memberDTO.setM_id(sc.next());

				System.out.print("Password: ");
				memberDTO.setM_pwd(sc.next());

				System.out.print("이름: ");
				memberDTO.setM_name(sc.next());

				System.out.print("학교명: ");
				memberDTO.setM_sName(sc.next());

				System.out.print("전공: ");
				memberDTO.setM_major(sc.next());

				System.out.print("관리자 여부 (Y/N): ");
				String adminOrNot = sc.next();
				if (adminOrNot.equals("Y")) {
					pstmt = con.prepareStatement("SELECT count(*) FROM MEMBER WHERE is_admin = 'Y'");
					ResultSet adminRs = pstmt.executeQuery();
					if (adminRs.next())
						System.out.println("관리자 계정이 이미 존재합니다.");
					break;
				}
				memberDTO.setIs_admin(sc.next());

				pstmt = con.prepareStatement("INSERT INTO member VALUES (?, ?, ?, ?, ?,?)");
				pstmt.setString(1, memberDTO.getM_id());
				pstmt.setString(2, memberDTO.getM_pwd());
				pstmt.setString(3, memberDTO.getM_name());
				pstmt.setString(4, memberDTO.getM_sName());
				pstmt.setString(5, memberDTO.getM_major());
				pstmt.setString(6, memberDTO.getIs_admin());
				pstmt.executeUpdate();

				System.out.println("회원가입이 완료되었습니다.");
				break;

			case 2:
				System.out.print("ID: ");
				String id = sc.next();

				System.out.print("Password: ");
				String password = sc.next();

				pstmt = con.prepareStatement("SELECT * FROM member WHERE m_id=? AND m_pwd =?");
				pstmt.setString(1, id);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					String isAdmin = rs.getString("is_admin");

					while (true) {
						if (isAdmin == null) {
							break;
						} else if (isAdmin.equalsIgnoreCase("Y")) {
							// 관리자 메뉴

							while (true) {
								System.out.println("1. 로그아웃");
								System.out.println("2. 모든 회원 정보 조회");
								System.out.println("3. 특정 회원 삭제");
								System.out.println("4. 게시판 삭제");
								System.out.print("메뉴 선택: ");

								int adminChoice = sc.nextInt();

								switch (adminChoice) {

								case 1:
									// 로그아웃
									System.out.println("로그아웃합니다.");
									break;

								case 2:
									// 모든 회원 정보 조회
									pstmt = con.prepareStatement("SELECT * FROM member");
									rs = pstmt.executeQuery();

									while (rs.next()) {
										System.out.println("================================");
										System.out.println("ID: " + rs.getString("m_id"));
										System.out.println("PWD: " + rs.getString("m_pwd"));
										System.out.println("UVY: " + rs.getString("m_sName"));
										System.out.println("MAYOR: " + rs.getString("m_major"));
										System.out.println("ADMIN:" + rs.getString("Is_Admin"));
										System.out.println("================================");
									}

									break;
								case 3:
									System.out.println("삭제할 회원의 아이디를 입력해주세요.");
									// 특정 회원 삭제
									String memberId = sc.next();
									pstmt = con.prepareStatement("DELETE FROM member WHERE m_id=?");
									pstmt.setString(1, memberId);
									int deleteCount = pstmt.executeUpdate();

									if (deleteCount > 0) {
										System.out.println("회원 삭제가 완료되었습니다.");
									} else {
										System.out.println("존재하지 않는 회원입니다.");
									}

									break;

								case 4:
									// 게시판 삭제

									break;

								default:
									System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
									break;
								}
								if (adminChoice == 1) {
									isAdmin = null;
									break;
								}
							}
						} else {
							// 일반 회원 메뉴
							System.out.println("1. 로그아웃");
							System.out.println("2. 게시판 조회");
							System.out.println("3. 게시글 만들기");
							System.out.println("4. 시간표 ");
							System.out.println("5. 기숙사 ");
							System.out.println("6. 학점");
							System.out.print("메뉴 선택: ");

							int memberChoice = sc.nextInt();

							switch (memberChoice) {
							case 1:
								// 로그아웃
								System.out.println("로그아웃합니다.");
								isAdmin = null;
								break;

							case 2:
								break;
								// 게시판 조회
							case 3:
								// 게시글 만들기
								break;
							case 4:
								// 시간표
								break;
							case 5:
								// 기숙사
								break;
							case 6:
								// 학점

								break;
							}
						}
					}
				} else {
					System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
				}

				break;

			case 3:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				break;
			}
		}
	}
}