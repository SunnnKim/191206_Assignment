package sources;

import java.util.Calendar;

public class Human {

	private int number;	// 시퀀스 넘버, 중복되지 않음
	private String name;
	private int age;
	private double  height;
	private Calendar bday;

	
	public Human() {
		
	}


	
	public Human(int number, String name, int age, double height, String strBday) {
		this.number = number;
		this.name = name;
		this.age = age;
		this.height = height;
		String[]split = strBday.split("/");
		bday= Calendar.getInstance();
		bday.set(Calendar.YEAR, Integer.parseInt(split[0]));
		bday.set(Calendar.MONTH, Integer.parseInt(split[1])-1);
		bday.set(Calendar.DATE, Integer.parseInt(split[2]));
	}



	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public void infomation() {
		System.out.print("이름:" + name + " ");
		System.out.print("나이:" + age + " ");
		System.out.print("신장:" + height + " ");
		System.out.print("생년월일: " + bday.get(Calendar.YEAR)+"/"+ (bday.get(Calendar.MONTH)+1)
						+ "/"+ bday.get(Calendar.DATE));
		
	}
	

	
	@Override
	public String toString() {
		return number + "-" + name + "-" + age + "-" + height 
				+ "-"+bday.get(Calendar.YEAR)+"/"+(bday.get(Calendar.MONTH)+1)
				+"/"+bday.get(Calendar.DATE);
	}



	public String getBday() {
		String b = bday.get(Calendar.YEAR)+"/"+(bday.get(Calendar.MONTH)+1)
				+"/"+bday.get(Calendar.DATE);
		return b;
	}



	public void setBday(Calendar bday) {
		this.bday = bday;
	}
	
	
	
	
	
}
