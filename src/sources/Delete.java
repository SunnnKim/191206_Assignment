package sources;

import java.util.Scanner;


public class Delete implements DaoInterface {
	
	Scanner sc = new Scanner(System.in);
	
	
	public Delete() throws Exception {
		
	}
	
	
	public void process() throws Exception {
		System.out.println("방출하고 싶은 선수명을 입력해주십시오.");
		System.out.print(">> ");
		String name = sc.next();
		Singleton singleton = Singleton.getInstance();
		Human getHuman = singleton.getMap().get(name);
		if(getHuman == null || getHuman.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다.");
			return;
		}
		singleton.getMap().remove(name);
		System.out.println(getHuman.getName()+" 선수의 데이터가 삭제되었습니다.");
	}
	

}
