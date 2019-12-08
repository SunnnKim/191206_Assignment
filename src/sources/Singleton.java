package sources;

import java.util.HashMap;


public class Singleton {
	private static Singleton singleton;
	// HashMap이 들어있는 Singleton
	private HashMap<String, Human> map = new HashMap<String,Human>();
	private int memNumber = 1000;	// sequence number : 아이디 값 주기
	
	// 싱글톤 호출하는 메소드
	public static Singleton getInstance()  {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
	
	
	// 생성자
	private Singleton() {
		map = new HashMap<String, Human>();
	}

	// getter / setter
	public int getMemNumber() {
		return memNumber;
	}

	public void setMemNumber(int memNumber) {
		this.memNumber = memNumber;
	}

	public HashMap<String, Human> getMap(){
		return map;
	}
	
	
	
}
