package sources;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;


public class Sorting implements DaoInterface {
	
	Scanner sc = new Scanner(System.in);
	HashMap<String,Human> originalMap;
	
	public Sorting() throws Exception {
		Singleton singleton = Singleton.getInstance();
		originalMap = singleton.getMap();
	}
	
	public void process() {
		Scanner sc = new Scanner(System.in);
		HashMap<String,Human> hashMap = new HashMap<String, Human>();	// 방어율
		HashMap<String,Human> hashMap2 = new HashMap<String, Human>();	// 타율
		
		Iterator<String> it = originalMap.keySet().iterator();
		int w = 0; // 같은 키 값이 들어가지 않도록 할 변수
		while(it.hasNext()) {
			String key = it.next();
			Human h = originalMap.get(key);
			if(h instanceof Pitcher ) {
				Pitcher p =(Pitcher)h;
				hashMap.put( p.getDefence() + "" + w, p);
				w++;
			}else {
				Batter b = (Batter)h;
				hashMap2.put( b.getHitAvg() + "" + w, b);
				w++;
			}
			
		}
		System.out.println("1.방어율순 보기 2.타율순 보기");
		int num;
		try {
			num= sc.nextInt();
		} catch (Exception e) {
			num = -1;
		}
		if(num == 1) {
		TreeMap<String,Human> tMap = new TreeMap<String, Human> (hashMap);
		Iterator<String> updownIt = tMap.keySet().iterator();
		while(updownIt.hasNext()) {
			String key = updownIt.next();
			Pitcher h = (Pitcher)tMap.get(key);
			System.out.println(" ID : "+ h.getNumber() + " 선수: " + h.getName() + " 방어율: " +h.getDefence());
			}
		}else if ( num == 2) {
			TreeMap<String,Human> tMap = new TreeMap<String, Human> (hashMap2);
			Iterator<String> updownIt = tMap.keySet().iterator();
			while(updownIt.hasNext()) {
				String key = updownIt.next();
				Batter h = (Batter)tMap.get(key);
				System.out.println(" ID : "+ h.getNumber()+ " 선수: " + h.getName()+" 타율: "  + h.getHitcount());
				}

		}else {
			System.out.println("잘못입력했습니다.");
		}
	}
	
	
	
	
	
}
