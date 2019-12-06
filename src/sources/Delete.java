package sources;

import java.util.Scanner;


public class Delete {
	
	public Delete() {
		
	}
	
	
	public boolean process(String name)  {
		Singleton singleton = Singleton.getInstance();
		Human getHuman = singleton.getMap().get(name);
		if(getHuman == null || getHuman.getName().equals("")) {
			return false;
		}
		singleton.getMap().remove(name);
		return true;
	}
	

}
