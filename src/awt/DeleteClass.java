package awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
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

import sources.Delete;
import sources.Select;

public class DeleteClass extends Frame implements WindowListener , ActionListener {

	Label label[];
	TextField txt[];
	Button menu, del;
	Label nameLabel;
	TextField searchName;
	Button searchBtn;
	TextArea printMem;
	Select s;
	Delete d;
	

	public DeleteClass() {

		setLayout(null);
		setBackground(Color.WHITE);
		Label mainLabel = new Label("< 선수 삭제 >");
		mainLabel.setAlignment(Label.CENTER);
		mainLabel.setLocation(0, 20);
		mainLabel.setSize(640, 80);
		mainLabel.setFont(new Font(null, Font.BOLD, 30));
		add(mainLabel);

		
		// 선수 검색하기
		Panel searchPanel = new Panel();
		searchPanel.setSize(640, 50);
		searchPanel.setLocation(0, 100);
		add(searchPanel);

		nameLabel = new Label("이름");
		searchName = new TextField(20);
		searchBtn = new Button("검색");
		searchBtn.setSize(100, 80);

		searchPanel.add(nameLabel);
		searchPanel.add(searchName);
		searchPanel.add(searchBtn);
		searchBtn.addActionListener(this);

		
		
		// 검색한 선수 보여주기
		
		printMem = new TextArea();
		printMem.setSize(400, 250);
		printMem.setLocation(120, 150);
		add(printMem);
		printMem.setEditable(false);
		
		
		
		
		// 버튼

		Panel addBtd  = new Panel();
		addBtd.setLayout(new FlowLayout());
		add(addBtd);
		addBtd.setSize(640, 200);
		addBtd.setLocation(0, 450);
		menu = new Button("메뉴");
		menu.setSize(300,150);
		menu.setLocation(100,420 );
		del = new Button("삭제");
		del.setSize(150,150);
		del.setLocation(340,420);
		
		
		menu.addActionListener(this);
		del.addActionListener(this);
		
		
		
		
		
		addBtd.add(menu);
		addBtd.add(del);
		
		
		
		
		
		setSize(640, 500);
		setLocation(100, 100);
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
			return;
		}
		if(nowBtn == searchBtn) {
			//검색 버튼일 때
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
					printMem.append("\t타율 :\t"+str[7]+"\n");
					
				}
				printMem.append("\n");
				printMem.append("\t해당 선수를 삭제하시려면 \n\t삭제 버튼을 눌러주세요.");
				
			}
			return;
		}
		
		if(nowBtn == del) {
			// 삭제 버튼일 때
			d = new Delete();
			String name = searchName.getText();
			boolean b = d.process(name);
			if(!b) {
				JOptionPane.showMessageDialog(null, "선수가 없습니다!");
				
			}
			else {
				JOptionPane.showMessageDialog(null, "성공적으로 삭제했습니다.");
				
			}
			printMem.setText("");
			
			return;
			
		}
		
		
		
		
		
	}
}
