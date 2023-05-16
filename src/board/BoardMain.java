package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num=0,count=0;
		String id=null,pwd=null,title=null,contents=null;
		
		BoardTest bt = new BoardTest();
		
		while(true) {		
			System.out.println("게시판");
			System.out.println("======================");
			System.out.println("1. 게시물 보기");
			System.out.println("2. 게시물 작성");
			System.out.println("3. 게시물 수정");
			System.out.println("4. 게시물 삭제");
			System.out.println("5. 나가기");
			System.out.println("======================");
			num=scan.nextInt();
			
			switch(num) {
			case 1 : 
				ArrayList<BoardDTO> list = bt.bVeiw();
				System.out.println("번호/작성자 ID/제목/작성 날짜");
				System.out.println("-----------------------");
				for(BoardDTO m : list) {
					System.out.print(m.getNum()+"\t");
					System.out.print(m.getId()+"\t" );
					System.out.print(m.getTitle()+"\t" );
					System.out.println(m.getDate());
				}
				System.out.println("-----------------------");
				System.out.println("확인할 게시물의 번호를 입력해주세요");
				int bnum = scan.nextInt();
				
				BoardDTO dto = bt.bVeiw_con(bnum);
				if (dto != null) {
				System.out.println("-----------------------");
				System.out.println("작성자 : " + dto.getId()); 
				System.out.println("게시물 번호 : " + dto.getNum()); 
				System.out.println("제목 : " + dto.getTitle()); 
				System.out.println("날짜 : " + dto.getDate()); 
				System.out.println("내용 : " + dto.getContents()); 
				System.out.println("-----------------------");
				}else {
					System.out.println("해당 글은 없습니다.");
				}
				break;
			case 2 :
				System.out.println("게시물을 작성합니다.");
				System.out.println("-----------------------");
				System.out.println("작성자 ID : ");
				id = scan.next();
				System.out.println("글 제목 :");
				title = scan.next();
				System.out.println("글 내용 :");
				contents = scan.next();
				System.out.println("글 비밀번호 :");
				pwd = scan.next();
				
				BoardDTO bd = new BoardDTO();
				bd.setId(id);
				bd.setTitle(title);
				bd.setContents(contents);
				bd.setPwd(pwd);
				int result = bt.bWirte(bd);
				if(result!=-1) {
					System.out.println("게시물이 등록되었습니다.");
				}
				break;
			case 3 :
				System.out.println("게시물을 수정합니다.");
				System.out.println("-----------------------");
				System.out.println("작성자ID를 입력하세요.");
				id=scan.next();
				int i1 = bt.search(id);
				if (i1 == -1) {
					System.out.println("아이디가 존재하지 않습니다.");
				}else {
					System.out.println("수정할 게시물의 번호를 입력하세요");
					int choice = scan.nextInt();
					System.out.println("수정할 내용을 입력하세요.");
					contents = scan.next();
					if(bt.bEdit(choice, contents)!=0) {
						System.out.println(id+"님의 " +choice+"번 게시물을 수했습니다.");
					}
				}
				break;
			case 4 :
				System.out.println("게시물을 삭제합니다.");
				System.out.println("-----------------------");
				System.out.println("작성자ID를 입력하세요.");
				id=scan.next();
				int i = bt.search(id);
				if (i == -1) {
					System.out.println("아이디가 존재하지 않습니다.");
				}else {
					System.out.println("삭제할 게시물의 번호를 입력하세요");
					int choice = scan.nextInt();
					if(bt.bDelete(choice)!=0) {
						System.out.println(id+"님의 " +choice+"번 게시물을 삭제했습니다.");
					}
				}
				break;
					default : 
					System.out.println("게시판을 나갑니다.");
					System.exit(0);
			}
		}
	}
}

