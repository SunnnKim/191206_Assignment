package awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import sources.FileData;

public class MenuClass extends Frame implements WindowListener, ActionListener{

	Button bt[];
	Label label1;
	
	
	public  MenuClass() {
		
		
		// TODO Auto-generated constructor stub
		super("Menu Class");
		setLayout(null);
		
		Panel p = new Panel();
		p.setLayout(new GridLayout(9,1,10,10));
		p.setSize(500, 480);
		p.setLocation(80, 30);
		Label mainTxt = new Label("Baseball Member");
		mainTxt.setFont(new Font(null,Font.BOLD,30));
		
		mainTxt.setBounds(0, 0, 640, 100);
		
		p.add(mainTxt);
		
		add(p);
		
		bt = new Button[7];
		bt[0] = new Button("선수 추가");
		bt[1] = new Button("선수 삭제");
		bt[2] = new Button("선수 정보 보기");
		bt[3] = new Button("선수 정보 수정");
		bt[4] = new Button("모든 선수 보기");
		bt[5] = new Button("파일로 저장하기");
		bt[6] = new Button("종료");
		
		for (int i = 0; i < bt.length; i++) {
			setSize(200, 200);
			setLocation(200, 100+(i*50));
			p.add(bt[i]);
			bt[i].addActionListener(this);
		}
		
		Label b = new Label();
		
		
		
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



	
	
	// 버튼 눌렀을 때

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		Button btn = (Button)obj;
		if(btn == bt[6]) {
			JOptionPane.showMessageDialog(null, "종료합니다.");
			System.exit(0);
		}else if(btn == bt[0]) { // 추가
			dispose();
			new InsertClass();
			
		}else if(btn == bt[1]) {	// 삭제
			dispose();
			new DeleteClass();
		}else if(btn == bt[2]) { 	// 선택
			dispose();
			new SelectClass();
		}else if(btn == bt[3]) {	// 수정
			dispose();
			new UpdateClass();
		}else if(btn == bt[4]) {	// 모두 프린트
			dispose();
			new AllPrintClass();
		}else if(btn == bt[5]) {	// 파일로 저장하기
			JOptionPane.showMessageDialog(null, "데이터를 파일로 저장했습니다.");
			// 데이터 저장
			
		}
		
		
		
	}

	
	
	
	
	
	
}
