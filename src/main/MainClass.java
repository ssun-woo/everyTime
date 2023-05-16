package main;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		
		while(true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");
			try {
				choice = scan.nextInt();
			}catch(Exception e) {
				choice = 0;
				scan.nextLine();
			}
			
			switch(choice) {
			case 1 : 
				System.out.println("회원가입");
				break;
			case 2 :
				System.out.println("로그인");
				
				if(true/*로그인성공*/) {
					
					// 로그인한 아이디의 logon을 1로 바꿈
					
					if(true/*성공한 아이디 .equals admin*/) {
						while(true) {
							System.out.println("1.로그아웃");
							System.out.println("2. 전체 회원 보기");
							System.out.println("3. 특정 회원 보기");
							System.out.println("4. 특정 회원 보기");
							System.out.println("5. 특정 회원 삭제");
							System.out.println("6. 게시판");
							
							int choice2 = scan.nextInt();
							
							switch(choice2) {
					
							}
						
							
					}
						
					
					while(true) {
						System.out.println("1.로그아웃");
						// 로그인한 아이디의 logon을 다시 0으로 바꿈
						
						System.out.println("2.게시판");
						
						// 2를 입력받으면 다시 
						// 1. 전체글 보기
						// 2. 아이디로 게시글 찾기
						// 3. ...
						System.out.println("개인 정보 수정");
						System.out.println("탈퇴");
						System.out.println("3.기숙사");
						// 해당하는 학교에는 기숙사가 없습니다 (d_room == 0일경우)
						// d_room != 0 d_room = n
						// 현재 남은 기숙사 방은 "n"개 입니다
						// 예약하시겠습니까 ?
						// 1. 예 ( > 예약됐습니다)
						// d_room -= 1;
						// m_dorCheck = 1;
						
						// 2. 아니요 (전으로 돌아감)
						
						System.out.println("4.학점관리");
						System.out.println("5.시간표");
						
						
						
						
					}
					
				}
				
				break;
			case 3: 
				System.out.println("프로그램 종료");
				System.exit(1);
			default :
				System.out.println("잘못된 입력입니다");
				break;
				
			}
		}
		
		
	}
}
