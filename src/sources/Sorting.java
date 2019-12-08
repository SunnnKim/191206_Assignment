package sources;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Sorting {
	HashMap<String, Human> originalMap;

	public Sorting() {
		Singleton singleton = Singleton.getInstance();
		originalMap = singleton.getMap();
	}

	public Object[][] process(int num) {
		HashMap<String, Human> hashMap = new HashMap<String, Human>(); // 방어율
		HashMap<String, Human> hashMap2 = new HashMap<String, Human>(); // 타율
		// 들어갈 내용
		// "투수번호","이름","타수","안타수","타율"
		Object[][] str = null;
		// 데이터 나누기
		Iterator<String> it = originalMap.keySet().iterator();
		int w = 0; // 같은 키 값이 들어가지 않도록 할 변수
		while (it.hasNext()) {
			String key = it.next();
			Human h = originalMap.get(key);
			if (h instanceof Pitcher) {
				Pitcher p = (Pitcher) h;
				hashMap.put(p.getDefence() + "" + w, p);
				w++;
			} else {
				Batter b = (Batter) h;
				hashMap2.put(b.getHitAvg() + "" + w, b);
				w++;
			}

		}

		// 투수/타자 데이터반환 정하기
		if (num == 1) { // 투수
			TreeMap<String, Human> tMap = new TreeMap<String, Human>(hashMap);
			Iterator<String> updownIt = tMap.keySet().iterator();
			str = new Object[tMap.size()][5];
			// 들어갈 내용
			// "투수번호","이름","승","패","방어율"
			w = 0;
			while (updownIt.hasNext()) {
				String key = updownIt.next();
				Pitcher h = (Pitcher) tMap.get(key);
				str[w][0] = h.getNumber();
				str[w][1] = h.getName();
				str[w][2] = h.getWin();
				str[w][3] = h.getLose();
				str[w][4] = h.getDefence();
				w++;
			}

		} else if (num == 2) { // 타자
			TreeMap<String, Human> tMap = new TreeMap<String, Human>(hashMap2);
			Iterator<String> updownIt = tMap.descendingKeySet().iterator();
			str = new Object[tMap.size()][5];
			// 들어갈 내용
			// "투수번호","이름","타수","안타수","타율"
			w = 0;
			while (updownIt.hasNext()) {
				String key = updownIt.next();
				Batter h = (Batter) tMap.get(key);
				str[w][0] = h.getNumber();
				str[w][1] = h.getName();
				str[w][2] = h.getBatcount();
				str[w][3] = h.getHitcount();
				str[w][4] = h.getHitAvg();
				w++;
			}

		}
		return str;

	}

}
