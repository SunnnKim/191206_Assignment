package sources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;



public class FileData {
	
private File file;
	
	public FileData(String filename) {
		
		// 나중에 여기 바꾸기!!
		file = new File("d:\\tmp\\"+filename +".txt");
		createfile();
	}
	
	public void createfile() {
		try {
			if(file.createNewFile()) {		
//				System.out.println("파일 생성 성공!");
			}else{			
//				System.out.println("이미 있는 파일 불러오기");
			}
		} catch (IOException e) {			 
			e.printStackTrace();
		}
	}
	
	
	
	public void writeFile() throws Exception {
		Singleton singleton = Singleton.getInstance();
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			Iterator<String> it = singleton.getMap().keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				Human h = singleton.getMap().get(key);
				pw.println(h.toString());
			}
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println("파일에 성공적으로 기입했습니다.");
		
	}
	
	// 파일 생성해서 dao에 바로 넘겨주기 
	public void readFile() throws Exception{
		Singleton singleton = Singleton.getInstance();
		if(checkBeforeReadFile(file)) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";
			Human human = null;
			while((str= br.readLine())!=null) {
				String splits[] = str.split("-");
				// 투수
				if(Integer.parseInt(splits[0]) < 2000) {
					human = new Pitcher(Integer.parseInt(splits[0]),
										splits[1],
										Integer.parseInt(splits[2]),
										Double.parseDouble(splits[3]),
										splits[4],
										Integer.parseInt(splits[5]),
										Integer.parseInt(splits[6]),
										Double.parseDouble(splits[7]));
					
					singleton.getMap().put(human.getName(), human);
					}
				// 타자
				else {
					human = new Batter(Integer.parseInt(splits[0]),
											splits[1],
											Integer.parseInt(splits[2]),
											Double.parseDouble(splits[3]),
											splits[4],
											Integer.parseInt(splits[5]),
											Integer.parseInt(splits[6]),
											Double.parseDouble(splits[7]));
					
					singleton.getMap().put(human.getName(), human);
				}
				

			}
		}
		else {
//			System.out.println("파일이 없거나 읽을 수 없습니다.");
		}
		if(singleton.getMap().size()>0) {
			Iterator<String> it = singleton.getMap().keySet().iterator();
			int lastNum = 0;
			while(it.hasNext()) {
				String key = it.next();
				Human h = singleton.getMap().get(key);
				int lastMemNum = h.getNumber();
				if(lastMemNum >= 2000 )	// 2000번 이상 일경우 -1000하기
					lastMemNum -= 1000;
				if(lastNum < lastMemNum) lastNum = lastMemNum;
				
			}
			singleton.setMemNumber(lastNum+1);
		}
		
		
	}
	// 파일이 있고 읽을 수 있는 지 확인용 메소드
	public boolean checkBeforeReadFile(File f) {
		if(f.exists()) 
			if(f.isFile() && f.canRead())
				return true;
		
		return false;
	}
		
	
	

}
