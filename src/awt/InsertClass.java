package awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import sources.Insert;

public class InsertClass  extends Frame implements WindowListener, ActionListener{
	
	Label label[];
	TextField txt[];
	Button menu, add;
	Checkbox pit, bat;
	
	public InsertClass() {
		// TODO Auto-generated constructor stub
		
		setLayout(new GridLayout(10,1));
		
		Label mainLabel = new Label("< 선수 추가 >");
		mainLabel.setAlignment(Label.CENTER);
		mainLabel.setFont(new Font(null, Font.BOLD, 30));
		add(mainLabel);
		
		Panel p[] = new Panel[7];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Panel();
			p[i].setBounds(10, 10, 600, 100);
//			add(p[i]);
		}
		
		label = new Label[7];
		txt = new TextField[7];
		
		for (int j = 0; j < p.length; j++) {
			label[j] = new Label();
		}
		
		label[0] = new Label("이름 :");
		label[1] = new Label("나이 :");
		label[2] = new Label("키 :");
		label[3] = new Label("생일:");
		label[4] = new Label("타수 :");
		label[5] = new Label("안타수 :");
		label[6] = new Label("타율 :");
		
		
		Panel select = new Panel();
		CheckboxGroup g = new CheckboxGroup();
		pit = new Checkbox("타자", true, g);
		bat = new Checkbox("투수", false, g);
		select.add(pit);
		select.add(bat);
		add(select);
		
		
		for (int i = 0; i < label.length; i++) {
			label[i].setBounds(10, 10, 30, 30);
			txt[i] = new TextField(30);

			p[i].add(label[i]);
			p[i].add(txt[i]);
			add(p[i]);
		}
		
		
		Panel addBtd  = new Panel();
		add(addBtd);
		addBtd.setSize(600, 200);
		menu = new Button("메뉴");
		menu.setSize(200,100);
		add = new Button("추가");
		add.setSize(250,100);
		
		
		menu.addActionListener(this);
		add.addActionListener(this);
		
		
		
		
		addBtd.add(menu);
		addBtd.add(add);
		
		

		
		
		pit.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
					label[4].setText("타수:");
					label[5].setText("안타수:");
					label[6].setText("타율:");
					
				
					
				
				}
		});
		
		bat.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				label[4].setText("승:");
				label[5].setText("패:");
				label[6].setText("방어율:");
			}
		});
		
		
		
		
		
		setSize(640,500);
		setLocation(100, 100);
		addWindowListener(this);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// 메뉴로 돌아가기
		Button nowBtn = (Button)e.getSource();
		if(nowBtn == menu) {
			dispose();
			new MenuClass();
			return;
		}
		
		// 추가하기
		String str[] = new String[7];
		for (int i = 0; i < str.length; i++) {
			str[i] = txt[i].getText().trim();
		}
		Insert a = new Insert();
		boolean b=false;
		if(pit.getState()) {
			b = a.process(str,1);	// 투수
		}else if(bat.getState()){
			b = a.process(str,2);	// 타자
		}
		if(!b) {
			JOptionPane.showMessageDialog(null, "숫자나 문자를 잘못 입력했습니다.");
		}
		else {
			JOptionPane.showMessageDialog(null, "선수를 성공적으로 추가했습니다.");
		}
		
		for (int i = 0; i < str.length; i++) {
			txt[i].setText("");
		}
		txt[0].requestFocus();
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

}
