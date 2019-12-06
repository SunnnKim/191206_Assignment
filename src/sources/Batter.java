package sources;

public class Batter extends Human{
	
	private int batcount;
	private int hitcount;
	private double hitAvg;

	
	public Batter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Batter(int number, String name, int age, double height,String bDay, int batcount, int hitcount, double hitAvg) {
		super(number, name, age, height,bDay);
		this.batcount = batcount;
		this.hitcount = hitcount;
		this.hitAvg = hitAvg;
	}


	public int getBatcount() {
		return batcount;
	}

	public void setBatcount(int batcount) {
		this.batcount = batcount;
	}

	public int getHitcount() {
		return hitcount;
	}

	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}

	public double getHitAvg() {
		return hitAvg;
	}

	public void setHitAvg(double hitAvg) {
		this.hitAvg = hitAvg;
	}

	public void infomation() {
		// TODO Auto-generated method stub
		super.infomation();
		System.out.print(" 타수: "+ batcount);
		System.out.print(" 안타수: "+ hitcount);
		System.out.print(" 타율: "+ hitAvg+"\n");
	}
	
	
	@Override
	public String toString() {
		return super.toString() +"-" + batcount + "-" + hitcount + "-" + hitAvg;
	}

	
	
	
	

}
