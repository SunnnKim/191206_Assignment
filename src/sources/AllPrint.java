package sources;

import java.util.Iterator;


public class AllPrint  {

	public Object[][] process(int choice)  {
		Singleton singleton = Singleton.getInstance();
		
		int pSize = 0;
		int bSize = 0;
		
		Iterator<String> it = singleton.getMap().keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			Human h  = singleton.getMap().get(key);
				if( h instanceof Pitcher)	pSize++;
				else if( h instanceof Batter) bSize++;
		}
		
		Iterator<String>it2 = singleton.getMap().keySet().iterator();
	
		
		if(choice == 1) {	// 투수
			Object[][] strData1 = new Object[pSize][8];
			int w=0;
			while(it2.hasNext()) {
				String key = it2.next();
				Human h = singleton.getMap().get(key);
				if(h instanceof Pitcher) {
				strData1[w][0] = h.getNumber();
				strData1[w][1] = h.getName();
				strData1[w][2] = h.getAge();
				strData1[w][3] = h.getHeight();
				strData1[w][4] = h.getBday();
				
				Pitcher p = (Pitcher) h;
				strData1[w][5] = p.getWin();
				strData1[w][6] = p.getLose();
				strData1[w][7] = p.getDefence();
				w++;
				}
				
			}
		
			return strData1;
		}
		else {	// 타자
			Object[][] strData2 = new Object[bSize][8];
			
			int w=0;
			while(it2.hasNext()) {
			
				String key = it2.next();
				Human h=singleton.getMap().get(key);
				if(h instanceof Batter){
				strData2[w][0] = h.getNumber();
				strData2[w][1] = h.getName();
				strData2[w][2] = h.getAge();
				strData2[w][3] = h.getHeight();
				strData2[w][4] = h.getBday();
			
			
				Batter b = (Batter) h;
				strData2[w][5] = b.getBatcount();
				strData2[w][6] = b.getHitcount();
				strData2[w][7] = b.getHitAvg();

				w++;
			}
			
		}
			return strData2;	
		}
		
			
	
	}
	
	
	
	
	
}
