package awt;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DeleteClass extends Frame implements WindowListener , ActionListener {

	Label label[];
	TextField txt[];
	Button menu, del;
	Label nameLabel;
	TextField searchName;
	Button searchBtn;
	TextArea showMember;
	

	public DeleteClass() {

		setLayout(new GridLayout(5, 1));
		Label mainLabel = new Label("< 선수 삭제 >");
		mainLabel.setAlignment(Label.CENTER);
		mainLabel.setLocation(30, 50);
		mainLabel.setFont(new Font(null, Font.BOLD, 30));
		add(mainLabel);

		
		// 선수 검색하기
		Panel searchPanel = new Panel();
		searchPanel.setSize(640, 200);
		add(searchPanel);

		nameLabel = new Label("이름");
		searchName = new TextField(20);
		searchBtn = new Button("검색");
		searchBtn.setSize(100, 80);

		searchPanel.add(nameLabel);
		searchPanel.add(searchName);
		searchPanel.add(searchBtn);

		
		
		// 검색한 선수 보여주기
		Panel showMemPane = new Panel();
		add(showMemPane);
		
		showMember = new TextArea();
		showMember.setSize(600, 300);
		showMemPane.add(showMember);
		showMember.setEditable(false);
		
		
		
		
		// 버튼

		Panel addBtd  = new Panel();
		add(addBtd);
		addBtd.setSize(600, 200);
		menu = new Button("메뉴");
		menu.setSize(200,100);
		del = new Button("삭제");
		del.setSize(250,100);
		
		
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
		}
		
		
	}
}
