package sources;

import java.util.Scanner;


public class Update implements DaoInterface {

	Scanner sc = new Scanner(System.in);
	Singleton singleton;
	
	public Update() throws Exception {
		singleton = Singleton.getInstance();
	}
	
	
	public void process() {
		System.out.println("수정하고 싶은 선수명을 입력해주십시오.");
		System.out.print(">> ");
		String name = sc.next();
		Human getHuman = singleton.getMap().get(name);
		if(getHuman == null || getHuman.getName().equals("")) {
			System.out.println("데이터를 찾을 수 없습니다.");
			return;
		}
		
		System.out.println("수정할 데이터를 입력하시오.");
		if( getHuman.getNumber() < 2000 )  {	// 투수
			Pitcher p = (Pitcher)getHuman;
			System.out.println("승 : ");
			int win = sc.nextInt();
			System.out.println("패 : ");
			int lose = sc.nextInt();
			System.out.println("방어율 : ");
			double defence = sc.nextDouble();
			
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);
		}else {	// 타자
			Batter b = (Batter)getHuman;
			System.out.println("타수 : ");
			int batcount = sc.nextInt();
			System.out.println("안타수 : ");
			int hitcount = sc.nextInt();
			System.out.println("타율 : ");
			double hitAvg = sc.nextDouble();
			
			b.setBatcount(batcount);
			b.setHitcount(hitcount);
			b.setHitAvg(hitAvg);
		}
		
		System.out.println("데이터를 수정했습니다.");
		singleton.getMap().put(getHuman.getName(), getHuman);
		
	}
	
	
	
	
}
