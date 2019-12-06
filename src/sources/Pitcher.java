package sources;

public class Pitcher extends Human {
	
	private int win;
	private int lose;
	private double defence;
	
	// 생성자
	public Pitcher() {
		super();
		
	}
	public Pitcher(int number, String name, int age, double height,String bDay,int win, int lose, double defence) {
		super(number, name, age, height,bDay);
		this.win = win;
		this.lose = lose;
		this.defence = defence;
	}
	
	
	// getter / setter
	
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public double getDefence() {
		return defence;
	}
	public void setDefence(double defence) {
		this.defence = defence;
	}
	
	
	public void infomation() {
		super.infomation();
		System.out.print(" 승: "+ win);
		System.out.print(" 패: "+ lose);
		System.out.print(" 방어율: "+ defence + "\n");
	}
	
	
	
	@Override
	// DB에 입력할 때 toString 사용해서 토큰까지 넣음
	public String toString() {
		return super.toString() + "-" + win + "-" + lose + "-" + defence;
	}

	
	

}
