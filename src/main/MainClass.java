package main;

import java.util.ArrayList;
import java.util.Scanner;

import dormitory.DormitoryDTO;
import dormitory.DormitoryService;
import dormitory.DormitoryServiceImpl;
import score.ScoreDTO;
import score.ScoreService;
import score.ScoreServiceImpl;

public class MainClass {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		DormitoryService ds = new DormitoryServiceImpl();
		ScoreService ss = new ScoreServiceImpl();
		DormitoryDTO ddto = null;
		ScoreDTO sdto = null;
		ArrayList<ScoreDTO> slist = null;

		int choice = 0;

		while (true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");
			try {
				choice = scan.nextInt();
			} catch (Exception e) {
				choice = 0;
				scan.nextLine();
			}

			switch (choice) {
			case 1:
				System.out.println("회원가입");
				break;
			case 2:
				System.out.println("로그인");
				boolean bool = true;
				if (bool == true/* 로그인성공 */) {
					// MemberDTO mdto = ms.getDto();
					if (bool != true/* 로그인아이디.equals"admin" */) {
						while (true) {
							System.out.println("1.로그아웃");
							System.out.println("2. 전체 회원 보기");
							System.out.println("3. 특정 회원 보기");
							System.out.println("5. 특정 회원 삭제");
							System.out.println("6. 게시판");
							System.out.print("입력 : ");
							int choice2 = scan.nextInt();

							switch (choice2) {
							case 1:
								return;
							case 2:
								return;
							case 3:
								return;
							case 4:
								return;
							case 5:
								return;
							case 6:
								return;
							default:
								return;
							}

						}
					} else {
						while (true) {
							System.out.println("1. 로그아웃");
							System.out.println("2. 게시판");
							System.out.println("3. 학점");
							System.out.println("4. 기숙사");
							System.out.println("5. 정보 수정");
							int choice3 = scan.nextInt();

							switch (choice3) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								while (true) {
									System.out.println("1. 성적 및 학점 보기");
									System.out.println("2. 성적 및 학점 등록");
									System.out.println("3. 성적 및 학점 수정");
									System.out.println("4. 목표학점 확인 및 설정");
									System.out.println("5. 돌아가기");
									int choice4;
									try {
										choice4 = scan.nextInt();
									} catch (Exception e) {
										choice4 = 0;
										scan.nextLine();
									}
									switch(choice4) {
									case 1:
										slist = ss.scoreList(mdto.getM_id);
										if(slist.isEmpty()) {
											System.out.println("현재 등록된 학점이 없습니다!");
										}else {
											System.out.println("학번 : " + mdto.getM_id);
											System.out.println("강의명\t\t학점\t등급\t전공여부");
											String s1 = null;
											for(ScoreDTO s : slist) {
												System.out.print("강의명 : " + s.getS_cName() +"\t");
												System.out.print("학점 : " + s.getS_credit() + "\t");
												System.out.println("등급 : " + s.getS_grade() + "\t");
												if(s.getS_mCheck() == 1) {
													s1 = "O"; 
												}else {
													s1 = "X";
												}
												System.out.println("전공여부 : " + s1);
											}
										}
										
										break;
									case 2:
										System.out.println("성적 및 학점 등록");
										
										System.out.print("강의명 입력 : ");
										String cName = scan.next();
										
										System.out.print("학점 입력 : ");
										int credit = scan.nextInt();
										
										System.out.print("등급 입력 : ");
										String grade = scan.next();
										
										System.out.println("전공 여부");
										System.out.println("1.O\t2.X");
										int mCheck;
										while((mCheck == 1 || mCheck == 2) == false) {
											System.out.println("잘못된 입력입니다 다시 입력하세요");
											try {
												 mCheck = scan.nextInt();
											}catch(Exception e) {
												scan.nextLine();
												mCheck = 0;
											}
										}
										
										int result = ss.inputScore(cName,credit ,grade,mCheck);
										
										if(result == 1) {
											System.out.println("등록됐습니다");
										}else {
											System.err.println("오류발생");
										}
										
										break;
									case 3:
										System.out.println("성적 및 학점 수정");
										
										System.out.print("기존 강의명 입력 : ");
										String originCname = scan.next();
										
										if(ss.searchCname(mdto.getM_id, originCname)) {
											System.out.print("수정할 강의명 입력 : ");
											String updateCname = scan.next();
											
											System.out.print("수정할 학점 입력 : ");
											int credit2 = scan.nextInt();
											
											System.out.print("수정할 등급 입력 : ");
											String grade2 = scan.next();
											
											System.out.println("전공 여부");
											System.out.println("1.O\t2.X");
											int mCheck2;
											while((mCheck2 == 1 || mCheck2 == 2) == false) {
												System.out.println("잘못된 입력입니다 다시 입력하세요");
												try {
													 mCheck2 = scan.nextInt();
												}catch(Exception e) {
													scan.nextLine();
													mCheck2 = 0;
												}
											}
											
											int result2 = ss.updateScore(mdto.getM_id, originCname, updateCname, credit2, grade2, mCheck2);
											
											if(result2 == 1) {
												System.out.println("정상적으로 업데이트 됐습니다");
											}
											
											
										}else{
											System.out.println("해당하는 강의명이 없습니다");
										}
										
										break;
									case 4 :
										System.out.println("목표학점 확인 및 확인");
										
										if(ss.getGoal(mdto.getM_id) == false) {
											System.out.println("현재 등록된 학점이 없습니다");
											System.out.println("등록할 학점을 입력하세요 : ");
											int goal = scan.nextInt();
											
											int result3 = ss.updateGoal(mdto.getM_id, goal);
											if(result3 >= 1) {
												System.out.println("수정됐습니다");
											}
											
										}else {
											System.out.println("현재 목표 학점은 "  + ss.getGoal2(mdto.getM_id) + "점 입니다");
										}
										
										
										
										
										return;
									default :
										System.out.println("잘못된 입력입니다");
										break;
										
									}

								}

								break;

							case 4:
								ddto = ds.remainRoom(mdto.getM_name);
								if (ddto.getD_room() == 0) {
									System.out.println("현재" + ddto.getD_sName() + "대학교에 예약 가능한 방이 없습니다");
								} else {
									if (mdto.getM_doriCheck != 1) {

										System.out.println(
												"현재" + ddto.getD_sName() + "대학교에 가능한 방이" + ddto.getD_room() + "개 있습니다");
										System.out.println("예약하시겠습니까 ?");
										System.out.println("1.예\t2.아니오");
										int dormiChoice;

										try {
											dormiChoice = scan.nextInt();
										} catch (Exception e) {
											dormiChoice = 0;
											scan.nextLine();
										}

										if (dormiChoice == 1) {
											int result = ds.updateRoom(mdto.getM_sName);
											if (result == 1) {
												System.out.println("예약이 완료됐습니다");
												ds.updateRoom(mdto.getM_sName);
												ms.dormiCheckUp(mdto.getM_id); // 기숙사 카운트 1로 바꾸는 sql
											} else {
												System.out.println("예약에 실패했습니다");
											}
										} else if (dormiChoice == 2) {
											System.out.println("이전단계로 돌아갑니다");
											break;
										} else {
											System.out.println("잘못된 입력입니다");
										}

									} else {
										System.out.println("이미 예약한 방이 있습니다");
										System.out.println("예약을 취소하시겠습니까 ?");
										System.out.println("1.네\t2.아니오");
										int cancelChoice;

										try {
											cancelChoice = scan.nextInt();
										} catch (Exception e) {
											cancelChoice = 0;
											scan.nextLine();
										}

										if (cancelChoice == 1) {
											System.out.println("예약이 취소됐습니다!");
											ds.cancleRoom(mdto.getM_sName);
											ms.dormiCheckDown(mdto.getM_id); // 기숙사 카운트 0으로 바꾸는 sql
										}

									}
								}
								break;
							default:
								break;
							}
						}
					}
				} else {
					System.out.println("아이디와 비밀번호 확인");
				}

//				
//				if(true/*로그인성공*/) {
//					
//					// 로그인한 아이디의 logon을 1로 바꿈
//					
//					if(true/*성공한 아이디 .equals admin*/) {
//						while(true) {
//							System.out.println("1.로그아웃");
//							System.out.println("2. 전체 회원 보기");
//							System.out.println("3. 특정 회원 보기");
//							System.out.println("5. 특정 회원 삭제");
//							System.out.println("6. 게시판");
//							
//							return;	
//						}
//					}else {
//						while(true) {
//							System.out.println("1.로그아웃");
//							// 로그인한 아이디의 logon을 다시 0으로 바꿈
//							
//							System.out.println("2.게시판");
//							
//							// 2를 입력받으면 다시 
//							// 1. 전체글 보기
//							// 2. 아이디로 게시글 찾기
//							// 3. ...
//							System.out.println("개인 정보 수정");
//							System.out.println("탈퇴");
//							System.out.println("3.기숙사");
//							// 해당하는 학교에는 기숙사가 없습니다 (d_room == 0일경우)
//							// d_room != 0 d_room = n
//							// 현재 남은 기숙사 방은 "n"개 입니다
//							// 예약하시겠습니까 ?
//							// 1. 예 ( > 예약됐습니다)
//							// d_room -= 1;
//							// m_dorCheck = 1;
//							
//							// 2. 아니요 (전으로 돌아감)
//							System.out.println("4.학점관리");
//							System.out.println("5.시간표");
//							return;
//						}
//					}
//				}

				break;
			case 3:
				System.out.println("프로그램 종료");
				System.exit(1);
			default:
				System.out.println("잘못된 입력입니다");
				break;

			}
		}

	}
}
