package sources;

import java.util.Scanner;


public class Update {

	Singleton singleton;
	
	public Update() {
		
	}
	
	
	public boolean process(String[] str) {
		singleton = Singleton.getInstance();
		if( str == null) {
			return false;
		}
		Human getHuman = singleton.getMap().get(str[1]);
		try {
		if( getHuman.getNumber() < 2000 )  {	// 투수
			getHuman.setAge(Integer.parseInt(str[2]));
			getHuman.setHeight(Double.parseDouble(str[3]));
			getHuman.setBday(str[4]);
			((Pitcher)getHuman).setWin(Integer.parseInt(str[5]));
			((Pitcher)getHuman).setLose(Integer.parseInt(str[6]));
			((Pitcher)getHuman).setDefence(Double.parseDouble(str[7]));
	
		
		
		}else {	// 타자
//			Batter b = (Batter)getHuman;
			getHuman.setAge(Integer.parseInt(str[2]));
			getHuman.setHeight(Double.parseDouble(str[3]));
			getHuman.setBday(str[4]);
			((Batter)getHuman).setBatcount(Integer.parseInt(str[5]));
			((Batter)getHuman).setHitcount(Integer.parseInt(str[6]));
			((Batter)getHuman).setHitAvg(Double.parseDouble(str[7]));
			
		}

		singleton.getMap().replace(getHuman.getName(),getHuman);
		return true;
	}catch(Exception e){
			return false;
		}
		
		}
	
	
	
	
}
