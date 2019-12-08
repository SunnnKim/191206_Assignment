package awt;

import sources.FileData;

public class main {

	public static void main(String[] args) throws Exception {
		FileData dataCls = new FileData("Baseball");
		try {
			dataCls.readFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MenuClass();
	}

}
