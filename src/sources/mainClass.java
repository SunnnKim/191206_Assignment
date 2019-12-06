package sources;

import java.util.Scanner;


public class mainClass {
	public static void main(String[] args) throws Exception {
		
	/*
 		Singleton 과제
 		
 		human : 
 		DAO 지우고 클래스 생성
 		1. insert / delete / select / update Class
 		   sorting / file
 		 ---> main에서 생성
 		2. Singleton : HashMap 생성하기 
 		3. mainClass : 모든 메소드클래스들 생성하고 
 
	 */
		// 인터페이스로 바꿔보기!
		
		Scanner sc = new Scanner(System.in);
		
		DaoInterface dao = null;
		
		
		
		System.out.println(" < Baseball players >");
			while(true) {
				dao = null;
				System.out.println("1. 선수 추가하기");
				System.out.println("2. 선수 삭제하기");
				System.out.println("3. 선수 검색하기");
				System.out.println("4. 선수 수정하기");
				System.out.println("5. 선수 전체보기");
				System.out.println("6. 타율/방어율 순으로 보기");
				System.out.println("7. 파일로 저장하기");
				System.out.println("0. 종료하기");
				System.out.print(">> ");
				int choice;
				try {
					choice= sc.nextInt();
				} catch (Exception e) {
					choice = -1;
				}
				if(choice == 1) {
					//추가
					dao = new Insert();
				}else if(choice == 2) {
					//삭제
					dao = new Delete();
				}else if(choice == 3) {
					// 검색
					dao = new Select();
				}else if(choice == 4) {
					// 수정 
					dao = new Update();
				}else if(choice == 5) {
					// 전체보기
					dao = new AllPrint();
				}else if(choice == 6) {
					// 타율/방어율 순으로 보기
					dao = new Sorting();
				}else if(choice == 7) {
					// 파일로 저장 
//					dataCls.writeFile();
				}else if(choice == 0) {
					System.out.println("종료합니다.");
					break;
				}else {
					System.out.println("잘못 누르셨습니다.");
				}
				
				if(dao != null) dao.process();
		}
		
		sc.close();
		
				
		
	}
}
