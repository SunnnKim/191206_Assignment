package awt;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import sources.mainClass;

public class SelectClass extends Frame implements WindowListener , ActionListener {
	
	Label nameLabel;
	TextField searchName;
	Button searchBtn;
	
	JTable table;
	JScrollPane scrPane;
	Button menu;
	Button select;
	
	public SelectClass() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(6,1));	
		Label mainLabel = new Label("< 선수 정보보기 >");
		mainLabel.setAlignment(Label.CENTER);
		mainLabel.setLocation(30, 50);
		mainLabel.setFont(new Font(null, Font.BOLD, 30));
		add(mainLabel);
		
		
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
		
		
		// 테이블 패널
		Panel tablePanel = new Panel();
		tablePanel.setSize(600,400);

		table = new JTable();
		table.setSize(600, 200);
		scrPane = new JScrollPane(table);
		scrPane.setSize(500,400);
		tablePanel.add(scrPane);
		add(tablePanel);
		
		
		// 메뉴 및 삭제
		Panel addBtd  = new Panel();
		add(addBtd);
		addBtd.setSize(600, 200);
		menu = new Button("메뉴");
		menu.setSize(200,100);
		menu.addActionListener(this);
		
		

		
		
		
		addBtd.add(menu);
	
		
		
		
		
		
		setSize(640,500);
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
		
		// 검색버튼 눌렀을 때
	}
}
