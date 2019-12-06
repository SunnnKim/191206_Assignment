package awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import sources.AllPrint;

public class AllPrintClass extends Frame implements WindowListener, ActionListener {
	
	JTable table;
	JScrollPane scrPane;
	JTable table2;
	JScrollPane scrPane2;
	 Button menu;
	AllPrint printAll = new AllPrint();
	String[] colunm1 = {	// 투수
			"투수번호","이름","나이","키","생년월일","타수","안타수","타율"
	};
	String[] colunm2 = {	// 타자
			"타자번호","이름","나이","키","생년월일","승","패","방어율"
	};
	Object[][] str1 = printAll.process(1);	//투수
	Object[][] str2 = printAll.process(2);	//타자
	
	public AllPrintClass() {
		
		setLayout(null);
		Label mainLabel = new Label("< 모든 선수 보기 >");
		mainLabel.setBounds(0, 30, 640, 50);
		mainLabel.setBackground(Color.gray);
		mainLabel.setAlignment(Label.CENTER);
		mainLabel.setFont(new Font(null, Font.BOLD, 30));
		add(mainLabel);
		
		
		table = new JTable(str1,colunm1);	//(object) rowData: 테이블안에 자료, ColumName: 테이블의 참조
		scrPane = new JScrollPane(table);
		scrPane.setSize(600, 150);
		scrPane.setLocation(20, 100);
		add(scrPane);
		
		table2 = new JTable(str2, colunm2);	//(object) rowData: 테이블안에 자료, ColumName: 테이블의 참조
		scrPane2 = new JScrollPane(table2);
		scrPane2.setSize(600, 150);
		scrPane2.setLocation(20, 270);
		add(scrPane2);
		
		
		// 메뉴 및 삭제
		Panel addBtd = new Panel();
		add(addBtd);
		addBtd.setSize(600, 200);
		menu = new Button("메뉴");
		menu.setSize(200,100);
		menu.addActionListener(this);
		
		addBtd.setLocation(0, 430);
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
		
	}
}


