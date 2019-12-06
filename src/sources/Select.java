package sources;



public class Select  {
	
	
	public Select()  {
		
	}
	
	public Object[] process(String name)   {
		Singleton singleton = Singleton.getInstance();
		Human getHuman = singleton.getMap().get(name);
		
		Object[] str = null;
		if(getHuman ==null) return str;
		if(getHuman instanceof Pitcher) {
			Pitcher p = (Pitcher)getHuman;
			str = new Object[8];
			str[0] = p.getNumber();
			str[1] = p.getName();
			str[2] = p.getAge();
			str[3] = p.getHeight();
			str[4] = p.getBday();
			str[5] = p.getWin();
			str[6] = p.getLose();
			str[7] = p.getDefence();
		}else {
			Batter p = (Batter)getHuman;
			str = new Object[8];
			str[0] = p.getNumber();
			str[1] = p.getName();
			str[2] = p.getAge();
			str[3] = p.getHeight();
			str[4] = p.getBday();
			str[5] = p.getBatcount();
			str[6] = p.getHitcount();
			str[7] = p.getHitAvg();
		}
		
		return str;
	}

}
