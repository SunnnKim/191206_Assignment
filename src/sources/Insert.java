package sources;

import java.util.Scanner;

public class Insert {
	
		Scanner sc = new Scanner(System.in);
		private int memNumber;
		public Insert()  {
			
		}
		
		
	public boolean process(String[] str, int choice) {
		Singleton singleton= Singleton.getInstance();
		memNumber= singleton.getMemNumber();
		
		
		Human human = null;
		
		if(choice == 1) { // 투수
			try {
				String name = str[0];
				int age = Integer.parseInt(str[1]);
				double height = Double.parseDouble(str[2]);
				String bday = str[3];
				int win = Integer.parseInt(str[4]);
				int lose = Integer.parseInt(str[5]);
				double defence = Double.parseDouble(str[6]);
				human = new Pitcher(memNumber, name, age, height, bday, 
										win, lose, defence);
			}catch (Exception e) {
				return false;
			}
		
			
		}else if(choice == 2) { // 타자
			
		try {
			String name = str[0];
			int age = Integer.parseInt(str[1]);
			double height = Double.parseDouble(str[2]);
			String bday = str[3];
			int batcount = Integer.parseInt(str[4]);
			int hitcount = Integer.parseInt(str[5]);
			double hitAvg = Double.parseDouble(str[6]);
			
			human = new Batter(memNumber+1000, name, age, height,bday, 
									batcount, hitcount, hitAvg);
		
			}catch (Exception e) {
				return false;
		}
		// 선수등록 :1000, 2001, 2002, 1003 
		// map에 추가
			
		}	
	
		singleton.getMap().put(human.getName(), human);
		singleton.setMemNumber(memNumber+1);
		return true;
	}
	

}
