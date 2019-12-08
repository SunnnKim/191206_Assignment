package awt;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import sources.Select;

public class SelectClass extends Frame implements WindowListener , ActionListener {
	
	Label nameLabel;
	TextField searchName;
	Button searchBtn;
	
	TextArea printMem;
	
	Button menu;
	Button select;
	Select s;
	
	public SelectClass() {
		// TODO Auto-generated constructor stub
		setLayout(null);	
		
		Label mainLabel = new Label("< 선수 정보보기 >");
		mainLabel.setAlignment(Label.CENTER);
		mainLabel.setLocation(0, 20);
		mainLabel.setSize(640, 80);
		mainLabel.setFont(new Font(null, Font.BOLD, 30));
		add(mainLabel);
		
		
		// 검색 패널
		Panel searchPanel = new Panel();
		searchPanel.setSize(640, 50);
		searchPanel.setLocation(0, 100);
		add(searchPanel);
		
		nameLabel = new Label("이름");
		searchName = new TextField(20);
		searchBtn = new Button("검색");
		searchBtn.setSize(100, 80);
		searchBtn.addActionListener(this);
		
		
		
		searchPanel.add(nameLabel);
		searchPanel.add(searchName);
		searchPanel.add(searchBtn);
		
		
		// 텍스트 애리어
		printMem = new TextArea();
		printMem.setBounds(120, 150, 400, 250);
		printMem.setEditable(false);
		add(printMem);
		
		
		// 메뉴 및 삭제
		Panel addBtd  = new Panel();
		add(addBtd);
		addBtd.setSize(640, 200);
		addBtd.setLocation(0, 425);
		menu = new Button("메뉴");
		menu.setSize(200,100);
		menu.addActionListener(this);
		
		

		
		
		
		addBtd.add(menu);
	
		
		
		
		
		
		setSize(640,500);
		setLocation(350, 150);
		addWindowListener(this);
		setVisible(true);
	}
	

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Button nowBtn = (Button)e.getSource();
		if(nowBtn == menu) {
			dispose();
			new MenuClass();
		}
		
		if(nowBtn == searchBtn) {
			//검색 버튼일 때
			printMem.setText("");
			s = new Select();
			String name = searchName.getText();
			Object [] str = s.process(name);
			if(str == null) {
				JOptionPane.showMessageDialog(null, "선수가 없습니다!");
			}
			else {
				if((int)str[0] < 2000) {	// 투수:1000~ 타자:2000~
					printMem.append("\n");
					printMem.append("\t번호 :\t"+str[0]+"\t\n");
					printMem.append("\t이름 :\t"+str[1]+"\n");
					printMem.append("\t나이 :\t"+str[2]+"\n");
					printMem.append("\t키 :\t"+str[3]+"\n");
					printMem.append("\t생년월일 :\t"+str[4]+"\n");
					printMem.append("\t승 :\t"+str[5]+"\n");
					printMem.append("\t패 :\t"+str[6]+"\n");
					printMem.append("\t방어율 :\t"+str[7]+"\n");
				}
				else {
					printMem.append("\n");
					printMem.append("\t번호 :\t"+str[0]+"\t\n");
					printMem.append("\t이름 :\t"+str[1]+"\n");
					printMem.append("\t나이 :\t"+str[2]+"\n");
					printMem.append("\t키 :\t"+str[3]+"\n");
					printMem.append("\t생년월일 :\t"+str[4]+"\n");
					printMem.append("\t타수 :\t"+str[5]+"\n");
					printMem.append("\t안타수 :\t"+str[6]+"\n");
					printMem.append("\t타율 :\t"+str[7]+"\n");
					
				}
			}
			
		}
		
		
	}
}
